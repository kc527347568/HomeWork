package com.example.day02kczy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day02kczy.R;
import com.example.day02kczy.adapter.Blank1Adapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class BlankFragment2 extends Fragment {

    private TabLayout tab_home;
    private ViewPager vwv_home;
    private Blank1Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank2, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tab_home = view.findViewById(R.id.tab_home);
        vwv_home = view.findViewById(R.id.vwv_home);

        HomeFragment homeFragment = new HomeFragment();
        FlyFragment flyFragment = new FlyFragment();
        TextFragment textFragment = new TextFragment();

        ArrayList<Fragment> list = new ArrayList<>();

        list.add(homeFragment);
        list.add(flyFragment);
        list.add(textFragment);

        ArrayList<String> title = new ArrayList<>();

        title.add("图片");
        title.add("视频");
        title.add("文本");

        adapter = new Blank1Adapter(getChildFragmentManager(), list, title);
        vwv_home.setAdapter(adapter);
        tab_home.setupWithViewPager(vwv_home);
    }
}