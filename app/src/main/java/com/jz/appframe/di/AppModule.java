package com.jz.appframe.di;

import android.content.Context;

import com.jz.appframe.db.NetApi;
import com.jz.appframe.db.room.RoomAgent;
import com.jz.appframe.db.room.UserDao;
import com.jz.appframe.model.ViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author jackzhous
 * @package com.jz.appframe.pi
 * @filename AppMoudel
 * date on 2020/5/15 3:55 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@Module(includes = ViewModelModule.class)
abstract class AppModule {
    @Singleton
    @Provides
    static NetApi provideApi(){
        return NetApi.Factory.create().create(NetApi.class);
    }

    @Singleton
    @Provides
    static UserDao provideUserDao(Context context){
        return RoomAgent.getInstance(context).userDao();
    }

}
