package com.example.day03_zy1.fragmen.nestfragmen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day03_zy1.R;
import com.example.day03_zy1.adapter.Rcy6_Adapter;
import com.example.day03_zy1.bean.TuiJian;
import com.example.day03_zy1.mvp.HomePersenter;
import com.example.day03_zy1.mvp.HomeView;

import java.util.List;

public class BlankFragment6 extends Fragment implements HomeView {

    private RecyclerView rcy;
    private  HomePersenter persenter;

    public BlankFragment6() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_blank6, container, false );
        persenter = new HomePersenter(this);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
      persenter.QingQiuTJ();
    }

    private void initView(View view){
        rcy = view.findViewById( R.id.rcy );
        rcy.setLayoutManager( new LinearLayoutManager( getContext() ) );
    }

    @Override
    public void ChengGong(Object object) {
        TuiJian tuiJian = ( TuiJian ) object;
        List<TuiJian.DataBeanX.DataBean> data = tuiJian.getData().getData();
        Rcy6_Adapter adapter = new Rcy6_Adapter( data, getContext() );
        rcy.setAdapter( adapter );
        adapter.notifyDataSetChanged();
    }

    @Override
    public void ShiBai(String mag) {

    }
}