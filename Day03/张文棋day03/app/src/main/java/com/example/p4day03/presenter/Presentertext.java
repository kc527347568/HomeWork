package com.example.p4day03.presenter;

import com.example.p4day03.bean.Textbean;
import com.example.p4day03.fragment.TextFragment;
import com.example.p4day03.model.Modelmain;
import com.example.p4day03.model.Modeltext;

public class Presentertext {
    private TextFragment view;
    private final Modeltext modeltext;

    public Presentertext(TextFragment view) {
        this.view = view;
        modeltext = new Modeltext();
    }

    public void getData() {
      modeltext.getData(new Resultcallback<Textbean>() {
          @Override
          public void ok(Textbean textbean) {
              view.getData(textbean);
          }

          @Override
          public void no(String n) {

          }
      });
    }
}
