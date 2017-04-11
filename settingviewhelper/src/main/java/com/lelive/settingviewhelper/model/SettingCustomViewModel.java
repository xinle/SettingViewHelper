package com.lelive.settingviewhelper.model;


import android.view.View;

import com.lelive.settingviewhelper.BaseSettingModel;

public class SettingCustomViewModel extends BaseSettingModel {
	private View customView;

	public View getCustomView() {
		return customView;
	}

	public void setCustomView(View customView) {
		this.customView = customView;
	}
}
