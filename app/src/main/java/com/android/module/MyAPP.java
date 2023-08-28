package com.android.module;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class MyAPP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this);
    }
}
