package com.example.zhaohang_day04;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.zhaohang_day04.fragment.nestFragment.TuHaoFragment;
import com.example.zhaohang_day04.fragment.nestFragment.QianDaoFragment;
import com.example.zhaohang_day04.fragment.nestFragment.DengJiFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager vp;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main3 );
        initView();
    }

    private void initView() {
        tab = (TabLayout) findViewById( R.id.tab );
        vp = (ViewPager) findViewById( R.id.vp );
        fragments = new ArrayList<>();
        fragments.add( new DengJiFragment() );
        fragments.add( new TuHaoFragment() );
        fragments.add( new QianDaoFragment() );
        vp.setAdapter( new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        tab.getTabAt( 0 ).setText( "土豪榜" );
        tab.getTabAt( 1 ).setText( "等级榜" );
        tab.getTabAt( 2 ).setText( "签到榜" );

    }
}