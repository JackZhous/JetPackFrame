package com.jz.appframe.di;

import android.content.Context;

import com.jz.appframe.db.NetApi;
import com.jz.appframe.db.room.RoomAgent;
import com.jz.appframe.model.ViewModelFactory;
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
@Module(subcomponents = BaseActivitySubComponent.class)
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

    @Singleton
    @Provides
    static ViewModelFactory provideViewModelFactory(NetApi api){
        return new ViewModelFactory(api);
    }

    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivityInjector();


    @ContributesAndroidInjector(modules = TestModule.class)
    abstract TestActivity testActivityInjector();

}
