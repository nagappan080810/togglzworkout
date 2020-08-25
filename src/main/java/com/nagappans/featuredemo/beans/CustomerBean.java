package com.nagappans.featuredemo.beans;

import com.nagappans.featuredemo.configs.FeatureOptions;
import org.togglz.core.manager.FeatureManager;

public class CustomerBean {

    public CustomerBean(FeatureManager featureManager) {
        if (featureManager.isActive(FeatureOptions.CUSTOMERBEANFEATURE)) {
            System.out.println("customer bean feature activated");
        }
        System.out.println("customer bean created");
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
