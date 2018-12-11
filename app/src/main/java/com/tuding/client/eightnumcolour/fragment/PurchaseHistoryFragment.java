package com.tuding.client.eightnumcolour.fragment;

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
import com.tuding.client.eightnumcolour.adapter.PurchaseHistoryAdapter;
import com.tuding.client.eightnumcolour.adapter.ScoreAdapter;

import java.util.ArrayList;

public class PurchaseHistoryFragment extends RBBaseFragment {
    private static PurchaseHistoryFragment homeFragment;

    ArrayList<View> viewListView = new ArrayList<>();
    ArrayList<String> titleListView = new ArrayList<>();

    public static PurchaseHistoryFragment newInstance() {
        homeFragment = new PurchaseHistoryFragment();
        return homeFragment;
    }

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {//缓存rootview
            rootView = inflater.inflate(R.layout.fragment_purchasehistory, container, false);
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
        View trading_record = LayoutInflater.from(getActivity()).inflate(R.layout.inflate_purchasehistory, null);
        View trading_record1 = LayoutInflater.from(getActivity()).inflate(R.layout.inflate_purchasehistory, null);
        ListView purchasehistory1_lv = trading_record.findViewById(R.id.purchasehistory_lv);
        ListView purchasehistory2_lv = trading_record1.findViewById(R.id.purchasehistory_lv);
        PurchaseHistoryAdapter historyAdapter = new PurchaseHistoryAdapter(getActivity());
        purchasehistory1_lv.setAdapter(historyAdapter);
        purchasehistory2_lv.setAdapter(historyAdapter);
        viewListView.add(trading_record);
        viewListView.add(trading_record1);
        titleListView.add("实战记录");
        titleListView.add("保存方案");
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
