package com.tuding.client.eightnumcolour.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.activity.BasketballActivity;

public class EventFilterAdapter extends BaseAdapter {
    BasketballActivity basketballActivity;
    String[] name = new String[]{"世俱杯", "俱乐部杯", "墨超", "欧冠", "欧罗巴", "阿甲"};

    public EventFilterAdapter(BasketballActivity basketballActivity) {
        this.basketballActivity = basketballActivity;

    }

    @Override
    public int getCount() {
        return name.length;
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
        View inflate = basketballActivity.getLayoutInflater().inflate(R.layout.item_event_filter, null, false);
        RadioButton name_tv = inflate.findViewById(R.id.name_tv);
        name_tv.setText(name[position]);

        return inflate;
    }
}
