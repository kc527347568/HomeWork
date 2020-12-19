package com.example.kangchen03;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.kangchen03.mainFragment.BlankFragment;
import com.example.kangchen03.mainFragment.BlankFragment2;
import com.example.kangchen03.mainFragment.BlankFragment3;
import com.example.kangchen03.mainFragment.BlankFragment4;
import com.example.kangchen03.mainFragment.BlankFragment5;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fl_main;
    private TabLayout tab_main;
    private FragmentManager supportFragmentManager;
    private BlankFragment2 blankFragment2;
    private BlankFragment blankFragment1;
    private BlankFragment3 blankFragment3;
    private BlankFragment4 blankFragment4;
    private BlankFragment5 blankFragment5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        fl_main = (FrameLayout) findViewById(R.id.fl_main);
        tab_main = (TabLayout) findViewById(R.id.tab_main);

        blankFragment1 = new BlankFragment();
        blankFragment2 = new BlankFragment2();
        blankFragment3 = new BlankFragment3();
        blankFragment4 = new BlankFragment4();
        blankFragment5 = new BlankFragment5();

        supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction()
                .add(R.id.fl_main, blankFragment1)
                .add(R.id.fl_main, blankFragment2)
                .add(R.id.fl_main, blankFragment3)
                .add(R.id.fl_main, blankFragment4)
                .add(R.id.fl_main, blankFragment5)
                .hide(blankFragment1)
                .hide(blankFragment2)
                .hide(blankFragment4)
                .hide(blankFragment5)
                .commit();


        tab_main.addTab(tab_main.newTab().setText("首页").setIcon(R.drawable.tab_a));
        tab_main.addTab(tab_main.newTab().setText("发现").setIcon(R.drawable.tab_d));
        tab_main.addTab(tab_main.newTab().setIcon(R.drawable.e));
        tab_main.addTab(tab_main.newTab().setText("商城").setIcon(R.drawable.tab_b));
        tab_main.addTab(tab_main.newTab().setText("我的").setIcon(R.drawable.tab_e));

        tab_main.getTabAt(2).select();

        tab_main.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        supportFragmentManager.beginTransaction()
                                .show(blankFragment1)
                                .hide(blankFragment2)
                                .hide(blankFragment3)
                                .hide(blankFragment4)
                                .hide(blankFragment5)
                                .commit();
                        break;
                    case 1:
                        supportFragmentManager.beginTransaction()
                                .show(blankFragment2)
                                .hide(blankFragment1)
                                .hide(blankFragment3)
                                .hide(blankFragment4)
                                .hide(blankFragment5)
                                .commit();
                        break;
                    case 2:
                        supportFragmentManager.beginTransaction()
                                .show(blankFragment3)
                                .hide(blankFragment2)
                                .hide(blankFragment1)
                                .hide(blankFragment4)
                                .hide(blankFragment5)
                                .commit();
                        break;
                    case 3:
                        supportFragmentManager.beginTransaction()
                                .show(blankFragment4)
                                .hide(blankFragment2)
                                .hide(blankFragment3)
                                .hide(blankFragment1)
                                .hide(blankFragment5)
                                .commit();
                        break;
                    case 4:
                        supportFragmentManager.beginTransaction()
                                .show(blankFragment5)
                                .hide(blankFragment2)
                                .hide(blankFragment3)
                                .hide(blankFragment4)
                                .hide(blankFragment1)
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