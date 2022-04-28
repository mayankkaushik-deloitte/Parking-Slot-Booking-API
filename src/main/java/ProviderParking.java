import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import static io.restassured.RestAssured.given;
public class ProviderParking{
    public void providerparking() throws IOException {
        RestAssured.useRelaxedHTTPSValidation();
        ExcelData ed = new ExcelData();
        String accesstoken = ed.getString(1,1, 5);
        data dt = new data(accesstoken);
        String name = ed.getString(1, 6, 0);
        String pincode = ed.getString(1, 6, 1);
        String address1 = ed.getString(1, 6, 2);
        String address2 = ed.getString(1, 6, 3);
        String district = ed.getString(1, 6, 4);
        String state = ed.getString(1, 6, 5);
        String country = ed.getString(1, 6, 6);
        String open = ed.getString(1, 6, 7);
        String close = ed.getString(1, 6, 8);
        JSONObject object= new JSONObject();
        given().
                contentType("multipart/form-data").
                multiPart("image", new File("data/img.png")).
                multiPart("name", name).
                multiPart("slots","100").
                multiPart("pincode",pincode).
                multiPart("address1",address1).
                multiPart("address2",address2).
                multiPart("district",district).
                multiPart("state",state).
                multiPart("country",country).
                multiPart("lat","12").
                multiPart("lon","13").
                multiPart("opening_time",open).
                multiPart("closing_time",close).
                headers(
                        "Authorization",
                        "JWT " + accesstoken,
                        "Content-Type",
                        "multipart/form-data",
                        "Accept",
                        ContentType.JSON
                ).
                when().
                post("https://plb-be-urtjok3rza-wl.a.run.app/api/provider/parking/").
                then().
                log().body().
                statusCode(HttpStatus.SC_CREATED);
    }
    public void providerparkingget() throws IOException
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
                get("https://plb-be-urtjok3rza-wl.a.run.app/api/provider/parking/").
                then().
                log().body().
                statusCode(HttpStatus.SC_OK);
    }
}
