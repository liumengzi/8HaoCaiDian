package com.tuding.client.eightnumcolour.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.bean.CertificationBean;
import com.tuding.client.eightnumcolour.utls.ToastUtil;
import com.tuding.client.eightnumcolour.utls.URls;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

public class CertificationActivity extends RBBaseActivity {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.et_real_name)
    EditText etRealName;
    @Bind(R.id.et_idcardno)
    EditText etIdcardno;
    @Bind(R.id.bt_renzheng)
    Button btRenzheng;
    private String name;
    private String cardno;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certification);
        ButterKnife.bind(this);
        initUI();
        initValue();
    }

    @Override
    public void initUI() {
        getCertification();
        btRenzheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etRealName.getText().toString().trim();
                cardno = etIdcardno.getText().toString().trim();
                if (TextUtils.isEmpty(name)) {
                    ToastUtil.showToast("请输入真实姓名");
                    return;
                }
                if (TextUtils.isEmpty(cardno)) {
                    ToastUtil.showToast("请输入身份证号");
                    return;
                }
                loadingDialog.show();
                certification();
            }
        });
    }

    private void getCertification() {
        OkGo.get(URls.GET_CERTIFICATION).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                JSONObject jsonObject= null;
                try {
                    jsonObject = new JSONObject(s);
                    int code = jsonObject.getInt("code");
                    if(code==1){
                        CertificationBean certificationBean = new Gson().fromJson(s,
                                CertificationBean.class);
                        CertificationBean.DataBean data = certificationBean.data;
                        String realname = data.realname;
                        String idcard = data.idcard;
                        etRealName.setText("*"+realname.substring(realname.length()-1));
                        etIdcardno.setText("**************"+idcard.substring(idcard.length()-4));
                        btRenzheng.setEnabled(false);
                    }else if(code==0){
                        btRenzheng.setEnabled(true);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                super.onError(call, response, e);
            }
        });

    }

    private void certification() {
        OkGo.post(URls.CERTIFICATION).params("realname", name).params("idcard", cardno).execute
                (new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                loadingDialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    int code = jsonObject.getInt("code");
                    String msg = null;
                    msg = jsonObject.getString("msg");
                    ToastUtil.showToast(msg);
                    if (code == 1) {
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

    @Override
    public void initValue() {
    }
}
