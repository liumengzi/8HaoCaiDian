package com.tuding.client.eightnumcolour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.utls.ToastUtil;
import com.tuding.client.eightnumcolour.utls.URls;
import com.tuding.client.eightnumcolour.utls.Util;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

public class RegisterActivity extends RBBaseActivity {
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
    @Bind(R.id.et_yaoqingma)
    EditText etYaoqingma;
    private String phone;
    private String tel;
    private String smsCode;
    private String yaoqingma;

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
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yaoqingma = etYaoqingma.getText().toString().trim();
                tel = etPhone.getText().toString().trim();
                smsCode = etSms.getText().toString().trim();
                if (!Util.isMobile(tel)) {
                    ToastUtil.showToast("请输入正确的手机号码");
                    return;
                }
                if (TextUtils.isEmpty(smsCode)) {
                    ToastUtil.showToast("请输入验证码");
                    return;
                }
                loadingDialog.show();
                register(yaoqingma, tel, smsCode);
            }
        });
    }

    private void register(String yaoqingma, String tel, String smsCode) {
        OkGo.post(URls.REGISTER).params("code", yaoqingma).params("mobile", tel).params
                ("sms_code", smsCode).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                loadingDialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    int code = jsonObject.getInt("code");
                    String msg = jsonObject.getString("msg");
                    if (code == 1) {
                        ToastUtil.showToast(msg);
                        startActivity(new Intent(RegisterActivity.this, SetNickNameAndPsActivity
                                .class));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                super.onError(call, response, e);
                loadingDialog.dismiss();
            }
        });
    }

    @Override
    public void initValue() {
    }

    private void getYZM() {
        OkGo.post(URls.GET_REGISTER_CODE).params("mobile", phone).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                Log.d("messagemessage", s);
                int code = 0;
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    String msg = jsonObject.getString("msg");
                    code = jsonObject.getInt("code");
                    if (code == 0) {
                        ToastUtil.showToast(msg);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                super.onError(call, response, e);
                Log.d("messagemessage", e.getMessage());
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
