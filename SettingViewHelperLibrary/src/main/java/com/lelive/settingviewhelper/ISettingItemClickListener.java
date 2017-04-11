package com.lelive.settingviewhelper;

public interface ISettingItemClickListener<T extends BaseSettingModel> {
	void onClick(T settingModel);
}
