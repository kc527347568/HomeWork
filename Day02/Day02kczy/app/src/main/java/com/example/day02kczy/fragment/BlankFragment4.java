package com.example.day02kczy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day02kczy.R;
import com.example.day02kczy.adapter.Blank4Adapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class BlankFragment4 extends Fragment {


    private TabLayout tab_b4;
    private ViewPager vwv_b4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank4, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tab_b4 = view.findViewById(R.id.tab_b4);
        vwv_b4 = view.findViewById(R.id.vwv_b4);

        CollFragment collFragment = new CollFragment();
        ListFragment listFragment = new ListFragment();

        ArrayList<Fragment> list = new ArrayList<>();
        list.add(collFragment);
        list.add(listFragment);

        ArrayList<String> title = new ArrayList<>();
        title.add("关注");
        title.add("推荐");

        Blank4Adapter adapter = new Blank4Adapter(getChildFragmentManager(), list, title);
        vwv_b4.setAdapter(adapter);
        tab_b4.setupWithViewPager(vwv_b4);
    }
}