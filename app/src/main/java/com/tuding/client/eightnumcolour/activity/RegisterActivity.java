package com.tuding.client.eightnumcolour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
                startActivity(new Intent(RegisterActivity.this, SetNickNameAndPsActivity.class));
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
        OkGo.post(URls.GET_REGISTER_CODE).params("mobile", phone).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                Log.d("messagemessage", s);
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
