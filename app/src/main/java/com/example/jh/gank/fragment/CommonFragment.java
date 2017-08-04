package com.example.jh.gank.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jh.gank.R;
import com.example.jh.gank.base.BaseListFragment;
import com.example.jh.gank.bean.GanHuo;
import com.example.jh.gank.common.recyclerview.base.ViewHolder;

/**
 * Created by jinhui on 2017/8/4.
 * 邮箱: 1004260403@qq.com
 */

public class CommonFragment extends BaseListFragment<GanHuo> {

    public static final String ARG_TYPE = "type";

    private String type;

    public static CommonFragment newInstance(String type) {

        Bundle args = new Bundle();
        CommonFragment fragment = new CommonFragment();
        args.putString(ARG_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            type = getArguments().getString(ARG_TYPE);
        Log.e("TAG", type);
    }


    @Override
    public int getItemLayout() {
        Log.e("TAG", "getItemLayout 方法");
        return R.layout.item_common;
    }

    @Override
    public void fillValue(ViewHolder holder, GanHuo ganHuo, int position) {
        Log.e("TAG", "fillValue 方法");
        TextView text = holder.getView(R.id.text);
        text.setText(Html.fromHtml("<a href=\""
                + ganHuo.getUrl() + "\">"
                + ganHuo.getDesc() + "</a>"
                + "[" + ganHuo.getWho() + "]"));
        text.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    protected String getUrl() {
        Log.e("TAG", "getUrl 方法");
        return "http://gank.io/api/data/" + type + "/"
                + String.valueOf(pageSize) + "/"
                + String.valueOf(page);
    }


}