package com.jz.appframe.di;

import android.content.Context;

import com.jz.appframe.MyApp;
import com.jz.appframe.ui.MainActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * @author jackzhous
 * @package com.jz.appframe.pi
 * @filename AppComponet
 * date on 2020/5/15 3:24 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
//@Singleton
@Component(modules =
                {AndroidInjectionModule.class,
                AndroidSupportInjectionModule.class,
                ActivityModule.class,
                AppModule.class})
interface AppComponent {
    MyApp inject(MyApp app);

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder applicationCtx(Context context);
        AppComponent build();
    }

}
