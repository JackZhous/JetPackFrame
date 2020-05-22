package com.jz.appframe.di;

import com.jz.appframe.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author jackzhous
 * @package com.jz.appframe.di
 * @filename ActivityModule
 * date on 2020/5/15 4:27 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@Module(subcomponents = ActivitySubComponent.class)
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract MainActivity mainActivityInjector();
}
