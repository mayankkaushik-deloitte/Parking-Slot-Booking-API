import org.testng.annotations.Test;

import java.io.IOException;

public class ConsumerProfileTest1 {
    static ConsumerProfile1 ConsumerProfile1=new ConsumerProfile1();
    @Test(priority = 1)
    public static void ConsumerProfileCreate() throws IOException {
        ConsumerProfile1.consumerprofile1();
    }
}
