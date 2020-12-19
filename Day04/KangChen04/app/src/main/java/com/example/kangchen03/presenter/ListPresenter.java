package com.example.kangchen03.presenter;

import com.example.kangchen03.bean.ItemBean;
import com.example.kangchen03.mainFragment.ListFragment;
import com.example.kangchen03.model.MyModel;
import com.example.kangchen03.view.ListView;

public class ListPresenter {
    private final ListView view;
    private final MyModel myModel;

    public ListPresenter(ListView view) {

        this.view = view;
        myModel = new MyModel();
    }

    public void getData(final int id) {
        myModel.getList(id, new MyPresenter<ItemBean>() {
            @Override
            public void getData(ItemBean itemBean) {
                view.getData(itemBean);
            }
        });
    }
}
