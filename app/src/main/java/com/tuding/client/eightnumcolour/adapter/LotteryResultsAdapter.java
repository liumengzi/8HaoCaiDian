package com.tuding.client.eightnumcolour.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.activity.LotteryResultsActivity;

public class LotteryResultsAdapter extends BaseAdapter {
    LotteryResultsActivity lotteryResultsActivity;
    private int[] data;

    public LotteryResultsAdapter(LotteryResultsActivity lotteryResultsActivity) {
        this.lotteryResultsActivity = lotteryResultsActivity;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        switch (data[position]) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            default:
                return 0;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 5;
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
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case 0:
                View inflate = lotteryResultsActivity.getLayoutInflater().inflate(R.layout.item_jczq, null, false);

                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
        return null;
    }

    public void setData(int[] data) {
        this.data = data;
    }
}
