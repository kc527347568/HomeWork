package com.umeng.lkx.presenter;

import com.umeng.lkx.bean.JingYanBean;
import com.umeng.lkx.bean.QianBean;
import com.umeng.lkx.bean.ReDianBean;
import com.umeng.lkx.bean.RemenBean;
import com.umeng.lkx.bean.SheTuanBean;
import com.umeng.lkx.bean.TushangBean;
import com.umeng.lkx.callback.TongCallBack;
import com.umeng.lkx.model.MainModel;
import com.umeng.lkx.view.TongView;

import java.util.List;

public class TongPresenter implements TongCallBack {
    private TongView tongView;
    private MainModel mainModel;

    public TongPresenter(TongView tongView) {
        this.tongView = tongView;
        mainModel=new MainModel();
    }

    @Override
    public void Remen(List<RemenBean.DataBean> remenBeans) {
        tongView.Fline(remenBeans);
    }

    @Override
    public void Redian(List<ReDianBean.DataBean.ListBean> redian) {
        tongView.Sunces(redian);
    }

    @Override
    public void Tushang(List<TushangBean.DataBean.ListBean> tushang) {
        tongView.Foug(tushang);
    }

    @Override
    public void Shetuan(List<SheTuanBean.DataBean> shetuan) {
        tongView.Shetuan(shetuan);
    }

    @Override
    public void Jingyan(List<JingYanBean.DataBean.ExpTopBean.ListBean> jingyan) {
        tongView.Jingyan(jingyan);
    }

    @Override
    public void Qian(List<QianBean.DataBean.SignTopBean.ListBean> qian) {
        tongView.Qian(qian);
    }

    public void setData() {
        mainModel.initData(this);
    }

    public void initDat() {
        mainModel.setData(this);
    }

    public void shang() {
        mainModel.shang(this);
    }

    public void setTuan() {
        mainModel.sheTuan(this);
    }

    public void qian() {
        mainModel.qian(this);
    }

    public void qiand() {
        mainModel.qiank(this);
    }
}
