package com.example.wuqi.fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wuqi.R;
import com.example.wuqi.adapter.MainVpAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SofaFragment extends Fragment {


    public SofaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sofa, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());

    }

    private void initView(View view) {
        TabLayout tab=view.findViewById(R.id.tab);
        ViewPager vp=view.findViewById(R.id.vp);

        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(new PictureFragment());
        fragments.add(new VideoFragment());
        fragments.add(new TextFragment());
        MainVpAdapter adapter=new MainVpAdapter(getChildFragmentManager(),fragments);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);

        tab.getTabAt(0).setText("图片");
        tab.getTabAt(1).setText("视频");
        tab.getTabAt(2).setText("文本");
    }
}
