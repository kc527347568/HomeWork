package com.example.day02kczy.persenter;

import android.content.Context;

import com.example.day02kczy.bean.ShiBean;
import com.example.day02kczy.fragment.FlyFragment;
import com.example.day02kczy.model.MyModel;
import com.example.day02kczy.view.FlyView;

public class FlyPresenter {
    private final FlyView view;
    private final MyModel myModel;

    public FlyPresenter(FlyView view) {

        this.view = view;
        myModel = new MyModel();
    }

    public void getData(Context context) {
        myModel.getShiData(context,new MyPresenter<ShiBean>() {
            @Override
            public void getData(ShiBean shiBean) {
                view.getData(shiBean);
            }
        });
    }
}
