package com.tuding.client.eightnumcolour.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.activity.BetActivity;
import com.tuding.client.eightnumcolour.adapter.HomeAdapter;
import com.tuding.client.eightnumcolour.bean.HomeBean;
import com.tuding.client.eightnumcolour.utls.URls;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class HomeFragment extends RBBaseFragment implements ViewPager.OnPageChangeListener, View
        .OnTouchListener, View.OnClickListener {
    private static final String TAG = "HomeFragment";
    private static HomeFragment homeFragment;
    private View rootView;
    private WelcomePagerAdapter adapter;
    private List<HomeBean.DataBean> data;

    public static HomeFragment newInstance() {
        homeFragment = new HomeFragment();
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        if (rootView == null) {//缓存rootview
            rootView = inflater.inflate(R.layout.fragment_home, container, false);
            initUI();

        } else {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
        }
        return rootView;
    }

    private ViewPager home_vp;
    private LinearLayout bannerLinear;
    String[] name = new String[]{"竞彩足球", "足球单关", "胜平负", "六场半全", "任选九", "总进球数", "竞彩篮球", "篮球单关"};
    String[] content = new String[]{"疯狂加奖", "猜中一场就有奖", "猜胜负赢500万", "流畅半全场胜负", "九场竞彩赚翻天", "总进球投注",
            "玩转NBA赛事", "猜中一场就有奖"};
    int[] img = new int[]{R.drawable.jincailanq, R.drawable.zuqiou_dan, R.drawable.shuyin, R
            .drawable.liuchang, R.drawable.jiu, R.drawable.zongjinqiu, R.drawable.jincailanq, R
            .drawable.lanqiudan};

    @Override
    public void initUI() {
        home_vp = (ViewPager) rootView.findViewById(R.id.home_vp);
        bannerLinear = (LinearLayout) rootView.findViewById(R.id.indicator);
        home_vp.setOnTouchListener(this);
        home_vp.setOnPageChangeListener(this);
        home_vp.setCurrentItem(data == null ? 1000 * imgstr.length : 1000 * data.size());
        home_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                home_vp.setCurrentItem(position);
                controlIndicator(position % 3);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        adapter = new WelcomePagerAdapter();
        home_vp.setAdapter(adapter);
        autoScrollHandler.sendEmptyMessageDelayed(1, 2000);
        GridView home_gv = rootView.findViewById(R.id.home_gv);
        HomeAdapter homeAdapter = new HomeAdapter(getActivity());
        homeAdapter.setData(name, img, content);
        home_gv.setAdapter(homeAdapter);
        TextView bet_tv = rootView.findViewById(R.id.bet_tv);
        bet_tv.setOnClickListener(this);

    }

    private Handler autoScrollHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            home_vp.setCurrentItem(home_vp.getCurrentItem() + 1);
            autoScrollHandler.sendEmptyMessageDelayed(1, 2000);
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        initValue();
    }

    @Override
    public void initValue() {
        OkGo.get(URls.GET_BANNER).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                Log.d(TAG, "onSuccess: " + s);
                HomeBean homeBean = new Gson().fromJson(s, HomeBean.class);
                data = homeBean.getData();

            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                super.onError(call, response, e);
                Log.e(TAG, "onError: " + e);
            }
        });
    }

    //初始化所有ViewPager上的指示按钮都不点亮（不选中），只点亮传入参数对应的那一个只是按钮
    private void controlIndicator(int whichPage) {
        ImageView imageView = (ImageView) bannerLinear.getChildAt(whichPage);
        //初始化所有的ImageView的enable属性为false
        int childCount = bannerLinear.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView childView = (ImageView) bannerLinear.getChildAt(i);
            childView.setEnabled(false);
        }
        imageView.setEnabled(true);
    }

    int[] imgstr = new int[]{R.drawable.phone, R.drawable.phone, R.drawable.phone};
    private static Boolean isTouch = false;

    @Override
    public void onClick(View view) {
        startActivity(new Intent(mContext, BetActivity.class));
    }

    class WelcomePagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(getActivity());
            //            Glide.with(getActivity()).load(imgList.get(position % imgList.size())
            // .getImguil()).into(imageView);
            //            int i = position % data.size();
            /*if (banners != null) {
                String imgAddr = banners.get(i).getImgAddr();

                Glide.with(mContext).load(Urls.HEAD_PASH + "/" + imgAddr).into(imageView);
            }*/
            if (data == null) {
                int i1 = position % imgstr.length;
                imageView.setImageResource(i1);
            } else {
                int i1 = position % data.size();
                Glide.with(mContext).load(data.get(i1).getImage()).into(imageView);
            }
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //            welcome_text.setText(txtList.get(position%txtList.size()));
            //            TextView txt=new_logo TextView(WelcomeActivity.this);
            //            txt.setText(txtList.get(position%txtList.size()));
            //            txt.setGravity(Gravity.CENTER);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                isTouch = true;
                autoScrollHandler.removeMessages(1);
                break;
            case MotionEvent.ACTION_UP:
                isTouch = false;
                autoScrollHandler.sendEmptyMessageDelayed(1, 2000);
                break;
        }
        return false;
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {
    }

    @Override
    public void onPageSelected(int i) {
        if (isTouch) {
            isTouch = false;
            autoScrollHandler.sendEmptyMessageDelayed(1, 2000);
        }

    }

    @Override
    public void onPageScrollStateChanged(int i) {
    }
}
