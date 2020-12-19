package com.example.day02kczy;

import com.example.day02kczy.bean.ListBean;
import com.example.day02kczy.bean.ShiBean;
import com.example.day02kczy.bean.TextBean;
import com.example.day02kczy.bean.TuBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ApiService {

    String TuUrl = "http://123.56.232.18:8080/serverdemo/";

    @GET("feeds/queryHotFeedsList?pageCount=12&feedType=pics")
    Flowable<TuBean> getTuData();


    @GET("feeds/queryHotFeedsList?pageCount=12&feedType=video")
    Flowable<ShiBean> getShiData();

    @GET("feeds/queryHotFeedsList?pageCount=10&feedType=text")
    Flowable<TextBean> getTextData();

    //http://123.56.232.18:8080/serverdemo/
    @GET("tag/queryTagList")
    Flowable<ListBean> getList();

}
