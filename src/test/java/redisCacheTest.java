import com.cetiti.core.cache.RedisCache;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class redisCacheTest extends BaseTest {

    @Autowired
    private RedisCache redisCache;
    @Test
    public void testPutCache() {
        String value = "LogCache";
        redisCache.putCache("LogCache",value);
    }

}
