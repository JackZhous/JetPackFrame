package com.jz.appframe.model;

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

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(UserViewModel.class)){
            return (T) new UserViewModel();
        }
        //noinspection unchecked
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
