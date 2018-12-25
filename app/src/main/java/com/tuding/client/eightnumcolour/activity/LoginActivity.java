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
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.bean.Data;
import com.tuding.client.eightnumcolour.utls.ToastUtil;
import com.tuding.client.eightnumcolour.utls.URls;
import com.tuding.client.eightnumcolour.utls.Util;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

public class LoginActivity extends RBBaseActivity implements View.OnClickListener {
    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.et_ps)
    EditText etPs;
    @Bind(R.id.retrieve_password_tv)
    TextView retrievePasswordTv;
    @Bind(R.id.login_tv)
    TextView loginTv;
    @Bind(R.id.register_tv)
    TextView registerTv;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    private String phone;
    private String ps;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initUI();
        initValue();
    }

    @Override
    public void initUI() {
        TextView login_tv = findViewById(R.id.login_tv);
        login_tv.setOnClickListener(this);
        TextView register_tv = findViewById(R.id.register_tv);
        register_tv.setOnClickListener(this);
        TextView retrieve_password_tv = findViewById(R.id.retrieve_password_tv);
        retrieve_password_tv.setOnClickListener(this);
        ivBack.setOnClickListener(this);
    }

    @Override
    public void initValue() {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_tv:
                phone = etPhone.getText().toString().trim();
                ps = etPs.getText().toString().trim();
                if (!Util.isMobile(phone)) {
                    ToastUtil.showToast("请输入正确的手机号码");
                    return;
                }
                if (TextUtils.isEmpty(ps)) {
                    ToastUtil.showToast("请输入密码");
                    return;
                }
                loadingDialog.show();
                loadingDialog.setTips("正在登录");
                login();
                break;
            case R.id.retrieve_password_tv:
                startActivity(new Intent(mContext, RetrievePasswordActivity.class));
                break;
            case R.id.register_tv:
                startActivity(new Intent(mContext, RegisterActivity.class));
                break;
            case R.id.iv_back:
                finish();
                break;
        }

    }

    private void login() {
        OkGo.post(URls.LOGIN).params("mobile", phone).params("password", ps).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                Log.i("loginsuccess", s.toString());
                loadingDialog.dismiss();
                Data data = new Gson().fromJson(s, Data.class);
                if (data != null) {
                    if (data.code == 1) {
                        startActivity(new Intent(mContext, MainActivity.class));
                    } else if (0 == data.code) {
                        ToastUtil.showToast(data.msg);

                    }
                }
            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                loadingDialog.dismiss();
                super.onError(call, response, e);
            }
        });
    }
}
