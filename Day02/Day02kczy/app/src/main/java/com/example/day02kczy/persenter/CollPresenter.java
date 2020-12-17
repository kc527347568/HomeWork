package com.example.day02kczy.persenter;

import com.example.day02kczy.bean.DataBean;
import com.example.day02kczy.fragment.CollFragment;
import com.example.day02kczy.model.MyModel;
import com.example.day02kczy.view.CollView;

import java.util.ArrayList;
import java.util.List;

public class CollPresenter {
    private final CollView view;
    private final MyModel myModel;

    public CollPresenter(CollView view) {

        this.view = view;
        myModel = new MyModel();
    }

    public void getData() {
        myModel.getDb(new ListPre() {
            @Override
            public void getLiData(List<DataBean> beans) {
                view.getData(beans);
            }
        });
    }

    public void delete(DataBean dataBean) {
        myModel.del(dataBean);
    }
}
