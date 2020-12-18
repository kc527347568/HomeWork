package com.example.p7homework.model.bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    public static final String URL = "http://cdwan.cn:7000/tongpao/";

    @GET("discover/hot_activity.json")
    Observable<ListBean> getRyList();

    @GET("discover/rank_level.json")
    Observable<JingYanBean> getJingYan();
}
