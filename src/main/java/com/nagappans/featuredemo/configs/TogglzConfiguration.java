package com.nagappans.featuredemo.configs;

import org.springframework.context.annotation.Configuration;
import org.togglz.core.Feature;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.file.FileBasedStateRepository;
import org.togglz.core.repository.mem.InMemoryStateRepository;
import org.togglz.core.user.UserProvider;
import org.togglz.spring.security.SpringSecurityUserProvider;

import java.io.File;

@Configuration
public class TogglzConfiguration implements TogglzConfig {

    public Class<? extends Feature> getFeatureClass() {
        return FeatureOptions.class;
    }

    public StateRepository getStateRepository() {
        return new InMemoryStateRepository();
    }

    public UserProvider getUserProvider() {
        return new SpringSecurityUserProvider("admin");
    }
}
