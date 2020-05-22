package com.jz.appframe.db.adapter

import com.jz.appframe.db.resp.ApiErrorResponse
import com.jz.appframe.db.resp.JResponse
import com.jz.appframe.util.AppConfig
import com.jz.appframe.util.LogHelper
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import retrofit2.*
import java.lang.RuntimeException
import java.lang.reflect.Type

/**
 * @package com.jz.appframe.db.adapter
 * @filename CoroutinesCallAdapter
 * date on 2020/5/21 5:13 PM
 * @author jackzhous
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
class CoroutinesCallAdapter<T>(private val returnType: Type) : CallAdapter<JResponse<T>, Deferred<JResponse<T>>>{

    override fun adapt(call: Call<JResponse<T>>): Deferred<JResponse<T>> {
        val job = CompletableDeferred<JResponse<T>>()

        job.invokeOnCompletion {
            if (job.isCancelled) {
                call.cancel()
            }
        }

        call.enqueue(object : Callback<JResponse<T>>{
            override fun onFailure(call: Call<JResponse<T>>, t: Throwable) {
                val error = ApiErrorResponse(-1, t.message ?: "unknown error")
                job.completeExceptionally(error)
            }

            override fun onResponse(call: Call<JResponse<T>>, response: Response<JResponse<T>>) {
                if (response.isSuccessful && response.body()?.code  == AppConfig.WEB_SUCCESS){
                    job.complete(response.body()!!)
                }else{
                    val error = ApiErrorResponse(response.body()?.code ?: response.code(), response.body()?.message ?: response.message())
                    job.completeExceptionally(error)
                }
            }
        })

        return job
    }

    override fun responseType() = returnType
}


