package com.nagappans.featuredemo.configs;

import org.togglz.core.Feature;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum FeatureOptions implements  Feature {

    @Label("Greetings Feature")
    GREETINGSFEATURE,

    @Label("Current TZ Feature")
    CURRENTTZFEATURE,

    @Label("Time zone conversion")
    TIMEZONECONVERSION,

    @Label("Customer bean feature")
    CUSTOMERBEANFEATURE,

    @Label("Product bean feature")
    PRODUCTBEANFEATURE;

    public boolean isActive() {
        System.out.println("greetings feature check");
        return FeatureContext.getFeatureManager().isActive(this);
    }
}
