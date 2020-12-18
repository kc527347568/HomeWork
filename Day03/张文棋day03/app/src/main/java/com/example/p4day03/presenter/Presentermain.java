package com.example.p4day03.presenter;

import com.example.p4day03.bean.Imagebean;
import com.example.p4day03.fragment.ImageFragment;
import com.example.p4day03.model.Modelmain;
import com.example.p4day03.view.Viewmain;

public class Presentermain {
    private Viewmain view;
    private final Modelmain modelmain;

    public Presentermain(Viewmain view) {
        this.view = view;
        modelmain = new Modelmain();
    }

    public void getData() {
        modelmain.getData(new Resultcallback<Imagebean>() {
            @Override
            public void ok(Imagebean imagebean) {
                view.getData(imagebean);
            }

            @Override
            public void no(String n) {

            }
        });
    }
}
