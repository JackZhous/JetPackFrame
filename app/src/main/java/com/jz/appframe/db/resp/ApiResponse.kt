package com.jz.appframe.db.resp

import retrofit2.Response
import java.lang.NumberFormatException
import java.util.regex.Pattern

/**
 * @package com.jz.appframe.db.resp
 * @filename ApiResponse
 * date on 2020/5/18 2:22 PM
 * @author jackzhous
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
sealed class ApiResponse<T> {
    companion object{
        fun <T> create(error: Throwable) : ApiErrorResponse<T> {
            return ApiErrorResponse(error.message ?: "unknown")
        }

        fun <T> create(response: Response<T>) : ApiResponse<T>{
            if(response.isSuccessful){
                val body = response.body();
                if(body == null || response.code() == 204){
                    return ApiEmptyResponse()
                }else{
                    return ApiSuccessResponse(
                            body = body,
                            linkHeader = response.headers()?.get("link")
                    )
                }
            }else{
                val msg = response.errorBody()?.string()
                val errorMsg = if(msg.isNullOrEmpty()){
                    response.message()
                }else{
                    msg
                }
                return ApiErrorResponse(errorMsg ?: "unkown error")
            }
        }
    }
}

data class ApiErrorResponse<T>(val errorMeeage: String) : ApiResponse<T>()

class ApiEmptyResponse<T> : ApiResponse<T>()

data class ApiSuccessResponse<T>(val body: T, val links: Map<String, String>) : ApiResponse<T>() {
    constructor(body: T, linkHeader : String?) : this(
            body = body,
            links = linkHeader?.extractLinks() ?: emptyMap()
    )

    val nextPage: Int? by lazy (LazyThreadSafetyMode.NONE){
        links[NEXT_LINK]?.let {next ->
            val matcher = PAGE_PATTERN.matcher(next)
            if(!matcher.find() || matcher.groupCount() != 1){
                null
            }else{
                try {
                    Integer.parseInt(matcher.group(1))
                }catch (ex: NumberFormatException){
                    ex.printStackTrace()
                    null
                }
            }
        }
    }

    companion object{
        private val LINK_PATTERN = Pattern.compile("<([^>]*)>[\\s]*;[\\s]*rel=\"([a-zA-Z0-9]+)\"")
        private val PAGE_PATTERN = Pattern.compile("\\bpage=(\\d+)")
        private const val NEXT_LINK = "next"
        private fun String.extractLinks(): Map<String, String> {
            val links = mutableMapOf<String, String>()
            val matcher = LINK_PATTERN.matcher(this)

            while (matcher.find()) {
                val count = matcher.groupCount()
                if (count == 2) {
                    links[matcher.group(2)] = matcher.group(1)
                }
            }
            return links
        }
    }
}