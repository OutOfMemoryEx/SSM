package com.openragonhuang.observe;

import org.junit.Test;

public class ProductListTest {
    @Test
    public void observeTest(){
        ProductList productList = ProductList.getInstance();
        productList.addProductListObserver(new Taobao());
        productList.addProductListObserver(new JD());
        productList.addProductListObserver(new PDD());
        productList.addProduct("小米8");
        productList.addProduct("努比亚 z11");
    }
}