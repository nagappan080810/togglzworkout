package com.nagappans.featuredemo.conditions;

import com.nagappans.featuredemo.configs.FeatureOptions;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.togglz.core.Feature;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.spi.FeatureProvider;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Consumer;


public class MyCondition implements Condition {

    private FeatureManager featureManager;

//    public MyCondition(Optional<FeatureManager> featureManager) {
//        if (featureManager.isPresent()) {
//            this.featureManager = featureManager.get();
//            System.out.println("it is a feature manager");
//        }
//    }

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        System.out.println("feature manager available");
        System.out.println(featureManager);
        FeatureManager featureManager = (FeatureManager) conditionContext.getBeanFactory().getBean(FeatureManager.class);
        System.out.println(featureManager.getFeatures());
        Iterator<String> iterator = conditionContext.getBeanFactory().getBeanNamesIterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());
        return true;
    }
}
