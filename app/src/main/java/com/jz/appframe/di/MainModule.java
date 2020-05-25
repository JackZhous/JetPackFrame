package com.jz.appframe.di;

import com.jz.appframe.db.NetApi;
import com.jz.appframe.db.room.RoomAgent;
import com.jz.appframe.db.room.UserDao;
import com.jz.appframe.model.UserViewModel;
import com.jz.appframe.model.ViewModelFactory;
import com.jz.appframe.ui.MainActivity;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

/**
 * @author jackzhous
 * @package com.jz.appframe.di
 * @filename MainModule
 * date on 2020/5/22 3:03 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@Module
abstract class MainModule {
    @Provides
    static UserViewModel provideUserModel(MainActivity activity, ViewModelFactory factory){
        return new ViewModelProvider(activity, factory).get(UserViewModel.class);
    }

    @Provides
    static UserDao provideUserDao(RoomAgent activity){
        return activity.userDao();
    }
}
