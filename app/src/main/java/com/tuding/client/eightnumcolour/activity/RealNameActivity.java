package com.tuding.client.eightnumcolour.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.utls.URls;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

public class RealNameActivity extends RBBaseActivity {

    private EditText real_name_name_et;
    private EditText real_name_num_et;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_real_name);

        initUI();

        requestData();
    }

    private void requestData() {

        OkGo.get(URls.REAL_NAME)
             .tag(this)
             .execute(new StringCallback() {
                 @Override
                 public void onSuccess(String s, Call call, Response response) {

                     try {
                         JSONObject  jsonObject = new JSONObject(s);

                     if (jsonObject.getInt("code") != 1) {

//                         Toast.makeText(RealNameActivity.this,jsonObject.getString("msg"),Toast.LENGTH_SHORT).show();
                         return;
                     }

                         JSONObject data = jsonObject.getJSONObject("data");
                         String realname = data.getString("realname");
                         String idcard = data.getString("idcard");

                         if (realname !=null) {
                             real_name_name_et.setText(realname);
                         }
                         if (idcard !=null) {
                             real_name_num_et.setText(idcard);
                         }


                     } catch (JSONException e) {
                         e.printStackTrace();
                     }

                 }
             });
    }

    @Override
    public void initUI() {
        ImageView iv_back = findViewById(R.id.iv_back);
        real_name_name_et = findViewById(R.id.real_name_name_et);
        real_name_num_et = findViewById(R.id.real_name_num_et);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        LinearLayout real_name_renzheng_ll = findViewById(R.id.real_name_renzheng_ll);
        real_name_renzheng_ll.setOnClickListener(mOnClick);

    }

    View.OnClickListener mOnClick =  new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (yanzheng()) {

                request();
            }

        }
    };
    private void request(){
        OkGo.post(URls.REAL_NAME_ADD)
                .tag(this)
                .params("realname",real_name_name_et.getText().toString().replaceAll(" ", ""))
                .params("idcard",real_name_num_et.getText().toString().replaceAll(" ", ""))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        try {

                            JSONObject jsonObject = new JSONObject(s);
                            if (jsonObject.getInt("code") != 1) {

                                Toast.makeText(RealNameActivity.this,jsonObject.getString("msg"),Toast.LENGTH_SHORT).show();
                                return;
                            }

                            Toast.makeText(RealNameActivity.this,jsonObject.getString("msg"),Toast.LENGTH_SHORT).show();
                            finish();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }

    private boolean yanzheng(){
        String name = real_name_name_et.getText().toString().replaceAll(" ", "");
        String num = real_name_num_et.getText().toString().replaceAll(" ", "");
        if (name.equals("")) {
            Toast.makeText(RealNameActivity.this,"信息输入不完整！",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (num.equals("")) {
            Toast.makeText(RealNameActivity.this,"信息输入不完整！",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    @Override
    public void initValue() {

    }
}
