package com.umeng.lkx.view;

import com.umeng.lkx.bean.JingYanBean;
import com.umeng.lkx.bean.QianBean;
import com.umeng.lkx.bean.ReDianBean;
import com.umeng.lkx.bean.RemenBean;
import com.umeng.lkx.bean.SheTuanBean;
import com.umeng.lkx.bean.TushangBean;

import java.util.List;

public interface TongView {
    void Fline(List<RemenBean.DataBean> remenBeans);
    void Sunces(List<ReDianBean.DataBean.ListBean> red);
    void Foug(List<TushangBean.DataBean.ListBean> tu);
    void Shetuan(List<SheTuanBean.DataBean> shetuan);
    void Jingyan(List<JingYanBean.DataBean.ExpTopBean.ListBean> jingyan);
    void Qian(List<QianBean.DataBean.SignTopBean.ListBean> qian);
}
