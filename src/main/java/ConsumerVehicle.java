

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import java.io.IOException;
import static io.restassured.RestAssured.given;
public class ConsumerVehicle {
    public void ConsumerVehicleBooking() throws IOException {
        RestAssured.useRelaxedHTTPSValidation();
        ExcelData ed = new ExcelData();
        String accesstoken = ed.getString(0,1, 5);
        data dt = new data(accesstoken);
        String vehicleNumber = ed.getString(0, 4, 0);
        String type = ed.getString(0, 4, 1);
        String identificationMark = ed.getString(0, 4, 2);
        String manufacturer = ed.getString(0, 4, 3);
        JSONObject object= new JSONObject();
        given().
                contentType("multipart/form-data").
                multiPart("vehicle_number", vehicleNumber).
                multiPart("type",type).
                multiPart("identification_mark",identificationMark).
                multiPart("manufacturer",manufacturer).
                headers(
                        "Authorization",
                        "JWT " + accesstoken,
                        "Content-Type",
                        "multipart/form-data",
                        "Accept",
                        ContentType.JSON
                ).
                when().
                post("https://plb-be-urtjok3rza-wl.a.run.app/api/consumer/vehicles/").
                then().
                log().body().
                statusCode(HttpStatus.SC_CREATED);
    }


}
