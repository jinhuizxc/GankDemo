package com.example.jh.gank.fragment;

import com.example.jh.gank.base.BaseListFragment;
import com.example.jh.gank.bean.GanHuo;
import com.example.jh.gank.common.recyclerview.base.ViewHolder;

/**
 * Created by jinhui on 2017/8/4.
 * 邮箱: 1004260403@qq.com
 */

public class SettingFragment extends BaseListFragment<GanHuo> {
    @Override
    public int getItemLayout() {
        return 0;
    }

    @Override
    public void fillValue(ViewHolder holder, GanHuo ganHuo, int position) {

    }

    @Override
    protected String getUrl() {
        return null;
    }
}
