import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ConsumerVehicleID{
    public void ConsumerVehicleIdMethod() throws IOException {

        RestAssured.useRelaxedHTTPSValidation();
        ExcelData ed = new ExcelData();
        String accesstoken = ed.getString(0, 1, 5);
        data dt = new data(accesstoken);
        String id = ed.getString(0, 5, 0);
        int id1 = Integer.parseInt(id);
        Response response = given().
                pathParam("id", id1).
                headers(
                        "Authorization",
                        "JWT " + accesstoken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                contentType(ContentType.JSON).
                get("https://plb-be-urtjok3rza-wl.a.run.app/api/consumer/vehicles/{id}/").
                then().
                log().body().
                statusCode(HttpStatus.SC_OK).extract().response();

    }
}

