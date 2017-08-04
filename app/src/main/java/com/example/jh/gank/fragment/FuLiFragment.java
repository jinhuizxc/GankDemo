package com.example.jh.gank.fragment;

import android.widget.ImageView;

import com.example.jh.gank.R;
import com.example.jh.gank.base.BaseListFragment;
import com.example.jh.gank.bean.GanHuo;
import com.example.jh.gank.common.recyclerview.base.ViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by jinhui on 2017/8/4.
 * 邮箱: 1004260403@qq.com
 */

public class FuLiFragment extends BaseListFragment<GanHuo> {

    @Override
    public int getItemLayout() {
        return R.layout.item_fuli;
    }

    @Override
    public void fillValue(ViewHolder holder, GanHuo ganHuo, int position) {
        ImageView mImage = holder.getView(R.id.image);
        Picasso.with(getContext()).load(ganHuo.getUrl()).placeholder(R.mipmap.avatar).into(mImage);
    }

    @Override
    protected String getUrl() {
        return "http://gank.io/api/data/福利/" + String.valueOf(pageSize) + "/" + String.valueOf(page);
    }
}
