import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import java.io.IOException;
import static io.restassured.RestAssured.given;
public class ParkingBookignPaid {
    public void providerparkingpaidget() throws IOException
    {
        RestAssured.useRelaxedHTTPSValidation();
        ExcelData ed = new ExcelData();
        String accesstoken = ed.getString(1,1, 5);
        String id = ed.getString(1, 8, 1);
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
                get("https://plb-be-urtjok3rza-wl.a.run.app/api/provider/bookings/{id}/paid/").
                then().
                log().body().
                statusCode(HttpStatus.SC_OK);

    }
    public void providerparkingpaidpost() throws IOException
    {
        RestAssured.useRelaxedHTTPSValidation();
        ExcelData ed = new ExcelData();
        String accesstoken = ed.getString(1,1, 5);
        String id = ed.getString(1, 8, 1);
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
                post("https://plb-be-urtjok3rza-wl.a.run.app/api/provider/bookings/{id}/paid/").
                then().
                log().body().
                statusCode(HttpStatus.SC_OK);

    }
}
