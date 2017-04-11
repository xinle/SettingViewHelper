package com.lelive.settingviewhelper.view;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.lelive.settingviewhelper.BaseSettingModel;

/**
 * Created by xinle on 16/12/18.
 */

public interface ISettingView <T extends BaseSettingModel>{
    View getSettingView();
    View inflate(Context context, ViewGroup viewGroup);
    void updateView();
}
