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
@ContextConfiguration(locations = {"classpath*:spring/spring-redis.xml","classpath*:spring/spring-jms.xml","classpath*:spring/spring-service.xml","classpath*:spring/spring-dao.xml"})
public class BaseTest {


}
