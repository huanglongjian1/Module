package com.android.module1;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.android.common_libs.Constants;
import com.android.export_cart.CartRouterTable;
import com.android.module1.databinding.Module1ActivityBinding;

@Route(path = CartRouterTable.MODULE1_ACTIVITY)
public class Module1Activity extends AppCompatActivity {
    Module1ActivityBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.module1_activity);
        // setContentView(R.layout.module1_activity);
        binding.module1Tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(CartRouterTable.PATH_PAGE_CART).navigation();
            }
        });
    }
}
