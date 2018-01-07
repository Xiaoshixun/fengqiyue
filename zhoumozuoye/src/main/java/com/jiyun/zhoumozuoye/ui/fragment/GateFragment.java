package com.jiyun.zhoumozuoye.ui.fragment;

import android.content.Context;
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
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.jiyun.zhoumozuoye.R;
import com.jiyun.zhoumozuoye.presenter.IPresenterImpl;
import com.jiyun.zhoumozuoye.presenter.contract.IRecommandContract;
import com.jiyun.zhoumozuoye.ui.Bean.ShiTi;
import com.jiyun.zhoumozuoye.ui.activity.Main2Activity;
import com.jiyun.zhoumozuoye.ui.activity.MainActivity;
import com.jiyun.zhoumozuoye.ui.adapter.MyAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by papi酱 on 2018/1/6.
 */

public class GateFragment extends Fragment implements IRecommandContract.IView<IRecommandContract.IPresenter>{

    private IRecommandContract.IPresenter iPresenter;
    private String responseString1;
    private ArrayList<String> strings = new ArrayList<>();
    private Banner banner_item;
    private RecyclerView Recycle_item;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.gatefragment, container, false);
        iPresenter = new IPresenterImpl(this);

        initView(inflate);

        return inflate;
    }

    @Override
    public void setPresenter(IRecommandContract.IPresenter iPresenter) {
        this.iPresenter = iPresenter;
        iPresenter.requestData();
    }

    @Override
    public void showData(String responseString) {
        responseString1 = responseString;
        Gson gson = new Gson();
        ShiTi shiTi = gson.fromJson(responseString1, ShiTi.class);
        final List<ShiTi.ResultBean.ListBean> mlist = shiTi.getResult().getList();
        MyAdapter adapter = new MyAdapter(mlist, getActivity());
        StaggeredGridLayoutManager st = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        Recycle_item.setLayoutManager(st);
        Recycle_item.setAdapter(adapter);
        adapter.setOnItemclik(new MyAdapter.OnItemclik() {
            @Override
            public void setOnItemClik(View view, int position) {
                Intent intent = new Intent(getActivity(), Main2Activity.class);
                intent.putExtra("name",mlist.get(position).getUrl());
                startActivity(intent);


            }
        });
        ArrayList<String> title = new ArrayList<>();
        strings.clear();
        for (int i = 0; i < mlist.size(); i++) {
            strings.add(mlist.get(i).getFirstImg());
            title.add((i + 1) + "/" + mlist.size() + "页");
        }
        banner_item.setImages(strings)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                .setImageLoader(new GlideImageLoader())
                .setBannerTitles(title)
                .setBannerAnimation(Transformer.Tablet)
                .setDelayTime(2000)
                .start();

    }

    @Override
    public void showListData(String responseStringList) {

    }

    private void initView(View inflate) {

        banner_item = (Banner) inflate.findViewById(R.id.banner_item);

        Recycle_item = (RecyclerView) inflate.findViewById(R.id.Recycle_item);
    }


    //图片加载器
    class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {

            //Picacco加载图片简单用法
            Glide.with(getActivity()).load((String) path).into(imageView);
        }
    }
}
