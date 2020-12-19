package com.example.p7homework.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p7homework.MyPagerAdapter;
import com.example.p7homework.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ShafaFragment extends Fragment {

    private ViewPager pager;
    private TabLayout tab;
    private ArrayList<Fragment> list;
    private MyPagerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shafa, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tab = view.findViewById(R.id.tab_shaFa);
        pager = view.findViewById(R.id.pager_shaFa);

        list = new ArrayList<>();
        list.add(new ImageFragment());
        list.add(new MpFragment());
        list.add(new TextFragment());
        adapter = new MyPagerAdapter(getChildFragmentManager(), list);
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);
        tab.getTabAt(0).setText("图片");
        tab.getTabAt(1).setText("视频");
        tab.getTabAt(2).setText("文本");
    }
}