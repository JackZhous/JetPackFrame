package com.jz.appframe.db.req;

import com.google.gson.annotations.SerializedName;
import com.jz.appframe.util.Util;

/**
 * @author jackzhous
 * @package com.jz.appframe.db.req
 * @filename ReqLogin
 * date on 2020/5/22 11:27 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class ReqLogin {
    String cmd = "login20170303";
    ParamBean params;
    public ReqLogin(String phone, String code){
        params = new ParamBean();
        params.authCode = code;
        params.mobile = phone;
    }

    static class ParamBean {
        @SerializedName("deviceType")
        private String deviceType = "Android";
        @SerializedName("channelId")
        private String channelId;
        @SerializedName("mobile")
        private String mobile;
        @SerializedName("code")
        private String authCode;
        private String phoneType = Util.getSystemModel();
        private String version = Util.getSystemVersion();
    }
}
