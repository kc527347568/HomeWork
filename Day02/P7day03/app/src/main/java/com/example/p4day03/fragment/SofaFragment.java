package com.example.p4day03.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.p4day03.R;
import com.google.android.material.tabs.TabLayout;


public class SofaFragment extends Fragment {



    private TabLayout tab;
    private ImageFragment imageFragment;
    private Mp4Fragment mp4Fragment;
    private TextFragment textFragment;
    private FragmentManager manager;
    private FrameLayout fl1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sofa, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tab = view.findViewById(R.id.tab);
        fl1 = view.findViewById(R.id.fl1);

        imageFragment = new ImageFragment();
        mp4Fragment = new Mp4Fragment();
        textFragment = new TextFragment();

        manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.fl1,imageFragment)
                .add(R.id.fl1,mp4Fragment)
                .add(R.id.fl1,textFragment)
                .hide(mp4Fragment)
                .hide(textFragment)
                .commit();


        tab.addTab(tab.newTab().setText("图片"));
        tab.addTab(tab.newTab().setText("视频"));
        tab.addTab(tab.newTab().setText("文本"));

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        manager.beginTransaction()
                                .show(imageFragment)
                                .hide(mp4Fragment)
                                .hide(textFragment)
                                .commit();
                        break;
                    case 1:
                        manager.beginTransaction()
                                .show(mp4Fragment)
                                .hide(imageFragment)
                                .hide(textFragment)
                                .commit();
                        break;
                    case 2:
                        manager.beginTransaction()
                                .show(textFragment)
                                .hide(mp4Fragment)
                                .hide(imageFragment)
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