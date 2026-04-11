package com.session05baitap.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Root Application Context Configuration
 * Quét các @Service, @Repository, và @Component (trừ @Controller)
 */
@Configuration
@ComponentScan(basePackages = "com.session05baitap",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class))
public class RootConfig {
}

