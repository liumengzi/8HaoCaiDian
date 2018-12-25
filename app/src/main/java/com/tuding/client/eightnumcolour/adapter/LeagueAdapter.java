package com.tuding.client.eightnumcolour.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.bean.MATCHRESULTBean;
import com.tuding.client.eightnumcolour.fragment.ScoreFragment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LeagueAdapter extends BaseAdapter implements CompoundButton.OnCheckedChangeListener {
    ScoreFragment scoreFragment;
    private List<MATCHRESULTBean.DataBean.LeagueListBean> data;
    private int checked = -1;
    private ViewHolder viewHolder;

    public Map<CompoundButton, String> getCompoundButtonMap() {
        return compoundButtonMap;
    }

    private Map<CompoundButton, String> compoundButtonMap;


    public LeagueAdapter(ScoreFragment scoreFragment) {

        this.scoreFragment = scoreFragment;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = scoreFragment.getLayoutInflater().inflate(R.layout.item_event_filter, null, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
            viewHolder.name_tv.setOnCheckedChangeListener(this);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (data != null) {
            viewHolder.name_tv.setText(data.get(position).getLeague());
        }
        if (checked == 0) {
            viewHolder.name_tv.setChecked(true);
        } else if (checked == 1) {
            if (viewHolder.name_tv.isChecked()) {
                viewHolder.name_tv.setChecked(false);
            } else {
                viewHolder.name_tv.setChecked(true);
            }

        }
        return convertView;
    }

    public void setData(List<MATCHRESULTBean.DataBean.LeagueListBean> data) {
        this.data = data;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (compoundButtonMap == null) {
            compoundButtonMap = new HashMap<>();
        }
        if (isChecked) {
            compoundButtonMap.put(buttonView, buttonView.getText().toString().trim());
        }


    }

    private class ViewHolder {

        private final RadioButton name_tv;

        public ViewHolder(View convertView) {
            name_tv = convertView.findViewById(R.id.name_tv);
        }
    }
}
