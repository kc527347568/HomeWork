package com.umeng.lkx.callback;

import com.umeng.lkx.bean.JingYanBean;
import com.umeng.lkx.bean.QianBean;
import com.umeng.lkx.bean.ReDianBean;
import com.umeng.lkx.bean.RemenBean;
import com.umeng.lkx.bean.SheTuanBean;
import com.umeng.lkx.bean.TushangBean;

import java.util.ArrayList;
import java.util.List;

public interface TongCallBack {
    void Remen(List<RemenBean.DataBean> remenBeans);
    void Redian(List<ReDianBean.DataBean.ListBean> redian);
    void Tushang(List<TushangBean.DataBean.ListBean> tushang);
    void Shetuan(List<SheTuanBean.DataBean> shetuan);
    void Jingyan(List<JingYanBean.DataBean.ExpTopBean.ListBean> jingyan);
    void Qian(List<QianBean.DataBean.SignTopBean.ListBean> qian);
}
