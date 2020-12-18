package com.example.day03zuoye.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day03zuoye.R;
import com.example.day03zuoye.adapter.Qianadapter;
import com.example.day03zuoye.bean.Redianbean;

import java.util.ArrayList;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RedianFragment extends Fragment {


    private RecyclerView rec;
    private ArrayList<Redianbean.DataBean.ListBean> listBeans;
    private Qianadapter qianadapter;
    private int page;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_redian, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(Service.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Service.class)
                .getBean(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Redianbean>() {
                    @Override
                    public void onNext(Redianbean redianbean) {
                        listBeans.addAll(redianbean.getData().getList());
                        qianadapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View view) {
        rec = view.findViewById(R.id.redianrec);
        rec.setLayoutManager(new LinearLayoutManager(getContext()));
        listBeans = new ArrayList<>();
        qianadapter = new Qianadapter(getContext(), listBeans);
        rec.setAdapter(qianadapter);
    }

    public interface Service{
        String url = "http://cdwan.cn:7000/tongpao/";

        @GET("discover/news_{page}.json")
        Flowable<Redianbean> getBean(@Path("page") int page);
    }
}