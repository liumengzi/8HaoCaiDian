package com.tuding.client.eightnumcolour.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.activity.BasketballActivity;
import com.tuding.client.eightnumcolour.bean.FT9MATCHBean;
import com.tuding.client.eightnumcolour.bean.FTMATCHBean;
import com.tuding.client.eightnumcolour.fragment.BTMATCHBean;
import com.tuding.client.eightnumcolour.fragment.FT6MATCHBean;

import java.util.ArrayList;
import java.util.List;

public class BasketballAdapter extends BaseAdapter {
    BasketballActivity basketballActivity;
    private int type;
    private View inflate;
    private FT6MATCHBean.DataBean data;
    private ViewHolder viewHolder;
    private FTMATCHBean.DataBean data1;
    private FT9MATCHBean.DataBean data2;
    private BTMATCHBean.DataBean data3;

    public BasketballAdapter(BasketballActivity basketballActivity) {

        this.basketballActivity = basketballActivity;
    }

    @Override
    public int getCount() {
        if (data1 != null && data1.getMatchList().size() > 0) {
            return data1.getMatchList().get(0).getMatchList().size();
        } else if (data != null) {
            return data.getMatchList().size();
        } else if (data2 != null) {
            return data2.getMatchList().size();
        } else if (data3 != null) {
            return data3.getMatchList().get(0).getMatchList().size();
        } else {
            return 0;
        }

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            switch (type) {
                case 0:
                    convertView = basketballActivity.getLayoutInflater().inflate(R.layout.item_single_pass, null, false);
                    break;
                case 1:
                    convertView = basketballActivity.getLayoutInflater().inflate(R.layout.item_pick_score, null, false);

                    break;
                case 2:
                    convertView = basketballActivity.getLayoutInflater().inflate(R.layout.item_tally, null, false);
                    break;
                case 3:
                    convertView = basketballActivity.getLayoutInflater().inflate(R.layout.item_half_full, null, false);
                    break;

                case 4:
                    convertView = basketballActivity.getLayoutInflater().inflate(R.layout.item_six_and_a_half, null, false);
                    break;
                case 5:
                    convertView = basketballActivity.getLayoutInflater().inflate(R.layout.item_rececolorbasketball, null, false);
                    break;
                case 6:
                    convertView = basketballActivity.getLayoutInflater().inflate(R.layout.item_baskball, null, false);
                    break;
                case 7:
                    convertView = basketballActivity.getLayoutInflater().inflate(R.layout.item_choose_nine, null, false);
                    break;

            }
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        switch (type) {
            case 0:
                setType4(position);
                break;
            case 1:
                viewHolder.pick_score_tv.setTag(position);
                viewHolder.pick_score_tv.setOnClickListener(scoreClickListener);
                break;
            case 2:

                if (data1 != null) {
                    List<FTMATCHBean.DataBean.MatchListBeanX> matchList = data1.getMatchList();
                    FTMATCHBean.DataBean.MatchListBeanX.MatchListBean matchListBean = matchList.get(0).getMatchList().get(position);
                    String league = matchListBean.getLeague();
                    String number = matchListBean.getNumber();
                    String home_team = matchListBean.getHome_team();
                    String away_team = matchListBean.getAway_team();
                    String end_time = matchListBean.getEnd_time();
                    String concede = matchListBean.getConcede();

                    FTMATCHBean.DataBean.MatchListBeanX.MatchListBean.OddsBean odds = matchListBean.getOdds();
                    List<FTMATCHBean.DataBean.MatchListBeanX.MatchListBean.OddsBean.JqsBean> jqs = odds.getJqs();
                    ArrayList<TextView> textViews = new ArrayList<>();
                    textViews.add(viewHolder.ban_tv);
                    textViews.add(viewHolder.ban_tv1);
                    textViews.add(viewHolder.ban_tv2);
                    textViews.add(viewHolder.ban_tv3);
                    textViews.add(viewHolder.quan_tv);
                    textViews.add(viewHolder.quan_tv1);
                    textViews.add(viewHolder.quan_tv2);
                    textViews.add(viewHolder.quan_tv3);
                    if (jqs != null) {
                        for (int i = 0; i < jqs.size(); i++) {
                            String odds1 = jqs.get(i).getOdds();
                            textViews.get(i).setText(odds1);
                        }

                    }
                    viewHolder.begin_time_tv.setText(end_time + "截止");
                    viewHolder.home_team_tv.setText(home_team);
                    viewHolder.away_team_tv.setText(away_team);
                    viewHolder.league_tv.setText(number);
                    viewHolder.numb_tv.setText(league);
                }
                break;
            case 3:

                break;

            case 4:
                if (data != null) {
                    List<FT6MATCHBean.DataBean.MatchListBean> matchList = data.getMatchList();
                    FT6MATCHBean.DataBean.MatchListBean matchListBean = matchList.get(position);
                    String league = matchListBean.getLeague();
                    String begin_date = matchListBean.getBegin_date();
                    String begin_time = matchListBean.getBegin_time();
                    String home_team = matchListBean.getHome_team();
                    String away_team = matchListBean.getAway_team();
                    FT6MATCHBean.DataBean.MatchListBean.OddsBean oddsBean = matchListBean.getOdds();
                    List<FT6MATCHBean.DataBean.MatchListBean.OddsBean.Bqc1Bean> bqc1 = oddsBean.getBqc1();
                    List<FT6MATCHBean.DataBean.MatchListBean.OddsBean.Bqc2Bean> bqc2 = oddsBean.getBqc2();

                    viewHolder.league_tv.setText(league);
                    viewHolder.begin_time_tv.setText(begin_date + "\n" + begin_time);
                    viewHolder.home_team_tv.setText(home_team);
                    viewHolder.away_team_tv.setText(away_team);

                    viewHolder.ban_tv1.setText(bqc1.get(0).getName() + " " + bqc1.get(0).getOdds());
                    viewHolder.ban_tv2.setText(bqc1.get(1).getName() + " " + bqc1.get(1).getOdds());
                    viewHolder.ban_tv3.setText(bqc1.get(2).getName() + " " + bqc1.get(2).getOdds());

                    viewHolder.quan_tv1.setText(bqc2.get(0).getName() + " " + bqc2.get(0).getOdds());
                    viewHolder.quan_tv2.setText(bqc2.get(1).getName() + " " + bqc2.get(1).getOdds());
                    viewHolder.quan_tv3.setText(bqc2.get(2).getName() + " " + bqc2.get(2).getOdds());
                } else if (data1 != null) {
                    setType4(position);


                }
                break;
            case 5:
                if (data3 != null) {
                    List<BTMATCHBean.DataBean.MatchListBeanX.MatchListBean> matchList = data3.getMatchList().get(0).getMatchList();
                    BTMATCHBean.DataBean.MatchListBeanX.MatchListBean matchListBean = matchList.get(position);
                    String end_time = matchListBean.getEnd_time();
                    String home_team = matchListBean.getHome_team();
                    String away_team = matchListBean.getAway_team();
                    String number = matchListBean.getNumber();
                    String league = matchListBean.getLeague();
                    BTMATCHBean.DataBean.MatchListBeanX.MatchListBean.OddsBean odds = matchListBean.getOdds();
                    List<BTMATCHBean.DataBean.MatchListBeanX.MatchListBean.OddsBean.BSfBean> b_sf = odds.getB_sf();
                    List<BTMATCHBean.DataBean.MatchListBeanX.MatchListBean.OddsBean.BRfBean> b_rf = odds.getB_rf();

                    viewHolder.begin_time_tv.setText(end_time + "截止");
                    viewHolder.home_team_tv.setText(home_team);
                    viewHolder.away_team_tv.setText(away_team);
                    viewHolder.league_tv.setText(number);
                    viewHolder.numb_tv.setText(league);

                    viewHolder.ban_tv1.setText(b_sf.get(0).getName() + " " + b_sf.get(0).getOdds());
                    viewHolder.ban_tv2.setText(b_sf.get(1).getName() + " " + b_sf.get(1).getOdds());

                    viewHolder.quan_tv1.setText(b_rf.get(0).getName() + " " + b_rf.get(0).getOdds());
                    viewHolder.quan_tv2.setText(b_rf.get(1).getName() + " " + b_rf.get(1).getOdds());
                }

                break;
            case 6:
                break;
            case 7:
                if (data2 != null) {
                    List<FT9MATCHBean.DataBean.MatchListBean> matchList = data2.getMatchList();

                    FT9MATCHBean.DataBean.MatchListBean matchListBean = matchList.get(position);
                    String league = matchListBean.getLeague();
                    String begin_date = matchListBean.getBegin_date();
                    String begin_time = matchListBean.getBegin_time();
                    String home_team = matchListBean.getHome_team();
                    String away_team = matchListBean.getAway_team();
                    viewHolder.league_tv.setText(league);
                    viewHolder.begin_time_tv.setText(begin_date + " " + begin_time);
                    viewHolder.home_team_tv.setText(home_team);
                    viewHolder.away_team_tv.setText(away_team);

                    List<FT9MATCHBean.DataBean.MatchListBean.OddsBean> odds = matchListBean.getOdds();
                    if (odds != null) {
                        viewHolder.quan_tv1.setText(odds.get(0).getOdds());
                        viewHolder.quan_tv2.setText(odds.get(1).getOdds());
                        viewHolder.quan_tv3.setText(odds.get(2).getOdds());
                    }

                }


                break;

        }


        return convertView;
    }

