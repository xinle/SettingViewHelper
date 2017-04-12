package com.lelive.settingviewhelper.view;

import android.widget.CompoundButton;

import com.kyleduo.switchbutton.SwitchButton;
import com.lelive.settingviewhelper.R;
import com.lelive.settingviewhelper.model.SettingCheckModel;

/**
 * Created by xinle on 16/12/18.
 */

class SettingCheckView extends BaseSettingView<SettingCheckModel> {
    public SettingCheckView(SettingCheckModel mBaseSettingModel) {
        super(mBaseSettingModel);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.lay_setting_item_check;
    }

    @Override
    public void updateView() {
        setCommonData(mSettingView.getContext() ,mBaseSettingModel);

        SwitchButton switchButton = (SwitchButton) mSettingView.findViewById(R.id.switch_btn);
        switchButton.setChecked(mBaseSettingModel.isChecked());
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mBaseSettingModel.getSettingItemClickListener() != null) {
                    mBaseSettingModel.getSettingItemClickListener().onClick(mBaseSettingModel);
                }
            }
        });
    }
}
