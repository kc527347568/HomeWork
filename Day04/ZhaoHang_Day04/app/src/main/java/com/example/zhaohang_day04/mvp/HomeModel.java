package com.example.zhaohang_day04.mvp;


import android.util.Log;


import com.example.zhaohang_day04.MyCallBack.DataCallBack;
import com.example.zhaohang_day04.api.ApiServer;
import com.example.zhaohang_day04.bean.HuoDongBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public
class HomeModel   {

    public void QingQiuData(DataCallBack dataCallBack) {
        Retrofit build = new Retrofit.Builder()
                .addCallAdapterFactory( RxJava2CallAdapterFactory.create() )
                .addConverterFactory( GsonConverterFactory.create() )
                .baseUrl( ApiServer.BAST_URL )
                .build();
        ApiServer apiServer = build.create( ApiServer.class );
        apiServer.getData().enqueue( new Callback<HuoDongBean>() {
            @Override
            public void onResponse(Call<HuoDongBean> call, Response<HuoDongBean> response) {
                dataCallBack.ShowCG( response.body() );
                Log.e( "GTR-----onResponse",response.toString());
            }

            @Override
            public void onFailure(Call<HuoDongBean> call, Throwable t) {
                dataCallBack.ShowSB( t.toString() );
                Log.e( "GTR-----onFailure",t.toString());
            }
        } );
    }

//    public void QingQiuTuHaoData(DataCallBack dataCallBack) {
//        Retrofit build = new Retrofit.Builder()
//                .addCallAdapterFactory( RxJava2CallAdapterFactory.create() )
//                .addConverterFactory( GsonConverterFactory.create() )
//                .baseUrl( ApiServer.BAST_URL )
//                .build();
//        ApiServer apiServer = build.create( ApiServer.class );
//      apiServer.getTuHaoData().enqueue( new Callback<TuHaoBean>() {
//          @Override
//          public void onResponse(Call<TuHaoBean> call, Response<TuHaoBean> response) {
//              dataCallBack.ShowCG( response.body() );
//          }
//
//          @Override
//          public void onFailure(Call<TuHaoBean> call, Throwable t) {
//              dataCallBack.ShowSB( t.toString() );
//          }
//      } );
//    }
}
