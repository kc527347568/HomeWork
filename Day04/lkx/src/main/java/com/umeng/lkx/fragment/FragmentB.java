package com.umeng.lkx.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.umeng.lkx.MainActivity2;
import com.umeng.lkx.MainActivity3;
import com.umeng.lkx.R;
import com.umeng.lkx.adapter.RemenAdapter;
import com.umeng.lkx.bean.JingYanBean;
import com.umeng.lkx.bean.QianBean;
import com.umeng.lkx.bean.ReDianBean;
import com.umeng.lkx.bean.RemenBean;
import com.umeng.lkx.bean.SheTuanBean;
import com.umeng.lkx.bean.TushangBean;
import com.umeng.lkx.fragment.lei.Frament;
import com.umeng.lkx.fragment.lei.Frbment;
import com.umeng.lkx.fragment.lei.Frcment;
import com.umeng.lkx.fragment.lei.Frdment;
import com.umeng.lkx.presenter.TongPresenter;
import com.umeng.lkx.view.TongView;

import java.util.ArrayList;
import java.util.List;

public class FragmentB extends Fragment implements TongView {

    private TabLayout tab1;
    private ViewPager page;
    private RecyclerView recy;
    private TongPresenter presenter;
    private RemenAdapter adapter;
    private ArrayList<RemenBean.DataBean> Beans;
    private ImageView she;
    private ImageView paihang;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragre, null);
        presenter = new TongPresenter(this);
        presenter.setData();
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        recy.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        Beans = new ArrayList<>();
        adapter = new RemenAdapter(getContext(), Beans);
        recy.setAdapter(adapter);
    }

    private void initView(View inflate) {
        tab1 = (TabLayout) inflate.findViewById(R.id.tab1);
        page = (ViewPager) inflate.findViewById(R.id.page);
        recy = (RecyclerView) inflate.findViewById(R.id.recy);

        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Frament());
        fragments.add(new Frbment());
        fragments.add(new Frcment());
        fragments.add(new Frdment());

        page.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        tab1.setupWithViewPager(page);
        tab1.getTabAt(0).setText("热点");
        tab1.getTabAt(1).setText("妆造");
        tab1.getTabAt(2).setText("图赏");
        tab1.getTabAt(3).setText("百科");
        she = (ImageView) inflate.findViewById(R.id.she);
        she.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MainActivity2.class));
            }
        });
        paihang = (ImageView) inflate.findViewById(R.id.paihang);
        paihang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MainActivity3.class));
            }
        });
    }

    @Override
    public void Fline(List<RemenBean.DataBean> remenBeans) {
        Beans.addAll(remenBeans);
        adapter.notifyDataSetChanged();
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

    }
}
