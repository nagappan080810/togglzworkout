package com.nagappans.featuredemo.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

public class ProductBean {
    private String productName;
    private String brandName;

    public ProductBean() {
        System.out.println("Product bean constructor initialized!!!");
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
