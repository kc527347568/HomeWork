package com.example.day02kczy.model;

import android.content.Context;
import android.util.Log;
import android.webkit.WebSettings;

import com.example.day02kczy.ApiService;
import com.example.day02kczy.BeanApp;
import com.example.day02kczy.bean.DataBean;
import com.example.day02kczy.bean.ListBean;
import com.example.day02kczy.bean.ShiBean;
import com.example.day02kczy.bean.TextBean;
import com.example.day02kczy.bean.TuBean;
import com.example.day02kczy.persenter.ListPre;
import com.example.day02kczy.persenter.MyPresenter;

import java.io.IOException;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel {
    public void getData(MyPresenter<TuBean> tuBeanMyPresenter) {
        new Retrofit.Builder()
                .baseUrl(ApiService.TuUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getTuData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<TuBean>() {
                    @Override
                    public void onNext(TuBean tuBean) {
                        tuBeanMyPresenter.getData(tuBean);
                        Log.e("TAG","成功:"+"111111111111111");
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e("TAG","错误:"+t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getShiData(Context context, MyPresenter<ShiBean> shiBeanMyPresenter) {

        new Retrofit.Builder()
                .baseUrl(ApiService.TuUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getShiData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<ShiBean>() {
                    @Override
                    public void onNext(ShiBean shiBean) {
                        shiBeanMyPresenter.getData(shiBean);
                        Log.e("TAG","成功:"+"22222222222222222222222");

                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e("TAG","视频错误:"+t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public void getTextData(MyPresenter<TextBean> textBeanMyPresenter) {
        new Retrofit.Builder()
                .baseUrl(ApiService.TuUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getTextData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<TextBean>() {
                    @Override
                    public void onNext(TextBean textBean) {
                        textBeanMyPresenter.getData(textBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getListData(MyPresenter<ListBean> listBeanMyPresenter) {
        new Retrofit.Builder()
                .baseUrl(ApiService.TuUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<ListBean>() {
                    @Override
                    public void onNext(ListBean listBean) {
                        listBeanMyPresenter.getData(listBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void addDb(DataBean dataBean) {
        BeanApp.getMyBeanApp().getDaoSession().getDataBeanDao()
                .insertOrReplace(dataBean);
        Log.e("TAG","添加数据库:"+dataBean.getTitle());
    }

    public void delete(DataBean dataBean) {
        BeanApp.getMyBeanApp().getDaoSession().getDataBeanDao()
                .delete(dataBean);
        Log.e("TAG","删除数据库:"+dataBean.getTitle());
    }

    public void getDb(ListPre listPre) {
        List<DataBean> list = BeanApp.getMyBeanApp().getDaoSession().getDataBeanDao()
                .queryBuilder().list();
        listPre.getLiData(list);
        Log.e("TAG","数据库查询:"+list.size());
    }

    public void del(DataBean dataBean) {
        BeanApp.getMyBeanApp().getDaoSession().getDataBeanDao()
                .delete(dataBean);
    }
}
