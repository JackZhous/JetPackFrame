package com.jz.appframe.di;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * @author jackzhous
 * @package com.jz.appframe.pi
 * @filename AppComponet
 * date on 2020/5/15 3:24 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@Singleton
@Component(modules =
        {AndroidInjectionModule.class, AppModule.class})
public interface AppComponet {
}
