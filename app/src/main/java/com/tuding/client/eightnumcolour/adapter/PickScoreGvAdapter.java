package com.tuding.client.eightnumcolour.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.activity.BasketballActivity;
import com.tuding.client.eightnumcolour.bean.FTMATCHBean;

class PickScoreGvAdapter extends BaseAdapter {
    BasketballActivity basketballActivity;
    private FTMATCHBean.DataBean.MatchListBeanX.MatchListBean.OddsBean data;

    public PickScoreGvAdapter(BasketballActivity basketballActivity) {
        this.basketballActivity = basketballActivity;
    }

    @Override
    public int getCount() {
        return 10;
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
        View inflate = basketballActivity.getLayoutInflater().inflate(R.layout.item_pick_score_gv, null, false);
        return inflate;
    }

    public void setData(FTMATCHBean.DataBean.MatchListBeanX.MatchListBean.OddsBean data) {
        this.data = data;
    }
}
