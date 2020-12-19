package com.example.kangchen03.model;

import com.example.kangchen03.ApiService;
import com.example.kangchen03.bean.ItemBean;
import com.example.kangchen03.bean.ReMengBean;
import com.example.kangchen03.bean.TitleBean;
import com.example.kangchen03.presenter.HomPresenter;
import com.example.kangchen03.presenter.MyPresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel {
    public void getData(final HomPresenter homPresenter) {
        new Retrofit.Builder()
                .baseUrl(ApiService.Url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getReMen()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<ReMengBean>() {
                    @Override
                    public void onNext(ReMengBean reMengBean) {
                        homPresenter.getReMen(reMengBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        new Retrofit.Builder()
                .baseUrl(ApiService.Url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getTitle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<TitleBean>() {
                    @Override
                    public void onNext(TitleBean titleBean) {
                        homPresenter.getTitle(titleBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public void getList(int id, final MyPresenter<ItemBean> itemBeanMyPresenter) {
        new Retrofit.Builder()
                .baseUrl(ApiService.Url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getItem(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<ItemBean>() {
                    @Override
                    public void onNext(ItemBean itemBean) {
                        itemBeanMyPresenter.getData(itemBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
