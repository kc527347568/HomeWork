package com.example.day04;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day04.adapter.MainVpAdapter;
import com.example.day04.fragment.AddFragment;
import com.example.day04.fragment.FindFragment;
import com.example.day04.fragment.HomeFragment;
import com.example.day04.fragment.MineFragment;
import com.example.day04.fragment.ShopFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ViewPager vp;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }


    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);

        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new FindFragment());
        fragments.add(new AddFragment());
        fragments.add(new ShopFragment());
        fragments.add(new MineFragment());
        MainVpAdapter adapter=new MainVpAdapter(getSupportFragmentManager(),fragments);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);

        tab.getTabAt(0).setText("首页").setIcon(R.drawable.home_selector);
        tab.getTabAt(1).setText("发现").setIcon(R.drawable.find_selector);
        tab.getTabAt(2).setIcon(R.drawable.add_selector);
        tab.getTabAt(3).setText("商城").setIcon(R.drawable.shop_selector);
        tab.getTabAt(4).setText("我的").setIcon(R.drawable.mine_selector);
    }
}
