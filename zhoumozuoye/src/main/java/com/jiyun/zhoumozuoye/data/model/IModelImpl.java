package com.jiyun.zhoumozuoye.data.model;

import android.support.annotation.NonNull;
import android.support.v7.view.menu.SubMenuBuilder;
import android.util.Log;

import com.jiyun.zhoumozuoye.common.constant.Constant;
import com.jiyun.zhoumozuoye.data.api.ApiService;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * Created by papi酱 on 2017/11/28.
 */

public class IModelImpl implements IModel {

    @Override
    public void setData(final setOnShowDataLisenter lisenter) {
        Retrofit build = new Retrofit.Builder().baseUrl(Constant.URLSTRING).build();
        ApiService apiService = build.create(ApiService.class);
        Call<ResponseBody> rXjavaString = apiService.getRXjavaString();
        rXjavaString.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    lisenter.onShowData(string);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }

    @Override
    public void setList(final setOnShowListLisenter Listlisenter) {
        Retrofit build = new Retrofit.Builder().baseUrl(Constant.URLSTRINGBASE).build();
        ApiService apiService = build.create(ApiService.class);
        Call<ResponseBody> rXjavaString = apiService.getRXString();
        rXjavaString.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Listlisenter.onShowList(string);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }


}



