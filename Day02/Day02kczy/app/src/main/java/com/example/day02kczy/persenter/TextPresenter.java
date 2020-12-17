package com.example.day02kczy.persenter;

import com.example.day02kczy.bean.TextBean;
import com.example.day02kczy.fragment.TextFragment;
import com.example.day02kczy.model.MyModel;
import com.example.day02kczy.view.TextView;

public class TextPresenter {
    private final TextView view;
    private final MyModel myModel;

    public TextPresenter(TextView view) {

        this.view = view;
        myModel = new MyModel();
    }


    public void getData() {
        myModel.getTextData(new MyPresenter<TextBean>() {
            @Override
            public void getData(TextBean textBean) {
                view.getData(textBean);
            }
        });
    }
}
