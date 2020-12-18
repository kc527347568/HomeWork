package com.example.p7homework;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.p7homework.view.fragment.FindFragment;
import com.example.p7homework.view.fragment.FirstFragment;
import com.example.p7homework.view.fragment.MineFragment;
import com.example.p7homework.view.fragment.SenterFragment;
import com.example.p7homework.view.fragment.ShafaFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager_main;
    private TabLayout tab_main;
    private ArrayList<Fragment> list;
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        pager_main = (ViewPager) findViewById(R.id.pager_main);
        tab_main = (TabLayout) findViewById(R.id.tab_main);

        list = new ArrayList<>();
        list.add(new FirstFragment());
        list.add(new ShafaFragment());
        list.add(new SenterFragment());
        list.add(new FindFragment());
        list.add(new MineFragment());
        adapter = new MyPagerAdapter(getSupportFragmentManager(), list);
        pager_main.setAdapter(adapter);
        tab_main.setupWithViewPager(pager_main);
        tab_main.getTabAt(0).setText("首页");
        tab_main.getTabAt(1).setText("沙发");
        tab_main.getTabAt(2).setText(" ");
        tab_main.getTabAt(3).setText("发现");
        tab_main.getTabAt(4).setText("我的");
    }
}