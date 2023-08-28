package com.android.module1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.android.export_cart.CartRouterTable;
import com.android.export_cart.CartServiceUtil;

@Route(path = CartRouterTable.PATH_PAGE_CART)
public class CartActivity extends AppCompatActivity {
    @Autowired()
    String key1;
    @Autowired()
    String key2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ARouter.getInstance().inject(this);
        TextView textView = findViewById(R.id.tv_cart_product_count);
        textView.setText("参数" + key1 + ":" + key2 + "\n" + "购物车商品数量:" + CartServiceUtil.getCartProductCount().productCount);
    }
}