package com.jz.appframe.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.jz.appframe.BuildConfig;
import com.jz.appframe.R;
import com.jz.appframe.db.room.RoomAgent;
import com.jz.appframe.db.room.UserDao;
import com.jz.appframe.model.UserViewModel;
import com.jz.appframe.model.ViewModelFactory;
import com.jz.appframe.ui.base.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<UserViewModel> {

    @Inject
    UserDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onlogin(View view){
        module.login("18828055318", "sdfsd");
    }

    protected Class<UserViewModel> provideModule(){
        return UserViewModel.class;
    }

}
