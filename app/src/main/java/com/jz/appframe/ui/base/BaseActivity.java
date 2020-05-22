package com.jz.appframe.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;

/**
 * @author jackzhous
 * @package com.jz.appframe.ui.base
 * @filename BaseActivity
 * date on 2020/5/15 4:11 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }
}
