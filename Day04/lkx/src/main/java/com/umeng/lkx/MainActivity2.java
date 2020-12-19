package com.umeng.lkx;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.umeng.lkx.adapter.SheTuanAdapter;
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

public class MainActivity2 extends AppCompatActivity implements TongView {

    private RecyclerView she;
    private SheTuanAdapter adapter;
    private ArrayList<SheTuanBean.DataBean> beans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TongPresenter presenter = new TongPresenter(this);
        presenter.setTuan();
        initView();
    }

    private void initView() {
        she = (RecyclerView) findViewById(R.id.she);
        she.setLayoutManager(new LinearLayoutManager(this));
        beans = new ArrayList<>();
        adapter = new SheTuanAdapter(this, beans);
        she.setAdapter(adapter);
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
        beans.addAll(shetuan);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void Jingyan(List<JingYanBean.DataBean.ExpTopBean.ListBean> jingyan) {

    }

    @Override
    public void Qian(List<QianBean.DataBean.SignTopBean.ListBean> qian) {

    }
}