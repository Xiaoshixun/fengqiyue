package com.jiyun.zhoumozuoye.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by papi酱 on 2018/1/6.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mlist;
    private ArrayList<String> arrayList;

    public MyFragmentAdapter(FragmentManager fm, ArrayList<Fragment> mlist, ArrayList<String> arrayList) {
        super(fm);
        this.mlist = mlist;
        this.arrayList = arrayList;
    }

    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arrayList.get(position);
    }
}
