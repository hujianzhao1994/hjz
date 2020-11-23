package com.hu.annotation.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "com.gooker",ignoreUnknownFields = false)
public class GookerProperties {

    private String companyName = "gooker";
}