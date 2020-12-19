package com.umeng.lkx.fragment.qian;

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
import com.umeng.lkx.adapter.QianAdapter;
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

public class Qbment extends Fragment implements TongView {
    private RecyclerView qiand;
    private ArrayList<QianBean.DataBean.SignTopBean.ListBean> listBeans;
    private QianAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.qian, null);
        initView(view);
        TongPresenter presenter = new TongPresenter(this);
        presenter.qiand();
        return view;
    }

    private void initView(View view) {
        qiand = (RecyclerView) view.findViewById(R.id.qiand);
        qiand.setLayoutManager(new LinearLayoutManager(getContext()));
        listBeans = new ArrayList<>();
        adapter = new QianAdapter(getContext(), listBeans);
        qiand.setAdapter(adapter);
    }

    @Override
    public void Fline(List<RemenBean.DataBean> remenBeans) {

    }

    @Override
    public void Sunces(List<ReDianBean.DataBean.ListBean> red) {

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
        listBeans.addAll(qian);
        adapter.notifyDataSetChanged();
    }
}
