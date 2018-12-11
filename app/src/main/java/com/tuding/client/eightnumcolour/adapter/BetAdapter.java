package com.tuding.client.eightnumcolour.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.activity.BetActivity;

import java.util.HashSet;

public class BetAdapter extends BaseAdapter {
    BetActivity betActivity;
    private int select;
    private CheckBox yuan_tv;
    private HashSet<Integer> data;
    int num;

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
        } else {
            yuan_tv = view.findViewById(R.id.yuan_tv);
            yuan_tv.setBackgroundResource(R.drawable.bet_bule_selector);
            yuan_tv.setTextColor(R.drawable.bule_text_selector);
        }
        yuan_tv.setText(value);
        yuan_tv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setTextColor(Color.WHITE);
                } else {
                    if (num == 35) {
                        buttonView.setBackgroundResource(R.drawable.bet_selector);
                        buttonView.setTextColor(R.drawable.main_text_selector);
                    } else {
                        buttonView.setBackgroundResource(R.drawable.bet_bule_selector);
                        buttonView.setTextColor(R.drawable.bule_text_selector);
                    }
                }
            }
        });
        if (data != null) {
            for (Integer datum : data) {
                if (datum == i + 1) {
                    yuan_tv.setChecked(true);
                }
            }
        }


        return view;
    }

    /**
     * 个位数补0操作
     *
     * @param num
     * @return
     */
    public static String getValue(int num) {
        return String.valueOf(num > 9 ? num : ("0" + num));
    }

    public void setSelect(int select) {
        this.select = select;
        notifyDataSetChanged();

    }

    public void setData(HashSet<Integer> data) {
        this.data = data;
    }
}
