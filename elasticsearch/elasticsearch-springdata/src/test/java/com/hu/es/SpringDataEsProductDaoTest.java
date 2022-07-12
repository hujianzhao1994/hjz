package com.hu.es;

import com.hu.es.dao.ProductDao;
import com.hu.es.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataEsProductDaoTest {

    @Autowired
    private ProductDao productDao;


    @Test
    public void save(){
        Product product = new Product();
        product.setId(1000L);
        product.setTitle("名称");
        product.setCategory("分类");
        product.setPrice(0.0D);
        product.setImages("https://gzxf.vpclub.cn/api/basic/api/obs/2fe105520fe34812928824c4b30a682e/3008841d2250448ba5fa47af333a02a6_gzxf_微信图片_20220520160046.jpg");
        productDao.save(product);
    }

}
