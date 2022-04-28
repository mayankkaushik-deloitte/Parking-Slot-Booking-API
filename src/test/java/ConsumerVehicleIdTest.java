import org.testng.annotations.Test;

import java.io.IOException;

public class ConsumerVehicleIdTest {
    static ConsumerVehicleID vehicleGet = new ConsumerVehicleID();
    @Test(priority = 1)
    public void ConsumerVeicleId() throws IOException {
        vehicleGet.ConsumerVehicleIdMethod();
    }
}

