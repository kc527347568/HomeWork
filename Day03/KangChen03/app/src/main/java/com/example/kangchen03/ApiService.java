package com.example.kangchen03;

import com.example.kangchen03.bean.ItemBean;
import com.example.kangchen03.bean.ReMengBean;
import com.example.kangchen03.bean.TitleBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    String Url = "http://cdwan.cn:7000/tongpao/";

    @GET("discover/hot_activity.json")
    Flowable<ReMengBean> getReMen();

    @GET("discover/navigation.json")
    Flowable<TitleBean> getTitle();

    @GET("discover/news_{page}.json")
    Flowable<ItemBean> getItem(@Path("page") int page);



}
