package com.example.wuqi.callback;

public interface ResultCallBack<T>{
    void successData(T t);
    void failData(String msg);
}
