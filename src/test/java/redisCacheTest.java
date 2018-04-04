import com.cetiti.dsp.cache.RedisCache;
import com.cetiti.dsp.core.annotation.LogInject;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class redisCacheTest extends BaseTest {

    @Autowired
    private RedisCache redisCache;
    @LogInject
    private static Logger log;
    @Test
    public void testPutCache() {
        try {
            String value = "LogCache";
            redisCache.putCache("LogCache",value);
            log.info("redis 成功");
        } catch (Exception e) {
            log.info("redis Erro");
        }
    }

}
