import org.testng.annotations.Test;

import java.io.IOException;

public class ConsumerVehicleTest {
    static ConsumerVehicle vehicle = new ConsumerVehicle();

    @Test(priority = 1)
    public static void ConsumerVehicleMethod() throws IOException {
        vehicle.ConsumerVehicleBooking();
    }

}
