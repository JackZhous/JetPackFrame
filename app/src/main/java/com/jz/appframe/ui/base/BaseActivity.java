package com.jz.appframe.ui.base;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jz.appframe.model.base.BaseVModel;
import com.jz.appframe.util.AppConfig;
import com.jz.appframe.util.LogHelper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.android.AndroidInjection;
import dagger.multibindings.IntoMap;

/**
 * @author jackzhous
 * @package com.jz.appframe.ui.base
 * @filename BaseActivity
 * date on 2020/5/15 4:11 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    protected boolean enableProgressDialog;
    protected abstract BaseVModel getModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        getModel().getError().observe(this, this::showMsg);
        getModel().getStatus().observe(this, it -> {
            if(!enableProgressDialog){
                return;
            }
            if (AppConfig.START == it) {
                showDialog();
            } else {
                closeDialog();
            }
        });
    }


    public void showMsg(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    protected void jumpTo(Class obj){
        startActivity(new Intent(this, obj));
    }

    private void showDialog(){
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("加载中，请稍后");
            progressDialog.setCanceledOnTouchOutside(true);
        }
        progressDialog.show();
    }

    private void closeDialog(){
        if(progressDialog == null || !progressDialog.isShowing()){
            return;
        }
        progressDialog.dismiss();
    }

}
