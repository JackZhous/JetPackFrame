package com.jz.appframe.di;

import android.content.Context;

import com.jz.appframe.MyApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
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
                {AndroidInjectionModule.class,
                AllActivityModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder applicationCtx(Context context);
        AppComponent build();
    }

    MyApp inject(MyApp app);

}
