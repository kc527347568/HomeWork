package com.example.zhaohang_day04.api;

import com.example.zhaohang_day04.bean.HuoDongBean;

import retrofit2.Call;
import retrofit2.http.GET;

public
interface ApiServer {

    String BAST_URL = "http://cdwan.cn:7000/tongpao/";

    @GET(" discover/hot_activity.json")
    Call<HuoDongBean> getData();

    //http://cdwan.cn:7000/tongpao/discover/rank_money.json

//    @GET("discover/rank_money.json")
//    Call<TuHaoBean> getTuHaoData();
}
