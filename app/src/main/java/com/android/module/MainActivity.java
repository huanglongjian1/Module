package com.android.module;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;
import com.android.common_libs.Constants;
import com.android.common_libs.Loge;
import com.android.export_cart.CartRouterTable;
import com.android.export_cart.CartServiceUtil;
import com.android.module.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileFilter;

public class MainActivity extends AppCompatActivity {
    protected ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_main, null, false);
        setContentView(binding.getRoot());
        binding.appActivityTv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(CartRouterTable.MODULE1_ACTIVITY).navigation();
            }
        });
        binding.btnGoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartServiceUtil.navigateCartPage("param1", "param1");
            }
        });
        binding.btnGoFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = (Fragment) ARouter.getInstance().build(CartRouterTable.PATH_FRAGMENT_CART).navigation();
                getSupportFragmentManager().beginTransaction().add(R.id.app_fragment, fragment).commit();
            }
        });


        binding.appActivityTv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(Constants.MODULE2_ACTIVITY).navigation();
            }
        });
        binding.appActivityTv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File plugin = getExternalFilesDir("plugin");
                File plugin_apk = plugin.listFiles(new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        return pathname.getAbsolutePath().endsWith(".apk");
                    }
                })[0];
                Loge.e(plugin_apk.getAbsolutePath());

                Intent intent = new Intent(MainActivity.this, ProxyActivity.class);
                intent.putExtra("path", plugin_apk.getAbsolutePath());
                intent.putExtra("classname", "com.android.plugin_test1.PluginTest1_Activity");
                startActivity(intent);
            }
        });
        binding.appActivityTv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File plugin = getExternalFilesDir("plugin_aar");
                File plugin_apk = plugin.listFiles(new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        return pathname.getAbsolutePath().endsWith(".apk");
                    }
                })[0];
                Loge.e(plugin_apk.getAbsolutePath());


                PackageInfo packageInfo = getPackageManager().getPackageArchiveInfo(plugin_apk.getAbsolutePath(), PackageManager.GET_ACTIVITIES | PackageManager.GET_SERVICES);
                Loge.e(packageInfo.packageName);
                String class_name = packageInfo.packageName + ".PluginTest3_Activity";
                Loge.e(class_name);

                if (class_name == null | TextUtils.isEmpty(class_name)) return;
                Intent intent = new Intent(MainActivity.this, ProxyActivity.class);
                intent.putExtra("path", plugin_apk.getAbsolutePath());
                intent.putExtra("classname", class_name);
                startActivity(intent);
            }
        });

    }
}