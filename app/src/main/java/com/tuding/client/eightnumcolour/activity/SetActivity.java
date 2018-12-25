package com.tuding.client.eightnumcolour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuding.client.eightnumcolour.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SetActivity extends RBBaseActivity implements View.OnClickListener {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.log_out_tv)
    TextView log_out_tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        ButterKnife.bind(this);
        initUI();
        initValue();
    }

    @Override
    public void initUI() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        log_out_tv.setOnClickListener(this);
    }

    @Override
    public void initValue() {
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
