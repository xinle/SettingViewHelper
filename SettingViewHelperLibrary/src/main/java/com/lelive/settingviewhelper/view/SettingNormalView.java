package com.lelive.settingviewhelper.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lelive.settingviewhelper.R;
import com.lelive.settingviewhelper.model.SettingNormalModel;

/**
 * Created by xinle on 16/12/18.
 */

public class SettingNormalView extends BaseSettingView<SettingNormalModel> {

    public SettingNormalView(SettingNormalModel mBaseSettingModel) {
        super(mBaseSettingModel);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.lay_setting_item_normal;
    }

    @Override
    public void updateView() {
        setCommonData(mSettingView.getContext() ,mBaseSettingModel);

        ImageView arrow = (ImageView) mSettingView.findViewById(R.id.setting_item_arrow);
        TextView rightContent = (TextView) mSettingView.findViewById(R.id.setting_item_right_content);

        arrow.setVisibility(mBaseSettingModel.isHaveArrows() ? View.VISIBLE : View.GONE);
        if(!TextUtils.isEmpty(mBaseSettingModel.getRightContent())) {
            rightContent.setText(mBaseSettingModel.getRightContent());
            rightContent.setTextColor(mSettingView.getContext().getResources().getColor(R.color.common_subtitle_color));
        } else {
            if(!TextUtils.isEmpty(mBaseSettingModel.getRightHint())) {
                rightContent.setText(mBaseSettingModel.getRightHint());
                rightContent.setTextColor(mSettingView.getContext().getResources().getColor(R.color.common_threetitle_color));
            } else {
                rightContent.setText("");
            }
        }

        if(mBaseSettingModel.getSettingItemClickListener() != null) {
            mSettingView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mBaseSettingModel.getSettingItemClickListener().onClick(mBaseSettingModel);
                }
            });
        }

    }
}
