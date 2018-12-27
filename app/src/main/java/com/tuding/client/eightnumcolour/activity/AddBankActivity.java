package com.tuding.client.eightnumcolour.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;

import com.tuding.client.eightnumcolour.R;

public class AddBankActivity extends RBBaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bank);
        initUI();
        initValue();
    }

    @Override
    public void initUI() {
        RelativeLayout bank_rl = findViewById(R.id.bank_rl);
        bank_rl.setOnClickListener(this);

    }

    @Override
    public void initValue() {

    }

    @Override
    public void onClick(View v) {
    }
}
