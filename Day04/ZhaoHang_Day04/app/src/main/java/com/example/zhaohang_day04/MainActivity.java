package com.example.zhaohang_day04;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.zhaohang_day04.fragment.BlankFragment1;
import com.example.zhaohang_day04.fragment.BlankFragment2;
import com.example.zhaohang_day04.fragment.BlankFragment3;
import com.example.zhaohang_day04.fragment.BlankFragment4;
import com.example.zhaohang_day04.fragment.BlankFragment5;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tab;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        initView();
    }

    private void initView() {
        vp = (ViewPager) findViewById( R.id.vp );
        tab = (TabLayout) findViewById( R.id.tab );

        fragments = new ArrayList<>();
        fragments.add( new BlankFragment1() );
        fragments.add( new BlankFragment2() );
        fragments.add( new BlankFragment3() );
        fragments.add( new BlankFragment4() );
        fragments.add( new BlankFragment5() );
        vp.setAdapter( new FragmentPagerAdapter( getSupportFragmentManager() ) {
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
        tab.getTabAt( 0 ).setText( "首页" )
                .setIcon( R.drawable.sy_selector );
        tab.getTabAt( 1 ).setText("发现" )
                .setIcon( R.drawable.fx_selector );
        tab.getTabAt( 2 )
//                .setText( "发布" )
                .setIcon( R.drawable.add_selector );
        tab.getTabAt( 3 ).setText( "商城" )
                .setIcon( R.drawable.sc_selector );
        tab.getTabAt( 4 ).setText( "我的" )
                .setIcon( R.drawable.my_selector );

    }
}