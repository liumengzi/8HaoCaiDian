package com.tuding.client.eightnumcolour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.bean.GET_REGISTER_CODEBean;
import com.tuding.client.eightnumcolour.utls.ToastUtil;
import com.tuding.client.eightnumcolour.utls.URls;
import com.tuding.client.eightnumcolour.utls.Util;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

public class RegisterActivity extends RBBaseActivity {
    private static final String TAG = "RegisterActivity";
    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.icon_yan)
    ImageView iconYan;
    @Bind(R.id.et_sms)
    EditText etSms;
    @Bind(R.id.tv_get_smscode)
    TextView tvGetSmscode;
    @Bind(R.id.tv_next)
    TextView tvNext;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    private String phone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initUI();
        initValue();
    }

    @Override
    public void initUI() {
        tvGetSmscode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = etPhone.getText().toString().trim();
                if (!Util.isMobile(phone)) {
                    ToastUtil.showToast("请输入正确的手机号码");
                    return;
                }
                //开始倒计时
                startTimer();
            }
        });
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile = etPhone.getText().toString().trim();
                String sms_code = etSms.getText().toString().trim();
                if ("".equals(phone) || "".equals(phone)) {
                    ToastUtil.showToast("手机号及验证码不能为空");
                    return;
                }

                OkGo.<String>post(URls.REGISTER).params("code", "").params("mobile", mobile).params("sms_code", sms_code).execute(new StringCallback() {
                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                        String s = response.body();

                        Log.d(TAG, "onSuccess: " + s);
                        GET_REGISTER_CODEBean get_register_codeBean = new Gson().fromJson(s, GET_REGISTER_CODEBean.class);
                        if (get_register_codeBean.getCode() == 0) {

                            ToastUtil.showToast(get_register_codeBean.getMsg());
                        } else {
                            startActivity(new Intent(RegisterActivity.this, SetNickNameAndPsActivity.class));
                        }

                    }
                });

            }
        });
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void initValue() {
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
                    Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
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
                                if (tvGetSmscode != null) {
                                    tvGetSmscode.setText("获取验证码");
                                    tvGetSmscode.setEnabled(true);
                                }
                            } else {
                                if (tvGetSmscode != null) {
                                    tvGetSmscode.setText(second + "s");
                                    tvGetSmscode.setEnabled(false);
                                }
                            }
                        }
                    });
                }
            }
        }.start();
    }
}