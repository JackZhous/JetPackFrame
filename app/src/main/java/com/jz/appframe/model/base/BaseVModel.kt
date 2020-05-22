package com.jz.appframe.model.base

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jz.appframe.db.NetApi
import com.jz.appframe.db.resp.JResponse
import com.jz.appframe.util.AppConfig
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
    //错误数据
    val error = MutableLiveData<String>()
    //状态数据，后台接口状态数据
    val status = MutableLiveData<Int>()

    /**
     * 异步协程
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
     * 异步协程,无返回值
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