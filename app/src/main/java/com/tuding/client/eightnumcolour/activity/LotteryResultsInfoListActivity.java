package com.tuding.client.eightnumcolour.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.adapter.LotteryResultsInfoListAdapter;
import com.tuding.client.eightnumcolour.bean.RESULTLISTBean;
import com.tuding.client.eightnumcolour.utls.URls;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class LotteryResultsInfoListActivity extends RBBaseActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = "LotteryResultsInfoListActivity";
    private String expect_type;
    private String name;
    private LotteryResultsInfoListAdapter lotteryResultsInfoListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        expect_type = intent.getStringExtra("expect_type");
        name = intent.getStringExtra("name");

        setContentView(R.layout.activity_lottery_results);
        initUI();
        initValue();
    }

    @Override
    public void initUI() {
        TextView title_tv = findViewById(R.id.title_tv);
        title_tv.setText(name);
        ListView lottery_resuluts_lv = findViewById(R.id.lottery_resuluts_lv);
        lotteryResultsInfoListAdapter = new LotteryResultsInfoListAdapter(this);
        lottery_resuluts_lv.setAdapter(lotteryResultsInfoListAdapter);
        lottery_resuluts_lv.setOnItemClickListener(this);
    }

    @Override
    public void initValue() {

        OkGo.<String>get(URls.RESULTLIST).params("expect_type", expect_type).execute(new StringCallback() {
            @SuppressLint("LongLogTag")
            @Override
            public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                String s = response.body();
                Log.d(TAG, "onSuccess: " + s);
                RESULTLISTBean resultlistBean = new Gson().fromJson(s, RESULTLISTBean.class);
                if (resultlistBean.getCode() == 1) {
                    RESULTLISTBean.DataBean data = resultlistBean.getData();
                    List<RESULTLISTBean.DataBean.ListBean> list = data.getList();
                    lotteryResultsInfoListAdapter.setData(list);
                    lotteryResultsInfoListAdapter.notifyDataSetChanged();
                }

            }

        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(this, LotteryResultsInfoActivity.class));
    }
}
