package com.jz.appframe.model;

import com.jz.appframe.db.NetApi;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

/**
 * @author jackzhous
 * @package com.jz.appframe.model
 * @filename ViewModelFactory
 * date on 2020/5/14 4:31 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class ViewModelFactory implements ViewModelProvider.Factory {

    private NetApi api;
    private Map<Class<? extends ViewModel>, ViewModel> vmMap;
    @Inject
    public ViewModelFactory(NetApi api) {
        this.api = api;
        vmMap = new HashMap<>();
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        T t = (T) vmMap.get(modelClass);
        if(t != null){
            return t;
        }

        //noinspection unchecked
        throw new IllegalArgumentException("Unknown ViewModel class");
    }

//    public static ViewModelFactory create(NetApi api){
//        return new ViewModelFactory(api);
//    }
//
//
//    public <T extends ViewModel> T getModule(ViewModelStoreOwner owner, @NonNull Class<T> modelClass){
//        return new ViewModelProvider(owner, this).get(modelClass);
//    }

}
