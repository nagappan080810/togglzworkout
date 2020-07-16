package com.nagappans.featuredemo.configs;

import org.togglz.core.Feature;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum FeatureOptions implements  Feature {

    @EnabledByDefault
    @Label("First Feature")
    FEATURE_ONE,

    @EnabledByDefault
    @Label("Greetings Feature")
    GREETINGSFEATURE;

    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }
}
