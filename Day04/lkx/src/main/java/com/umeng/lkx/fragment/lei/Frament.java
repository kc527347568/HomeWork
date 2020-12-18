package com.umeng.lkx.fragment.lei;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.umeng.lkx.R;
import com.umeng.lkx.adapter.ReDianAdapter;
import com.umeng.lkx.bean.JingYanBean;
import com.umeng.lkx.bean.QianBean;
import com.umeng.lkx.bean.ReDianBean;
import com.umeng.lkx.bean.RemenBean;
import com.umeng.lkx.bean.SheTuanBean;
import com.umeng.lkx.bean.TushangBean;
import com.umeng.lkx.presenter.TongPresenter;
import com.umeng.lkx.view.TongView;

import java.util.ArrayList;
import java.util.List;

public class Frament extends Fragment implements TongView {
    private RecyclerView redian;
    private ArrayList<ReDianBean.DataBean.ListBean> listBeans;
    private ReDianAdapter dianAdapter;
    private TongPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.redian, null);
        initView(view);
        presenter = new TongPresenter(this);
        presenter.initDat();
        return view;
    }

    private void initView(View view) {
        redian = (RecyclerView) view.findViewById(R.id.redian);
        redian.setLayoutManager(new LinearLayoutManager(getContext()));
        listBeans = new ArrayList<>();
        dianAdapter = new ReDianAdapter(getContext(), listBeans);
        redian.setAdapter(dianAdapter);
    }

    @Override
    public void Fline(List<RemenBean.DataBean> remenBeans) {

    }

    @Override
    public void Sunces(List<ReDianBean.DataBean.ListBean> red) {
        listBeans.addAll(red);
        dianAdapter.notifyDataSetChanged();
    }

    @Override
    public void Foug(List<TushangBean.DataBean.ListBean> tu) {

    }

    @Override
    public void Shetuan(List<SheTuanBean.DataBean> shetuan) {

    }

    @Override
    public void Jingyan(List<JingYanBean.DataBean.ExpTopBean.ListBean> jingyan) {

    }

    @Override
    public void Qian(List<QianBean.DataBean.SignTopBean.ListBean> qian) {

    }
}
