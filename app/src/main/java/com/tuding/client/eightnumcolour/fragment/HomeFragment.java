package com.tuding.client.eightnumcolour.fragment;

import android.annotation.SuppressLint;
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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.activity.BasketballActivity;
import com.tuding.client.eightnumcolour.activity.BetActivity;
import com.tuding.client.eightnumcolour.activity.LotteryResultsActivity;
import com.tuding.client.eightnumcolour.adapter.HomeAdapter;
import com.tuding.client.eightnumcolour.bean.HomeBean;
import com.tuding.client.eightnumcolour.utls.URls;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import okhttp3.Call;
import okhttp3.Response;

public class HomeFragment extends RBBaseFragment implements ViewPager.OnPageChangeListener, View
        .OnTouchListener, View.OnClickListener, AdapterView.OnItemClickListener {
    private static final String TAG = "HomeFragment";
    private static HomeFragment homeFragment;
    private View rootView;
    private WelcomePagerAdapter adapter;
    private List<HomeBean.DataBean> data;
    private int type;
    private int count;
    private String title;
    private int postion;
    private LinearLayout num_ll;

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
        home_gv.setOnItemClickListener(this);
        TextView bet_tv = rootView.findViewById(R.id.bet_tv);
        bet_tv.setOnClickListener(this);
        RelativeLayout lottery_results_rl = rootView.findViewById(R.id.lottery_results_rl);
        lottery_results_rl.setOnClickListener(this);
        RelativeLayout daletou_rl = rootView.findViewById(R.id.daletou_rl);
        daletou_rl.setOnClickListener(this);
        final ImageView over_iv = rootView.findViewById(R.id.over_iv);


        over_iv.setOnClickListener(new View.OnClickListener() {
            private int randomNum;

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(final View v) {
                Animation operatingAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.tip);
                LinearInterpolator lin = new LinearInterpolator();
                operatingAnim.setInterpolator(lin);
                v.startAnimation(operatingAnim);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        //execute the task
                        ArrayList<Integer> integers = new ArrayList<>();
                        Random random = new Random();
                        while (integers.size() < 7) {
                            if (integers.size() < 5) {
                                randomNum = random.nextInt(35) + 1;
                            } else {
                                randomNum = random.nextInt(12) + 1;
                            }
                            if (!integers.contains(randomNum)) {

                                integers.add(randomNum);
                                Log.d(TAG, "onClick: " + randomNum);
                            }

                        }
                        int childCount = num_ll.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            TextView childAt = (TextView) num_ll.getChildAt(i);
                            childAt.setText(integers.get(i) + "");

                        }
                        v.clearAnimation();
                    }
                }, 2000);

            }
        });
        num_ll = rootView.findViewById(R.id.num_ll);

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
        OkGo.<String>get(URls.GET_BANNER).execute(new StringCallback() {
            @Override
            public void onError(com.lzy.okgo.model.Response<String> response) {
                super.onError(response);
                Log.e(TAG, "onError: " + response.getException().getMessage());
            }

            @Override
            public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                String s = response.body();

                Log.d(TAG, "onSuccess: " + s);
                HomeBean homeBean = new Gson().fromJson(s, HomeBean.class);
                data = homeBean.getData();

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
        switch (view.getId()) {
            case R.id.bet_tv:
                startActivity(new Intent(mContext, BetActivity.class).putExtra("isSpint", true));
                break;
            case R.id.lottery_results_rl:
                startActivity(new Intent(mContext, LotteryResultsActivity.class));
                break;
            case R.id.daletou_rl:
                startActivity(new Intent(mContext, BetActivity.class));
                break;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        postion = position;
        switch (position) {
            case 0:
                type = 0;
                count = 5;

                title = "混合过关";
                break;
            case 1:
                type = 0;
                count = 6;
                title = "单关";
                break;
            case 2:
                type = 4;
                count = 1;
                title = "胜平负(让球)";
                break;
            case 3:
                type = 4;
                count = 0;
                title = "六场半全";
                break;
            case 4:
                type = 7;
                count = 0;
                title = "任选九";
                break;
            case 5:
                type = 2;
                count = 3;
                title = "总进球";
                break;
            case 6:
                type = 5;
                count = 5;
                title = "混合过关";
                break;
            case 7:
                type = 6;
                count = 6;
                title = "单关";
                break;
        }
        startActivity(new Intent(getActivity(), BasketballActivity.class).putExtra("postion", postion).putExtra("title", title).putExtra("type", type).putExtra("count", count));
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
