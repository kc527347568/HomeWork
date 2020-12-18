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
import com.example.p4day03.adapter.Imageadapter;
import com.example.p4day03.bean.Imagebean;
import com.example.p4day03.presenter.Presentermain;
import com.example.p4day03.view.Viewmain;

import java.util.ArrayList;


public class ImageFragment extends Fragment implements Viewmain {


    private RecyclerView rec;
    private ArrayList<Imagebean.DataBeanX.DataBean> reclist;
    private Imageadapter imageadapter;
    private Presentermain presentermain;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        presentermain = new Presentermain(this);
        initViwe(view);
        initData();
        return view;
    }

    private void initData() {
        presentermain.getData();
    }

    private void initViwe(View view) {
        rec = view.findViewById(R.id.rec);
        rec.setLayoutManager(new LinearLayoutManager(getContext()));
        reclist = new ArrayList<>();
        imageadapter = new Imageadapter(getContext(),reclist);
        rec.setAdapter(imageadapter);
        rec.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));


    }

    @Override
    public void getData(Imagebean imagebean) {
        reclist.addAll(imagebean.getData().getData());
        imageadapter.notifyDataSetChanged();
    }
}