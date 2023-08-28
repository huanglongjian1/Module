package com.android.module;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.common_libs.Loge;
import com.android.plugin.BaseActivity;
import com.android.plugin.PluginUtils;

import dalvik.system.PathClassLoader;

public class ProxyActivity extends AppCompatActivity {
    private String mActivityClassName;
    private BaseActivity mIPluginActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityClassName = getIntent().getStringExtra("classname");


        String plugin_apk = getIntent().getStringExtra("path");
        if (plugin_apk == null) {
            throw new NullPointerException("未获取到插件APK");
        }
        Loge.e(plugin_apk);
        PathClassLoader pathClassLoader = new PathClassLoader(plugin_apk, getClassLoader());


        PluginUtils.inject(pathClassLoader, this, plugin_apk);
        PluginUtils.mergePluginResources(this, plugin_apk);

        lunchActivity();
    }

    private void lunchActivity() {
        try {
            Class clazz = Class.forName(mActivityClassName);
            //将Activity加载到内存中了
            Object o = clazz.newInstance();
            //判断要跳转到的插件Activity是否实现了规则接口
            if (o instanceof BaseActivity) {
                mIPluginActivity = (BaseActivity) o;
                //赋予插件Activity上下文信息
                mIPluginActivity.attach(this);
                Bundle bundle = new Bundle();
                //表明是由宿主Activity跳转过去的
                bundle.putInt("from", BaseActivity.FORM_INTERNAL);
                //回调插件Activity的onCreate方法，使其具有生命周期回调
                getLifecycle().addObserver(mIPluginActivity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }
}
