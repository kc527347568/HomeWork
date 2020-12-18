package com.example.p7homework.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.p7homework.R;
import com.example.p7homework.model.adapter.MyPagerAdapter;
import com.example.p7homework.view.fragement.JingyanFragment;
import com.example.p7homework.view.fragement.QiandaoFragment;
import com.example.p7homework.view.fragement.TuhaoFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class PaihangActivity extends AppCompatActivity {

    private TabLayout tab_paiHang;
    private ViewPager pager_paiHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paihang);
        initView();
    }

    private void initView() {
        tab_paiHang = (TabLayout) findViewById(R.id.tab_paiHang);
        pager_paiHang = (ViewPager) findViewById(R.id.pager_paiHang);

        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new JingyanFragment());
        list.add(new TuhaoFragment());
        list.add(new QiandaoFragment());
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), list);
        pager_paiHang.setAdapter(adapter);
        tab_paiHang.setupWithViewPager(pager_paiHang);
        tab_paiHang.getTabAt(0).setText("经验榜");
        tab_paiHang.getTabAt(1).setText("土豪榜");
        tab_paiHang.getTabAt(2).setText("签到榜");
    }
}