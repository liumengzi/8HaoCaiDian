package com.tuding.client.eightnumcolour.activity;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.adapter.BasketballAdapter;
import com.tuding.client.eightnumcolour.adapter.BasketballExpandableAdapter;
import com.tuding.client.eightnumcolour.adapter.EventFilterAdapter;
import com.tuding.client.eightnumcolour.adapter.MyFragmentPagerAdapter;
import com.tuding.client.eightnumcolour.bean.FT9MATCHBean;
import com.tuding.client.eightnumcolour.bean.FTMATCHBean;
import com.tuding.client.eightnumcolour.fragment.BTMATCHBean;
import com.tuding.client.eightnumcolour.fragment.FT6MATCHBean;
import com.tuding.client.eightnumcolour.utls.URls;
import com.tuding.client.eightnumcolour.view.MyGridView;

import okhttp3.Call;
import okhttp3.Response;

public class BasketballActivity extends RBBaseActivity implements View.OnClickListener {

    private static final String TAG = "BasketballActivity";
    private RadioGroup rgManholeStateOne;
    private RadioGroup rgManholeStateTwo;
    private RadioButton rb_1;
    private RadioButton rb_2;
    private RadioButton rb_3;
    private RadioButton rb_4;
    private RadioButton rb_5;
    private RadioButton rb_6;
    private RelativeLayout title_rl;
    private PopupWindow popupWindow;
    private ImageView status_iv;
    private ImageView menu_iv;
    private ImageView finsh_iv;
    private TextView title_name_tv;
    private TextView title_tv;
    private BasketballExpandableAdapter basketballAdapter;
    private int type;
    private int postion;
    private int typenum;
    private int count;

