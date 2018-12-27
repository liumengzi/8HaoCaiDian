package com.tuding.client.eightnumcolour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.adapter.BankAdapter;

public class BankCardManagementActivity extends RBBaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_card_management);
        initUI();
        initValue();
    }

    @Override
    public void initUI() {
        ImageView add_bank_iv = findViewById(R.id.add_bank_iv);
        add_bank_iv.setOnClickListener(this);
        ListView bank_lv = findViewById(R.id.bank_lv);
        BankAdapter bankAdapter = new BankAdapter(this);
        bank_lv.setAdapter(bankAdapter);

    }

    @Override
    public void initValue() {

    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, AddBankActivity.class));
    }
}
