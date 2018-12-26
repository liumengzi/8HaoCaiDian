package com.tuding.client.eightnumcolour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.bean.Data;
import com.tuding.client.eightnumcolour.utls.ToastUtil;
import com.tuding.client.eightnumcolour.utls.URls;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

public class SetNickNameAndPsActivity extends RBBaseActivity {
    @Bind(R.id.et_nickname)
    EditText etNickname;
    @Bind(R.id.et_ps)
    EditText etPs;
    @Bind(R.id.et_second_ps)
    EditText etSecondPs;
    @Bind(R.id.tv_next)
    TextView tvNext;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    private String nickname;
    private String ps;
    private String secondPs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setps);
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
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nickname = etNickname.getText().toString().trim();
                ps = etPs.getText().toString().trim();
                secondPs = etSecondPs.getText().toString().trim();
                if (TextUtils.isEmpty(nickname)) {
                    ToastUtil.showToast("请输入昵称");
                    return;
                }
                if (TextUtils.isEmpty(ps)) {
                    ToastUtil.showToast("请输入密码");
                    return;
                }
                if (TextUtils.isEmpty(secondPs)) {
                    ToastUtil.showToast("请再次输入密码");
                    return;
                }
                if (!ps.equals(secondPs)) {
                    ToastUtil.showToast("两次输入的密码不一致");
                    return;
                }
                loadingDialog.show();
                setPs();
            }

        });
    }

    @Override
    public void initValue() {
    }

    private void setPs() {
        OkGo.<String>post("http://bhcd-admin.tudingsoft.com/index.php/Api/User/set_nickname").params("nickname", nickname).params("password", ps).params
                ("confirm_pass", secondPs).execute(new StringCallback() {
            @Override
            public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                String s = response.body();

                loadingDialog.dismiss();
                Data data = new Gson().fromJson(s, Data.class);
                if (data != null) {
                    if (data.code == 1) {
                        startActivity(new Intent(SetNickNameAndPsActivity.this, MainActivity
                                .class));
                    } else {
                        ToastUtil.showToast(data.msg);
                    }
                }
            }

            @Override
            public void onError(com.lzy.okgo.model.Response<String> response) {
                super.onError(response);
                loadingDialog.dismiss();

            }

        });
    }
}
