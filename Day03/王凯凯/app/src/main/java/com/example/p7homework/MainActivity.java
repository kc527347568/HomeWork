package com.example.p7homework;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.p7homework.model.adapter.MyPagerAdapter;
import com.example.p7homework.view.fragement.CenterFragment;
import com.example.p7homework.view.fragement.FindFragment;
import com.example.p7homework.view.fragement.FirstFragment;
import com.example.p7homework.view.fragement.MineFragment;
import com.example.p7homework.view.fragement.ShangChengFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager_main;
    private TabLayout tab_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        pager_main = (ViewPager) findViewById(R.id.pager_main);
        tab_main = (TabLayout) findViewById(R.id.tab_main);
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new FirstFragment());
        list.add(new FindFragment());
        list.add(new CenterFragment());
        list.add(new ShangChengFragment());
        list.add(new MineFragment());
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(),list);
        pager_main.setAdapter(adapter);
        tab_main.setupWithViewPager(pager_main);
        tab_main.getTabAt(0).setText("首页");
        tab_main.getTabAt(1).setText("发现");
        tab_main.getTabAt(2).setText(" ");
        tab_main.getTabAt(3).setText("商城");
        tab_main.getTabAt(4).setText("我的");
    }
}