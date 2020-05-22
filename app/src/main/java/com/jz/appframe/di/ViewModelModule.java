package com.jz.appframe.di;

import android.content.Context;

import com.jz.appframe.db.NetApi;
import com.jz.appframe.model.UserViewModel;
import com.jz.appframe.model.ViewModelFactory;
import com.jz.appframe.ui.base.BaseActivity;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

/**
 * @author jackzhous
 * @package com.jz.appframe.di
 * @filename MainModule
 * date on 2020/5/22 3:03 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel.class)
    abstract ViewModel bindUserViewModel(UserViewModel model);


    @Binds
    abstract ViewModelProvider.Factory bindVMProvider(ViewModelFactory factory);
}
