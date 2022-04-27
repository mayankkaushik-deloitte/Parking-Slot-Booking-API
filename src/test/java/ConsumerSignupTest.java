import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

public class ConsumerSignupTest {
    static ConsumerSignup consumer = new ConsumerSignup();
    @Test(priority = 1)
    public static void userlogin() throws IOException {
        consumer.userRegister();
    }
    @Test(priority = 2)
    public static void userbookings() throws IOException {
        consumer.userLogin();
    }

}
