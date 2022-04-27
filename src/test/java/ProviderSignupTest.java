import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
public class ProviderSignupTest {
    static ProviderSignup provider = new ProviderSignup();
    @Test(priority = 1)
    public static void providerregisterpost() throws IOException {
        provider.Providersignuppost();
    }

    @Test(priority = 2)
    public static void providerregisterget() throws IOException {
        provider.userRegister();
        provider.userLogin();
    }
}
