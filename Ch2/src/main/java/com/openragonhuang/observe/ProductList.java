package com.openragonhuang.observe;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ProductList extends Observable {
    private List<String> productList = new LinkedList<>();
    private static ProductList instance;

    private ProductList(){}

    public static ProductList getInstance(){
    /*
        效率不高
        synchronized(ProductList.class){
            if(instance == null){
                instance = new ProductList();
            }
        }
    */
        if(instance == null){
            synchronized(ProductList.class){
                if(instance == null){
                    instance = new ProductList();
                }
            }
        }
        return instance;
    }

    /**
     * 添加产品列表的观察者
     * @param observer 待添加的观察者
     */
    public void addProductListObserver(Observer observer){
        this.addObserver(observer);
    }

    public void addProduct(String newProduct){
        productList.add(newProduct);
        System.out.println("产品列表新增了产品："+newProduct);
        this.setChanged();
        this.notifyObservers(newProduct);
    }
}
