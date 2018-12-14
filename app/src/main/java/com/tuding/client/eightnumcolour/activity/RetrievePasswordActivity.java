package com.tuding.client.eightnumcolour.activity;

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

public class RetrievePasswordActivity extends RBBaseActivity {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.et_nickname)
    EditText etNickname;
    @Bind(R.id.icon_yan)
    ImageView iconYan;
    @Bind(R.id.et_sms)
    EditText etSms;
    @Bind(R.id.tv_get_smscode)
    TextView tvGetSmscode;
    @Bind(R.id.et_ps)
    EditText etPs;
    @Bind(R.id.et_second_ps)
    EditText etSecondPs;
    @Bind(R.id.tv_finish)
    TextView tvFinish;
    private String tel;
    private String sms;
    private String ps;
    private String secondPs;
    private String phone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetps);
        ButterKnife.bind(this);
        initUI();
        initValue();
    }

    @Override
    public void initUI() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tel = etNickname.getText().toString().trim();
                sms = etSms.getText().toString().trim();
                ps = etPs.getText().toString().trim();
                secondPs = etSecondPs.getText().toString().trim();
                if (!Util.isMobile(tel)) {
                    ToastUtil.showToast("请输入正确的手机号码");
                    return;
                }
                if (TextUtils.isEmpty(sms)) {
                    ToastUtil.showToast("请输入验证码");
                    return;
                }
                if (TextUtils.isEmpty(ps)) {
                    ToastUtil.showToast("请输入密码");
                    return;
                }
                if (!secondPs.equals(ps)) {
                    ToastUtil.showToast("两次输入的密码不一致");
                    return;
                }
                loadingDialog.show();
                forgetPs();
            }

        });
        tvGetSmscode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = etNickname.getText().toString().trim();
                if (!Util.isMobile(phone)) {
                    ToastUtil.showToast("请输入正确的手机号码");
                    return;
                }
                startTimer();

            }
        });
    }

    private void forgetPs() {
        OkGo.post(URls.FORGET_PS).params("mobile", tel).params("password", ps).params
                ("confirm_pass", secondPs).params("code", sms).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                loadingDialog.dismiss();
                int code = 0;
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    String msg = jsonObject.getString("msg");
                    code = jsonObject.getInt("code");
                    if (code == 0) {
                        ToastUtil.showToast(msg);
                    }else  if(code==1){
                        finish();
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

    private void getYZM() {
        OkGo.post(URls.GET_FORGET_MOBILE).params("mobile", phone).execute(new StringCallback() {
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

    @Override
    public void initValue() {
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
