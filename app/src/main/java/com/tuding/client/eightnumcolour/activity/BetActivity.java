package com.tuding.client.eightnumcolour.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.adapter.BetAdapter;
import com.tuding.client.eightnumcolour.view.MyGridView;

import java.util.HashSet;
import java.util.Random;

public class BetActivity extends RBBaseActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    private static final String TAG = "BetActivity";
    private BetAdapter betAdapter;
    private BetAdapter betAdapter1;
    private Spinner random_sp;
    private Spinner bulerandom_sp;
    private HashSet<Integer> integers;
    private Integer selectedItem;
    private Random random;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bet);
        initUI();
        initValue();

    }

    @Override
    public void initUI() {
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

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.random_tv:
                integers = new HashSet<>();
                selectedItem = Integer.parseInt(random_sp.getSelectedItem().toString());
                random = new Random();
                while (integers.size() < selectedItem) {
                    int randomNum = random.nextInt(35);
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
                    int randomNum = random.nextInt(12);
                    integers.add(randomNum);
                    Log.d(TAG, "onClick: " + randomNum);

                }
                betAdapter1.setData(integers);
                betAdapter1.notifyDataSetChanged();
                break;
        }

    }
}
