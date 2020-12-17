package com.example.day02kczy;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.day02kczy.db.DaoMaster;
import com.example.day02kczy.db.DaoSession;

public class BeanApp extends Application {

    private static BeanApp myBeanApp;
    private DaoMaster.DevOpenHelper helper;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        myBeanApp = this;

        helper = new DaoMaster.DevOpenHelper(this, "bean.db", null);
        db = helper.getWritableDatabase();
        //Android 9 默认使用了wal模式,需要关闭wal模式
        db.disableWriteAheadLogging();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public static BeanApp getMyBeanApp(){
        return myBeanApp;
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }
}
