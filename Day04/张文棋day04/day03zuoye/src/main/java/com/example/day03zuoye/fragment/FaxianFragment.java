package com.example.day03zuoye.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day03zuoye.R;
import com.example.day03zuoye.adapter.Faxianrecadapter;
import com.example.day03zuoye.bean.Fenleitab;
import com.example.day03zuoye.bean.Remenhuodong;

import java.util.ArrayList;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


public class FaxianFragment extends Fragment {


    private RecyclerView rec;
    private ArrayList<Remenhuodong.DataBean> renmen;
    private ArrayList<Fenleitab.DataBean> fentab;
    private Faxianrecadapter faxianrecadapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faxian, container, false);
        initView(view);
        initData();
        initfentab();
        return view;
    }

    private void initfentab() {
        new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Remenrec.fentab)
                .build()
                .create(Remenrec.class)
                .getfentab()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Fenleitab>() {
                    @Override
                    public void onNext(Fenleitab fenleitab) {
                        fentab.addAll(fenleitab.getData());
                        faxianrecadapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //热门活动rec解析
    private void initData() {
        new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Remenrec.url)
                .build()
                .create(Remenrec.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Remenhuodong>() {
                    @Override
                    public void onNext(Remenhuodong remenhuodong) {
                        renmen.addAll(remenhuodong.getData());
                        faxianrecadapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public interface Remenrec{
        String url = "http://cdwan.cn:7000/tongpao/";

        @GET("discover/hot_activity.json")
        Flowable<Remenhuodong> getData();


        String fentab = "http://cdwan.cn:7000/tongpao/";

        @GET("discover/navigation.json")
        Flowable<Fenleitab> getfentab();
    }

    private void initView(View view) {
        rec = view.findViewById(R.id.rec);
        rec.setLayoutManager(new LinearLayoutManager(getContext()));
        renmen = new ArrayList<>();
        fentab = new ArrayList<>();
        faxianrecadapter = new Faxianrecadapter(getContext(), renmen, fentab,getActivity().getSupportFragmentManager());
        rec.setAdapter(faxianrecadapter);
    }
}