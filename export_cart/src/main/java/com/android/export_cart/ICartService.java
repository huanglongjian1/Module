package com.android.export_cart;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface ICartService extends IProvider {

    /**
     * 获取购物车中商品数量
     * @return
     */
    CartInfo getProductCountInCart();
}