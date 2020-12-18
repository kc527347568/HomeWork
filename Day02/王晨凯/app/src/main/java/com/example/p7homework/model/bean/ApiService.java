package com.example.p7homework.model.bean;

import com.example.p7homework.view.fragment.RecoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    public static final String URL = "http://123.56.232.18:8080/serverdemo/";

    @GET("feeds/queryHotFeedsList")
    Observable<ImageBean> getImage(@Query("pagerCount") int pagerCount, @Query("feedType") String feedType);

    @GET("feeds/queryHotFeedsList")
    Observable<MpBean> getMp(@Query("pageCount") int pageCount, @Query("feedType") String feedType);

    @GET("feeds/queryHotFeedsList")
    Observable<TextBean> getText(@Query("pageCount") int pageCount
            ,@Query("feedType")String feedType,@Query("feedId")String feedId);

    @GET("tag/queryTagList")
    Observable<RecoBean> getReCo();
}
