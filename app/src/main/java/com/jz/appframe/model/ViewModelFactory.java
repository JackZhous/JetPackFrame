package com.jz.appframe.model;

import android.telephony.SmsManager;

import com.jz.appframe.db.NetApi;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.DirectoryIteratorException;
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
@Singleton
public class ViewModelFactory implements ViewModelProvider.Factory {

    private NetApi api;
    private static ViewModelFactory instance;

    @Inject
    public ViewModelFactory(NetApi api) {
        this.api = api;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        try {
            return modelClass.getConstructor(NetApi.class).newInstance(api);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }

        //noinspection unchecked
        throw new IllegalArgumentException("Unknown ViewModel class");
    }

    public static ViewModelFactory create(NetApi api){
        if(instance == null){
            instance = new ViewModelFactory(api);
        }
        return instance;
    }
//
//
//    public <T extends ViewModel> T getModule(ViewModelStoreOwner owner, @NonNull Class<T> modelClass){
//        return new ViewModelProvider(owner, this).get(modelClass);
//    }

}
