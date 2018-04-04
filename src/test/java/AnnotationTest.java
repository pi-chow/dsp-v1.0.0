import com.cetiti.dsp.annotation.Message;
import org.junit.Test;

public class AnnotationTest {

    @Message(num = 10)
    private static int a;

    @Test
    @Message(num = 10, name = "jason")
    public void test(){
        System.out.println(a);
    }
}
