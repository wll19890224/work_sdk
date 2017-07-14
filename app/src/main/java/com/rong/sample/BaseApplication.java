package com.rong.sample;

import android.app.Application;

import com.rongcapital.sdk.ui.RongSdk;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RongSdk.initial(this);
    }
}
