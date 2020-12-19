package com.example.wuqi.model;

import com.example.wuqi.callback.ResultCallBack;
import com.example.wuqi.model.bean.PictureBean;
import com.google.gson.Gson;

import javax.xml.validation.Validator;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PictureModel {

    public void resultPic(final ResultCallBack<PictureBean> callBack){
        new Retrofit.Builder()
                .baseUrl(ApiSerivice.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ApiSerivice.class)
                .getPic(12,"pics")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PictureBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PictureBean value) {
                        if (callBack!=null){
                            callBack.successData(value);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callBack!=null){
                            callBack.failData(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
