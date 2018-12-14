package com.tuding.client.eightnumcolour.adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.activity.LotteryResultsInfoListActivity;
import com.tuding.client.eightnumcolour.bean.RESULTLISTBean;

import java.util.List;

public class LotteryResultsInfoListAdapter extends BaseAdapter {
    private static final String TAG = "LotteryResultsInfoListAdapter";

    LotteryResultsInfoListActivity lotteryResultsInfoListActivity;
    private List<RESULTLISTBean.DataBean.ListBean> data;
    private List<String> result_red;
    private List<String> result_blue;
    private List<String> result;

    public LotteryResultsInfoListAdapter(LotteryResultsInfoListActivity lotteryResultsInfoListActivity) {
        this.lotteryResultsInfoListActivity = lotteryResultsInfoListActivity;
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("LongLogTag")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = lotteryResultsInfoListActivity.getLayoutInflater().inflate(R.layout.item_lotteryresultsinfolist, null, false);
        TextView numb_tv = convertView.findViewById(R.id.numb_tv);

        LinearLayout num_ll = convertView.findViewById(R.id.num_ll);
        LinearLayout fang_ll = convertView.findViewById(R.id.fang_ll);

        if (data != null) {
            RESULTLISTBean.DataBean.ListBean listBean = data.get(position);
            numb_tv.setText(listBean.getKj_date() + " 第" + listBean.getExpect_no() + "期");
            String expect_type = data.get(position).getExpect_type();
            result_red = listBean.getResult_red();
            result_blue = listBean.getResult_blue();
            numb_tv.setText("第"+listBean.getExpect_no()+"期");
            switch (expect_type) {
                case "ssq":
                    num_ll.setVisibility(View.VISIBLE);
                    fang_ll.setVisibility(View.GONE);
                    int childCount = num_ll.getChildCount();
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
                case "dlt":
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
                case "lcbqc":
                    result = listBean.getResult();
                    num_ll.setVisibility(View.GONE);
                    fang_ll.setVisibility(View.VISIBLE);
                    for (int i = 0; i < result.size(); i++) {
                        TextView childAt = (TextView) fang_ll.getChildAt(i);
                        childAt.setVisibility(View.VISIBLE);
                        childAt.setText(result.get(i));

                    }
                    break;
                case "sf":
                    result = listBean.getResult();
                    num_ll.setVisibility(View.GONE);
                    fang_ll.setVisibility(View.VISIBLE);
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

    public void setData(List<RESULTLISTBean.DataBean.ListBean> data) {
        this.data = data;
    }
}
