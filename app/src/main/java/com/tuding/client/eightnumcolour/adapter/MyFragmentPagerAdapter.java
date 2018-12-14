package com.tuding.client.eightnumcolour.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private Fragment[] fragments;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    public void setFragments(Fragment[] fragments) {
        this.fragments = fragments;
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public Fragment getItem(int arg0) {
        return fragments[arg0];
    }
}