package com.lelive.settingviewhelper.model;

import com.lelive.settingviewhelper.BaseSettingModel;

public class SettingNormalModel extends BaseSettingModel {
	private boolean haveArrows = true;
	private CharSequence rightContent;
	private CharSequence rightHint;

	public boolean isHaveArrows() {
		return haveArrows;
	}

	public void setHaveArrows(boolean haveArrows) {
		this.haveArrows = haveArrows;
	}

	public CharSequence getRightContent() {
		return rightContent;
	}

	public void setRightContent(CharSequence rightContent) {
		this.rightContent = rightContent;
	}

	public CharSequence getRightHint() {
		return rightHint;
	}

	public void setRightHint(CharSequence rightHint) {
		this.rightHint = rightHint;
	}
}
