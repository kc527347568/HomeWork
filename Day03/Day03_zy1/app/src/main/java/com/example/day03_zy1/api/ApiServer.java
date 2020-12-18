package com.example.day03_zy1.api;

import com.example.day03_zy1.bean.ImageBean;
import com.example.day03_zy1.bean.SPBean;
import com.example.day03_zy1.bean.TextBean;
import com.example.day03_zy1.bean.TuiJian;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.GET;

public
interface ApiServer {
    String BATA_URL = " http://123.56.232.18:8080/serverdemo/feeds/";
    String BASE_URL = " http://123.56.232.18:8080/serverdemo//";

    @GET("queryHotFeedsList?pageCount=12&feedType=pics")
    Call<ImageBean> getData();

    @GET("queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275")
    Call<TextBean> getTextData();



    @GET("queryHotFeedsList?pageCount=12&feedType=video")
    Call<SPBean> getSPData();

    @GET("tag/queryTagList")
    Call<TuiJian> getTJData();
}
