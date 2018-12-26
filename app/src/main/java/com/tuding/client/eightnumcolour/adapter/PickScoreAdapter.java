package com.tuding.client.eightnumcolour.adapter;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.activity.BasketballActivity;
import com.tuding.client.eightnumcolour.bean.FTMATCHBean;
import com.tuding.client.eightnumcolour.fragment.FT6MATCHBean;
import com.tuding.client.eightnumcolour.view.MyGridView;

import java.util.List;

class PickScoreAdapter extends BaseAdapter {
    BasketballActivity basketballActivity;
    String[] name = new String[]{"0", "总进球", "半全场", "胜", "平", "负"};
    String[] color = new String[]{"#e5d1c6","#d97fbd","#4cb5e7","#4cb5e7", "#459ccb", "#acb57e"};
    private FTMATCHBean.DataBean.MatchListBeanX.MatchListBean.OddsBean data;
    private PickScoreGvAdapter pickScoreGvAdapter;

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


        convertView = basketballActivity.getLayoutInflater().inflate(R.layout.item_pick_score_lv, null, false);
        TextView name_tv = convertView.findViewById(R.id.name_tv);
        LinearLayout ll = convertView.findViewById(R.id.ll);
        name_tv.setText(name[position]);
        name_tv.setBackgroundColor(Color.parseColor(color[position]));

        MyGridView my_gv = convertView.findViewById(R.id.my_gv);
        pickScoreGvAdapter = new PickScoreGvAdapter(basketballActivity);
        my_gv.setAdapter(pickScoreGvAdapter);
        switch (position) {
            case 0:
                List<FTMATCHBean.DataBean.MatchListBeanX.MatchListBean.OddsBean.SpfBean> spf = data.getSpf();
                name_tv.setVisibility(View.GONE);
                ll.setVisibility(View.VISIBLE);
                my_gv.setNumColumns(3);
                pickScoreGvAdapter.setData(data);

                break;
            case 1:
                name_tv.setVisibility(View.VISIBLE);
                ll.setVisibility(View.GONE);
                my_gv.setNumColumns(4);
                break;
            case 2:
                name_tv.setVisibility(View.VISIBLE);
                ll.setVisibility(View.GONE);
                my_gv.setNumColumns(3);
                break;
            default:
                name_tv.setVisibility(View.VISIBLE);
                ll.setVisibility(View.GONE);
                my_gv.setNumColumns(5);
                break;
        }
        return convertView;
    }

    public void setData(FTMATCHBean.DataBean.MatchListBeanX.MatchListBean.OddsBean data) {
        this.data = data;
    }
}
