package com.example.p4day03.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p4day03.R;
import com.example.p4day03.adapter.Textadapter;
import com.example.p4day03.bean.Textbean;
import com.example.p4day03.presenter.Presentertext;
import com.example.p4day03.view.Viewtext;

import java.util.ArrayList;


public class TextFragment extends Fragment implements Viewtext {

    private RecyclerView rec;
    private ArrayList<Textbean.DataBeanX.DataBean> reclist;
    private Textadapter textadapter;
    private Presentertext presentertext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        presentertext = new Presentertext(this);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        presentertext.getData();
    }

    private void initView(View view) {
        rec = view.findViewById(R.id.rec);
        rec.setLayoutManager(new LinearLayoutManager(getContext()));
        reclist = new ArrayList<>();
        textadapter = new Textadapter(getContext(),reclist);
        rec.setAdapter(textadapter);
        rec.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }

    @Override
    public void getData(Textbean textbean) {
        reclist.addAll(textbean.getData().getData());
        textadapter.notifyDataSetChanged();
    }
}