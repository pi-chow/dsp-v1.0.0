import com.cetiti.dsp.dao.GoodsDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GoodsDaoTest extends BaseTest {
    @Autowired
    private GoodsDao goodsDao;
    @Test
    public void test(){
        System.out.println(goodsDao.queryAll());
    }
}
