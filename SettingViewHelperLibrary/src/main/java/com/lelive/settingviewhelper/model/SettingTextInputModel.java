package com.lelive.settingviewhelper.model;

public class SettingTextInputModel extends BaseSettingModel {
	private CharSequence inputHint;
	private CharSequence content;
	private int maxLength;

	public CharSequence getInputHint() {
		return inputHint;
	}

	public void setInputHint(CharSequence inputHint) {
		this.inputHint = inputHint;
	}

	public CharSequence getContent() {
		return content;
	}

	public void setContent(CharSequence content) {
		this.content = content;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
}
