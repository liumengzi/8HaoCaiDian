package com.tuding.client.eightnumcolour.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.activity.BetActivity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BetAdapter extends BaseAdapter {
    private static final String TAG = "BetAdapter";
    BetActivity betActivity;
    private CheckBox yuan_tv;
    private HashSet<Integer> data;
    int num;

    public Set<Integer> getCompoundButtonIntegerHashMap() {
        return compoundButtonIntegerHashMap;
    }

    private Set<Integer> compoundButtonIntegerHashMap;
    private Set<Integer> compoundButtonIntegerHashMap1;

    public BetAdapter(BetActivity betActivity, int num) {
        this.betActivity = betActivity;
        this.num = num;
    }

    @Override
    public int getCount() {
        return num;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = betActivity.getLayoutInflater().inflate(R.layout.item_bet, null, false);

        String value = getValue(i + 1);

        if (num == 35) {
            yuan_tv = view.findViewById(R.id.yuan_tv);
            yuan_tv.setBackgroundResource(R.drawable.bet_selector);
            yuan_tv.setTextColor(R.drawable.main_text_selector);
            if (i == 0) {
                compoundButtonIntegerHashMap = new HashSet<>();
            }
        } else {
            yuan_tv = view.findViewById(R.id.yuan_tv);
            yuan_tv.setBackgroundResource(R.drawable.bet_bule_selector);
            yuan_tv.setTextColor(R.drawable.bule_text_selector);
            if (i == 0) {
                compoundButtonIntegerHashMap1 = new HashSet<>();
            }
        }
        yuan_tv.setText(value);

        yuan_tv.setOnCheckedChangeListener(changeListener);
        if (data != null) {
            for (Integer datum : data) {
                if (datum == i + 1) {
                    yuan_tv.setChecked(true);
                }
            }
        }


        return view;
    }

    CompoundButton.OnCheckedChangeListener changeListener = new CompoundButton.OnCheckedChangeListener() {


        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            if (isChecked) {
                buttonView.setTextColor(Color.WHITE);
                int parseint = Integer.parseInt(buttonView.getText().toString().trim());
                if (num == 35) {
                    compoundButtonIntegerHashMap.add(parseint);
                } else {
                    compoundButtonIntegerHashMap1.add(parseint);
                }

            } else {
                int parseint = Integer.parseInt(buttonView.getText().toString().trim());
                if (num == 35) {
                    buttonView.setBackgroundResource(R.drawable.bet_selector);
                    buttonView.setTextColor(R.drawable.main_text_selector);
                    compoundButtonIntegerHashMap.remove(parseint);
                } else {
                    buttonView.setBackgroundResource(R.drawable.bet_bule_selector);
                    buttonView.setTextColor(R.drawable.bule_text_selector);
                    compoundButtonIntegerHashMap1.remove(parseint);
                }

            }
            if (num == 35) {
                Log.d(TAG, "onCheckedChanged:1 " + compoundButtonIntegerHashMap.size());
            } else {

                Log.d(TAG, "onCheckedChanged:2 " + compoundButtonIntegerHashMap1.size());
            }
            betActivity.setVluse(compoundButtonIntegerHashMap, compoundButtonIntegerHashMap1);

        }
    };

    /**
     * 个位数补0操作
     *
     * @param num
     * @return
     */
    public static String getValue(int num) {
        return String.valueOf(num > 9 ? num : ("0" + num));
    }


    public void setData(HashSet<Integer> data) {
        this.data = data;
    }
}
