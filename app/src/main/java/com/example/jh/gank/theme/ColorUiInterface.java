package com.example.jh.gank.theme;

import android.content.res.Resources;
import android.view.View;

/**
 * Created by jinhui on 2017/8/3.
 * 邮箱: 1004260403@qq.com
 *
 * 换肤接口
 */

public interface ColorUiInterface {

    View getView();

    void setTheme(Resources.Theme themeId);
}
