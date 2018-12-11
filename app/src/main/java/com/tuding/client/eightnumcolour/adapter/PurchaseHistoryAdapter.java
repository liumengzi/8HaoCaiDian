package com.tuding.client.eightnumcolour.adapter;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tuding.client.eightnumcolour.R;

public class PurchaseHistoryAdapter extends BaseAdapter {
    FragmentActivity activity;

    public PurchaseHistoryAdapter(FragmentActivity activity) {

        this.activity = activity;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = activity.getLayoutInflater().inflate(R.layout.item_purchase, null, false);
        return view;
    }
}
