package com.example.jh.gank;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by jinhui on 2017/8/3.
 * 邮箱: 1004260403@qq.com
 */

public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        // logger
        Logger.init("jh")
                .methodOffset(2)
                .methodCount(2) // 方法数
                .hideThreadInfo()
                .logLevel(BuildConfig.DEBUG ? LogLevel.FULL : LogLevel.NONE);
    }

    // 获取上下文的方法
    public static Context getContext() {
        return context;
    }
}