    private ViewPager pager;
    private Fragment[] fragments;
    TabLayout tabLayout;
    private String title;
    private FT6MATCHBean.DataBean ft6MATCHData;
    private ExpandableListView basketball_lv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball);
        initUI();
        initValue();
    }

    @Override
    public void initUI() {
        postion = getIntent().getIntExtra("postion", 0);
        type = getIntent().getIntExtra("type", 0);
        typenum = type;
        count = getIntent().getIntExtra("count", 0);
        title = getIntent().getStringExtra("title");
        finsh_iv = findViewById(R.id.finsh_iv);
        finsh_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        menu_iv = findViewById(R.id.menu_iv);

        menu_iv.setOnClickListener(menuClickListener);
        title_name_tv = findViewById(R.id.title_name_tv);
        title_tv = findViewById(R.id.title_tv);
        title_rl = findViewById(R.id.title_rl);
        status_iv = findViewById(R.id.status_iv);
        LinearLayout title_ll = findViewById(R.id.title_ll);
        title_ll.setOnClickListener(this);
        basketball_lv = findViewById(R.id.basketball_lv);
        basketballAdapter = new BasketballExpandableAdapter(this);
        basketballAdapter.setType(type);
        basketball_lv.setAdapter(basketballAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("胜平负/让球"));
        tabLayout.addTab(tabLayout.newTab().setText("全部比赛"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                    type = 4;
                } else {
                    type = 1;
                }
                is_single = position + 1;
                basketballAdapter.setType(type);
                getFTMATCH1();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        title_tv.setText(title);
        title_name_tv.setText(title);
        if (postion == 1) {
            tabLayout.setVisibility(View.VISIBLE);
        }
        if (count == 0) {
            title_ll.setVisibility(View.GONE);
            menu_iv.setVisibility(View.GONE);
            title_tv.setVisibility(View.VISIBLE);

        } else if (type == count) {
            title_ll.setVisibility(View.VISIBLE);
            menu_iv.setVisibility(View.VISIBLE);
            title_tv.setVisibility(View.GONE);

        } else {
            title_ll.setVisibility(View.VISIBLE);
            menu_iv.setVisibility(View.VISIBLE);
            title_tv.setVisibility(View.GONE);

        }
    }

    @Override
    public void initValue() {

        switch (postion) {
            case 0:
                getFTMATCH();
                break;
            case 1:
                getFTMATCH1();
                break;
            case 2:
                getFTMATCH();

                break;
            case 3:
                getFT6MATCH();

                break;
            case 4:
                getFT9MATCH();

                break;
            case 5:
                getFTMATCH();

                break;
            case 6:
                getBTMATCH();

                break;
            case 7:
                getBTMATCH1();
                break;
        }

    }

    private void getBTMATCH() {
        OkGo.get(URls.BTMATCH).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                Log.d(TAG, "onSuccess: " + s);
                BTMATCHBean btmatchBean = new Gson().fromJson(s, BTMATCHBean.class);
                if (btmatchBean.getCode() == 1) {
                    BTMATCHBean.DataBean btmatchBeanData = btmatchBean.getData();
                    basketballAdapter.setData3(btmatchBeanData);
                    basketballAdapter.notifyDataSetChanged();
                    for(int i = 0; i < basketballAdapter.getGroupCount(); i++){

                        basketball_lv.expandGroup(i);

                    }
                }

            }
        });
    }

    private void getBTMATCH1() {
        OkGo.get(URls.BTMATCH).params("is_single", 1).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                Log.d(TAG, "onSuccess: " + s);
                BTMATCHBean btmatchBean = new Gson().fromJson(s, BTMATCHBean.class);
                if (btmatchBean.getCode() == 1) {
                    BTMATCHBean.DataBean btmatchBeanData = btmatchBean.getData();
                    basketballAdapter.setData3(btmatchBeanData);
                    basketballAdapter.notifyDataSetChanged();
                    for(int i = 0; i < basketballAdapter.getGroupCount(); i++){

                        basketball_lv.expandGroup(i);

                    }
                }

            }
        });
    }

    private void getFT9MATCH() {
        OkGo.get(URls.FT9MATCH).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                Log.d(TAG, "onSuccess: " + s);
                FT9MATCHBean ft9MATCHBean = new Gson().fromJson(s, FT9MATCHBean.class);
                if (ft9MATCHBean.getCode() == 1) {
                    FT9MATCHBean.DataBean ft9MATCHBeanData = ft9MATCHBean.getData();
                    basketballAdapter.setData2(ft9MATCHBeanData);
                    basketballAdapter.notifyDataSetChanged();
                    for(int i = 0; i < basketballAdapter.getGroupCount(); i++){

                        basketball_lv.expandGroup(i);

                    }
                }

            }
        });

    }

    private void getFT6MATCH() {
        OkGo.get(URls.FT6MATCH).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                Log.d(TAG, "onSuccess: " + s);
                FT6MATCHBean ft6MATCHBean = new Gson().fromJson(s, FT6MATCHBean.class);
                if (ft6MATCHBean.getCode() == 1) {
                    ft6MATCHData = ft6MATCHBean.getData();
                    basketballAdapter.setData(ft6MATCHData);
                    basketballAdapter.notifyDataSetChanged();
                    for (int i = 0; i < basketballAdapter.getGroupCount(); i++) {

                        basketball_lv.expandGroup(i);

                    }
                }

            }
        });
    }

    private void getFTMATCH() {
        OkGo.get(URls.FTMATCH).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                Log.d(TAG, "onSuccess: " + s);
                FTMATCHBean ftmatchBean = new Gson().fromJson(s, FTMATCHBean.class);
                if (ftmatchBean.getCode() == 1) {
                    FTMATCHBean.DataBean ftmatchBeanData = ftmatchBean.getData();
                    basketballAdapter.setData1(ftmatchBeanData);
                    basketballAdapter.notifyDataSetChanged();
                    for (int i = 0; i < basketballAdapter.getGroupCount(); i++) {

                        basketball_lv.expandGroup(i);

                    }
                }

            }
        });
    }

    int is_single = 1;

    private void getFTMATCH1() {
        OkGo.get(URls.FTMATCH).params("is_single", is_single).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                Log.d(TAG, "onSuccess: " + s);
                FTMATCHBean ftmatchBean = new Gson().fromJson(s, FTMATCHBean.class);
                if (ftmatchBean.getCode() == 1) {
                    FTMATCHBean.DataBean ftmatchBeanData = ftmatchBean.getData();
                    basketballAdapter.setData1(ftmatchBeanData);
                    basketball_lv.setAdapter(basketballAdapter);
                    for (int i = 0; i < basketballAdapter.getGroupCount(); i++) {

                        basketball_lv.expandGroup(i);

                    }
                }

            }
        });
    }

    View.OnClickListener menuClickListener = new View.OnClickListener() {
        private PopupWindow popupWindow;

        @SuppressLint("WrongConstant")
        @Override
        public void onClick(View v) {

            View inflate = getLayoutInflater().inflate(R.layout.window_menu, null, false);
            EditText input_odds_et = inflate.findViewById(R.id.input_odds_et);
            RelativeLayout rl = inflate.findViewById(R.id.rl);
            rl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (popupWindow != null && popupWindow.isShowing()) {
                        popupWindow.dismiss();
                    }
                }
            });
            MyGridView grid_v = inflate.findViewById(R.id.grid_v);
            final EventFilterAdapter eventFilterAdapter = new EventFilterAdapter(BasketballActivity.this);
            grid_v.setAdapter(eventFilterAdapter);
            if (popupWindow != null && popupWindow.isShowing()) {
                popupWindow.dismiss();
            } else {
                popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.showAsDropDown(inflate);
            }
            popupWindow.setFocusable(true);
