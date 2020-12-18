package com.example.p7homework;

import android.app.Application;

import com.example.p7homework.db.DaoMaster;
import com.example.p7homework.db.DaoSession;

public class App extends Application {

    public static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "greenName");

        daoSession = new DaoMaster(devOpenHelper.getWritableDatabase()).newSession();
    }
}
