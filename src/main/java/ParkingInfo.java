import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import static io.restassured.RestAssured.given;
public class ParkingInfo {
    public void providerparkinginfo() throws IOException
    {
        RestAssured.useRelaxedHTTPSValidation();
        ExcelData ed = new ExcelData();
        String accesstoken = ed.getString(1,1, 5);
        data dt = new data(accesstoken);
        given().
                headers(
                        "Authorization",
                        "JWT " + accesstoken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                contentType(ContentType.JSON).
                when().
                get("https://plb-be-urtjok3rza-wl.a.run.app/api/parking/info/").
                then().
                log().body().
                statusCode(HttpStatus.SC_OK);

    }
    public void providerparkinginfoid() throws IOException
    {
        RestAssured.useRelaxedHTTPSValidation();
        ExcelData ed = new ExcelData();
        String accesstoken = ed.getString(1,1, 5);
        String id = ed.getString(1, 8, 0);
        int id1=Integer.parseInt(id);
        data dt = new data(accesstoken);
        given().
                contentType(ContentType.JSON).
                pathParam("id",id1).
                headers(
                        "Authorization",
                        "JWT " + accesstoken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                contentType(ContentType.JSON).
                when().
                get("https://plb-be-urtjok3rza-wl.a.run.app/api/parking/info/{id}").
                then().
                log().body().
                statusCode(HttpStatus.SC_OK);

    }
}
