package com.jz.appframe.di;

import com.jz.appframe.db.NetApi;
import com.jz.appframe.model.UserViewModel;
import com.jz.appframe.model.ViewModelFactory;
import com.jz.appframe.ui.base.BaseActivity;

import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;

/**
 * @author jackzhous
 * @package com.jz.appframe.di
 * @filename MainModule
 * date on 2020/5/22 3:03 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@Module
public class MainActivityBuilder {

    @Provides
    UserViewModel provideUVM(BaseActivity activity, NetApi api){
//        return new ViewModelProvider(activity, ViewModelFactory.create(api)).get(UserViewModel.class);
        return new UserViewModel(api);
    }
}
