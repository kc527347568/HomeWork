package com.example.p4day03.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.p4day03.R;
import com.google.android.material.tabs.TabLayout;

public class FaxianFragment extends Fragment {


    private RecyclerView rec;
    private FrameLayout fl;
    private TabLayout tab;
    private GuanzhuFragment guanzhuFragment;
    private TuijianFragment tuijianFragment;
    private FragmentManager manager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faxian, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        fl = view.findViewById(R.id.fl);
        tab = view.findViewById(R.id.tab);

        guanzhuFragment = new GuanzhuFragment();
        tuijianFragment = new TuijianFragment();

        manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.fl,guanzhuFragment)
                .add(R.id.fl,tuijianFragment)
                .hide(guanzhuFragment)
                .commit();

        tab.addTab(tab.newTab().setText("关注"));
        tab.addTab(tab.newTab().setText("推荐"));

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        manager.beginTransaction()
                                .show(guanzhuFragment)
                                .hide(tuijianFragment)
                                .commit();
                        break;
                    case 1:
                        manager.beginTransaction()
                                .show(tuijianFragment)
                                .hide(guanzhuFragment)
                                .commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}