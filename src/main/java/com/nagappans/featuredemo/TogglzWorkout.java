package com.nagappans.featuredemo;

import com.nagappans.featuredemo.configs.FeatureOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.spi.FeatureProvider;

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
}