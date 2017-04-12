package com.lelive.settingviewhelper.view;


import com.lelive.settingviewhelper.model.BaseSettingModel;

/**
 * Created by xinle on 16/12/18.
 */

class SettingCustomView extends BaseSettingView {
    public SettingCustomView(BaseSettingModel mBaseSettingModel) {
        super(mBaseSettingModel);
    }

    @Override
    protected int getItemLayoutId() {
        return 0;
    }

    @Override
    public void updateView() {
        mSettingView.requestLayout();
        mSettingView.invalidate();
    }
}
