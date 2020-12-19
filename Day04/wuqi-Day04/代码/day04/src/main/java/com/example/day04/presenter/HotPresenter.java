package com.example.day04.presenter;

import com.example.day04.callback.ResultCallBack;
import com.example.day04.model.HotModel;
import com.example.day04.view.IView;

public class HotPresenter {
    private IView view;
    private final HotModel model;

    public HotPresenter(IView view) {
        this.view = view;
        model = new HotModel();
    }
    public void start(){
        model.requestHot(new ResultCallBack() {
            @Override
            public void successData(Object obj) {
                view.showSuccessUi(obj);
            }

            @Override
            public void failData(String msg) {
                view.showFailUi(msg);
            }
        });
    }
}
