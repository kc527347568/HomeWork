package com.example.day03_zy1.fragmen.nestfragmen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.day03_zy1.R;
import com.example.day03_zy1.adapter.Recy_Adapter;
import com.example.day03_zy1.adapter.Recy_Adapter3;
import com.example.day03_zy1.bean.ImageBean;
import com.example.day03_zy1.bean.TextBean;
import com.example.day03_zy1.mvp.HomePersenter;
import com.example.day03_zy1.mvp.HomeView;

import java.util.List;


public class BlankFragment3 extends Fragment implements HomeView {

    private RecyclerView rcy;
    private HomePersenter persenter;
    
    public BlankFragment3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_blank3, container, false );
       persenter =  new HomePersenter( this );
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        persenter.QingQiuText();
    }

    private void initView(View view) {
        rcy = view.findViewById( R.id.rcy );
        rcy.setLayoutManager( new LinearLayoutManager( getContext() ) );
    }

    @Override
    public void ChengGong(Object object) {
        TextBean textBean = (TextBean) object;
        Log.e( "GTR",textBean.getData().getData().toString() );
        List<TextBean.DataBeanX.DataBean> data = textBean.getData().getData();
        Recy_Adapter3 adapter3 = new Recy_Adapter3( data, getContext() );
        rcy.setAdapter( adapter3 );
        adapter3.notifyDataSetChanged();
    }

    @Override
    public void ShiBai(String mag) {

    }
}