package com.lelive.settingviewhelper.view;

import android.widget.ImageView;

import com.lelive.settingviewhelper.R;
import com.lelive.settingviewhelper.model.SettingRadioModel;

/**
 * Created by xinle on 16/12/18.
 */

public class SettingRadioView extends BaseSettingView<SettingRadioModel> {

    public SettingRadioView(SettingRadioModel mBaseSettingModel) {
        super(mBaseSettingModel);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.lay_setting_item_radio;
    }

    @Override
    public void updateView() {
        setCommonData(mSettingView.getContext() ,mBaseSettingModel);

        ImageView radio = (ImageView) mSettingView.findViewById(R.id.setting_item_check);
        radio.setSelected(mBaseSettingModel.isSelected());
    }
}
