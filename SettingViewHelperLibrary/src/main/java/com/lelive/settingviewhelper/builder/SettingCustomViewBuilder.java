package com.lelive.settingviewhelper.builder;


import android.view.View;

import com.lelive.settingviewhelper.model.SettingCustomViewModel;

public class SettingCustomViewBuilder extends SettingViewBuilder<SettingCustomViewModel> {

	public SettingCustomViewBuilder(View customView) {
		super(SettingCustomViewModel.class, null, null);
		t.setCustomView(customView);
	}
	
}
