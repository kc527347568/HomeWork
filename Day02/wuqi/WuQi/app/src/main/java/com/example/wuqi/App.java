package com.example.wuqi;

import android.app.Application;

import com.example.wuqi.db.DaoMaster;
import com.example.wuqi.db.DaoSession;

public class App extends Application {

    public static DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "person");
        daoSession = new DaoMaster(helper.getWritableDb()).newSession();
    }
}
