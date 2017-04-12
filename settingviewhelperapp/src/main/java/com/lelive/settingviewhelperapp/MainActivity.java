package com.lelive.settingviewhelperapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.Toast;

import com.lelive.settingviewhelper.model.BaseSettingModel;
import com.lelive.settingviewhelper.ISettingItemClickListener;
import com.lelive.settingviewhelper.SettingCreateViewUtil;
import com.lelive.settingviewhelper.SettingGroup;
import com.lelive.settingviewhelper.builder.SettingCheckBuilder;
import com.lelive.settingviewhelper.builder.SettingNormalBuilder;
import com.lelive.settingviewhelper.builder.SettingRadioBuilder;
import com.lelive.settingviewhelper.builder.SettingTextInputBuilder;
import com.lelive.settingviewhelper.model.SettingCheckModel;
import com.lelive.settingviewhelper.model.SettingNormalModel;
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
        settingGroup.setCheckOne(true);

        BaseSettingModel timeModel = new SettingNormalBuilder("出发时间", new ISettingItemClickListener<SettingNormalModel>() {
            @Override
            public void onClick(final SettingNormalModel settingModel) {
                Toast.makeText(MainActivity.this, settingModel.getTitle(), Toast.LENGTH_SHORT).show();
            }
        }).rightContent("2017-04-12").create();
        SettingGroup settingGroup1 = new SettingGroup(timeModel);


        List<BaseSettingModel> settingModels2 = new ArrayList<BaseSettingModel>();
        SettingTextInputModel inputModel = new SettingTextInputBuilder("编辑说明", "请输入简要说明").create();

        if (!isSelected) {
            inputModel.setContent(mContent);
        }

        settingModels2.add(inputModel);
        SettingGroup settingGroup2 = new SettingGroup(settingModels2);

        SettingCheckModel checkModel = new SettingCheckBuilder("是否联网", new ISettingItemClickListener<SettingCheckModel>() {
            @Override
            public void onClick(SettingCheckModel settingModel) {
                Toast.makeText(MainActivity.this, "切换了", Toast.LENGTH_SHORT).show();
            }
        }).create();

        SettingGroup settingGroup3 = new SettingGroup(checkModel);

        List<SettingGroup> settingGroups = new ArrayList<SettingGroup>();

        settingGroups.add(settingGroup);
        settingGroups.add(settingGroup1);
        settingGroups.add(settingGroup2);
        settingGroups.add(settingGroup3);

        mScrollView.addView(SettingCreateViewUtil.createSettingViewByGroup(this, settingGroups));
    }
}
