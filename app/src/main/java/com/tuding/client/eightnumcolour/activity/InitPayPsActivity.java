package com.tuding.client.eightnumcolour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.bean.GET_REGISTER_CODEBean;

public class InitPayPsActivity extends RBBaseActivity {

    private static final String TAG = "InitPayPsActivity";
    private EditText password_et;
    private EditText confirm_password_et;
    private Button init_paypassword_bt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_payps);
        initUI();
        initValue();
    }


    @Override
    public void initUI() {
        password_et = findViewById(R.id.password_et);
        confirm_password_et = findViewById(R.id.confirm_password_et);

        init_paypassword_bt = findViewById(R.id.init_paypassword_bt);
        init_paypassword_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yanzheng()) {
                    String password = password_et.getText().toString().trim();
                    String confirm_pass = confirm_password_et.getText().toString().trim();
                    OkGo.<String>post("http://bhcd-admin.tudingsoft.com/index.php/Api/Member/pay_pwd_set")
                            .params("password", password)
                            .params("confirm_pass", confirm_pass)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(Response<String> response) {
                                    Log.d(TAG, "onSuccess: " + response.body());

                                    GET_REGISTER_CODEBean get_register_codeBean = new Gson().fromJson(response.body(), GET_REGISTER_CODEBean.class);
                                    if (get_register_codeBean.getCode() == 0) {
                                        Toast.makeText(InitPayPsActivity.this, get_register_codeBean.getMsg(), Toast.LENGTH_SHORT).show();
                                    } else {
                                        startActivity(new Intent(InitPayPsActivity.this, MainActivity.class));
                                        finish();
                                    }

                                }
                            });

                }
            }
        });
    }

    private void request() {

    }

    String password, confirm_password;

    private boolean yanzheng() {
        password = password_et.getText().toString().replaceAll(" ", "");
        confirm_password = confirm_password_et.getText().toString().replaceAll(" ", "");

        if (password.equals("")) {
            Toast.makeText(InitPayPsActivity.this, "信息输入不完整！", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (confirm_password.equals("")) {
            Toast.makeText(InitPayPsActivity.this, "信息输入不完整！", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (confirm_password.length() < 8) {
            Toast.makeText(InitPayPsActivity.this, "密码长度不能小于8位数！", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.length() < 8) {
            Toast.makeText(InitPayPsActivity.this, "密码长度不能小于8位数！", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!password.equals(confirm_password)) {
            Toast.makeText(InitPayPsActivity.this, "两次输入密码不一致！", Toast.LENGTH_SHORT).show();

            return false;
        }
        return true;
    }

    @Override
    public void initValue() {
    }
}
