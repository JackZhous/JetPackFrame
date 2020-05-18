package com.jz.appframe.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.jz.appframe.BuildConfig;
import com.jz.appframe.R;
import com.jz.appframe.db.room.RoomAgent;
import com.jz.appframe.db.room.UserDao;
import com.jz.appframe.model.UserViewModel;
import com.jz.appframe.model.ViewModelFactory;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    UserDao dao;
    @Inject
    UserViewModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userModel = new ViewModelProvider(this, new ViewModelFactory()).get(UserViewModel.class);
    }
}
