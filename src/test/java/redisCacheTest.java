import com.cetiti.core.cache.RedisCache;
import com.cetiti.core.annotation.LogInject;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class redisCacheTest extends BaseTest {

    @LogInject
    private static Logger log;
    @Autowired
    private RedisCache redisCache;
    @Test
    public void testPutCache() {
        try {
            String value = "LogCache";
            redisCache.putCache("LogCache",value);
        } catch (Exception e) {
        }
    }

}
