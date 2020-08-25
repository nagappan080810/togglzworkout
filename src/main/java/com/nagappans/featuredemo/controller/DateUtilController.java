package com.nagappans.featuredemo.controller;

import com.nagappans.featuredemo.configs.FeatureOptions;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.Feature;
import org.togglz.core.context.FeatureContext;
import org.togglz.core.manager.FeatureManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;
import java.util.TimeZone;

@RestController
@RequestMapping(value = "/api")
public class DateUtilController {

    @Autowired
    private BeanFactory beanFactory;

    private FeatureManager manager;

    public DateUtilController(FeatureManager manager) {
        this.manager = manager;
        System.out.println("i am in date util controller");
        Set<Feature> features = this.manager.getFeatures();
        System.out.println(this.beanFactory);
        for (Feature feature1: features) {
            System.out.println(feature1.name());
            //System.out.println(this.manager.isActive(feature1));
        }
        System.out.println(this.manager.getFeatures());
    }

    @RequestMapping(value="/timezoneconversions")
    public String convertTimezone(@RequestParam("timezone") String timezone) {
        if (!this.manager.isActive(FeatureOptions.TIMEZONECONVERSION)) {
            return "Feature is not active";
        }
        System.out.println(this.manager.getFeatureState(FeatureOptions.TIMEZONECONVERSION));
        System.out.println(this.manager.getCurrentFeatureUser().getName());
        Calendar currentdate = Calendar.getInstance();
        DateFormat formatter= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone(timezone));
        String convertedDate = formatter.format(currentdate.getTime());
        formatter.setTimeZone(TimeZone.getTimeZone(timezone));
        return convertedDate;
    }

    @RequestMapping(value="/currenttimezone")
    public String getServerTimezone() {
        if (this.manager.isActive(FeatureOptions.CURRENTTZFEATURE)) {
            return TimeZone.getDefault().getDisplayName();
        } else {
            return "Feature not active";
        }
    }

//    public static void main(String args[]) {
//        DateUtilController dateUtilController = new DateUtilController();
//        System.out.println(dateUtilController.convertTimezone("America/New_York"));
//    }
}
