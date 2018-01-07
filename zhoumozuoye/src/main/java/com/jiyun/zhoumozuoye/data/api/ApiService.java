package com.jiyun.zhoumozuoye.data.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by papi酱 on 2018/1/6.
 */

public interface ApiService {
@GET("first_page.json")
    Call<ResponseBody> getRXjavaString();
    @GET("second_page.json")
    Call<ResponseBody> getRXString();

}
