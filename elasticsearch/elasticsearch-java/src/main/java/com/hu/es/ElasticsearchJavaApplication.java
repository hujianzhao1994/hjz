package com.hu.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ElasticsearchJavaApplication {

    private static final String hostname = "localhost";

    private static final int port = 9200;

    public static void main(String[] args) throws IOException {
//        SpringApplication.run(ElasticsearchJavaApplication.class, args);

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost(hostname,port,"http"))
        );


//
//        CreateIndexRequest createIndexRequest = new CreateIndexRequest("user1");
//        CreateIndexResponse response = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
//
//        boolean acknowledged = response.isAcknowledged();
//        // 响应状态
//        System.out.println("操作状态 = " + acknowledged);


        // 查询索引 - 请求对象
        GetIndexRequest getIndexRequest = new GetIndexRequest("user");
        // 发送请求，获取响应
        GetIndexResponse response = client.indices().get(getIndexRequest,
                RequestOptions.DEFAULT);
        System.out.println("aliases:"+response.getAliases());
        System.out.println("mappings:"+response.getMappings());
        System.out.println("settings:"+response.getSettings());


        //删除索引，请求对象
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("user");
        //发送请求，获取结果
        AcknowledgedResponse acknowledgedResponse = client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        // 操作结果
        System.out.println("操作结果 ： " + acknowledgedResponse.isAcknowledged());


        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
