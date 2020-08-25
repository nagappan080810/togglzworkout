package com.nagappans.featuredemo.conditions;

import com.nagappans.featuredemo.beans.ProductBean;
import com.nagappans.featuredemo.configs.FeatureOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import org.togglz.core.manager.FeatureManager;
import org.togglz.spring.listener.TogglzApplicationContextBinderApplicationListener;

@Component
public class SpringTogglzListener extends TogglzApplicationContextBinderApplicationListener {

    @Autowired
    DefaultListableBeanFactory beanFactory;

    @Autowired
    ApplicationContext applicationContext;

    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("Wow! Togglz application context binder initialized!!!");
        FeatureManager featureManager = (FeatureManager) beanFactory.getBean(FeatureManager.class);
        System.out.println(featureManager.isActive(FeatureOptions.PRODUCTBEANFEATURE));
        if (featureManager.isActive(FeatureOptions.PRODUCTBEANFEATURE))
            System.out.println(beanFactory.getBean("productBean"));
    }
}
