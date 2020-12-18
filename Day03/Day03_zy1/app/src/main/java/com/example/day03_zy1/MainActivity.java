package com.example.day03_zy1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.day03_zy1.fragmen.ABlankFragment;
import com.example.day03_zy1.fragmen.BBlankFragment;
import com.example.day03_zy1.fragmen.CBlankFragment;
import com.example.day03_zy1.fragmen.DBlankFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTab;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById( R.id.vp );
        mTab = (TabLayout) findViewById( R.id.tab );
        fragments = new ArrayList<>();
        fragments.add( new ABlankFragment() );
        fragments.add( new BBlankFragment() );
        fragments.add( new CBlankFragment() );
        fragments.add( new DBlankFragment() );
        mVp.setAdapter( new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        mTab.setupWithViewPager( mVp );
        mTab.getTabAt( 0 ).setText( "首页" );
        mTab.getTabAt( 1 ).setText( "发现" );
        mTab.getTabAt( 2 ).setText( "商城" );
        mTab.getTabAt( 3 ).setText( "我的" );
    }
}