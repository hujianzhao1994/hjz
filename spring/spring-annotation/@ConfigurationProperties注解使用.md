#### @ConfigurationProperties配置模块

​	*`应用场景，在项目开发过程中，存在大量参数配置在application.properties 或application.yml文件中，通过@ConfigurationProperties注解，可以批量获取参数值`*。

1. ##### 新增maven依赖

   ```
   		<!-- Compile dependencies -->
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-autoconfigure</artifactId>
           </dependency>
           <!-- @ConfigurationProperties annotation processing (metadata for IDEs) -->
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-configuration-processor</artifactId>
               <optional>true</optional>
           </dependency>
   ```

   

2. 新增 GookerProperties 类并添加到spring容器

   ```
   @Component
   @Data
   @ConfigurationProperties(prefix = "com.gooker",ignoreUnknownFields = false)
   public class GookerProperties {
   
       private String companyName = "gooker";
   }
   ```

   

3. 通过@EnableConfigurationProperties 注解，使之能够被springboot支持

   ```
   @Configuration
   @EnableConfigurationProperties(GookerProperties.class)
   public class RegistGookerPropertiesConfig {
   
   }
   ```

   

4. 测试使用

   ```
   @SpringBootTest
   class PracApplicationTests {
   
       @Resource
       private GookerProperties gookerProperties;
   
       @Test
       void test1() {
   
           System.out.println(gookerProperties.getCompanyName());
       }
   
   }
   
   ```

5. 参数剖析

   |      参数名称       |                           参数解释                           | 参数默认值 |
   | :-----------------: | :----------------------------------------------------------: | :--------: |
   |        value        |                                                              |            |
   |       prefix        |               前缀，映射properties文件里的前缀               |            |
   | ignoreInvalidFields | 在properties(或yml)定义的字段值类型与实体类中的字段类型不匹配。<br />当ignoreInvalidFields=true ，不会报错<br />当ignoreInvalidFields=false，程序报错 |   false    |
   | ignoreUnknownFields | 在properties或yml 中已经定义的参数，实体类中未定义字段与之匹配，当ignoreUnknownFields=true,会报错，ignoreUnknownFields=false将不会报错 |    true    |

   

   