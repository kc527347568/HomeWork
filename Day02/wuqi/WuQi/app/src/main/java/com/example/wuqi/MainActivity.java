package com.example.wuqi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.wuqi.adapter.MainVpAdapter;
import com.example.wuqi.fragment.FindFragment;
import com.example.wuqi.fragment.HomeFragment;
import com.example.wuqi.fragment.MineFragment;
import com.example.wuqi.fragment.PublishFragment;
import com.example.wuqi.fragment.SofaFragment;
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
        fragments.add(new SofaFragment());
        fragments.add(new PublishFragment());
        fragments.add(new FindFragment());
        fragments.add(new MineFragment());
        MainVpAdapter adapter=new MainVpAdapter(getSupportFragmentManager(),fragments);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);


        tab.getTabAt(0).setText("首页").setIcon(R.drawable.icon_tab_home);
        tab.getTabAt(1).setText("沙发").setIcon(R.drawable.icon_tab_sofa);
        tab.getTabAt(2).setIcon(R.drawable.icon_tab_publish);
        tab.getTabAt(3).setText("发现").setIcon(R.drawable.icon_tab_find);
        tab.getTabAt(4).setText("我的").setIcon(R.drawable.icon_tab_mine);
    }
}
