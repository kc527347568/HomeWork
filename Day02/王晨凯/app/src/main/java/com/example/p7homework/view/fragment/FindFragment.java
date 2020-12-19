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

public class FindFragment extends Fragment {

    private ViewPager pager;
    private TabLayout tab;
    private MyPagerAdapter adapter;
    private ArrayList<Fragment> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        innitView(view);
        return view;
    }

    private void innitView(View view) {
        tab = view.findViewById(R.id.tab_find);
        pager = view.findViewById(R.id.pager_find);

        list = new ArrayList<>();
        list.add(new ConcernFragment());
        list.add(new RecoFragment());
        adapter = new MyPagerAdapter(getChildFragmentManager(), list);
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);
        tab.getTabAt(0).setText("关注");
        tab.getTabAt(1).setText("推荐");
    }
}