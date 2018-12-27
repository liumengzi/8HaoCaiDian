package com.tuding.client.eightnumcolour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;

import com.tuding.client.eightnumcolour.R;

public class CashManagementActivity extends RBBaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_management);
        initUI();
        initValue();
    }

    @Override
    public void initUI() {
        RelativeLayout destoon_finance_cash_rl = findViewById(R.id.destoon_finance_cash_rl);
        RelativeLayout draw_the_detail_rl = findViewById(R.id.draw_the_detail_rl);
        destoon_finance_cash_rl.setOnClickListener(this);
        draw_the_detail_rl.setOnClickListener(this);

    }

    @Override
    public void initValue() {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.destoon_finance_cash_rl:
                startActivity(new Intent(this, DestoonFinanceCashActivity.class));

                break;
            case R.id.draw_the_detail_rl:
                startActivity(new Intent(this,DrawTheDetailActivity.class));
                break;
        }
    }
}
