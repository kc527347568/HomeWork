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
import com.example.p4day03.adapter.Mp4adapter;
import com.example.p4day03.bean.Mp4bean;
import com.example.p4day03.presenter.Presentermp4;
import com.example.p4day03.view.Viewmp4;

import java.util.ArrayList;


public class Mp4Fragment extends Fragment implements Viewmp4 {


    private RecyclerView rec;
    private ArrayList<Mp4bean.DataBeanX.DataBean> reclist;
    private Mp4adapter mp4adapter;
    private Presentermp4 presentermp4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mp4, container, false);
        presentermp4 = new Presentermp4(this);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        presentermp4.getData();

    }

    private void initView(View view) {
        rec = view.findViewById(R.id.rec);
        rec.setLayoutManager(new LinearLayoutManager(getContext()));
        reclist = new ArrayList<>();
        mp4adapter = new Mp4adapter(getContext(), reclist);
        rec.setAdapter(mp4adapter);
        rec.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }

    @Override
    public void getData(Mp4bean mp4bean) {
        reclist.addAll(mp4bean.getData().getData());
        mp4adapter.notifyDataSetChanged();
    }
}