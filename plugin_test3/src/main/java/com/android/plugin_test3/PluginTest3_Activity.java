package com.android.plugin_test3;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;

import com.android.plugin.BaseActivity;

public class PluginTest3_Activity extends BaseActivity {
    int index = 0;

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        super.onCreate(owner);
        AppCompatActivity activity = (AppCompatActivity) owner;
        activity.setContentView(R.layout.plugin_test3_activity);
        TextView textView = activity.findViewById(R.id.pluginTest3_tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("点击次数" + index++);
            }
        });
        PluginTest3_Fragment pluginTest3_fragment = new PluginTest3_Fragment();
        activity.getSupportFragmentManager().beginTransaction().add(R.id.pluginTest3_fragment, pluginTest3_fragment).commit();
        TextView quit = activity.findViewById(R.id.pluginTest3_quit_tv);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }
}
