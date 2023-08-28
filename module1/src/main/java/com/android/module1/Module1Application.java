package com.android.module1;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class Module1Application extends Application {
    private boolean isDebugARouter = true;

    @Override
    public void onCreate() {
        super.onCreate();
        if (isDebugARouter){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
