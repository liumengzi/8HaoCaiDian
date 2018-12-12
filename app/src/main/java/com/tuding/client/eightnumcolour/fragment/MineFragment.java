package com.tuding.client.eightnumcolour.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.activity.ChargeActivity;
import com.tuding.client.eightnumcolour.activity.ConnactServiceActivity;
import com.tuding.client.eightnumcolour.activity.LotteryResultsActivity;
import com.tuding.client.eightnumcolour.activity.SetActivity;
import com.tuding.client.eightnumcolour.adapter.HomeAdapter;
import com.tuding.client.eightnumcolour.view.MyGridView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MineFragment extends RBBaseFragment implements AdapterView.OnItemClickListener {
    private static MineFragment homeFragment;
    @Bind(R.id.iv_setting)
    ImageView ivSetting;
    @Bind(R.id.head_portrait_riv)
    RoundedImageView headPortraitRiv;
    @Bind(R.id.mine_gv)
    MyGridView mineGv;
    @Bind(R.id.daletou_iv)
    ImageView daletouIv;
    @Bind(R.id.daletou_title_tv)
    TextView daletouTitleTv;
    @Bind(R.id.kaijiang_iv)
    ImageView kaijiangIv;
    @Bind(R.id.kaijiang_title_tv)
    TextView kaijiangTitleTv;
    @Bind(R.id.rl_kefu)
    RelativeLayout rlKefu;
    @Bind(R.id.tv_charge)
    TextView tvCharge;
    @Bind(R.id.tv_cashout)
    TextView tvCashout;

    public static MineFragment newInstance() {
        homeFragment = new MineFragment();
        return homeFragment;
    }

    String[] name = new String[]{"开奖公告", "账户明细", "实名认证", "提现管理", "密码管理", "银行卡管理"};
    String[] content = new String[]{"最快知道中奖", "查看资金流向", "资料完整", "提现及明细", "密码安全", "我的银行卡"};
    int[] img = new int[]{R.drawable.gonggao, R.drawable.qianbao, R.drawable.shiming, R.drawable
            .zijin, R.drawable.mimagl, R.drawable.yinhangka};
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        if (rootView == null) {//缓存rootview
            rootView = inflater.inflate(R.layout.fragment_mine, container, false);
            ButterKnife.bind(this, rootView);
            initUI();
        } else {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
        }
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void initUI() {
        GridView mine_gv = rootView.findViewById(R.id.mine_gv);
        HomeAdapter homeAdapter = new HomeAdapter(getActivity());
        homeAdapter.setData(name, img, content);
        mine_gv.setAdapter(homeAdapter);
        mine_gv.setOnItemClickListener(this);
        ivSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SetActivity.class));
            }
        });
        rlKefu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ConnactServiceActivity.class));
            }
        });
        tvCharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ChargeActivity.class));
            }
        });
    }

    @Override
    public void initValue() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(getContext(), LotteryResultsActivity.class));
                break;
        }
    }
}
