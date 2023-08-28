package com.android.module1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.android.export_cart.CartRouterTable;
import com.android.export_cart.CartServiceUtil;

//添加注解@Route，指定路径
@Route(path = CartRouterTable.PATH_FRAGMENT_CART)
public class CartFragment extends Fragment {
    public CartFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //显示“cart_fragment"
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.fragment_cart_tv);
        textView.setText("购物车数量"+ CartServiceUtil.getCartProductCount().productCount);
    }
}