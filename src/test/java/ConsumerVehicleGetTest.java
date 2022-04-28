import org.testng.annotations.Test;

import java.io.IOException;

public class ConsumerVehicleGetTest {
    static ConsumerVehicleGet vehicleGet = new ConsumerVehicleGet();
    @Test(priority = 2)
    public void Consumerget() throws IOException {
        vehicleGet.ConsumerVehicleget();
    }
}

