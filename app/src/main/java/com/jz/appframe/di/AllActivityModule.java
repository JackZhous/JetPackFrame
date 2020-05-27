package com.jz.appframe.di;

import android.content.Context;

import com.jz.appframe.db.NetApi;
import com.jz.appframe.db.room.RoomAgent;
import com.jz.appframe.ui.MainActivity;
import com.jz.appframe.ui.TestActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * @author jackzhous
 * @package com.jz.appframe.di
 * @filename ActivityModule
 * date on 2020/5/15 4:27 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@Module(subcomponents = BaseActivitySubComponent.class, includes = ViewModuleModel.class)
abstract class AllActivityModule {

    @Singleton
    @Provides
    static NetApi provideApi(){
        return NetApi.Factory.create().create(NetApi.class);
    }

    @Singleton
    @Provides
    static RoomAgent provideRoomAgent(Context context){
        return RoomAgent.getInstance(context);
    }

    //如果某一个类需要提供其他出ViewModuel意外的依赖，可以创建一个Module，如下
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivityInjector();


    @ContributesAndroidInjector
    abstract TestActivity testActivityInjector();

}
