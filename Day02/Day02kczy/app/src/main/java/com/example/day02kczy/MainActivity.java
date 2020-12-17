package com.example.day02kczy;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.day02kczy.fragment.BlankFragment;
import com.example.day02kczy.fragment.BlankFragment2;
import com.example.day02kczy.fragment.BlankFragment3;
import com.example.day02kczy.fragment.BlankFragment4;
import com.example.day02kczy.fragment.BlankFragment5;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fl_main;
    private TabLayout tab_main;
    private BlankFragment blankFragment1;
    private BlankFragment2 blankFragment2;
    private BlankFragment3 blankFragment3;
    private BlankFragment4 blankFragment4;
    private BlankFragment5 blankFragment5;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        blankFragment1 = new BlankFragment();
        blankFragment2 = new BlankFragment2();
        blankFragment3 = new BlankFragment3();
        blankFragment4 = new BlankFragment4();
        blankFragment5 = new BlankFragment5();

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fl_main,blankFragment1)
                .add(R.id.fl_main,blankFragment2)
                .add(R.id.fl_main,blankFragment3)
                .add(R.id.fl_main,blankFragment4)
                .add(R.id.fl_main,blankFragment5)
                .hide(blankFragment1)
                .hide(blankFragment2)
                .hide(blankFragment4)
                .hide(blankFragment5)
                .commit();

        tab_main.addTab(tab_main.newTab().setText("首页").setIcon(R.drawable.icon_tab_home));
        tab_main.addTab(tab_main.newTab().setText("沙发").setIcon(R.drawable.icon_tab_sofa));
        tab_main.addTab(tab_main.newTab().setIcon(R.drawable.icon_tab_publish));
        tab_main.addTab(tab_main.newTab().setText("发现").setIcon(R.drawable.icon_tab_find));
        tab_main.addTab(tab_main.newTab().setText("我的").setIcon(R.drawable.icon_tab_mine));

        tab_main.getTabAt(2).getPosition();

        tab_main.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        fragmentManager.beginTransaction()
                                .show(blankFragment1)
                                .hide(blankFragment2)
                                .hide(blankFragment3)
                                .hide(blankFragment4)
                                .hide(blankFragment5)
                                .commit();
                        break;
                    case 1:
                        fragmentManager.beginTransaction()
                                .show(blankFragment2)
                                .hide(blankFragment1)
                                .hide(blankFragment3)
                                .hide(blankFragment4)
                                .hide(blankFragment5)
                                .commit();
                        break;
                    case 2:
                        fragmentManager.beginTransaction()
                                .show(blankFragment3)
                                .hide(blankFragment2)
                                .hide(blankFragment1)
                                .hide(blankFragment4)
                                .hide(blankFragment5)
                                .commit();
                        break;
                    case 3:
                        fragmentManager.beginTransaction()
                                .show(blankFragment4)
                                .hide(blankFragment2)
                                .hide(blankFragment3)
                                .hide(blankFragment1)
                                .hide(blankFragment5)
                                .commit();
                        break;
                    case 4:
                        fragmentManager.beginTransaction()
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

    private void initView() {
        fl_main = (FrameLayout) findViewById(R.id.fl_main);
        tab_main = (TabLayout) findViewById(R.id.tab_main);
    }
}