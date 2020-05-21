package com.jz.appframe.db.adapter

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
class CoroutinesCallAdapter<T>(private val returnType: Type) : CallAdapter<T, Deferred<T>>{

    override fun adapt(call: Call<T>): Deferred<T> {
        val job = CompletableDeferred<T>()

        job.invokeOnCompletion {
            if (job.isCancelled) {
                call.cancel()
            }
        }

        call.enqueue(object : Callback<T>{
            override fun onFailure(call: Call<T>, t: Throwable) {
                val cause = t.message ?: "unknown network error"
                LogHelper.de_e(cause)
                job.completeExceptionally(t)
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful){
                    job.complete(response.body()!!)
                }else{
                    job.completeExceptionally(HttpException(response))
                }
            }
        })

        return job
    }

    override fun responseType() = returnType
}