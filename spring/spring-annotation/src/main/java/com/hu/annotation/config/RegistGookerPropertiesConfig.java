package com.hu.annotation.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *  通过@EnableConfigurationProperties 注解，使之能够被springboot支持
 */
@Configuration
@EnableConfigurationProperties(GookerProperties.class)
public class RegistGookerPropertiesConfig {

    

}