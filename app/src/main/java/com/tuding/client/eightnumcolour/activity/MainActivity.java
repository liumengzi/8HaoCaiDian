package com.tuding.client.eightnumcolour.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.fragment.HomeFragment;
import com.tuding.client.eightnumcolour.fragment.MineFragment;
import com.tuding.client.eightnumcolour.fragment.PurchaseHistoryFragment;
import com.tuding.client.eightnumcolour.fragment.ScoreFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends RBBaseActivity {
    private static final String TAG = "MainActivity";
    List<Fragment> fragments = new ArrayList<>();
    private RadioGroup main_rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initValue();
    }

    @Override
    public void initUI() {
        main_rg = (RadioGroup) findViewById(R.id.main_rg);
        fragments.add(HomeFragment.newInstance());
        fragments.add(ScoreFragment.newInstance());
        fragments.add(PurchaseHistoryFragment.newInstance());
        fragments.add(MineFragment.newInstance());
        // 系统 6.0 以上 状态栏白底黑字的实现方法
        this.getWindow()
                .getDecorView()
                .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        //        MIUISetStatusBarLightMode(this.getWindow(), true);
        //        FlymeSetStatusBarLightMode(this.getWindow(), true);
        main_rg.setOnCheckedChangeListener(checkListener);
        ((RadioButton) main_rg.getChildAt(0)).setChecked(true);
    }

    public void indexChid(int i) {
        ((RadioButton) main_rg.getChildAt(i)).setChecked(true);
    }

    @Override
    public void initValue() {
    }

    // 用来计算返回键的点击间隔时间
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                //弹出提示，可以有多种方式
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private RadioGroup.OnCheckedChangeListener checkListener = new RadioGroup
            .OnCheckedChangeListener() {
        /**
         *
         * @param group         设置了监听的控件
         * @param checkedId     被勾选的RadioButton的id
         */
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            //            checkedId -> View -> index -->  Fragment;
            View child = group.findViewById(checkedId);
            int index = group.indexOfChild(child);
            Fragment fragment = fragments.get(index);
            //            replaceFragment(fragment);
            //            addShowHideFragment(fragment);
            switch (index) {
                case 0:
                    replaceFragment(fragment);
                    break;
                case 1:
                    replaceFragment(fragment);
                    break;
                case 2:
                    replaceFragment(fragment);
                    break;
                case 3:
                    replaceFragment(fragment);
                    break;

            }
        }
    };

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, fragment)
                .commit();
    }
}
