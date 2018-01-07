package com.jiyun.zhoumozuoye.data.model;

/**
 * Created by papi酱 on 2017/11/28.
 */

public interface IModel {
    void setData(setOnShowDataLisenter lisenter);

    interface setOnShowDataLisenter{
        void onShowData(String responseString);
    }
    void setList(setOnShowListLisenter Listlisenter);

    interface setOnShowListLisenter{
        void onShowList(String resposeDataString);
    }

}
