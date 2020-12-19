package com.example.day02kczy.persenter;

import com.example.day02kczy.bean.DataBean;
import com.example.day02kczy.bean.ListBean;
import com.example.day02kczy.fragment.ListFragment;
import com.example.day02kczy.model.MyModel;
import com.example.day02kczy.view.ListView;

import java.util.ArrayList;

public class ListPresenter {
    private final ListView view;
    private final MyModel myModel;

    public ListPresenter(ListView view) {

        this.view = view;
        myModel = new MyModel();
    }

    public void getData() {
        myModel.getListData(new MyPresenter<ListBean>() {
            @Override
            public void getData(ListBean listBean) {
                view.getData(listBean);
            }
        });
    }

    public void addDb(DataBean dataBean) {
        myModel.addDb(dataBean);
    }

    public void delete(DataBean dataBean) {
        myModel.delete(dataBean);
    }

}
