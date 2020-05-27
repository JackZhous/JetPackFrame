package com.jz.appframe.ui;

import android.os.Bundle;

import com.jz.appframe.R;
import com.jz.appframe.model.TestViewModle;
import com.jz.appframe.model.UserViewModel;
import com.jz.appframe.model.base.BaseVModel;
import com.jz.appframe.ui.base.BaseActivity;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author jackzhous
 * @package com.jz.appframe.ui
 * @filename TestActivity
 * date on 2020/5/15 4:28 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class TestActivity extends BaseActivity<TestViewModle> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    @Override
    protected Class<TestViewModle> getViewModelClass() {
        return TestViewModle.class;
    }
}
