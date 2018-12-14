package com.tuding.client.eightnumcolour.adapter;

import android.annotation.SuppressLint;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.bean.MATCHRESULTBean;

import java.util.List;

public class ScoreAdapter extends BaseAdapter {
    FragmentActivity activity;
    private List<MATCHRESULTBean.DataBean.MatchListBean> data;

    public ScoreAdapter(FragmentActivity activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = activity.getLayoutInflater().inflate(R.layout.item_score, null, false);
        if (data != null) {
            TextView title_tv = view.findViewById(R.id.title_tv);
            TextView home_team_tv = view.findViewById(R.id.home_team_tv);
            TextView away_team_tv = view.findViewById(R.id.away_team_tv);
            TextView status_tv = view.findViewById(R.id.status_tv);
            ImageView home_team_logo_iv = view.findViewById(R.id.home_team_logo_iv);
            ImageView away_team_logo_iv = view.findViewById(R.id.away_team_logo_iv);
            MATCHRESULTBean.DataBean.MatchListBean matchListBean = data.get(i);
            title_tv.setText(matchListBean.getWeek() + matchListBean.getNumber() + " " + matchListBean.getLeague() + " " + matchListBean.getBegin_time());
            home_team_tv.setText(matchListBean.getHome_team());
            away_team_tv.setText(matchListBean.getAway_team());
            String home_score = matchListBean.getHome_score();
            String away_score = matchListBean.getAway_score();
            String home_score_half = matchListBean.getHome_score_half();
            String away_score_half = matchListBean.getAway_score_half();
            if (home_score != null && away_score != null && home_score_half != null && away_score_half != null) {
                status_tv.setText(home_score + ":" + away_score + "(半场 " + home_score_half + ":" + away_score_half + ")");
            }

            Glide.with(activity).load(matchListBean.getHome_team_logo()).into(home_team_logo_iv);
            Glide.with(activity).load(matchListBean.getAway_team_logo()).into(away_team_logo_iv);
        }
        return view;
    }

    public void setData(List<MATCHRESULTBean.DataBean.MatchListBean> data) {
        this.data = data;
    }
}
