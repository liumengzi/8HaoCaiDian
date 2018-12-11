package com.tuding.client.eightnumcolour.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.adapter.ScoreAdapter;

import java.util.ArrayList;

public class ScoreFragment extends RBBaseFragment {
    private static ScoreFragment homeFragment;
    private View rootView;
    ArrayList<View> viewListView = new ArrayList<>();
    ArrayList<String> titleListView = new ArrayList<>();

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
        View trading_record = LayoutInflater.from(getActivity()).inflate(R.layout.inflate_score, null);
        View trading_record1 = LayoutInflater.from(getActivity()).inflate(R.layout.inflate_score, null);
        View trading_record2 = LayoutInflater.from(getActivity()).inflate(R.layout.inflate_score, null);
        ListView score1_lv = trading_record.findViewById(R.id.score_lv);
        ListView score2_lv = trading_record1.findViewById(R.id.score_lv);
        ListView score3_lv = trading_record2.findViewById(R.id.score_lv);
        ScoreAdapter scoreAdapter = new ScoreAdapter(getActivity());
        score1_lv.setAdapter(scoreAdapter);
        score2_lv.setAdapter(scoreAdapter);
        score3_lv.setAdapter(scoreAdapter);
        viewListView.add(trading_record);
        viewListView.add(trading_record1);
        viewListView.add(trading_record2);
        titleListView.add("未结束");
        titleListView.add("已结束");
        titleListView.add("我的比赛");
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
                if (position == 0) {

//                    Intent data = new Intent();
//                    setResult(200, data);
//                    finish();
                }

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
    @Override
    public void initValue() {

    }
}
