package com.nagappans.featuredemo;

import com.nagappans.featuredemo.beans.CustomerBean;
import com.nagappans.featuredemo.beans.ProductBean;
import com.nagappans.featuredemo.configs.FeatureOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.spi.FeatureProvider;
import org.togglz.core.user.FeatureUser;
import org.togglz.core.user.SimpleFeatureUser;
import org.togglz.core.user.UserProvider;

@SpringBootApplication
@ComponentScan(basePackages= {"com.nagappans.featuredemo"})
@EnableWebSecurity
public class TogglzWorkout {

    public static void main(String[] args) {
        SpringApplication.run(TogglzWorkout.class, args);}

    @Bean
    public FeatureProvider featureProvider() {
        return new EnumBasedFeatureProvider(FeatureOptions.class);
    }

    @Bean
    public UserProvider getUserProvider() {
        System.out.println("**getting the user provider");

        return new UserProvider() {
            @Override
            public FeatureUser getCurrentUser() {
                System.out.println("**inside the current user" +  SecurityContextHolder.getContext().getAuthentication().toString());
                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                String username = ((UserDetails) principal).getUsername();
                return new SimpleFeatureUser(username, true);
            }
        };
    }

    @Bean
    public CustomerBean customerBean(FeatureManager featureManager) {
        if (featureManager.isActive(FeatureOptions.CUSTOMERBEANFEATURE)) {
            System.out.println("customer bean feature activte");
            return new CustomerBean(featureManager);
        }
        System.out.println("inside customer bean");
        System.out.println(featureManager);
        return null;
    }

    @Bean
    @Lazy(true)
    public ProductBean productBean() {
        System.out.println("product bean started..");
        return new ProductBean();
    }
}