package com.jz.appframe.di;

import com.jz.appframe.db.NetApi;
import com.jz.appframe.model.TestViewModle;
import com.jz.appframe.model.UserViewModel;
import com.jz.appframe.model.ViewModelFactory;
import com.jz.appframe.ui.MainActivity;

import java.lang.annotation.Documented;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
/**
 * @author jackzhous
 * @package com.jz.appframe.di
 * @filename ViewModule
 * date on 2020/5/27 11:43 AM
 * @describe
 * 生成所有的ViewModel，会将生成的Provider<T>装入到ViewModelFactory
 * 的Map中去
 * @email jackzhouyu@foxmail.com
 **/
@Module
abstract class ViewModuleModel {
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel.class)
    abstract ViewModel provideUserModel(UserViewModel model);

    @IntoMap
    @Binds
    @ViewModelKey(TestViewModle.class)
    abstract ViewModel provideTestModel(TestViewModle model);

    @Binds
    abstract ViewModelProvider.Factory provideViewModelFactory(ViewModelFactory factory);
}
