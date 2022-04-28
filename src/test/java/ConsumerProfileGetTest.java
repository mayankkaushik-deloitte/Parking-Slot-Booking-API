import org.testng.annotations.Test;

import java.io.IOException;

public class ConsumerProfileGetTest {
    static ConsumerProfileGet consumerProfileGet1=new ConsumerProfileGet();
    @Test(priority = 1)
    public static void ConsumerProfileGet() throws IOException {
       consumerProfileGet1.ConsumerProfileGet();
    }
}
