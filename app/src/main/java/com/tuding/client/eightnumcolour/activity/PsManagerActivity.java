package com.tuding.client.eightnumcolour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.tuding.client.eightnumcolour.R;

public class PsManagerActivity extends RBBaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ps_manager);
        initUI();
        initValue();
    }

    @Override
    public void initUI() {

        RelativeLayout login_password_rl = findViewById(R.id.login_password_rl);
        login_password_rl.setOnClickListener(myOnClickListener);

        RelativeLayout pay_password_rl = findViewById(R.id.pay_password_rl);
        pay_password_rl.setOnClickListener(myOnClickListener);

        RelativeLayout find_pay_password_rl = findViewById(R.id.find_pay_password_rl);
        find_pay_password_rl.setOnClickListener(myOnClickListener);

    }


    View.OnClickListener myOnClickListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.login_password_rl :
                    startActivity(new Intent(PsManagerActivity.this,ModifyLoginPsActivity.class));
                    break;

                case R.id.pay_password_rl :
                    startActivity(new Intent(PsManagerActivity.this,InitPayPsActivity.class));
                    break;

                case R.id.find_pay_password_rl :
                    startActivity(new Intent(PsManagerActivity.this,FindBackPayPsActivity.class));
                    break;
            }

        }
    };
    @Override
    public void initValue() {
    }
}
