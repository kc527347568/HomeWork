package com.example.p7homework.view.fragement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p7homework.R;
import com.example.p7homework.model.adapter.MyJingYanAdapter;
import com.example.p7homework.model.bean.ApiService;
import com.example.p7homework.model.bean.JingYanBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class JingyanFragment extends Fragment {


    private RecyclerView ry_list;
    private FragmentActivity activity;
    private ArrayList<JingYanBean.DataBean.ExpTopBean.ListBean> list;
    private MyJingYanAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();
        View view = inflater.inflate(R.layout.fragment_jingyan, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        new Retrofit.Builder().baseUrl(ApiService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ApiService.class)
                .getJingYan().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JingYanBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JingYanBean value) {
                        List<JingYanBean.DataBean.ExpTopBean.ListBean> listBeans = value.getData().getExpTop().getList();
                        list.addAll(listBeans);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View view) {
        ry_list = view.findViewById(R.id.ry_list_jingYan);
        list = new ArrayList<>();
        adapter = new MyJingYanAdapter(activity, list);
        ry_list.setLayoutManager(new LinearLayoutManager(activity));
        ry_list.addItemDecoration(new DividerItemDecoration(activity,DividerItemDecoration.VERTICAL));
        ry_list.setAdapter(adapter);
    }
}