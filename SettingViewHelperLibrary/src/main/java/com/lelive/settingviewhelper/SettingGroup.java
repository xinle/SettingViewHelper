package com.lelive.settingviewhelper;


import com.lelive.settingviewhelper.model.SettingRadioModel;

import java.util.ArrayList;
import java.util.List;

public class SettingGroup {
	
	private String header;
	private String footer;
	private List<BaseSettingModel> settingModels;
	private boolean isCheckOne;
	
	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public SettingGroup(String header, String footer, List<BaseSettingModel> settingModels) {
		super();
		this.header = header;
		this.footer = footer;
		this.setSettingModels(settingModels);
	}

	public SettingGroup() {
		super();
	}

	public SettingGroup(List<BaseSettingModel> settingModels) {
		super();
		this.setSettingModels(settingModels);
	}
	
	public SettingGroup(final BaseSettingModel settingModel) {
		super();
		this.setSettingModels(new ArrayList<BaseSettingModel>() {
			{
				add(settingModel);
			}
		});
	}

	public boolean isCheckOne() {
		return isCheckOne;
	}

	public void setCheckOne(boolean isCheckOne) {
		this.isCheckOne = isCheckOne;
	}

	public List<BaseSettingModel> getSettingModels() {
		return settingModels;
	}

	public void setSettingModels(List<BaseSettingModel> settingModels) {
		if(settingModels == null) {
			return;
		}
		
		int index = 0;
		boolean haveChoose = false;
		int firstRadioIndex = -1;
		for (int i = 0; i < settingModels.size(); i++) {
			if(settingModels.get(i) instanceof SettingRadioModel) {
				if(firstRadioIndex == -1) {
					firstRadioIndex = i;
				}
				
				if(((SettingRadioModel) settingModels.get(i)).isSelected()) {
					haveChoose = true;
				}
				
				((SettingRadioModel) settingModels.get(i)).setIndex(index);
				((SettingRadioModel) settingModels.get(i)).setGroupId(this.hashCode());
				index ++;
			}
		}
		
		if(!haveChoose && firstRadioIndex != -1) {
			((SettingRadioModel) settingModels.get(firstRadioIndex)).setSelected(true);
		}
		
		this.settingModels = settingModels;
	}

}
