package com.example.jh.gank.http;

/**
 * Created by jinhui on 2017/8/3.
 * 邮箱: 1004260403@qq.com
 */

public interface HttpListener {

    void onSuccess(Object result);

    void onFailure(int errorType, String message);
}
