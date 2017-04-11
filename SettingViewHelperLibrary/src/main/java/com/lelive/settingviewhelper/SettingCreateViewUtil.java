package com.lelive.settingviewhelper;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lelive.settingviewhelper.model.SettingRadioModel;
import com.lelive.settingviewhelper.view.BaseSettingView;

import java.util.List;

public class SettingCreateViewUtil {
	public static View createSettingViewByGroup(final Context context, List<SettingGroup> settingGroups) {
		if (settingGroups == null || settingGroups.isEmpty()) {
			return null;
		}

		int px16 = dp2px(context, 16);
		
		final LinearLayout linearLayout = new LinearLayout(context);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		SettingViewFactory settingViewFactory = new SettingViewFactory();
		for (int i = 0; i < settingGroups.size(); i++) {
			final SettingGroup settingGroup = settingGroups.get(i);
			
			if(!TextUtils.isEmpty(settingGroup.getHeader())) {
				linearLayout.addView(createHeaderOrFooterView(context ,settingGroup.getHeader(), true));
			} else {
				View view = new View(context);
				view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, px16));
				linearLayout.addView(view);
			}
			
			linearLayout.addView(createLine(context));
			
			final List<BaseSettingModel> baseSettingModels = settingGroup.getSettingModels();
			
			if(baseSettingModels != null && !baseSettingModels.isEmpty()) {
				for (int j = 0; j < baseSettingModels.size(); j++) {

					BaseSettingModel t = baseSettingModels.get(j);
					final BaseSettingView settingView = settingViewFactory.getSettingViewByModel(t);
					View view = settingView.inflate(context ,linearLayout);
					if(view != null) {
						view.setTag(t.getTag());
					}
					t.setSettingView(settingView);

					if(t instanceof SettingRadioModel) {
						final int tempi = j;
						settingView.getSettingView().setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								if(settingGroup.isCheckOne()) {
									for (int k = 0; k < baseSettingModels.size(); k++) {
										BaseSettingModel settingModel = baseSettingModels.get(k);
										if(settingModel instanceof SettingRadioModel) {
											SettingRadioModel settingRadioModel = (SettingRadioModel) settingModel;
											settingRadioModel.setSelected(k == tempi);
											settingRadioModel.updateView();
										}
									}
								} else {
									SettingRadioModel settingRadioModel = (SettingRadioModel) baseSettingModels.get(tempi);
									settingRadioModel.setSelected(!settingRadioModel.isSelected());
									settingRadioModel.updateView();
								}
							}
						});
					}
 					linearLayout.addView(createLine(context));
				}
			}

			if(!TextUtils.isEmpty(settingGroup.getFooter())) {
				linearLayout.addView(createHeaderOrFooterView(context ,settingGroup.getFooter() ,false));
			}
		}
		
		return linearLayout;
	}
	
	private static TextView createHeaderOrFooterView(Context context , String content , boolean isHeader) {
		TextView header = new TextView(context);
		int px16 = dp2px(context, 16);
		header.setPadding(px16, isHeader ? 0 : px16, px16, isHeader ? px16 : 0);
		header.setTextColor(context.getResources().getColor(R.color.common_subtitle_color));
		header.setText(content);
		return header;
	}
	
	private static View createLine(Context context){
		View view = new View(context);
		view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, dp2px(context, 1)));
		view.setBackgroundColor(context.getResources().getColor(R.color.common_split_color));
		return view;
	}

	public static int dp2px(Context context, float dipValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}

}
