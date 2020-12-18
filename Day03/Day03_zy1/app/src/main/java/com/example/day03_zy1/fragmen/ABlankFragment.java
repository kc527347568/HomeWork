package com.example.day03_zy1.fragmen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day03_zy1.R;
import com.example.day03_zy1.fragmen.nestfragmen.BlankFragment1;
import com.example.day03_zy1.fragmen.nestfragmen.BlankFragment2;
import com.example.day03_zy1.fragmen.nestfragmen.BlankFragment3;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ABlankFragment extends Fragment {


    private TabLayout tab;
    private ViewPager vp;
    private ArrayList<Fragment> fragments;

    public ABlankFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_a_blank, container, false );
        initView(view);
        return view;
    }

    private void initView(View view) {
        tab = view.findViewById( R.id.tab );
        vp = view.findViewById( R.id.vp );
        fragments = new ArrayList<>();
        fragments.add( new BlankFragment1() );
        fragments.add( new BlankFragment2() );
        fragments.add( new BlankFragment3() );
        vp.setAdapter( new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get( position );
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        } );
        tab.setupWithViewPager( vp );
        tab.getTabAt( 0 ).setText( "图片" );
        tab.getTabAt( 1 ).setText( "视频" );
        tab.getTabAt( 2 ).setText( "文本" );
    }
}