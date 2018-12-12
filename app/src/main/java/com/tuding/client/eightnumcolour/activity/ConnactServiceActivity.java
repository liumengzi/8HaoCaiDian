package com.tuding.client.eightnumcolour.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.dialog.CustomServiceDialog;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ConnactServiceActivity extends RBBaseActivity implements View.OnClickListener {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.rl_paijiang)
    RelativeLayout rlPaijiang;
    @Bind(R.id.rl_daozhang)
    RelativeLayout rlDaozhang;
    @Bind(R.id.rl_buchenggong)
    RelativeLayout rlBuchenggong;
    @Bind(R.id.rl_tixian)
    RelativeLayout rlTixian;
    @Bind(R.id.rl_chupiao)
    RelativeLayout rlChupiao;
    private CustomServiceDialog customServiceDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connactservice);
        ButterKnife.bind(this);
        initUI();
        initValue();
    }

    @Override
    public void initUI() {
        customServiceDialog = new CustomServiceDialog(this);
        rlPaijiang.setOnClickListener(this);
        rlDaozhang.setOnClickListener(this);
        rlBuchenggong.setOnClickListener(this);
        rlTixian.setOnClickListener(this);
        rlChupiao.setOnClickListener(this);
        ivBack.setOnClickListener(this);
    }

    @Override
    public void initValue() {
    }

    @Override
    public void onClick(View v) {
        customServiceDialog.show();
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_paijiang:
                customServiceDialog.setContent("   " +
                        "本平台所有数据都与中国竞彩网同步，比赛完出赛果了就会处理派奖事宜。一般时长为了比赛完半个小时至一小时左右");
                break;
            case R.id.rl_daozhang:
                customServiceDialog.setContent("   周一至周日均可申请提款，提款处理工作时间为09：00-22：000" +
                        "(其他国家法定假日处理时间另行公示)；09：00-22：00的提款申请做到半个小时受理完毕，22：00后的提款申请延至第二天上午处理");
                break;
            case R.id.rl_buchenggong:
                customServiceDialog.setContent("   提款时请确保银行卡号完整、并与本站实名信息相符，若提款未成功可及时联系客服");
                break;
            case R.id.rl_tixian:
                customServiceDialog.setContent("   " +
                        "为配合银行严厉打击套现、洗钱等违法行为，重置金额将须用于购彩，不可提现！请各位用户合理规划资金，根据实际消费需求充值");
                break;
            case R.id.rl_chupiao:
                customServiceDialog.setContent("   " +
                        "周一至周五：09：00-24：00；周六至周日：09：00-01：00");
                break;
        }
    }
}
