package com.example.wuqi.model;

import com.example.wuqi.model.bean.PictureBean;
import com.example.wuqi.model.bean.RecommendBean;
import com.example.wuqi.model.bean.TextBean;
import com.example.wuqi.model.bean.VideoBean;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiSerivice {
    public static final String BASE_URL="http://123.56.232.18:8080/serverdemo/feeds/";

    public static final String BASE_URL1="http://123.56.232.18:8080/serverdemo//tag/";

    //http://123.56.232.18:8080/serverdemo/feeds/?pageCount=12&feedType=video

    //http://123.56.232.18:8080/serverdemo//tag/queryTagList

    @GET("queryHotFeedsList")
    Observable<PictureBean> getPic(@Query("pageCount") int pageCount,
                                 @Query("feedType") String feedType);

    @GET("queryHotFeedsList")
    Observable<VideoBean> getVideo(@Query("pageCount") int pageCount,
                                   @Query("feedType") String video);

    @GET("queryHotFeedsList")
    Observable<TextBean> getText(@Query("pageCount") int pageCount,
                                      @Query("feedType") String video,
                                 @Query("feedId") int feedId);

    @GET("queryTagList")
    Observable<RecommendBean> getRecommend();
}
