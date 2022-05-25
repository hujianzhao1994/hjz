package com.jr.util;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.jr.formater.DateDerializer;
import com.jr.formater.LocalDateTimeDerializer;
import com.jr.formater.LocalDateTimeJsonSerializer;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class JsonUtil {
    //https://github.com/jayway/JsonPath
//https://www.baeldung.com/jackson-annotations
    public static String getJsonString(Object obj) {
        ObjectMapper mapper = getMapper();
        String ret = "";
        try {
            ret = mapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static ObjectMapper getMapper(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        //DeserializationConfig cfg = mapper.getDeserializationConfig();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX,true);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        //mapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE,true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true) ;////允许出现特殊字符和转义符
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Date.class, new DateDerializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDerializer());
        module.addSerializer(LocalDateTime.class,new LocalDateTimeJsonSerializer());
        mapper.registerModule(module);
        return mapper;
    }

    public static <T> T getJsonObject(String inputStr, Class<T> clazz) {
        ObjectMapper mapper = getMapper();
        try {
            T req = mapper.readValue(inputStr, clazz);
            return req;
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }
}

