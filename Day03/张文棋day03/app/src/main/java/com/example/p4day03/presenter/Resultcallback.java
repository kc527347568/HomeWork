package com.example.p4day03.presenter;

public interface Resultcallback<T>{
    void ok(T t);
    void no(String n);
}
