package com.example.componentapp.adapter;

import java.util.ArrayList;
import java.util.List;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.libs.base.BaseFragment;

public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> mList;

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mList = new ArrayList<>();
    }

    public MainViewPagerAdapter(FragmentManager fm, List<BaseFragment> list) {
        this(fm);

        if (list != null && !list.isEmpty()) {
            mList.addAll(list);
        }
    }

    @Override
    public Fragment getItem(int i) {
        return mList.get(i);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "world";
    }
}
