package com.lelive.settingviewhelper.model;


import com.lelive.settingviewhelper.BaseSettingModel;

public class SettingRadioModel extends BaseSettingModel {
	private int groupId;
	private int index;
	private boolean isSelected;

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	public String getViewTag() {
		return groupId + "" + index;
	}
}
