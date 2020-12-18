package com.example.day03_zy1.mvp;


import android.util.Log;

import com.example.day03_zy1.MyCallBack.DataCallBack;
import com.example.day03_zy1.api.ApiServer;
import com.example.day03_zy1.bean.ImageBean;
import com.example.day03_zy1.bean.SPBean;
import com.example.day03_zy1.bean.TextBean;
import com.example.day03_zy1.bean.TuiJian;

import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public
class HomeModel   {

    public void QingQiuData(final DataCallBack dataCallBack) {
        Retrofit build = new Retrofit.Builder()
                .addCallAdapterFactory( RxJava2CallAdapterFactory.create() )
                .addConverterFactory( GsonConverterFactory.create() )
                .baseUrl( ApiServer.BATA_URL )
                .build();
        ApiServer apiServer = build.create( ApiServer.class );
        apiServer.getData().enqueue( new Callback<ImageBean>() {
            @Override
            public void onResponse(Call<ImageBean> call, Response<ImageBean> response) {
                dataCallBack.ShowCG( response.body() );
            }

            @Override
            public void onFailure(Call<ImageBean> call, Throwable t) {
                dataCallBack.ShowSB( t.toString() );
            }
        } );


    }

    public void QingQiuTextData(DataCallBack dataCallBack) {

        Retrofit build = new Retrofit.Builder()
                .addCallAdapterFactory( RxJava2CallAdapterFactory.create() )
                .addConverterFactory( GsonConverterFactory.create() )
                .baseUrl( ApiServer.BATA_URL )
                .build();
        ApiServer apiServer = build.create( ApiServer.class );
        apiServer.getTextData().enqueue( new Callback<TextBean>() {
            @Override
            public void onResponse(Call<TextBean> call, Response<TextBean> response) {
                Log.e( "GTR ----- onResponse",response.body().toString());
                dataCallBack.ShowCG( response.body() );


            }

            @Override
            public void onFailure(Call<TextBean> call, Throwable t) {
                dataCallBack.ShowSB( t.toString() );
                Log.e( "GTR",t.toString());
            }
        } );

    }

    public void QingQiuSPData(DataCallBack dataCallBack) {
        Retrofit build = new Retrofit.Builder()
                .addCallAdapterFactory( RxJava2CallAdapterFactory.create() )
                .addConverterFactory( GsonConverterFactory.create() )
                .baseUrl( ApiServer.BATA_URL )
                .build();
        ApiServer apiServer = build.create( ApiServer.class );
        apiServer.getSPData().enqueue( new Callback<SPBean>() {
            @Override
            public void onResponse(Call<SPBean> call, Response<SPBean> response) {
                dataCallBack.ShowCG( response.body() );
            }

            @Override
            public void onFailure(Call<SPBean> call, Throwable t) {
                dataCallBack.ShowSB( t.toString() );
            }
        } );
    }

    public void QingQiuTJData(DataCallBack dataCallBack) {
        Retrofit build = new Retrofit.Builder()
                .addCallAdapterFactory( RxJava2CallAdapterFactory.create() )
                .addConverterFactory( GsonConverterFactory.create() )
                .baseUrl( ApiServer.BASE_URL )
                .build();
        ApiServer apiServer = build.create( ApiServer.class );
       apiServer.getTJData().enqueue( new Callback<TuiJian>() {
           @Override
           public void onResponse(Call<TuiJian> call, Response<TuiJian> response) {
               dataCallBack.ShowCG( response.body() );
           }

           @Override
           public void onFailure(Call<TuiJian> call, Throwable t) {
               dataCallBack.ShowSB( t.toString() );
           }
       } );
    }
}
