package com.android.export_cart;

/**
 * 购物车组件路由表
 * 即 购物车组件中 所有可以从外部跳转的页面 的路由信息
 *
 * @author hufeiyang
 */
public interface CartRouterTable {
    public static final String MODULE1_ACTIVITY = "/module1/Module1Activity";

    /**
     * 购物车页面
     */
    String PATH_PAGE_CART = "/cart/cartActivity";

    /**
     * 购物车服务
     */
    String PATH_SERVICE_CART = "/cart/service";

    //    cat页面
    String PATH_FRAGMENT_CART = "/cart/CartFragment";

}