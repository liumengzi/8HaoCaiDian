package com.tuding.client.eightnumcolour.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuding.client.eightnumcolour.R;

public class HomeAdapter extends BaseAdapter {
    Activity homeFragment;

    public HomeAdapter(Activity homeFragment) {

        this.homeFragment = homeFragment;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int i) {
        return name[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = homeFragment.getLayoutInflater().inflate(R.layout.item_home, null, false);
        ImageView item_iv = view.findViewById(R.id.item_iv);
        TextView title_tv = view.findViewById(R.id.title_tv);
        TextView content_tv = view.findViewById(R.id.content_tv);
        title_tv.setText(name[i]);
        content_tv.setText(content[i]);
        item_iv.setImageResource(img[i]);
        return view;
    }

    String[] name;
    int[] img;
    String[] content;

    public void setData(String[] name, int[] img, String[] content) {
        this.name = name;
        this.img = img;
        this.content = content;
    }
}
