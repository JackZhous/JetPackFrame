package com.jz.appframe;

import android.app.Activity;
import android.app.Application;


import com.jz.appframe.di.AppComponent;
import com.jz.appframe.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * @author jackzhous
 * @package com.jz.appframe
 * @filename MyApp
 * date on 2020/5/22 2:35 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class MyApp extends Application implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        AppComponent component = DaggerAppComponent.builder().applicationCtx(this).build();
        if(component instanceof DaggerAppComponent){
            component.inject(this);
        }
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
