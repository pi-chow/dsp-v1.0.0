import com.cetiti.dsp.cache.RedisCache;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class redisCacheTest extends BaseTest {

    @Autowired
    private RedisCache redisCache;

    @Test
    public void testPutCache() {
        String value = "cache";
        redisCache.putCache("cache",value);
    }

}
