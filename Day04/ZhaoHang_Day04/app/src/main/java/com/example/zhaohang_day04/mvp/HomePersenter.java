package com.example.zhaohang_day04.mvp;

import android.util.Log;

import com.example.zhaohang_day04.MyCallBack.DataCallBack;
import com.example.zhaohang_day04.bean.HuoDongBean;
import com.example.zhaohang_day04.fragment.nestFragment.TuHaoFragment;

public
class HomePersenter {

    private HomeView homeView;
    private HomeModel homeModel;

    public HomePersenter(HomeView homeView) {
        this.homeView = homeView;
        homeModel = new HomeModel();
    }


    public void QingQiuHuoDong() {
        homeModel.QingQiuData( new DataCallBack() {
            @Override
            public void ShowCG(Object o) {
                homeView.ChengGong( ( HuoDongBean )o  );
            }

            @Override
            public void ShowSB(String mag) {
                homeView.ShiBai( mag );
            }
        } );
    }

//    public void QingQiuTuHao() {
//        homeModel.QingQiuTuHaoData( new DataCallBack() {
//            @Override
//            public void ShowCG(Object o) {
//                homeView.ChengGong( ( TuHaoFragment )o );
//            }
//
//            @Override
//            public void ShowSB(String mag) {
//                homeView.ShiBai( mag );
//            }
//        } );
//    }
}
