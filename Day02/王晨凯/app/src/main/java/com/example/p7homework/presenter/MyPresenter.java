package com.example.p7homework.presenter;

import com.example.p7homework.callback.MyCallback;
import com.example.p7homework.model.MyModel;
import com.example.p7homework.view.IView;

public class MyPresenter {
    private IView mView;
    private MyModel myModel;

    public MyPresenter(IView mView) {
        this.mView = mView;
        myModel = new MyModel();
    }

    public void start(int page,String types) {
        myModel.getData(page, types, new MyCallback() {
            @Override
            public void successData(Object object) {
                mView.successUi(object);
            }

            @Override
            public void fileData(String msg) {
                mView.fileUi(msg);
            }
        });
    }
}
