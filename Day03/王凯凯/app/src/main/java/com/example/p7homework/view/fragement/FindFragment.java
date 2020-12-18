package com.example.p7homework.view.fragement;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.p7homework.R;
import com.example.p7homework.model.adapter.MyInfoAdapter;
import com.example.p7homework.model.adapter.MyPagerAdapter;
import com.example.p7homework.model.bean.ApiService;
import com.example.p7homework.model.bean.ListBean;
import com.example.p7homework.model.bean.PaiHangBean;
import com.example.p7homework.view.activity.PaihangActivity;
import com.example.p7homework.view.fragement.fragment.BaikeFragment;
import com.example.p7homework.view.fragement.fragment.ImageFragment;
import com.example.p7homework.view.fragement.fragment.RedianFragment;
import com.example.p7homework.view.fragement.fragment.ZhuangZaoFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FindFragment extends Fragment {


    private RecyclerView ry_list;
    private TabLayout tab;
    private ViewPager pager;
    private MyPagerAdapter adapter;
    private ArrayList<Fragment> fragmentArrayList;
    private FragmentActivity activity;
    private ArrayList<ListBean.DataBean> list;
    private MyInfoAdapter adapter1;
    //    private RecyclerView ry_list2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        new Retrofit.Builder().baseUrl(ApiService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ApiService.class)
                .getRyList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ListBean value) {
                        List<ListBean.DataBean> data = value.getData();
                        list.addAll(data);
                        adapter1.notifyDataSetChanged();
                        Log.e("TAG","获取成功");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG","获取失败"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    private void initView(View view) {
        ImageView image1 = view.findViewById(R.id.image1_find);
        ImageView image2 = view.findViewById(R.id.image2_find);
        ImageView image3 = view.findViewById(R.id.image3_find);

        Glide.with(activity).load(R.drawable.a).apply(new RequestOptions().circleCrop()).into(image1);
        Glide.with(activity).load(R.drawable.b).apply(new RequestOptions().circleCrop()).into(image2);
        Glide.with(activity).load(R.drawable.c).apply(new RequestOptions().circleCrop()).into(image3);

//        image1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity, PaihangActivity.class));
            }
        });
        //列表1
        ry_list = view.findViewById(R.id.ry_list_find);
        list = new ArrayList<>();
        adapter1 = new MyInfoAdapter(activity, list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        ry_list.setLayoutManager(linearLayoutManager);

        ry_list.setAdapter(adapter1);


        //嵌套
        tab = view.findViewById(R.id.tab_find);
        pager = view.findViewById(R.id.pager_find);
        fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new RedianFragment());
        fragmentArrayList.add(new ZhuangZaoFragment());
        fragmentArrayList.add(new ImageFragment());
        fragmentArrayList.add(new BaikeFragment());
        this.adapter = new MyPagerAdapter(getChildFragmentManager(), fragmentArrayList);
        pager.setAdapter(this.adapter);
        tab.setupWithViewPager(pager);
        tab.getTabAt(0).setText("热点");
        tab.getTabAt(1).setText("妆造");
        tab.getTabAt(2).setText("图赏");
        tab.getTabAt(3).setText("百科");
    }
}