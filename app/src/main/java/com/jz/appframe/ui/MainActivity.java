package com.jz.appframe.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Insert;
import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import android.os.Bundle;

import com.jz.appframe.R;
import com.jz.appframe.model.UserViewModel;
import com.jz.appframe.model.ViewModelFactory;
import com.jz.appframe.room.RoomAgent;
import com.jz.appframe.room.User;
import com.jz.appframe.room.UserDao;
import com.jz.frame.util.LogHelper;

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
        testRoom();

        userModel = new ViewModelProvider(this, new ViewModelFactory()).get(UserViewModel.class);
    }


    private void testRoom(){
        dao = RoomAgent.getInstance(getApplicationContext()).userDao();
        dao.insetUser(new User("jackzhous"))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new CompletableObserver() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onComplete() {
                                LogHelper.de_i("insert done");
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });
        dao.queryAllUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {
                        LogHelper.de_i(user.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        LogHelper.de_i(e.getCause().toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