    private void setType4(int position) {
        List<FTMATCHBean.DataBean.MatchListBeanX> matchList = data1.getMatchList();
        FTMATCHBean.DataBean.MatchListBeanX.MatchListBean matchListBean = matchList.get(0).getMatchList().get(position);
        String league = matchListBean.getLeague();
        String number = matchListBean.getNumber();
        String home_team = matchListBean.getHome_team();
        String away_team = matchListBean.getAway_team();
        String end_time = matchListBean.getEnd_time();
        String concede = matchListBean.getConcede();

        FTMATCHBean.DataBean.MatchListBeanX.MatchListBean.OddsBean odds = matchListBean.getOdds();
        List<FTMATCHBean.DataBean.MatchListBeanX.MatchListBean.OddsBean.SpfBean> spf = odds.getSpf();
        List<FTMATCHBean.DataBean.MatchListBeanX.MatchListBean.OddsBean.RqBean> rq = odds.getRq();

        viewHolder.begin_time_tv.setText(end_time + "截止");
        viewHolder.home_team_tv.setText(home_team);
        viewHolder.away_team_tv.setText(away_team);
        viewHolder.league_tv.setText(number);
        viewHolder.numb_tv.setText(league);
        viewHolder.quan_tv.setText("1");
        viewHolder.ban_tv.setText("0");

        if (concede.contains("-")) {
            viewHolder.quan_tv.setBackgroundColor(Color.parseColor("#acb57e"));
            viewHolder.quan_tv.setText(concede);
        } else {
            viewHolder.quan_tv.setBackgroundColor(Color.parseColor("#e7756a"));
            viewHolder.quan_tv.setText("+" + concede);
        }
        if (spf != null) {
            viewHolder.ban_tv1.setText(spf.get(0).getName() + " " + spf.get(0).getOdds());
            viewHolder.ban_tv2.setText(spf.get(1).getName() + " " + spf.get(1).getOdds());
            viewHolder.ban_tv3.setText(spf.get(2).getName() + " " + spf.get(2).getOdds());
        }
        if (rq != null) {
            viewHolder.quan_tv1.setText(rq.get(0).getName() + " " + rq.get(0).getOdds());
            viewHolder.quan_tv2.setText(rq.get(1).getName() + " " + rq.get(1).getOdds());
            viewHolder.quan_tv3.setText(rq.get(2).getName() + " " + rq.get(2).getOdds());
        }

    }

