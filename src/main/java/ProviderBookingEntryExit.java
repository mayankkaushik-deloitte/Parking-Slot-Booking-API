import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import java.io.IOException;
import static io.restassured.RestAssured.given;
public class ProviderBookingEntryExit {
    public void providerbookingentry() throws IOException {
        RestAssured.useRelaxedHTTPSValidation();
        ExcelData ed = new ExcelData();
        String accesstoken = ed.getString(1, 1, 5);
        data dt = new data(accesstoken);
        String id = ed.getString(1, 8, 1);
        int id1=Integer.parseInt(id);
        String vehicle = ed.getString(1, 8, 2);
        JSONObject object = new JSONObject();
        object.put("vehicle_number", vehicle);
        String dt1 = object.toString();
        Response response = given().
                pathParam("id",id1).
                body(dt1).
                headers(
                        "Authorization",
                        "JWT " + accesstoken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                contentType(ContentType.JSON).
                post("https://plb-be-urtjok3rza-wl.a.run.app/api/provider/bookings/{id}/entry/").
                then().
                log().body().
                statusCode(HttpStatus.SC_OK).extract().response();
    }
    public void providerbookingexit() throws IOException {
        RestAssured.useRelaxedHTTPSValidation();
        ExcelData ed = new ExcelData();
        String accesstoken = ed.getString(1, 1, 5);
        data dt = new data(accesstoken);
        String id = ed.getString(1, 8, 1);
        int id1=Integer.parseInt(id);
        String vehicle = ed.getString(1, 8, 2);
        JSONObject object = new JSONObject();
        object.put("vehicle_number", vehicle);
        String dt1 = object.toString();
        Response response = given().
                pathParam("id",id1).
                body(dt1).
                headers(
                        "Authorization",
                        "JWT " + accesstoken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                contentType(ContentType.JSON).
                post("https://plb-be-urtjok3rza-wl.a.run.app/api/provider/bookings/{id}/exit/").
                then().
                log().body().
                statusCode(HttpStatus.SC_OK).extract().response();
    }
}
