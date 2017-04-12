package com.lelive.settingviewhelper;

import com.lelive.settingviewhelper.model.BaseSettingModel;

public interface ISettingItemClickListener<T extends BaseSettingModel> {
	void onClick(T settingModel);
}
