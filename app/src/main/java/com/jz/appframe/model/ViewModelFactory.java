package com.jz.appframe.model;

import com.jz.appframe.db.NetApi;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

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

    private ViewModelFactory(NetApi api) {
        this.api = api;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(UserViewModel.class)){
            return (T) new UserViewModel(api);
        }
        //noinspection unchecked
        throw new IllegalArgumentException("Unknown ViewModel class");
    }

    public static ViewModelFactory create(NetApi api){
        return new ViewModelFactory(api);
    }

}
