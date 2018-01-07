package com.jiyun.zhoumozuoye.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.jiyun.zhoumozuoye.R;
import com.jiyun.zhoumozuoye.presenter.IPresenterImpl;
import com.jiyun.zhoumozuoye.presenter.contract.IRecommandContract;
import com.jiyun.zhoumozuoye.ui.Bean.ShiTi2;
import com.jiyun.zhoumozuoye.ui.activity.Main2Activity;
import com.jiyun.zhoumozuoye.ui.adapter.MyAdapter2;

import java.util.List;

/**
 * Created by papi酱 on 2018/1/6.
 */

public class AttentionFragment extends Fragment implements IRecommandContract.IView<IRecommandContract.IPresenter>{
    private RecyclerView recy_item;
    private IRecommandContract.IPresenter iPresenter;
    private String responseStringList1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.attentionfragment, container, false);
        iPresenter = new IPresenterImpl(this);
        initView(inflate);

        return inflate;
    }

    private void initView(View inflate) {
        recy_item = (RecyclerView) inflate.findViewById(R.id.recy_item);
    }


    @Override
    public void showData(String responseString) {

    }

    public void showListData(String responseStringList) {
        responseStringList1 = responseStringList;
        Gson gson  = new Gson();
        ShiTi2 shiTi2 = gson.fromJson(responseStringList1, ShiTi2.class);
        final List<ShiTi2.ResultBean.DataBean> mlist = shiTi2.getResult().getData();
        MyAdapter2 adapter2 = new MyAdapter2(mlist,getActivity());
        recy_item.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        recy_item.setLayoutManager(new LinearLayoutManager(getActivity()));
        recy_item.setAdapter(adapter2);
        adapter2.setOnItemclik(new MyAdapter2.OnItemclik() {
            @Override
            public void setOnItemClik(View view, int position) {
                Intent intent = new Intent(getActivity(), Main2Activity.class);
                intent.putExtra("name",mlist.get(position).getUrl());
                startActivity(intent);
            }
        });
    }


    @Override
    public void setPresenter(IRecommandContract.IPresenter iPresenter) {
        this.iPresenter = iPresenter;
        iPresenter.requestList();
    }
}
