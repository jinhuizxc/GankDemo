package com.example.jh.gank.common.recyclerview.base;



/**
 * Created by jinhui on 2017/8/3.
 * 邮箱: 1004260403@qq.com
 */

public interface ItemViewDelegate<T> {

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);

    void convert(ViewHolder holder, T t, int position);
}
