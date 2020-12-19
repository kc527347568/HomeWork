package com.example.wuqi.presenter;

import com.example.wuqi.callback.ResultCallBack;
import com.example.wuqi.model.PictureModel;
import com.example.wuqi.model.bean.PictureBean;
import com.example.wuqi.view.IView;

public class PicturePresenter {
    private IView view;
    private final PictureModel model;


    public PicturePresenter(IView view) {
        this.view = view;
        model = new PictureModel();
    }
    public void start(){
        model.resultPic(new ResultCallBack<PictureBean>() {
            @Override
            public void successData(PictureBean pictureBean) {
                view.showSuccessUi(pictureBean);
            }

            @Override
            public void failData(String msg) {
                view.showFailData(msg);
            }
        });
    }

}
