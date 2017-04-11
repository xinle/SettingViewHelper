package com.lelive.settingviewhelper;

import com.lelive.settingviewhelper.model.SettingCheckModel;
import com.lelive.settingviewhelper.model.SettingCustomViewModel;
import com.lelive.settingviewhelper.model.SettingNormalModel;
import com.lelive.settingviewhelper.model.SettingRadioModel;
import com.lelive.settingviewhelper.model.SettingTextInputModel;
import com.lelive.settingviewhelper.view.BaseSettingView;
import com.lelive.settingviewhelper.view.SettingCheckView;
import com.lelive.settingviewhelper.view.SettingCustomView;
import com.lelive.settingviewhelper.view.SettingNormalView;
import com.lelive.settingviewhelper.view.SettingRadioView;
import com.lelive.settingviewhelper.view.SettingTextInputView;

/**
 * Created by xinle on 16/12/18.
 */

public class SettingViewFactory<T extends BaseSettingModel> {

    public BaseSettingView getSettingViewByModel(T t) {

        if (t instanceof SettingNormalModel) {
            return new SettingNormalView((SettingNormalModel) t);
        }
        else if (t instanceof SettingCheckModel) {
            return new SettingCheckView((SettingCheckModel) t);
        }
        else if (t instanceof SettingRadioModel) {
            return new SettingRadioView((SettingRadioModel) t);
        }
        else if (t instanceof SettingTextInputModel) {
            return new SettingTextInputView((SettingTextInputModel) t);
        }
        else if (t instanceof SettingCustomViewModel) {
            SettingCustomView settingCustomView = new SettingCustomView(t);
            settingCustomView.setSettingView(((SettingCustomViewModel) t).getCustomView());
            return settingCustomView;
        }
        throw new RuntimeException("没有相关的setting模型");
    }
}
