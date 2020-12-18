package com.example.day04.model;

import com.example.day04.model.bean.ExperienceBean;
import com.example.day04.model.bean.HotBean;
import com.example.day04.model.bean.LocalBean;
import com.example.day04.model.bean.SignBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    public static final String BASE_URL="http://cdwan.cn:7000/tongpao/";
    @GET("discover/hot_activity.json")
    Observable<HotBean> getHot();

    @GET("discover/rank_level.json")
    Observable<ExperienceBean> getExperience();

    @GET("discover/rank_money.json")
    Observable<LocalBean> getLocal();

    @GET("discover/rank_sign.json")
    Observable<SignBean> getSign();
}
