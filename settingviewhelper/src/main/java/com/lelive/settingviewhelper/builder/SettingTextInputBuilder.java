package com.lelive.settingviewhelper.builder;


import com.lelive.settingviewhelper.SettingViewBuilder;
import com.lelive.settingviewhelper.model.SettingTextInputModel;

public class SettingTextInputBuilder extends SettingViewBuilder<SettingTextInputModel> {
	public SettingTextInputBuilder(CharSequence title ,CharSequence inputHint) {
		super(SettingTextInputModel.class, title, null);
		t.setInputHint(inputHint);
	}
	
	public SettingTextInputBuilder setContent(CharSequence content) {
		t.setContent(content);
		return this;
	}
	
	public SettingTextInputBuilder setMaxLength(int maxLength) {
		t.setMaxLength(maxLength);
		return this;
	}
}
