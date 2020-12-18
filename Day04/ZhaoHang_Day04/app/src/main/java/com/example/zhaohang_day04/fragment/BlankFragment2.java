package com.example.zhaohang_day04.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zhaohang_day04.MainActivity1;
import com.example.zhaohang_day04.MainActivity2;
import com.example.zhaohang_day04.MainActivity3;
import com.example.zhaohang_day04.R;
import com.example.zhaohang_day04.abapter.Rcy_Adapter;
import com.example.zhaohang_day04.bean.HuoDongBean;
import com.example.zhaohang_day04.mvp.HomePersenter;
import com.example.zhaohang_day04.mvp.HomeView;

import java.util.List;

public class BlankFragment2 extends Fragment implements HomeView {


    private RecyclerView rcy;
    private HomePersenter persenter;
    private ImageView lv1;
    private ImageView lv2;
    private ImageView lv3;

    public BlankFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_blank2, container, false );
        persenter = new HomePersenter( this );
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        persenter.QingQiuHuoDong();
    }

    private void initView(View view) {
        rcy = view.findViewById( R.id.rcy );
        lv1 = view.findViewById( R.id.lv1 );
        lv2 = view.findViewById( R.id.lv2 );
        lv3 = view.findViewById( R.id.lv3 );
        lv1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( getContext(), MainActivity1.class ) );
            }
        } );
        lv2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( getContext(), MainActivity2.class ) );
            }
        } );
        lv3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( getContext(), MainActivity3.class ) );
            }
        } );

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( getContext(), RecyclerView.HORIZONTAL, true );
        rcy.setLayoutManager(  linearLayoutManager );
    }


    @Override
    public void ChengGong(Object object) {
        HuoDongBean huoDongBean = ( HuoDongBean ) object;
        List<HuoDongBean.DataBean> data = huoDongBean.getData();
        Log.e( "GTR-----ChengGong",data.toString());
        Rcy_Adapter adapter = new Rcy_Adapter( data, getContext() );
        rcy.setAdapter( adapter );
        adapter.notifyDataSetChanged();
    }

    @Override
    public void ShiBai(String mag) {

    }
}