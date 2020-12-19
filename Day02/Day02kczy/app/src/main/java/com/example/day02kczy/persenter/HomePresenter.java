package com.example.day02kczy.persenter;

import com.example.day02kczy.bean.TuBean;
import com.example.day02kczy.fragment.HomeFragment;
import com.example.day02kczy.model.MyModel;
import com.example.day02kczy.view.HomeView;

public class HomePresenter {
    private final HomeView view;
    private final MyModel myModel;

    public HomePresenter(HomeView view) {

        this.view = view;
        myModel = new MyModel();
    }

    public void getData() {
        myModel.getData(new MyPresenter<TuBean>() {
            @Override
            public void getData(TuBean tuBean) {
                view.getData(tuBean);
            }
        });
    }
}
