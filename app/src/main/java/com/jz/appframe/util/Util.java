package com.jz.appframe.util;

/**
 * @author jackzhous
 * @package com.jz.appframe.util
 * @filename Util
 * date on 2020/5/22 11:29 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class Util {

    /**
     * 系统版本
     * @return
     */
    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 手机机型
     * @return
     */
    public static String getSystemModel() {
        return android.os.Build.MODEL;
    }
}
