package com.example.zhaohang_day04.fragment.nestFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhaohang_day04.R;
import com.example.zhaohang_day04.mvp.HomePersenter;
import com.example.zhaohang_day04.mvp.HomeView;

public class TuHaoFragment extends Fragment implements HomeView {


    private RecyclerView rcy;
    private HomePersenter persenter;

    public TuHaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_deng_ji, container, false );
        persenter = new HomePersenter( this );
        initView(view);
        initData();
        return view;
    }

    private void initData() {
//        persenter.QingQiuTuHao();
    }

    private void initView(View view) {
        rcy = view.findViewById( R.id.rcy );
        rcy.setLayoutManager( new LinearLayoutManager( getContext() ) );
    }

    @Override
    public void ChengGong(Object object) {
//        TuHaoBean tuHaoBean = (TuHaoBean) object;
//        tuHaoBean
    }

    @Override
    public void ShiBai(String mag) {

    }
}