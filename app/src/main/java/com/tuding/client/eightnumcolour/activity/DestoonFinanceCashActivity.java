package com.tuding.client.eightnumcolour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;

import com.tuding.client.eightnumcolour.R;

public class DestoonFinanceCashActivity extends RBBaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destoon_finance_cash);
        initUI();
        initValue();
    }

    @Override
    public void initUI() {
        RelativeLayout destoon_finance_cash_rl = findViewById(R.id.destoon_finance_cash_rl);
        destoon_finance_cash_rl.setOnClickListener(this);
    }

    @Override
    public void initValue() {

    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,BankCardManagementActivity.class));
    }
}
