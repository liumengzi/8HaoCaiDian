package com.tuding.client.eightnumcolour.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;

import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.adapter.LotteryResultsAdapter;

public class LotteryResultsActivity extends RBBaseActivity {
    int[] type = new int[]{0, 1, 1, 2, 4, 3, 2, 2, 1, 0, 0, 3, 4, 1, 0, 0, 0, 0};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottery_results);
        ListView lottery_resuluts_lv = findViewById(R.id.lottery_resuluts_lv);
        LotteryResultsAdapter lotteryResultsAdapter = new LotteryResultsAdapter(this);
        lotteryResultsAdapter.setData(type);
        lottery_resuluts_lv.setAdapter(lotteryResultsAdapter);
    }

    @Override
    public void initUI() {

    }

    @Override
    public void initValue() {

    }
}
