package com.example.jh.gank.http;

import com.google.gson.internal.$Gson$Types;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by jinhui on 2017/8/3.
 * 邮箱: 1004260403@qq.com
 *
 * 反射Type
 */

public abstract class CallBack<T>{

    public Type type;

    public CallBack(){
        type = getSuperclassTypeParameter(getClass());
    }

    private Type getSuperclassTypeParameter(Class<? extends CallBack> aClass) {
        Type superclass = aClass.getGenericSuperclass();
        if(superclass instanceof Class){
            throw new RuntimeException("Missing type parameter.");
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
    }

    public abstract void onSuccess(T result);

    public void onFailure(String message) {
//        Toast.makeText(App.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
