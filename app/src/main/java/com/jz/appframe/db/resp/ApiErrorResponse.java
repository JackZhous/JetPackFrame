package com.jz.appframe.db.resp;

/**
 * @author jackzhous
 * @package com.jz.appframe.db.resp
 * @filename ApiErrorResponse
 * date on 2020/5/21 5:23 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class ApiErrorResponse  extends RuntimeException{
    int code;
    public ApiErrorResponse(int code, String message) {
        super(message);
        this.code = code;
    }


}
