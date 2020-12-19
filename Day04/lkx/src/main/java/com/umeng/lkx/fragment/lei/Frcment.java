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
import com.umeng.lkx.adapter.TushangAdapter;
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

public class Frcment extends Fragment implements TongView {
    private RecyclerView shang;
    private ArrayList<TushangBean.DataBean.ListBean> listBeans;
    private TushangAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shang, null);
        initView(view);
        TongPresenter presenter = new TongPresenter(this);
        presenter.shang();
        return view;
    }

    private void initView(View view) {
        shang = (RecyclerView) view.findViewById(R.id.shang);
        shang.setLayoutManager(new LinearLayoutManager(getContext()));
        listBeans = new ArrayList<>();
        adapter = new TushangAdapter(getContext(), listBeans);
        shang.setAdapter(adapter);
    }

    @Override
    public void Fline(List<RemenBean.DataBean> remenBeans) {

    }

    @Override
    public void Sunces(List<ReDianBean.DataBean.ListBean> red) {

    }

    @Override
    public void Foug(List<TushangBean.DataBean.ListBean> tu) {
        listBeans.addAll(tu);
        adapter.notifyDataSetChanged();
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
