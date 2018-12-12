package com.tuding.client.eightnumcolour.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tuding.client.eightnumcolour.R;

public class CustomServiceDialog extends Dialog {
    private final Context context;
    private final View view;
    private TextView tv_content;
    private Button bt_sure;

    public CustomServiceDialog(@NonNull Context context) {
        super(context, R.style.dialog_style);
        this.context = context;
        view = View.inflate(context, R.layout.dialog_customservice, null);
        setContentView(view);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        findViews();
    }

    private void findViews() {
        tv_content = view.findViewById(R.id.tv_content);
        bt_sure = view.findViewById(R.id.bt_sure);
        bt_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public void setContent(String content) {
        tv_content.setText(content);
    }
}
