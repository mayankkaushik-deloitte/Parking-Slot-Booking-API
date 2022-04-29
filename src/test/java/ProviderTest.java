import org.testng.annotations.Test;
import java.io.IOException;
import static org.hamcrest.MatcherAssert.assertThat;
public class ProviderTest {
    static ProviderSignup provider = new ProviderSignup();
    static ProviderProfile profile = new ProviderProfile();
    static ProviderParking parking = new ProviderParking();
    static ProviderBookingStats stats = new ProviderBookingStats();
    static ParkingInfo info = new ParkingInfo();
    static ProviderBooking booking = new ProviderBooking();
    static ProviderBookingEntryExit entry = new ProviderBookingEntryExit();
    static ParkingBookignPaid paid = new ParkingBookignPaid();
    static ConsumerBookingReview review = new ConsumerBookingReview();
    @Test(priority = 1)
    public static void providerregisterpost() throws IOException {
        provider.Providersignuppost();
    }
    @Test(priority = 2)
    public static void providerregisterget() throws IOException {
        provider.userRegister();
        provider.userLogin();
    }
    @Test(priority = 3)
    public static void providerprofile() throws IOException {
        profile.providerprofile();
    }
    @Test(priority = 4)
    public static void providerprofileget() throws IOException {
        profile.providerget();
    }
    @Test(priority = 5)
    public static void providerparking() throws IOException{
        parking.providerparking();
    }
    @Test(priority = 6)
    public static void providerparkingget() throws IOException{
        parking.providerparkingget();
    }
    @Test(priority = 7)
    public static void parkinginfo() throws IOException{
        info.providerparkinginfo();

    }
    @Test(priority = 8)
    public static void parkinginfoid() throws IOException{
        info.providerparkinginfoid();
    }
    @Test(priority = 9)
    public static void parkingstats() throws IOException{
        stats.providerbookingstats();
    }
    @Test(priority = 10)
    public static void providerbookingget() throws IOException{
        booking.providerbooking();
    }
    @Test(priority = 11)
    public static void providerbookinggetid() throws IOException{
        booking.providerbookingid();
    }
    @Test(priority = 12)
    public static void providerbookingentry() throws IOException{
        entry.providerbookingentry();
    }
    @Test(priority = 13)
    public static void providerbookingexit() throws IOException{
        entry.providerbookingexit();
    }
    @Test(priority = 14)
    public static void providerpaidget() throws IOException{
        paid.providerparkingpaidget();
    }
    @Test(priority = 15)
    public static void providerpaidpost() throws IOException{
        paid.providerparkingpaidpost();
    }
    @Test(priority = 16)
    public static void consumerreviewpost() throws IOException{
        review.consumerreview();
    }
    @Test(priority = 17)
    public static void consumerreviewget() throws IOException{
        review.consumerreviewget();
    }
}
