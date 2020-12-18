package com.example.p4day03.model;

import com.example.p4day03.bean.Imagebean;
import com.example.p4day03.presenter.Resultcallback;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class Modelmain {
    public void getData(final Resultcallback<Imagebean> resultcallback) {
        new Retrofit.Builder()
                .baseUrl(ApiService.imageurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Imagebean>() {
                    @Override
                    public void onNext(Imagebean imagebean) {
                        resultcallback.ok(imagebean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface ApiService{
        String imageurl = "http://123.56.232.18:8080/serverdemo/feeds/";

        @GET("queryHotFeedsList?pageCount=12&feedType=pics")
        Flowable<Imagebean> getData();
    }
}
