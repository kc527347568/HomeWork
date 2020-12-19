package com.example.p4day03.model;

import com.example.p4day03.bean.Textbean;
import com.example.p4day03.presenter.Resultcallback;
import com.google.gson.Gson;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Modeltext {
    public void getData(Resultcallback<Textbean> resultcallback) {
        new Retrofit.Builder()
                .baseUrl(Apitext.texturl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Apitext.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Textbean>() {
                    @Override
                    public void onNext(Textbean textbean) {
                        resultcallback.ok(textbean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface Apitext{
        String texturl = "http://123.56.232.18:8080/serverdemo/feeds/";
        @GET("queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275")
        Flowable<Textbean> getData();
    }
}
