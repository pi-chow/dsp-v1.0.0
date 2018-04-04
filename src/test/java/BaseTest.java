import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置spring和junit整合，junit启动加载springIOC容器 spring-test,junit
 *
 * @author zhouliyu
 * */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring 配置文件
@ContextConfiguration(locations = {"classpath*:spring/spring-bean.xml","classpath*:spring/spring-redis.xml"})
public class BaseTest {


}
