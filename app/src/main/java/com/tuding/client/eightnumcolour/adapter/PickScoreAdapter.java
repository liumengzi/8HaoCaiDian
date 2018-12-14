package com.tuding.client.eightnumcolour.adapter;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.activity.BasketballActivity;
import com.tuding.client.eightnumcolour.view.MyGridView;

class PickScoreAdapter extends BaseAdapter {
    BasketballActivity basketballActivity;
    String[] name = new String[]{"胜", "平", "负"};
    String[] color = new String[]{"#d97fbd", "#459ccb", "#acb57e"};

    public PickScoreAdapter(BasketballActivity basketballActivity) {
        this.basketballActivity = basketballActivity;

    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View inflate = basketballActivity.getLayoutInflater().inflate(R.layout.item_pick_score_lv, null, false);
        TextView name_tv = inflate.findViewById(R.id.name_tv);
        name_tv.setText(name[position]);
        name_tv.setBackgroundColor(Color.parseColor(color[position]));

        MyGridView my_gv = inflate.findViewById(R.id.my_gv);
        PickScoreGvAdapter pickScoreGvAdapter = new PickScoreGvAdapter(basketballActivity);
        my_gv.setAdapter(pickScoreGvAdapter);
        return inflate;
    }
}
