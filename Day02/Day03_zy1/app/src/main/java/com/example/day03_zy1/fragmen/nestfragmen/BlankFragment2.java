package com.example.day03_zy1.fragmen.nestfragmen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day03_zy1.R;
import com.example.day03_zy1.adapter.Rcy2_Adapter;
import com.example.day03_zy1.bean.SPBean;
import com.example.day03_zy1.mvp.HomePersenter;
import com.example.day03_zy1.mvp.HomeView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment2 extends Fragment implements HomeView {

    private RecyclerView rcy;
    private HomePersenter persenter;

    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_blank2, container, false );
        persenter = new HomePersenter(this);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        persenter.QingQiuSP();
    }

    private void initView(View view) {
        rcy = view.findViewById( R.id.rcy );
        rcy.setLayoutManager( new LinearLayoutManager( getContext() ) );
    }

    @Override
    public void ChengGong(Object object) {
        SPBean spBean = ( SPBean ) object;
        List<SPBean.DataBeanX.DataBean> data = spBean.getData().getData();
        Rcy2_Adapter adapter = new Rcy2_Adapter( data, getContext() );
        rcy.setAdapter( adapter );
        adapter.notifyDataSetChanged();
    }

    @Override
    public void ShiBai(String mag) {

    }
}