package com.lelive.settingviewhelper.view;

import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.lelive.settingviewhelper.R;
import com.lelive.settingviewhelper.model.SettingTextInputModel;


/**
 * Created by xinle on 16/12/18.
 */

public class SettingTextInputView extends BaseSettingView<SettingTextInputModel> {
    public SettingTextInputView(SettingTextInputModel mBaseSettingModel) {
        super(mBaseSettingModel);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.lay_setting_item_input;
    }

    @Override
    public void updateView() {
        setCommonData(mSettingView.getContext() ,mBaseSettingModel);

        EditText editText = (EditText) mSettingView.findViewById(R.id.setting_item_input_edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBaseSettingModel.setContent(s);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        editText.setText(mBaseSettingModel.getContent());
        editText.setHintTextColor(ContextCompat.getColor(mSettingView.getContext(), R.color.common_subtitle_color));
        editText.setHint(mBaseSettingModel.getInputHint());
    }
}