    View.OnClickListener scoreClickListener = new View.OnClickListener() {

        private PopupWindow popupWindow;

        @Override
        public void onClick(View v) {
            int tag = (int) v.getTag();
            View inflate = basketballActivity.getLayoutInflater().inflate(R.layout.item_score_info, null, false);
            RelativeLayout rl = inflate.findViewById(R.id.rl);
            rl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (popupWindow != null && popupWindow.isShowing()) {
                        popupWindow.dismiss();
                    }
                }
            });
            ListView score_lv = inflate.findViewById(R.id.score_lv);
            PickScoreAdapter pickScoreAdapter = new PickScoreAdapter(basketballActivity);
            score_lv.setAdapter(pickScoreAdapter);
            if (popupWindow != null && popupWindow.isShowing()) {
                popupWindow.dismiss();
            } else {
                popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.showAsDropDown(inflate);

            }

        }
    };

    public void setType(int type) {
        this.type = type;
    }

    public void setData(FT6MATCHBean.DataBean data) {
        this.data = data;
    }

    public void setData1(FTMATCHBean.DataBean data1) {
        this.data1 = data1;
    }

    public void setData2(FT9MATCHBean.DataBean data2) {
        this.data2 = data2;
    }

    public void setData3(BTMATCHBean.DataBean data3) {
        this.data3 = data3;
    }

    private class ViewHolder {

        private final TextView pick_score_tv;
        private final TextView league_tv;
        private final TextView begin_time_tv;
        private final TextView home_team_tv;
        private final TextView away_team_tv;
        private final TextView quan_tv;
        private final TextView quan_tv1;
        private final TextView quan_tv2;
        private final TextView quan_tv3;
        private final TextView ban_tv;
        private final TextView ban_tv1;
        private final TextView ban_tv2;
        private final TextView ban_tv3;
        private final TextView numb_tv;

        public ViewHolder(View convertView) {
            pick_score_tv = convertView.findViewById(R.id.pick_score_tv);
            league_tv = convertView.findViewById(R.id.league_tv);
            begin_time_tv = convertView.findViewById(R.id.begin_time_tv);
            home_team_tv = convertView.findViewById(R.id.home_team_tv);
            away_team_tv = convertView.findViewById(R.id.away_team_tv);
            ban_tv = convertView.findViewById(R.id.ban_tv);
            ban_tv1 = convertView.findViewById(R.id.ban_tv1);
            ban_tv2 = convertView.findViewById(R.id.ban_tv2);
            ban_tv3 = convertView.findViewById(R.id.ban_tv3);
            quan_tv = convertView.findViewById(R.id.quan_tv);
            quan_tv1 = convertView.findViewById(R.id.quan_tv1);
            quan_tv2 = convertView.findViewById(R.id.quan_tv2);
            quan_tv3 = convertView.findViewById(R.id.quan_tv3);
            numb_tv = convertView.findViewById(R.id.numb_tv);

        }
    }
}
