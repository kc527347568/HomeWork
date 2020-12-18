package com.example.day04;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day04.adapter.MainVpAdapter;
import com.example.day04.fragment.ExperienceFragment;
import com.example.day04.fragment.LocalFragment;
import com.example.day04.fragment.SignFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class CarryActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tab;
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carry);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);

        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(new ExperienceFragment());
        fragments.add(new LocalFragment());
        fragments.add(new SignFragment());
        MainVpAdapter adapter=new MainVpAdapter(getSupportFragmentManager(),fragments);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);

        tab.getTabAt(0).setText("经验榜");
        tab.getTabAt(1).setText("土豪榜");
        tab.getTabAt(2).setText("签到榜");

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                toolbar.setTitle(tab.getText());
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
