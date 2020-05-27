package com.jz.appframe.ui;

import android.os.Bundle;
import android.view.View;

import com.jz.appframe.R;
import com.jz.appframe.db.room.User;
import com.jz.appframe.db.room.UserDao;
import com.jz.appframe.model.UserViewModel;
import com.jz.appframe.model.base.BaseVModel;
import com.jz.appframe.ui.base.BaseActivity;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends BaseActivity<UserViewModel> {

    @Inject
    UserDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        module.loginData.observe(this, token -> showMsg(token.getToken()));
    }

    public void onlogin(View view){
        module.login1("13883976960", "sdfsd");
    }

    @Override
    protected Class<UserViewModel> getViewModelClass() {
        return UserViewModel.class;
    }

    public void onjump(View view){
        jumpTo(TestActivity.class);
    }


}
