package com.umeng.lkx;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.umeng.lkx.fragment.qian.Qbment;
import com.umeng.lkx.fragment.qian.Qcment;
import com.umeng.lkx.fragment.qian.Qrament;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private TabLayout ble;
    private ViewPager ppl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        ble = (TabLayout) findViewById(R.id.ble);
        ppl = (ViewPager) findViewById(R.id.ppl);
        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Qrament());
        fragments.add(new Qbment());
        fragments.add(new Qcment());
        ppl.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        ble.setupWithViewPager(ppl);
        ble.getTabAt(0).setText("经验榜");
        ble.getTabAt(1).setText("土豪榜");
        ble.getTabAt(2).setText("签到榜");
    }
}