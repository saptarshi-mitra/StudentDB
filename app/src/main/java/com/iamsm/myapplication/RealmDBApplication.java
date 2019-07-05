package com.iamsm.myapplication;

import android.app.Application;

import io.realm.Realm;

public class RealmDBApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
