package com.lelive.settingviewhelper.builder;


import com.lelive.settingviewhelper.SettingViewBuilder;
import com.lelive.settingviewhelper.model.SettingRadioModel;

public class SettingRadioBuilder extends SettingViewBuilder<SettingRadioModel> {

	public SettingRadioBuilder(CharSequence title) {
		super(SettingRadioModel.class, title, null);
	}

	public SettingRadioBuilder setSelected(boolean isSelected) {
		t.setSelected(isSelected);
		return this;
	}
}
