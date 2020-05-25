package com.jz.appframe.di;

import com.jz.appframe.db.NetApi;
import com.jz.appframe.model.TestViewModle;
import com.jz.appframe.model.UserViewModel;
import com.jz.appframe.model.ViewModelFactory;
import com.jz.appframe.ui.MainActivity;
import com.jz.appframe.ui.TestActivity;

import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;

/**
 * @author jackzhous
 * @package com.jz.appframe.di
 * @filename TestModule
 * date on 2020/5/25 4:51 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@Module
abstract class TestModule {

    @Provides
    static TestViewModle provideTestModel(TestActivity activity, ViewModelFactory factory){
        return new ViewModelProvider(activity, factory).get(TestViewModle.class);
    }

}
