package com.hu.annotation.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource(value ={"classpath:/gookerInfo.properties"})  //指定路径下的配置文件  https://blog.csdn.net/qq_37312838/article/details/108237678
@ConfigurationProperties(prefix = "com.gooker",ignoreUnknownFields = false)
public class GookerProperties {

    private String companyName = "gooker";

    private Integer personNum ;
}