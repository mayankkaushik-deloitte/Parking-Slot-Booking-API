import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ConsumerBookings {
    public void consumerBookingPost() throws IOException {
        RestAssured.useRelaxedHTTPSValidation();
        ExcelData ed = new ExcelData();
        String accessToken = ed.getString(0,1, 5);
        String entryTime = ed.getString(0, 6, 0);
        String exitTime = ed.getString(0, 6, 1);
        String vehicle = ed.getString(0, 6, 2);
        String parking = ed.getString(0, 6, 3);
        JSONObject object= new JSONObject();
        object.put("entry_time",entryTime);
        object.put("exit_time",exitTime);
        object.put("vehicle",vehicle);
        object.put("parking",parking);
        String data = object.toString();

        given().
                body(data).
                headers(
                        "Authorization",
                        "JWT " + accessToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                contentType(ContentType.JSON).
                when().
                post("https://plb-be-urtjok3rza-wl.a.run.app/api/consumer/bookings/").
                then().
                log().body().
                statusCode(HttpStatus.SC_CREATED);
    }
    public void consumerBookingGet() throws IOException {
        RestAssured.useRelaxedHTTPSValidation();
        ExcelData ed = new ExcelData();
        String accessToken = ed.getString(0,1, 5);
        data dt = new data(accessToken);
        given().
                headers(
                        "Authorization",
                        "JWT " + accessToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                contentType(ContentType.JSON).
                when().
                get("https://plb-be-urtjok3rza-wl.a.run.app/api/consumer/bookings/").
                then().
                log().body().
                statusCode(HttpStatus.SC_OK);
    }
    public void bookingStatus () throws IOException {
        RestAssured.useRelaxedHTTPSValidation();
        ExcelData ed = new ExcelData();
        String accessToken = ed.getString(0, 1, 5);
        data dt = new data(accessToken);
        Response response = given().
                headers(
                        "Authorization",
                        "JWT " + accessToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                contentType(ContentType.JSON).
                get("https://plb-be-urtjok3rza-wl.a.run.app/api/consumer/bookings/stats/").
                then().
                log().body().
                statusCode(HttpStatus.SC_OK).extract().response();
    }
    public void bookingIdGet() throws IOException {
        RestAssured.useRelaxedHTTPSValidation();
        ExcelData ed = new ExcelData();
        String accesstoken = ed.getString(0, 1, 5);
        data dt = new data(accesstoken);
        String id = ed.getString(0, 7, 0);
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
                get("https://plb-be-urtjok3rza-wl.a.run.app/api/consumer/bookings/{id}").
                then().
                log().body().
                statusCode(HttpStatus.SC_OK).extract().response();
    }
}
