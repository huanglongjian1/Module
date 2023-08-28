package com.android.plugin;

import android.app.Activity;

import androidx.lifecycle.DefaultLifecycleObserver;

public class BaseActivity implements DefaultLifecycleObserver {
    //内部跳转
    public static final int FORM_INTERNAL = 1;
    //外部跳转
    public static final int FROM_EXTERNAL = 2;
    protected Activity proxyActivity;

    public void attach(Activity proxyActivity) {
        this.proxyActivity = proxyActivity;
    }

}
