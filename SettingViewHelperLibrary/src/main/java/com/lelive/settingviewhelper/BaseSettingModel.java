package com.lelive.settingviewhelper;

import com.lelive.settingviewhelper.view.BaseSettingView;

public abstract class BaseSettingModel {
	private CharSequence title;
	private String iconUrl;
	private int iconRes;
	private Object tag;
	private ISettingItemClickListener settingItemClickListener;
	private BaseSettingView settingView;

	public CharSequence getTitle() {
		return title;
	}

	public void setTitle(CharSequence title) {
		this.title = title;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public int getIconRes() {
		return iconRes;
	}

	public void setIconRes(int iconRes) {
		this.iconRes = iconRes;
	}

	public ISettingItemClickListener getSettingItemClickListener() {
		return settingItemClickListener;
	}

	public void setSettingItemClickListener(ISettingItemClickListener settingItemClickListener) {
		this.settingItemClickListener = settingItemClickListener;
	}

	public Object getTag() {
		return tag;
	}

	public void setTag(Object tag) {
		this.tag = tag;
	}

	public BaseSettingView getSettingView() {
		return settingView;
	}

	public void setSettingView(BaseSettingView settingView) {
		this.settingView = settingView;
	}

	public void updateView() {
		if(this.settingView != null) {
			this.settingView.updateView();
		}
	}
}
