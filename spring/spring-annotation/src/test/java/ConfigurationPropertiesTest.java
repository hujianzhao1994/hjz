import com.hu.AnnocationStar;
import com.hu.annotation.config.GookerProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author hjz
 * @Create 2020/11/23 16:05
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AnnocationStar.class)
public class ConfigurationPropertiesTest {



    @Resource
    private GookerProperties gookerProperties;

    @Test
    public void test1() {
        System.out.println(gookerProperties.getCompanyName());
    }
}
