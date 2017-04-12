package com.lelive.settingviewhelper.builder;

import com.lelive.settingviewhelper.ISettingItemClickListener;
import com.lelive.settingviewhelper.model.SettingCheckModel;

public class SettingCheckBuilder extends SettingViewBuilder<SettingCheckModel> {
	public SettingCheckBuilder(CharSequence title, ISettingItemClickListener<SettingCheckModel> settingItemClickListener) {
		super(SettingCheckModel.class, title, settingItemClickListener);
	}

	public SettingCheckBuilder isChecked(boolean ischecked) {
		t.setChecked(ischecked);
		return this;
	}
}