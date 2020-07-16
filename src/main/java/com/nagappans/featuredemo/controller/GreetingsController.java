package com.nagappans.featuredemo.controller;

import com.nagappans.featuredemo.configs.FeatureOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.manager.FeatureManager;

@RestController
@RequestMapping(value = "/api")
public class GreetingsController {

    private FeatureManager manager;

    public GreetingsController(FeatureManager manager) {
        this.manager = manager;
    }

    @GetMapping(value = "/helloworld/{name}")
    public String greeter(@PathVariable("name") String name) {
        // Other way to check - this.manager.isActive(FeatureOptions.GREETINGSFEATURE);
        if (FeatureOptions.GREETINGSFEATURE.isActive()) {
            return "Hello " + name;
        }
        return "It is not active";
    }


}