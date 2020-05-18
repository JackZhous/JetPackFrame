package com.jz.appframe.model.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jz.appframe.db.NetApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @package com.jz.appframe.model
 * @filename BaseVModel
 * date on 2020/5/18 4:05 PM
 * @author jackzhous
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
abstract class BaseVModel(var api: NetApi?) : ViewModel(){
    val exceptionData = MutableLiveData<String>()

    protected fun joinCoroutine(){
        viewModelScope.launch (Dispatchers.IO){  }
    }


    override fun onCleared() {
        super.onCleared()
        api = null
    }
}