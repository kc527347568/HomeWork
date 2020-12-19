package com.umeng.lkx.api;

import com.umeng.lkx.bean.JingYanBean;
import com.umeng.lkx.bean.QianBean;
import com.umeng.lkx.bean.ReDianBean;
import com.umeng.lkx.bean.RemenBean;
import com.umeng.lkx.bean.SheTuanBean;
import com.umeng.lkx.bean.TushangBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String BASE_URL="http://cdwan.cn:7000/tongpao/";
    @GET("home/topic_discussed.json")
    Observable<RemenBean> getRemen();

    @GET("discover/news_1.json")
    Observable<ReDianBean> getRedian();

    @GET("discover/news_3.json")
    Observable<TushangBean> getTushang();

    @GET("home/personal_msg.json")
    Observable<SheTuanBean> getShetuan();

    @GET("discover/rank_level.json")
    Observable<JingYanBean> getJingyan();

    @GET("discover/rank_sign.json")
    Observable<QianBean>getQian();
}
