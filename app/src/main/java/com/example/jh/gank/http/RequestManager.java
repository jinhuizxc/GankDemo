package com.example.jh.gank.http;

import com.orhanobut.logger.Logger;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by jinhui on 2017/8/3.
 * 邮箱: 1004260403@qq.com
 *
 * 管理所有请求类
 */

public class RequestManager {

    private static final String ERROR = "error";
    private static final String RESULTS = "results";
    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new LoggingInterceptor())
            .build();

    /**
     * 请求响应日志信息，方便debug
     */
    public static class LoggingInterceptor implements Interceptor {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();

            long t1 = System.nanoTime();
            Logger.i(String.format("Sending request %s on %s%n%s",
                    request.url(), chain.connection(), request.headers()));

            Response response = chain.proceed(request);

            long t2 = System.nanoTime();
            Logger.i(String.format("Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers()));

            return response;
        }
    }
    /**
     * 根据tag取消请求
     *
     * @param tag 标签
     */
    public static void cancelRequest(Object tag) {
        for (Call call : okHttpClient.dispatcher().queuedCalls()) {
            if (call.request().tag().equals(tag)) {
                call.cancel();
            }
        }
        for (Call call : okHttpClient.dispatcher().runningCalls()) {
            if (call.request().tag().equals(tag)) {
                call.cancel();
            }
        }
    }
}
