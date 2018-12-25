package com.tuding.client.eightnumcolour.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.adapter.LeagueAdapter;
import com.tuding.client.eightnumcolour.adapter.ScoreAdapter;
import com.tuding.client.eightnumcolour.bean.MATCHRESULTBean;
import com.tuding.client.eightnumcolour.utls.URls;
import com.tuding.client.eightnumcolour.view.MyGridView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

public class ScoreFragment extends RBBaseFragment implements View.OnClickListener {
    private static final String TAG = "ScoreFragment";
    private static ScoreFragment homeFragment;
    private View rootView;
    ArrayList<View> viewListView = new ArrayList<>();
    ArrayList<String> titleListView = new ArrayList<>();
    private ScoreAdapter scoreAdapter;
    private TextView match_type_tv;
    private TextView date_tv;
    private TextView screen_tv;
    private String match_type = "f";
    private List<MATCHRESULTBean.DataBean.LeagueListBean> leagueList;
    private PopupWindow popupWindow;
    private LeagueAdapter leagueAdapter;
    private Collection<String> values;
    private String league = "";

    public static ScoreFragment newInstance() {
        homeFragment = new ScoreFragment();
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {//缓存rootview
            rootView = inflater.inflate(R.layout.fragment_score, container, false);
            initUI();
            initValue();
        } else {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
        }

        return rootView;
    }

    ViewPager viewpager;
    TabLayout tabLayout;
    private int index;

    @Override
    public void initUI() {
        match_type_tv = rootView.findViewById(R.id.match_type_tv);
        match_type_tv.setOnClickListener(this);
        date_tv = rootView.findViewById(R.id.date_tv);
        date_tv.setOnClickListener(this);
        screen_tv = rootView.findViewById(R.id.screen_tv);
        screen_tv.setOnClickListener(this);
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        time = getTime(date);
        date_tv.setText(time);
        View trading_record = LayoutInflater.from(getActivity()).inflate(R.layout.inflate_score, null);
        View trading_record1 = LayoutInflater.from(getActivity()).inflate(R.layout.inflate_score, null);
        View trading_record2 = LayoutInflater.from(getActivity()).inflate(R.layout.inflate_score, null);
        ListView score1_lv = trading_record.findViewById(R.id.score_lv);
        ListView score2_lv = trading_record1.findViewById(R.id.score_lv);
        ListView score3_lv = trading_record2.findViewById(R.id.score_lv);
        scoreAdapter = new ScoreAdapter(getActivity());
        score1_lv.setAdapter(scoreAdapter);
        score2_lv.setAdapter(scoreAdapter);
        score3_lv.setAdapter(scoreAdapter);
        viewListView.add(trading_record);
        viewListView.add(trading_record1);
        viewListView.add(trading_record2);
        titleListView.add("未结束");
        titleListView.add("已结束");
        titleListView.add("我投注");
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabLayout);
        viewpager = (ViewPager) rootView.findViewById(R.id.viewpager);
        viewpager.setAdapter(pagerAdapter);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewpager);
        tabLayout.setScrollPosition(index, 0, true);
        viewpager.setCurrentItem(index);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                type = position + 1;
                initValue();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    PagerAdapter pagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {

            return viewListView == null ? 0 : viewListView.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewListView.get(position));
            return viewListView.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleListView.get(position);
        }
    };
    int type = 1;
    String time;

    @Override
    public void initValue() {
        time = date_tv.getText().toString().trim();
        OkGo.<String>post(URls.MATCHRESULT).params("league", league).params("date", time).params("type", type).params("match_type", match_type).execute(new StringCallback() {
            @Override
            public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                String s = response.body();

                Log.d(TAG, "onSuccess: " + s);
                MATCHRESULTBean matchresultBean = new Gson().fromJson(s, MATCHRESULTBean.class);
                if (matchresultBean.getCode() == 1) {
                    MATCHRESULTBean.DataBean data = matchresultBean.getData();
                    leagueList = data.getLeagueList();
                    List<MATCHRESULTBean.DataBean.MatchListBean> matchList = data.getMatchList();
                    scoreAdapter.setData(matchList);
                    scoreAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.match_type_tv:
                String trim = match_type_tv.getText().toString().trim();
                if (trim.equals("竞彩足球")) {
                    match_type_tv.setText("竞彩篮球");
                    match_type = "b";
                } else {
                    match_type_tv.setText("竞彩足球");
                    match_type = "f";
                }
                initValue();
                break;
            case R.id.date_tv:
                //时间选择器
                TimePickerView pvTime = new TimePickerView.Builder(getActivity(), new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {//选中事件回调
                        date_tv.setText(getTime(date));
                        initValue();
                    }
                })
                        .build();
                pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
                pvTime.show();

                break;
            case R.id.screen_tv:
                View inflate = getLayoutInflater().inflate(R.layout.window_screen, null, false);
                TextView quxiao_tv = inflate.findViewById(R.id.quxiao_tv);
                TextView queding_tv = inflate.findViewById(R.id.queding_tv);
                TextView inverse_tv = inflate.findViewById(R.id.inverse_tv);
                TextView all_tv = inflate.findViewById(R.id.all_tv);
                all_tv.setOnClickListener(clickListener);
                inverse_tv.setOnClickListener(clickListener);
                quxiao_tv.setOnClickListener(clickListener);
                queding_tv.setOnClickListener(clickListener);
                RelativeLayout rl = inflate.findViewById(R.id.rl);
                rl.setOnClickListener(clickListener);
                MyGridView league_gv = inflate.findViewById(R.id.league_gv);
                leagueAdapter = new LeagueAdapter(this);
                leagueAdapter.setData(leagueList);
                league_gv.setAdapter(leagueAdapter);
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                } else {
                    popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    popupWindow.showAsDropDown(inflate);
                }
                break;
        }

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.rl:
                    if (popupWindow != null && popupWindow.isShowing()) {
                        popupWindow.dismiss();
                    }
                    break;
                case R.id.all_tv:
                    leagueAdapter.setChecked(0);
                    leagueAdapter.notifyDataSetChanged();
                    break;
                case R.id.inverse_tv:
                    leagueAdapter.setChecked(1);
                    leagueAdapter.notifyDataSetChanged();
                    break;
                case R.id.queding_tv:
                    Map<CompoundButton, String> compoundButtonMap = leagueAdapter.getCompoundButtonMap();
                    values = compoundButtonMap.values();
                    int i = 0;
                    for (String value : values) {
                        if (i == 0) {
                            league = value;
                        } else {
                            league += "," + value;
                        }

                        i++;
                    }


                    initValue();

                    if (popupWindow != null && popupWindow.isShowing()) {
                        popupWindow.dismiss();
                    }
                    break;
                case R.id.quxiao_tv:

                    if (popupWindow != null && popupWindow.isShowing()) {
                        popupWindow.dismiss();
                    }


                    break;
            }

        }
    };

    private String getTime(Date date) {//可根据需要自行截取数据显示
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
}
