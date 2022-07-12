package com.hu.es.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "shopping",shards = 3,replicas = 1)
public class Product {

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private Long id; //商品唯一标识

    private String title; //商品名称
    @Field(type = FieldType.Keyword)
    private String category; // 分类名称
    @Field(type = FieldType.Double)
    private Double price; //商品价格
    @Field(type = FieldType.Keyword, index = false)
    private String images; //图片地址


}
