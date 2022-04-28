import org.testng.annotations.Test;

import java.io.IOException;

public class ConsumerBookingsTest {
    static ConsumerBookings consumerBookings = new ConsumerBookings();
    @Test(priority = 1)
    public void bookingsPost() throws IOException {
        consumerBookings.consumerBookingPost();
    }
    @Test(priority = 2)
    public void bookingGet() throws IOException {
        consumerBookings.consumerBookingGet();
    }
    @Test(priority = 3)
    public void bookingStatsGet() throws IOException {
        consumerBookings.bookingStatus();
    }
    @Test(priority = 4)
    public void bookingIdGet() throws IOException {
        consumerBookings.bookingIdGet();
    }
}
