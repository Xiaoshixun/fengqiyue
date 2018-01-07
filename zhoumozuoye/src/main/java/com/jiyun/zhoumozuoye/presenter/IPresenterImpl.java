package com.jiyun.zhoumozuoye.presenter;


import com.jiyun.zhoumozuoye.data.model.IModel;
import com.jiyun.zhoumozuoye.data.model.IModelImpl;
import com.jiyun.zhoumozuoye.presenter.contract.IRecommandContract;
import com.jiyun.zhoumozuoye.ui.fragment.AttentionFragment;
import com.jiyun.zhoumozuoye.ui.fragment.GateFragment;

/**
 * Created by papi酱 on 2017/11/28.
 */

public class IPresenterImpl implements IRecommandContract.IPresenter {
    IRecommandContract.IView iView;

    private IModel iModel;



    public IPresenterImpl(IRecommandContract.IView iView){
        this.iView = iView;


        iModel = new IModelImpl();

        iView.setPresenter(this);



    }




    @Override
    public void start() {

    }

    @Override
    public void requestData() {

        iModel.setData(new IModel.setOnShowDataLisenter() {
            @Override
            public void onShowData(String responseString) {
               iView.showData(responseString);

            }
        });
    }

    @Override
    public void requestList() {
        iModel.setList(new IModel.setOnShowListLisenter() {
            @Override
            public void onShowList(String resposeDataString) {
                iView.showListData(resposeDataString);
            }
        });
    }


}
