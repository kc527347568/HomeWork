package com.example.kangchen03.presenter;

import com.example.kangchen03.bean.ItemBean;
import com.example.kangchen03.bean.ReMengBean;
import com.example.kangchen03.bean.TitleBean;
import com.example.kangchen03.mainFragment.BlankFragment2;
import com.example.kangchen03.model.MyModel;
import com.example.kangchen03.view.HomeView;

public class HomePresenter {
    private final HomeView view;
    private final MyModel myModel;

    public HomePresenter(HomeView view) {

        this.view = view;

        myModel = new MyModel();
    }

    public void getData() {
        myModel.getData(new HomPresenter() {
            @Override
            public void getReMen(ReMengBean reMengBean) {
                view.getRe(reMengBean);
            }

            @Override
            public void getTitle(TitleBean titleBean) {
                view.getTitle(titleBean);
            }
        });
    }
}
