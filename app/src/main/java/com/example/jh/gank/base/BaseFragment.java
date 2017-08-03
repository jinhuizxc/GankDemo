package com.example.jh.gank.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jh.gank.http.RequestManager;

import java.util.UUID;

import butterknife.ButterKnife;

/**
 * Created by jinhui on 2017/8/3.
 * 邮箱: 1004260403@qq.com
 */

public abstract class BaseFragment extends Fragment {

    protected String tag = UUID.randomUUID().toString();

    private boolean isViewPrepared;  // 标识fragment视图已经初始化完毕
    private boolean hasFetchData;  // 标识已经触发过懒加载数据

    protected View mRootView;

    protected abstract @LayoutRes int getLayoutId();
    protected abstract void initViews();
    protected abstract void lazyFetchData();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("TAG", "onViewCreated 方法执行");
        isViewPrepared = true;
        lazyFetchDataIfPrepared();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("TAG", "onCreateView 方法执行");
        mRootView = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, mRootView);
        initViews();
        return mRootView;
    }

    // v4.Fragment 中的方法
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e("TAG", "setUserVisibleHint 方法执行");
        if(isVisibleToUser){
            lazyFetchDataIfPrepared();
        }
    }

    private void lazyFetchDataIfPrepared() {
        if(getUserVisibleHint() && !hasFetchData && isViewPrepared){
            hasFetchData = true;
            lazyFetchData();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        hasFetchData = false;
        isViewPrepared = false;
        ButterKnife.unbind(this);
        // 取消请求
        RequestManager.cancelRequest(tag);
    }
}
