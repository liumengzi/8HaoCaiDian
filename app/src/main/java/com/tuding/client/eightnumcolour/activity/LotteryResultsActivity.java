package com.tuding.client.eightnumcolour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.adapter.LotteryResultsAdapter;
import com.tuding.client.eightnumcolour.bean.NOTERESULTBean;
import com.tuding.client.eightnumcolour.utls.URls;

import okhttp3.Call;
import okhttp3.Response;

public class LotteryResultsActivity extends RBBaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "LotteryResultsActivity";
    private LotteryResultsAdapter lotteryResultsAdapter;
    private String expect_type;
    private String name;
    private ImageView mResults_back_iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottery_results);
        initUI();
        initValue();
    }

    @Override
    public void initUI() {

        ListView lottery_resuluts_lv = findViewById(R.id.lottery_resuluts_lv);
        lotteryResultsAdapter = new LotteryResultsAdapter(this);

        mResults_back_iv = (ImageView) findViewById(R.id.results_back_iv);
        mResults_back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lottery_resuluts_lv.setAdapter(lotteryResultsAdapter);
        lottery_resuluts_lv.setOnItemClickListener(this);
    }

    @Override
    public void initValue() {
        OkGo.get(URls.NOTERESULT).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                Log.d(TAG, "onSuccess: " + s);
                NOTERESULTBean noteresultBean = new Gson().fromJson(s, NOTERESULTBean.class);
                if (noteresultBean.getCode() == 1) {
                    NOTERESULTBean.DataBean data = noteresultBean.getData();
                    lotteryResultsAdapter.setData(data);
                    lotteryResultsAdapter.notifyDataSetChanged();
                }


            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                expect_type = "ssq";
                name = "双色球开奖结果";
                break;
            case 1:
                expect_type = "dlt";
                name = "大乐透开奖结果";
                break;
            case 2:
                expect_type = "lcbqc";
                name = "半全场开奖结果";
                break;
            case 3:
                expect_type = "sf";
                name = "任选九开奖结果";
                break;
        }
        startActivity(new Intent(this, LotteryResultsInfoListActivity.class).putExtra("name", name).putExtra("expect_type", expect_type));
    }
}
