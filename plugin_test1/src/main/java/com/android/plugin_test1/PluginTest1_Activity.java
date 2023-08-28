package com.android.plugin_test1;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

import com.android.plugin.BaseActivity;

import java.util.Random;

public class PluginTest1_Activity extends BaseActivity {
    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        super.onCreate(owner);
        proxyActivity.setContentView(R.layout.plugin_test1_activity);
        TextView textView=proxyActivity.findViewById(R.id.plugin_test1_tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("随机数字"+new Random().nextInt(Integer.MAX_VALUE));
            }
        });
    }
}
