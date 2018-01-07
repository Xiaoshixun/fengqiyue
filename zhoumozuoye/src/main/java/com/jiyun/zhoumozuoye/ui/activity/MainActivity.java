package com.jiyun.zhoumozuoye.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.jiyun.zhoumozuoye.R;
import com.jiyun.zhoumozuoye.ui.adapter.MyFragmentAdapter;
import com.jiyun.zhoumozuoye.ui.fragment.AttentionFragment;
import com.jiyun.zhoumozuoye.ui.fragment.GateFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.View_item)
    ViewPager ViewItem;
    @Bind(R.id.table_item)
    TabLayout tableItem;
    private ArrayList<Fragment> mlist;
    private ArrayList<String> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mlist = new ArrayList<>();
        mlist.add(new GateFragment());
        mlist.add(new AttentionFragment());
        arrayList = new ArrayList<>();
        arrayList.add("校外");
        arrayList.add("关注");
        initAdapter();
    }

    private void initAdapter() {
        MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager(), mlist, arrayList);
        tableItem.setupWithViewPager(ViewItem);
        ViewItem.setAdapter(adapter);
    }
}
