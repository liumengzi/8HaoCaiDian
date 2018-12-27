package com.tuding.client.eightnumcolour.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.activity.BankCardManagementActivity;

public class BankAdapter extends BaseAdapter {
    BankCardManagementActivity bankCardManagementActivity;

    public BankAdapter(BankCardManagementActivity bankCardManagementActivity) {

        this.bankCardManagementActivity = bankCardManagementActivity;
    }

    @Override
    public int getCount() {
        return 10;
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
        convertView = bankCardManagementActivity.getLayoutInflater().inflate(R.layout.item_bank, null, false);

        return convertView;
    }
}
