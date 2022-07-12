package com.hu.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hu.es.entity.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ElasticsearchJavaApplicationTests {

    private static final String hostname = "localhost";

    private static final int port = 9200;

    private RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(new HttpHost(hostname,port,"http")));
    @Test
    void contextLoads() {

    }


    /**
     * 创建文档，如果存在，会自动更新
     *
     * @throws IOException ioexception
     */
    @Test
    public void indexRequest() throws IOException {
        //新增文档，请求对象
        IndexRequest indexRequest = new IndexRequest();
        //设置索引及唯一性标识
        indexRequest.index("user").id("1001");
        //创建数据对象
        User user = new User();
        user.setName("胡哥");
        user.setAge(280);
        user.setSex("男");
        ObjectMapper objectMapper = new ObjectMapper();
        String productJson = objectMapper.writeValueAsString(user);

        //添加文档数据，数据格式为JSON
        indexRequest.source(productJson, XContentType.JSON);

        //客户端发送请求，获取响应对象
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        //打印结果信息
        System.out.println("_index:"+ indexResponse.getIndex());
        System.out.println("_id:"+ indexResponse.getId());
        System.out.println("_result:"+ indexResponse.getResult());

    }


    @Test
    public void updateIndexRequest() throws IOException {
        //修改文档，请求对象
        UpdateRequest updateRequest = new UpdateRequest();
        //配置修改参数
        updateRequest.index("user").id("1001");

        //配置请求体，对数据进行修改
        updateRequest.doc(XContentType.JSON,"sex","女");

        //客户端发送请求，获取响应对象
        UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
        //打印结果信息
        System.out.println("_index:"+ updateResponse.getIndex());
        System.out.println("_id:"+ updateResponse.getId());
        System.out.println("_result:"+ updateResponse.getResult());
        System.out.println("_result:"+ updateResponse.getShardInfo());

    }


    @Test
    public void getRequest() throws IOException {
        //1.创建请求对象
        GetRequest request = new GetRequest().index("user").id("1001");
//2.客户端发送请求，获取响应对象
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
////3.打印结果信息
        System.out.println("_index:" + response.getIndex());
        System.out.println("_type:" + response.getType());
        System.out.println("_id:" + response.getId());
        System.out.println("source:" + response.getSourceAsString());

    }

    @Test
    public void deleteRequest() throws IOException {
        //创建请求对象
        DeleteRequest deleteRequest = new DeleteRequest().index("user").id("1");
        //客户端发送请求，获取响应对象
        DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);
        //打印信息
        System.out.println(deleteResponse.toString());
    }

    @Test
    public void bulkRequest() throws IOException {
        //创建批量删除请求对象
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(
                new IndexRequest()
                        .index("user")
                        .id("1001")
                        .source(XContentType.JSON,"name","zhangsan"));
        bulkRequest.add(
                new IndexRequest()
                        .index("user")
                        .id("1002")
                        .source(XContentType.JSON, "name","lisi"));
        bulkRequest.add(
                new IndexRequest()
                        .index("user")
                        .id("1003")
                        .source(XContentType.JSON, "name", "wangwu"));
        //客户端发送请求，获取响应对象
        BulkResponse responses = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        //打印结果信息
        System.out.println("took:" + responses.getTook());
        System.out.println("items:" + responses.getItems());
    }

    @Test
    public void searchRequest() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("student");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        //查询所有数据
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        //查询匹配
        SearchHits hits = searchResponse.getHits();
        System.out.println("took:"+ searchResponse.getTook());
        System.out.println("timeout:"+ searchResponse.isTimedOut());
        System.out.println("total:"+hits.getTotalHits());
        System.out.println("MaxScore: ");
    }
}
