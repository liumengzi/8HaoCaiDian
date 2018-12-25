package com.tuding.client.eightnumcolour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.adapter.BetAdapter;
import com.tuding.client.eightnumcolour.bean.DLTPERIODBean;
import com.tuding.client.eightnumcolour.utls.URls;
import com.tuding.client.eightnumcolour.view.MyGridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import okhttp3.Call;
import okhttp3.Response;

public class BetActivity extends RBBaseActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    private static final String TAG = "BetActivity";
    private BetAdapter betAdapter;
    private BetAdapter betAdapter1;
    private Spinner random_sp;
    private Spinner bulerandom_sp;
    private HashSet<Integer> integers;
    private Integer selectedItem;
    private Random random;
    private TextView content_tv;
    private boolean isSpint;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bet);
        Intent intent = getIntent();
        isSpint = intent.getBooleanExtra("isSpint", false);

        initUI();
        initValue();

    }

    @Override
    public void initUI() {
        content_tv = findViewById(R.id.content_tv);
        TextView random_tv = findViewById(R.id.random_tv);
        random_tv.setOnClickListener(this);
        TextView bule_random_tv = findViewById(R.id.bule_random_tv);
        bule_random_tv.setOnClickListener(this);
        MyGridView bet_gv = findViewById(R.id.bet_gv);
        MyGridView bule_bet_gv = findViewById(R.id.bule_bet_gv);
        betAdapter = new BetAdapter(this, 35);
        betAdapter1 = new BetAdapter(this, 12);
        bet_gv.setAdapter(betAdapter);
        bet_gv.setOnItemClickListener(this);
        bule_bet_gv.setAdapter(betAdapter1);
        bule_bet_gv.setOnItemClickListener(this);
        random_sp = findViewById(R.id.random_sp);
        bulerandom_sp = findViewById(R.id.bulerandom_sp);
        random_sp.setOnItemSelectedListener(onItemSelectedListener);
        bulerandom_sp.setOnItemSelectedListener(onItemSelectedListener);

        if (isSpint) {
            initSpint();
        }
    }

    AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {

        private String itemAtPosition;

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
            switch (view.getId()) {
                case R.id.random_sp:
                    itemAtPosition = (String) random_sp.getItemAtPosition(position);
                    Toast.makeText(mContext, itemAtPosition, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.bulerandom_sp:
                    itemAtPosition = (String) bulerandom_sp.getItemAtPosition(position);
                    Toast.makeText(mContext, itemAtPosition, Toast.LENGTH_SHORT).show();
                    break;
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    @Override
    public void initValue() {
        OkGo.<String>get(URls.DLTPERIOD).execute(new StringCallback() {
            @Override
            public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                String s = response.body();

                Log.d(TAG, "onSuccess: " + s);
                DLTPERIODBean dltperiodBean = new Gson().fromJson(s, DLTPERIODBean.class);
                if (dltperiodBean.getCode() == 1) {
                    DLTPERIODBean.DataBean data = dltperiodBean.getData();
                    content_tv.setText("第" + data.getExpert_no() + "期   " + data.getEnd_time() + "截止");

                }

            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    public void initSpint() {
        integers = new HashSet<>();
        selectedItem = Integer.parseInt(random_sp.getSelectedItem().toString());
        random = new Random();
        while (integers.size() < selectedItem) {
            int randomNum = random.nextInt(35) + 1;
            integers.add(randomNum);
            Log.d(TAG, "onClick: " + randomNum);

        }
        betAdapter.setData(integers);
        betAdapter.notifyDataSetChanged();

        integers = new HashSet<>();
        selectedItem = Integer.parseInt(bulerandom_sp.getSelectedItem().toString());
        random = new Random();
        while (integers.size() < selectedItem) {
            int randomNum = random.nextInt(12) + 1;
            integers.add(randomNum);
            Log.d(TAG, "onClick: " + randomNum);
        }
        betAdapter1.setData(integers);
        betAdapter1.notifyDataSetChanged();

    }

    public static List<List<Integer>> getAllCombinerDun(List<Integer> data) {
        List<List<Integer>> combinerResults = new ArrayList<>();

        combinerSelect(combinerResults, data, new ArrayList<Integer>(), data.size(), 3);

        Log.d(TAG, "组合大小：{}" + combinerResults.size());
//        logger.info("组合结果：{}", results.toString());
        return combinerResults;
    }

    /***
     * C(n,k) 从n个中找出k个组合
     * @param data
     * @param workSpace
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combinerSelect(List<List<Integer>> combinerResults, List<Integer> data, List<Integer> workSpace, int n, int k) {
        List<Integer> copyData;
        List<Integer> copyWorkSpace;

        if (workSpace.size() == k) {
            List<Integer> dunTiles = new ArrayList<>();
            for (Integer c : workSpace) {
                dunTiles.add(c);
            }

            combinerResults.add(dunTiles);
        }

        for (int i = 0; i < data.size(); i++) {
            copyData = new ArrayList<>(data);
            copyWorkSpace = new ArrayList<>(workSpace);

            copyWorkSpace.add(copyData.get(i));
            for (int j = i; j >= 0; j--)
                copyData.remove(j);
            combinerSelect(combinerResults, copyData, copyWorkSpace, n, k);
        }


        return combinerResults;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.random_tv:
                integers = new HashSet<>();
                selectedItem = Integer.parseInt(random_sp.getSelectedItem().toString());
                random = new Random();
                while (integers.size() < selectedItem) {
                    int randomNum = random.nextInt(35) + 1;
                    integers.add(randomNum);
                    Log.d(TAG, "onClick: " + randomNum);

                }
                betAdapter.setData(integers);
                betAdapter.notifyDataSetChanged();
                break;
            case R.id.bule_random_tv:
                integers = new HashSet<>();
                selectedItem = Integer.parseInt(bulerandom_sp.getSelectedItem().toString());
                random = new Random();
                while (integers.size() < selectedItem) {
                    int randomNum = random.nextInt(12) + 1;
                    integers.add(randomNum);
                    Log.d(TAG, "onClick: " + randomNum);

                }
                betAdapter1.setData(integers);
                betAdapter1.notifyDataSetChanged();
                break;
        }

    }
}
