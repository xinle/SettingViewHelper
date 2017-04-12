package com.lelive.settingviewhelper.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lelive.settingviewhelper.R;
import com.lelive.settingviewhelper.model.BaseSettingModel;

/**
 * Created by xinle on 16/12/18.
 */

public abstract class BaseSettingView<T extends BaseSettingModel> implements ISettingView<T> {
    protected View mSettingView;

    protected T mBaseSettingModel;

    private BaseSettingView(){

    }

    BaseSettingView(T mBaseSettingModel) {
        this.mBaseSettingModel = mBaseSettingModel;
    }

    protected abstract int getItemLayoutId();

    @Override
    public View inflate(Context context, ViewGroup parentView) {
        int itemLayoutId = getItemLayoutId();
        // 这里表示是自定义View
        if(itemLayoutId <= 0) {
            if(mSettingView != null && parentView != null) {
                parentView.addView(mSettingView);
            }
            return mSettingView;
        }

        View inflate = LayoutInflater.from(context).inflate(itemLayoutId, parentView ,false);

        if(parentView != null) {
            parentView.addView(inflate);
        }

        mSettingView = inflate;

        updateView();

        return inflate;
    }

    protected void setCommonData(Context context ,T t) {
        ImageView icon = (ImageView) mSettingView.findViewById(R.id.setting_item_icon);
        TextView title = (TextView) mSettingView.findViewById(R.id.setting_item_text);

        if(t.getIconRes() > 0) {
            Glide.with(context).load(t.getIconRes()).into(icon);
        } else if(!TextUtils.isEmpty(t.getIconUrl())){
            Glide.with(context).load(t.getIconUrl()).into(icon);
        } else {
            icon.setVisibility(View.GONE);
        }

        if(!TextUtils.isEmpty(t.getTitle())) {
            title.setText(t.getTitle());
        } else {
            title.setText("");
        }
    }

    @Override
    public View getSettingView() {
        return mSettingView;
    }

    /**
     * XXX 一般不要设置这个
     * @param mSettingView
     */
    public void setSettingView(View mSettingView) {
        this.mSettingView = mSettingView;
    }
}
