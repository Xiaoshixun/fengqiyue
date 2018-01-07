package com.jiyun.zhoumozuoye.presenter.contract;


import android.widget.BaseAdapter;

import com.jiyun.zhoumozuoye.BaseView;
import com.jiyun.zhoumozuoye.BaseViewmsg;
import com.jiyun.zhoumozuoye.presenter.BasePresenter;
import com.jiyun.zhoumozuoye.presenter.BasePresentermsg;

/**
 * Created by papi酱 on 2017/11/28.
 */

public interface IRecommandContract {
    interface IPresenter extends BasePresenter {
        void requestData();
        void requestList();


    }
    interface IView<IPresenter> extends BaseView<IPresenter> {
        void showData(String responseString);
        void showListData(String responseStringList);

    }



}
