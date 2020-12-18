package com.example.day03_zy1.mvp;

import android.util.Log;

import com.example.day03_zy1.MyCallBack.DataCallBack;
import com.example.day03_zy1.bean.ImageBean;
import com.example.day03_zy1.bean.SPBean;
import com.example.day03_zy1.bean.TextBean;
import com.example.day03_zy1.bean.TuiJian;
import com.example.day03_zy1.fragmen.nestfragmen.BlankFragment1;

public
class HomePersenter {

    private HomeView homeView;
    private HomeModel homeModel;

    public HomePersenter(HomeView homeView) {
        this.homeView = homeView;
        homeModel = new HomeModel();
    }

    public void QingQiu() {
        homeModel.QingQiuData( new DataCallBack() {
            @Override
            public void ShowCG(Object o) {
                homeView.ChengGong( (ImageBean) o );
            }

            @Override
            public void ShowSB(String mag) {
                homeView.ShiBai( mag );
            }
        } );
    }

    public void QingQiuText() {
        homeModel.QingQiuTextData( new DataCallBack() {
            @Override
            public void ShowCG(Object o) {
                homeView.ChengGong( (TextBean) o );
                Log.e( "GTR-----ShowCG",( (TextBean) o ).getData().getData().get( 1 ).getId()+"" );
            }

            @Override
            public void ShowSB(String mag) {
                homeView.ShiBai( mag );
                Log.e( "GTR-----ShowSB",mag);
            }
        } );
    }

    public void QingQiuSP() {
        homeModel.QingQiuSPData( new DataCallBack() {
            @Override
            public void ShowCG(Object o) {
                homeView.ChengGong( (SPBean) o );
            }

            @Override
            public void ShowSB(String mag) {
                homeView.ShiBai( mag );
            }
        } );
    }

    public void QingQiuTJ() {
        homeModel.QingQiuTJData( new DataCallBack() {
            @Override
            public void ShowCG(Object o) {
                homeView.ChengGong( (TuiJian) o );
            }

            @Override
            public void ShowSB(String mag) {
                homeView.ShiBai( mag );
            }
        } );
    }
}
