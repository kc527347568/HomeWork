package com.example.p7homework.model;

import com.example.p7homework.callback.MyCallback;
import com.example.p7homework.model.bean.ApiService;
import com.example.p7homework.model.bean.ImageBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel {

    public void getData(int pagerCount, String feedType, final MyCallback callback) {
        new Retrofit.Builder()
                .baseUrl(ApiService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ApiService.class)
                .getImage(pagerCount,feedType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ImageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ImageBean value) {
                        if(callback != null){
                            callback.successData(value);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(callback != null){
                            callback.fileData(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
