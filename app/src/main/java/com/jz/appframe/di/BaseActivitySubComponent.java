package com.jz.appframe.di;

import com.jz.appframe.model.base.BaseVModel;
import com.jz.appframe.ui.base.BaseActivity;

import androidx.lifecycle.ViewModel;
import dagger.BindsInstance;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * @author jackzhous
 * @package com.jz.appframe.di
 * @filename ActivityComponet
 * date on 2020/5/15 4:12 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@Subcomponent(modules = AndroidInjectionModule.class)
public interface BaseActivitySubComponent extends AndroidInjector<BaseActivity<BaseVModel>> {

    //每一个继承BaseActivity的Activity都共享同一个SubComponent
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BaseActivity<BaseVModel>>{
    }

}
