package com.example.p4day03.presenter;

import com.example.p4day03.bean.Mp4bean;
import com.example.p4day03.fragment.Mp4Fragment;
import com.example.p4day03.model.Modelmp4;

public class Presentermp4 {
    private Mp4Fragment view;
    private final Modelmp4 modelmp4;

    public Presentermp4(Mp4Fragment view) {
        this.view = view;
        modelmp4 = new Modelmp4();
    }

    public void getData() {
        modelmp4.getData(new Resultcallback<Mp4bean>() {
            @Override
            public void ok(Mp4bean mp4bean) {
                view.getData(mp4bean);
            }

            @Override
            public void no(String n) {

            }
        });
    }
}
