package com.tuding.client.eightnumcolour.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.utls.URls;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

public class AccountDetailActivity extends RBBaseActivity {

    private TextView account_details_count_tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_detail);
        initUI();
        initValue();
    }

    @Override
    public void initUI() {
        account_details_count_tv = (TextView) findViewById(R.id.account_details_count_tv);
        ImageView viewById = findViewById(R.id.iv_back);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void initValue() {

        OkGo.<String>get(URls.USER_CASH_RECORD)
                .tag(this)
                .params("page",1)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                        String s = response.body();

                        try {
                            JSONObject jsonObject = new JSONObject(s);

                            JSONObject data = jsonObject.getJSONObject("data");

                            int count = data.getInt("count");
                            account_details_count_tv.setText(count+"");


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                    }

                });
    }
}
