package com.jz.appframe.di;

import com.jz.appframe.ui.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

/**
 * @author jackzhous
 * @package com.jz.appframe.di
 * @filename ActivityModule
 * date on 2020/5/15 4:27 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@Module(subcomponents = ActivitySubComponent.class)
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = MainActivityBuilder.class)
    abstract MainActivity mainActivityInjector();
}
