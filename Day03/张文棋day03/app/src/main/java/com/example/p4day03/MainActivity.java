package com.example.p4day03;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.p4day03.fragment.FaxianFragment;
import com.example.p4day03.fragment.JiaFragment;
import com.example.p4day03.fragment.MeFragment;
import com.example.p4day03.fragment.ShouFragment;
import com.example.p4day03.fragment.SofaFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fl;
    private TabLayout tab;
    private SofaFragment sofaFragment;
    private FaxianFragment faxianFragment;
    private FragmentManager manager;
    private ShouFragment shouFragment;
    private MeFragment meFragment;
    private JiaFragment jiaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        fl = (FrameLayout) findViewById(R.id.fl);
        tab = (TabLayout) findViewById(R.id.tab);

        sofaFragment = new SofaFragment();
        faxianFragment = new FaxianFragment();
        shouFragment = new ShouFragment();
        meFragment = new MeFragment();
        jiaFragment = new JiaFragment();
        manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.fl,shouFragment)
                .add(R.id.fl,sofaFragment)
                .add(R.id.fl,jiaFragment)
                .add(R.id.fl,faxianFragment)
                .add(R.id.fl,meFragment)
                .hide(shouFragment)
                .hide(sofaFragment)
                .hide(jiaFragment)
                .hide(faxianFragment)
                .hide(meFragment)
                .commit();

        tab.addTab(tab.newTab().setText("首页").setIcon(R.drawable.b1));
        tab.addTab(tab.newTab().setText("沙发").setIcon(R.drawable.b2));
        tab.addTab(tab.newTab().setIcon(R.drawable.b3));
        tab.addTab(tab.newTab().setText("发现").setIcon(R.drawable.b4));
        tab.addTab(tab.newTab().setText("我的").setIcon(R.drawable.b5));

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        manager.beginTransaction()
                                .show(shouFragment)
                                .hide(sofaFragment)
                                .hide(jiaFragment)
                                .hide(faxianFragment)
                                .hide(meFragment)
                                .commit();
                        break;
                    case 1:
                        manager.beginTransaction()
                                .show(sofaFragment)
                                .hide(shouFragment)
                                .hide(jiaFragment)
                                .hide(faxianFragment)
                                .hide(meFragment)
                                .commit();
                        break;
                    case 2:
                        manager.beginTransaction()
                                .show(jiaFragment)
                                .hide(shouFragment)
                                .hide(sofaFragment)
                                .hide(faxianFragment)
                                .hide(meFragment)
                                .commit();
                        break;
                    case 3:
                        manager.beginTransaction()
                                .show(faxianFragment)
                                .hide(shouFragment)
                                .hide(jiaFragment)
                                .hide(sofaFragment)
                                .hide(meFragment)
                                .commit();
                        break;
                    case 4:
                        manager.beginTransaction()
                                .show(meFragment)
                                .hide(shouFragment)
                                .hide(jiaFragment)
                                .hide(faxianFragment)
                                .hide(sofaFragment)
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