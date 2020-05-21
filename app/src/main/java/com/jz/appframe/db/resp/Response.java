package com.jz.appframe.db.resp;

/**
 * @author jackzhous
 * @package com.jz.appframe.db.resp
 * @filename Response
 * date on 2020/5/18 9:43 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class Response<T> {
    int code;
    String message;
    T params;

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setParams(T params) {
        this.params = params;
    }
}
