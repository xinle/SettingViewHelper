package com.lelive.settingviewhelper.model;

import com.lelive.settingviewhelper.BaseSettingModel;

public class SettingCheckModel extends BaseSettingModel {
	private boolean isChecked = false;

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	
	protected SettingCheckModel() {
		super();
	}
	
}
