package com.example.jh.gank.utils;

/**
 * Created by jinhui on 2017/8/4.
 * 邮箱: 1004260403@qq.com
 */

public class CommonUtils {

    private static long lastClickTime;
    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if ( 0 < timeD && timeD < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}
