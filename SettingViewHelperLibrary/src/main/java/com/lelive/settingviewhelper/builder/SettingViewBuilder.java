package com.lelive.settingviewhelper.builder;

import com.lelive.settingviewhelper.model.BaseSettingModel;
import com.lelive.settingviewhelper.ISettingItemClickListener;

abstract class SettingViewBuilder<T extends BaseSettingModel> {
	protected T t;

	SettingViewBuilder(Class<T> classType, CharSequence title, ISettingItemClickListener<T> settingItemClickListener) {

		T t = null;
		try {
			if (classType != null) {
				t = classType.newInstance();
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		t.setTitle(title);
		t.setSettingItemClickListener(settingItemClickListener);

		this.t = t;
	}
	
	public SettingViewBuilder<T> iconUrl(String iconUrl) {
		t.setIconUrl(iconUrl);
		return this;
	}
	
	public SettingViewBuilder<T> iconRes(int iconRes) {
		t.setIconRes(iconRes);
		return this;
	}
	
	public T create() {
		return t;
	}
}