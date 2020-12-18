package com.example.p4day03.model;

import com.example.p4day03.bean.Mp4bean;
import com.example.p4day03.presenter.Resultcallback;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Modelmp4 {
    public void getData(final Resultcallback<Mp4bean> resultcallback) {
        new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Apiservicemp4.mp4url)
                .build()
                .create(Apiservicemp4.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Mp4bean>() {
                    @Override
                    public void onNext(Mp4bean mp4bean) {
                        resultcallback.ok(mp4bean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface Apiservicemp4{
        String mp4url = "http://123.56.232.18:8080/serverdemo/feeds/";

        @GET("queryHotFeedsList?pageCount=12&feedType=video")
        Flowable<Mp4bean> getData();
    }
}