//            popupWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
//            popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        }
    };

    @Override
    public void onClick(View v) {
        View inflate = getLayoutInflater().inflate(R.layout.window_title, null, false);
        LinearLayout ll = inflate.findViewById(R.id.ll);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                    status_iv.setImageResource(R.drawable.xiajiantou);
                }
            }
        });
        rgManholeStateOne = inflate.findViewById(R.id.rg_manhole_state_one);
        rgManholeStateTwo = inflate.findViewById(R.id.rg_manhole_state_two);
        rb_1 = inflate.findViewById(R.id.rb_1);
        rb_2 = inflate.findViewById(R.id.rb_2);
        rb_3 = inflate.findViewById(R.id.rb_3);
        rb_4 = inflate.findViewById(R.id.rb_4);
        rb_5 = inflate.findViewById(R.id.rb_5);
        rb_6 = inflate.findViewById(R.id.rb_6);
        rgManholeStateOne.setOnCheckedChangeListener(new OnMyManholeStateOneCheckedChangeListener());
        rgManholeStateTwo.setOnCheckedChangeListener(new OnMyManholeStateTwoCheckedChangeListener());
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
            status_iv.setImageResource(R.drawable.xiajiantou);
        } else {
            popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            popupWindow.showAsDropDown(title_rl);
            status_iv.setImageResource(R.drawable.shangjiantou);
            if (Build.VERSION.SDK_INT >= 24) {
                Rect visibleFrame = new Rect();
                title_rl.getGlobalVisibleRect(visibleFrame);
                int height = title_rl.getResources().getDisplayMetrics().heightPixels - visibleFrame.bottom;
                popupWindow.setHeight(height);
                popupWindow.showAsDropDown(title_rl, 0, 0);
            } else {
                popupWindow.showAsDropDown(title_rl, 0, 0);
            }
        }
        if (typenum == count) {
            rb_1.setText("胜负");
            rb_2.setText("让分胜负");
            rb_3.setText("胜分差");
            rb_4.setText("大小分");
            rb_5.setText("混合过关");
            rb_6.setText("单关");

        }
        if (count <= 3) {
            RadioButton childAt = (RadioButton) rgManholeStateOne.getChildAt(count - 1);
            childAt.setChecked(true);

        } else {
            RadioButton childAt = (RadioButton) rgManholeStateTwo.getChildAt(count - 4);
            childAt.setChecked(true);
        }
    }

    private class OnMyManholeStateOneCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int position) {
            switch (position) {
                case R.id.rb_1:
                    if (rb_1.isChecked())
                        rgManholeStateTwo.clearCheck();
                    title = rb_1.getText().toString();
                    tabLayout.setVisibility(View.GONE);
                    type = 4;
                    basketballAdapter.setType(type);
                    basketballAdapter.notifyDataSetChanged();
                    break;
                case R.id.rb_2:
                    if (rb_2.isChecked())
                        rgManholeStateTwo.clearCheck();
                    title = rb_2.getText().toString();
                    tabLayout.setVisibility(View.GONE);
                    type = 1;
                    basketballAdapter.setType(type);
                    basketballAdapter.notifyDataSetChanged();
                    break;
                case R.id.rb_3:
                    if (rb_3.isChecked())
                        rgManholeStateTwo.clearCheck();
                    title = rb_3.getText().toString();
                    tabLayout.setVisibility(View.GONE);
                    type = 2;
                    basketballAdapter.setType(type);
                    basketballAdapter.notifyDataSetChanged();
                    break;
            }

            title_tv.setText(title);
            title_name_tv.setText(title);
        }
    }

    private class OnMyManholeStateTwoCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int position) {

            switch (position) {
                case R.id.rb_4:
                    if (rb_4.isChecked())
                        rgManholeStateOne.clearCheck();
                    title = rb_4.getText().toString();
                    tabLayout.setVisibility(View.GONE);
                    type = 3;
                    basketballAdapter.setType(type);
                    basketballAdapter.notifyDataSetChanged();
                    break;
                case R.id.rb_5:
                    if (rb_5.isChecked())
                        rgManholeStateOne.clearCheck();
                    title = rb_5.getText().toString();
                    tabLayout.setVisibility(View.GONE);
                    type = 0;
                    basketballAdapter.setType(type);
                    basketballAdapter.notifyDataSetChanged();
                    break;
                case R.id.rb_6:
                    if (rb_6.isChecked())
                        rgManholeStateOne.clearCheck();
                    title = rb_6.getText().toString();
                    tabLayout.setVisibility(View.VISIBLE);
                    type = 4;
                    basketballAdapter.setType(type);
                    basketballAdapter.notifyDataSetChanged();
                    break;
            }

            title_tv.setText(title);
            title_name_tv.setText(title);
        }
    }
}
