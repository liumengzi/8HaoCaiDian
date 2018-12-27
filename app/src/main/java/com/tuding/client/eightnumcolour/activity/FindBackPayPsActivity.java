package com.tuding.client.eightnumcolour.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.bean.GET_REGISTER_CODEBean;
import com.tuding.client.eightnumcolour.utls.ToastUtil;
import com.tuding.client.eightnumcolour.utls.URls;
import com.tuding.client.eightnumcolour.utls.Util;

import me.alexrs.prefs.lib.Prefs;

public class FindBackPayPsActivity extends RBBaseActivity implements View.OnClickListener {

    private static final String TAG = "FindBackPayPsActivity";
    private TextView getcode_tv;
    private TextView tv_next;
    private EditText et_phone;
    private EditText auth_code_et;
    private EditText password_et;
    private EditText confirm_password_et;
    private String phone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findback_payps);
        initUI();
        initValue();
    }

    @Override
    public void initUI() {
        String mobile = Prefs.with(mContext).getString("mobile", "");
        et_phone = findViewById(R.id.et_phone);
        getcode_tv = findViewById(R.id.getcode_tv);
        tv_next = findViewById(R.id.tv_next);
        auth_code_et = findViewById(R.id.auth_code_et);
        password_et = findViewById(R.id.password_et);
        et_phone.setText(mobile);
        tv_next.setOnClickListener(this);
        getcode_tv.setOnClickListener(this);

    }

    @Override
    public void initValue() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.getcode_tv:
                phone = et_phone.getText().toString().trim();
                if (!Util.isMobile(phone)) {
                    ToastUtil.showToast("请输入正确的手机号码");
                    return;
                }
                //开始倒计时
                startTimer();
                break;
            case R.id.tv_next:
                String auth_code = auth_code_et.getText().toString().trim();
                String password = password_et.getText().toString().trim();
                String confirm_password = confirm_password_et.getText().toString().trim();

                if (auth_code.equals("") || password.equals("") || confirm_password.equals("")) {
                    Toast.makeText(this, "输入内容不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.equals(confirm_password)) {
                    Toast.makeText(this, "输入密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                }

                OkGo.<String>post("http://bhcd-admin.tudingsoft.com/index.php/Api/Member/back_pay_pwd").params("password", password)
                        .params("confirm_pass", confirm_password)
                        .params("code", auth_code).execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.d(TAG, "onSuccess: " + response.body());
                        GET_REGISTER_CODEBean get_register_codeBean = new Gson().fromJson(response.body(), GET_REGISTER_CODEBean.class);
                        if (get_register_codeBean.getCode() == 0) {
                            Toast.makeText(FindBackPayPsActivity.this, get_register_codeBean.getMsg(), Toast.LENGTH_SHORT).show();
                        } else {
                            finish();
                        }

                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);

                    }
                });
                break;
        }

    }


    private void getYZM() {
        OkGo.<String>post(URls.GET_REGISTER_CODE).params("mobile", phone).execute(new StringCallback() {
            @Override
            public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                String s = response.body();

                GET_REGISTER_CODEBean get_register_codeBean = new Gson().fromJson(s, GET_REGISTER_CODEBean.class);
                int code = get_register_codeBean.getCode();
                if (code == 0) {
                    String msg = get_register_codeBean.getMsg();
                    Toast.makeText(FindBackPayPsActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
                Log.d("messagemessage", s);
            }

            @Override
            public void onError(com.lzy.okgo.model.Response<String> response) {
                super.onError(response);
                Log.d("messagemessage", response.getException().getMessage());

            }

        });
    }

    /**
     * 短信验证码倒计时
     */
    private void startTimer() {
        getYZM();
        new Thread() {
            @Override
            public void run() {
                for (int i = 59; i >= -1; i--) {
                    final int second = i;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (second < 0) {
                                if (getcode_tv != null) {
                                    getcode_tv.setText("获取验证码");
                                    getcode_tv.setEnabled(true);
                                }
                            } else {
                                if (getcode_tv != null) {
                                    getcode_tv.setText(second + "s");
                                    getcode_tv.setEnabled(false);
                                }
                            }
                        }
                    });
                }
            }
        }.start();
    }
}
