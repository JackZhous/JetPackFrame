package com.jz.appframe.ui.base;

import android.os.Bundle;

import com.jz.appframe.model.ViewModelFactory;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.android.AndroidInjection;

/**
 * @author jackzhous
 * @package com.jz.appframe.ui.base
 * @filename BaseActivity
 * date on 2020/5/15 4:11 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public abstract class BaseActivity<M extends ViewModel> extends AppCompatActivity {

    protected M module;
//    @Inject
//    ViewModelFactory factory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
//        module = factory.getModule(this, provideModule());
    }

    protected abstract Class<M> provideModule();
}
