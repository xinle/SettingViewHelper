package com.lelive.settingviewhelper.builder;

import com.lelive.settingviewhelper.ISettingItemClickListener;
import com.lelive.settingviewhelper.model.SettingNormalModel;

public class SettingNormalBuilder extends SettingViewBuilder<SettingNormalModel> {
	
	public SettingNormalBuilder(CharSequence title, ISettingItemClickListener<SettingNormalModel> settingItemClickListener) {
		super(SettingNormalModel.class, title, settingItemClickListener);
	}

	public SettingNormalBuilder haveArrows(boolean haveArrows) {
		t.setHaveArrows(haveArrows);
		return this;
	}

	public SettingNormalBuilder rightContent(CharSequence rightContent) {
		t.setRightContent(rightContent);
		return this;
	}
	
	public SettingNormalBuilder rightHint(CharSequence rightHint) {
		t.setRightHint(rightHint);
		return this;
	}
	
	public SettingNormalBuilder tag(Object object) {
		t.setTag(object);
		return this;
	}
}
