package com.umeng.lkx;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.umeng.lkx.fragment.FragmentA;
import com.umeng.lkx.fragment.FragmentB;
import com.umeng.lkx.fragment.FragmentC;
import com.umeng.lkx.fragment.FragmentD;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private TabLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        table = (TabLayout) findViewById(R.id.table);

        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentA());
        fragments.add(new FragmentB());
        fragments.add(new FragmentC());
        fragments.add(new FragmentD());
        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        table.setupWithViewPager(viewpager);
        table.getTabAt(0).setText("首页");
        table.getTabAt(1).setText("发现");
        table.getTabAt(2).setText("商城");
        table.getTabAt(3).setText("我的");
    }
}
