package com.jz.appframe.model.base

import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jz.appframe.db.NetApi
import com.jz.appframe.db.resp.JResponse
import com.jz.appframe.util.AppConfig
import com.jz.appframe.util.LogHelper
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.regex.Pattern

/**
 * @package com.jz.appframe.model
 * @filename BaseVModel
 * date on 2020/5/18 4:05 PM
 * @author jackzhous
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
open class BaseVModel(protected val api : NetApi) : ViewModel(){
    //错误数据，网络操作过程中出现的错误
    open val error = MutableLiveData<String>()
    //状态数据，网络操作起始状态监听
    open val status = MutableLiveData<Int>()

    /**
     * 异步协程,带有需要的返回参数
     */
    protected fun<Q, R> asynCorotines(req : Q,
                                      io : (Q) -> Deferred<JResponse<R>>,
                                      ret : MutableLiveData<R>) {
        viewModelScope.launch(Dispatchers.IO){
            try {
                status.postValue(AppConfig.START)
                val result = io(req).await()
                ret.postValue(result.params)
            } catch (e: Exception) {
                error.postValue(e.message)
            }
            status.postValue(AppConfig.END)
        }
    }

    /**
     * 异步协程,只有基础的数据返回，如返回的response只有code和msg，没有detail部分
     */
    protected fun<Q> asynCorotines(req : Q,
                                   io : (Q) -> Deferred<JResponse<Any>>) {
        viewModelScope.launch(Dispatchers.IO){
            try {
                status.postValue(AppConfig.START)
                val result = io(req).await()
                error.postValue(result.message)
            } catch (e: Exception) {
                error.postValue(e.message)
            }
            status.postValue(AppConfig.END)
        }
    }

    /**
     * 检查输入参数是否为空
     */
    protected fun isEmpty(text : String, warn : String): Boolean {
        if(TextUtils.isEmpty(text)){
            error.postValue(warn)
            return true
        }
        return false
    }

    /**
     * 正则表达式判断
     */
    protected fun isEmpty(text : String, regex : String, emptyWarn : String, warn : String): Boolean {
        if(isEmpty(text, emptyWarn)){
            return true
        }
        val pattern = Pattern.compile(regex)
        if (!pattern.matcher(text).matches()) {
            error.postValue(warn)
            return true
        }
        return false
    }
}