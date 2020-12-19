package com.example.day03zuoye;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import com.example.day03zuoye.fragment.FaxianFragment;
import com.example.day03zuoye.fragment.HuodongFragment;
import com.example.day03zuoye.fragment.JiaFragment;
import com.example.day03zuoye.fragment.MeFragment;
import com.example.day03zuoye.fragment.ShouFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private Toolbar tb;
    private FrameLayout fl;
    private TabLayout tab;
    private ShouFragment shouFragment;
    private FaxianFragment faxianFragment;
    private JiaFragment jiaFragment;
    private HuodongFragment huodongFragment;
    private MeFragment meFragment;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tb = (Toolbar) findViewById(R.id.tb);
        setSupportActionBar(tb);
        fl = (FrameLayout) findViewById(R.id.fl);
        tab = (TabLayout) findViewById(R.id.tab);

        shouFragment = new ShouFragment();
        faxianFragment = new FaxianFragment();
        jiaFragment = new JiaFragment();
        huodongFragment = new HuodongFragment();
        meFragment = new MeFragment();

        tab.addTab(tab.newTab().setText("首页").setIcon(R.drawable.shou));
        tab.addTab(tab.newTab().setText("發現").setIcon(R.drawable.faxian));
        tab.addTab(tab.newTab().setIcon(R.drawable.jia));
        tab.addTab(tab.newTab().setText("活动").setIcon(R.drawable.huodong));
        tab.addTab(tab.newTab().setText("我").setIcon(R.drawable.wo));

        manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.fl,shouFragment)
                .add(R.id.fl,faxianFragment)
                .add(R.id.fl,jiaFragment)
                .add(R.id.fl,huodongFragment)
                .add(R.id.fl,meFragment)
                .hide(faxianFragment)
                .hide(jiaFragment)
                .hide(huodongFragment)
                .hide(meFragment)
                .commit();

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tb.setTitle(tab.getText());
                switch (tab.getPosition()){
                    case 0:
                        manager.beginTransaction()
                                .show(shouFragment)
                                .hide(faxianFragment)
                                .hide(jiaFragment)
                                .hide(huodongFragment)
                                .hide(meFragment)
                                .commit();
                        break;
                    case 1:
                        manager.beginTransaction()
                                .show(faxianFragment)
                                .hide(shouFragment)
                                .hide(jiaFragment)
                                .hide(huodongFragment)
                                .hide(meFragment)
                                .commit();
                        break;
                    case 2:
                        manager.beginTransaction()
                                .show(jiaFragment)
                                .hide(faxianFragment)
                                .hide(shouFragment)
                                .hide(huodongFragment)
                                .hide(meFragment)
                                .commit();
                        break;
                    case 3:
                        manager.beginTransaction()
                                .show(huodongFragment)
                                .hide(faxianFragment)
                                .hide(jiaFragment)
                                .hide(shouFragment)
                                .hide(meFragment)
                                .commit();
                        break;
                    case 4:
                        manager.beginTransaction()
                                .show(meFragment)
                                .hide(faxianFragment)
                                .hide(jiaFragment)
                                .hide(huodongFragment)
                                .hide(shouFragment)
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
