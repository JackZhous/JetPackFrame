package com.jz.appframe.model;

import com.jz.appframe.db.NetApi;
import com.jz.appframe.db.req.ReqLogin;
import com.jz.appframe.db.resp.RespLogin;
import com.jz.appframe.model.base.BaseVModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * @author jackzhous
 * @package com.jz.appframe.model
 * @filename UserViewModel
 * date on 2020/5/14 4:19 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class UserViewModel extends BaseVModel {

    public MutableLiveData<RespLogin> loginData = new MutableLiveData<>();

    public UserViewModel(NetApi api) {
        super(api);
    }

    public void login(String phone, String code){
        if(isEmpty(phone, "[0-9]{11}", "手机号不允许为空", "手机号必须为11位")
                || isEmpty(code, "验证码不能为空")){
            return;
        }
        asynCorotines(new ReqLogin(phone, code), (it) -> getApi().loginWithNoResposne(it));
    }

    public void login1(String phone, String code){
        if(isEmpty(phone, "[0-9]{11}", "手机号不允许为空", "手机号必须为11位")
                || isEmpty(code, "验证码不能为空")){
            return;
        }
        asynCorotines(new ReqLogin(phone, code), (it) -> getApi().login(it), loginData);
    }
}
