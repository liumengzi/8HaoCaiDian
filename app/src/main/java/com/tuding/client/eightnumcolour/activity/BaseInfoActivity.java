package com.tuding.client.eightnumcolour.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.tuding.client.eightnumcolour.R;

public class BaseInfoActivity extends RBBaseActivity  {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseinfo);
        initUI();
        initValue();

    }

    @Override
    public void initUI() {
    }

    @Override
    public void initValue() {
    }

}
