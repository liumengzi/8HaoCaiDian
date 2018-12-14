package com.tuding.client.eightnumcolour.adapter;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.activity.LotteryResultsActivity;
import com.tuding.client.eightnumcolour.bean.NOTERESULTBean;

import java.util.List;

public class LotteryResultsAdapter extends BaseAdapter {
    LotteryResultsActivity lotteryResultsActivity;
    private NOTERESULTBean.DataBean data;
    private int childCount;
    private List<String> result_red;
    private List<String> result_blue;
    private List<String> result;
    private TextView type_tv;
    private TextView numb_tv;
    private TextView date_tv;

    public LotteryResultsAdapter(LotteryResultsActivity lotteryResultsActivity) {
        this.lotteryResultsActivity = lotteryResultsActivity;
    }

    @Override
    public int getCount() {
        return data == null ? 0 : 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = lotteryResultsActivity.getLayoutInflater().inflate(R.layout.item_jczq, null, false);
        type_tv = convertView.findViewById(R.id.type_tv);
        numb_tv = convertView.findViewById(R.id.numb_tv);
        date_tv = convertView.findViewById(R.id.date_tv);
        LinearLayout num_ll = convertView.findViewById(R.id.num_ll);
        LinearLayout fang_ll = convertView.findViewById(R.id.fang_ll);

        if (data != null) {
            NOTERESULTBean.DataBean.DltBean dlt = data.getDlt();
            NOTERESULTBean.DataBean.Ft6Bean ft6 = data.getFt6();
            NOTERESULTBean.DataBean.Ft9Bean ft9 = data.getFt9();
            NOTERESULTBean.DataBean.SsqBean ssq = data.getSsq();

            switch (position) {
                case 0:
                    date_tv.setText(ssq.getKj_date());
                    numb_tv.setText("第"+ssq.getExpect_no()+"期");
                    type_tv.setText("双色球");
                    result_red = ssq.getResult_red();
                    result_blue = ssq.getResult_blue();

                    num_ll.setVisibility(View.VISIBLE);
                    fang_ll.setVisibility(View.GONE);
                    childCount = num_ll.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        TextView childAt = (TextView) num_ll.getChildAt(i);
                        if (i <= childCount - 2) {
                            childAt.setBackgroundResource(R.drawable.yuan);
                            childAt.setText(result_red.get(i));
                        } else {
                            childAt.setBackgroundResource(R.drawable.yuan_bule);
                            childAt.setText(result_blue.get(childCount - i - 1));
                        }
                    }


                    break;
                case 1:
                    date_tv.setText(dlt.getKj_date());
                    type_tv.setText("大乐透");
                    result_red = dlt.getResult_red();
                    result_blue = dlt.getResult_blue();
                    numb_tv.setText("第"+dlt.getExpect_no()+"期");
                    num_ll.setVisibility(View.VISIBLE);
                    fang_ll.setVisibility(View.GONE);
                    childCount = num_ll.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        TextView childAt = (TextView) num_ll.getChildAt(i);
                        if (i <= childCount - 3) {
                            childAt.setBackgroundResource(R.drawable.yuan);
                            childAt.setText(result_red.get(i));
                        } else {
                            childAt.setBackgroundResource(R.drawable.yuan_bule);
                            childAt.setText(result_blue.get(childCount - i - 1));
                        }
                    }
                    break;
                case 2:
                    date_tv.setText(ft6.getKj_date());
                    numb_tv.setText("第"+ft6.getExpect_no()+"期");
                    type_tv.setText("半全场");
                    result = ft6.getResult();
                    num_ll.setVisibility(View.GONE);
                    fang_ll.setVisibility(View.VISIBLE);
                    childCount = fang_ll.getChildCount();
                    for (int i = 0; i < result.size(); i++) {
                        TextView childAt = (TextView) fang_ll.getChildAt(i);
                        childAt.setVisibility(View.VISIBLE);
                        childAt.setText(result.get(i));

                    }
                    break;
                case 3:

                    date_tv.setText(ft9.getKj_date());
                    numb_tv.setText("第"+ft9.getExpect_no()+"期");
                    type_tv.setText("任选九");
                    result = ft9.getResult();
                    num_ll.setVisibility(View.GONE);
                    fang_ll.setVisibility(View.VISIBLE);
                    childCount = fang_ll.getChildCount();
                    for (int i = 0; i < result.size(); i++) {
                        TextView childAt = (TextView) fang_ll.getChildAt(i);
                        childAt.setVisibility(View.VISIBLE);
                        childAt.setText(result.get(i));
                    }
                    break;
            }

        }
        return convertView;
    }

    public void setData(NOTERESULTBean.DataBean data) {
        this.data = data;
    }
}
