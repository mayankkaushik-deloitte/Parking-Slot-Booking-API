import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

public class ConsumerSignupTest {
    static ConsumerSignup consumer = new ConsumerSignup();
    @Test(priority = 1)
    public static void consumersignup() throws IOException {
        consumer.Consumersignup();
    }
    @Test(priority = 2)
    public static void consumerlogin() throws IOException {
        consumer.userRegister();
        consumer.userLogin();
    }
}
