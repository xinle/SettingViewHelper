package com.lelive.settingviewhelperapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ScrollView;

import com.lelive.settingviewhelper.BaseSettingModel;
import com.lelive.settingviewhelper.SettingCreateViewUtil;
import com.lelive.settingviewhelper.SettingGroup;
import com.lelive.settingviewhelper.builder.SettingRadioBuilder;
import com.lelive.settingviewhelper.builder.SettingTextInputBuilder;
import com.lelive.settingviewhelper.model.SettingTextInputModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private ScrollView mScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String mContent = "飞机";

        String [] arrStrings = null;
        try {
            arrStrings = getResources().getStringArray(R.array.vehicle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(arrStrings == null) {
            return;
        }

        mScrollView = (ScrollView) findViewById(R.id.common_scroll);

        List<BaseSettingModel> settingModels = new ArrayList<BaseSettingModel>();
        boolean isSelected = false;
        for (int i = 0; i < arrStrings.length; i++) {
            String title = arrStrings[i];
            if(title.equals(mContent)) {
                isSelected = true;
                settingModels.add(new SettingRadioBuilder(title).setSelected(true).create());
            } else {
                settingModels.add(new SettingRadioBuilder(title).setSelected(false).create());
            }
        }
        SettingGroup settingGroup = new SettingGroup(settingModels);

        List<BaseSettingModel> settingModels2 = new ArrayList<BaseSettingModel>();
        SettingTextInputModel inputModel = new SettingTextInputBuilder("编辑说明", "请输入约会简要说明").create();

        if (!isSelected) {
            inputModel.setContent(mContent);
        }

        settingModels2.add(inputModel);
        SettingGroup settingGroup2 = new SettingGroup(settingModels2);

        List<SettingGroup> settingGroups = new ArrayList<SettingGroup>();
        settingGroup.setCheckOne(true);
        settingGroups.add(settingGroup);
        settingGroups.add(settingGroup2);

        mScrollView.addView(SettingCreateViewUtil.createSettingViewByGroup(this, settingGroups));
    }
}
