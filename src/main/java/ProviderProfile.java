import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import java.io.IOException;
import static io.restassured.RestAssured.given;
public class ProviderProfile {
    public void providerprofile() throws IOException {
        RestAssured.useRelaxedHTTPSValidation();
        ExcelData ed = new ExcelData();
        String accesstoken = ed.getString(1,1, 5);
        data dt = new data(accesstoken);
        String firstname = ed.getString(1, 3, 0);
        String lastname = ed.getString(1, 3, 1);
        String phonenumer = ed.getString(1, 3, 2);
        String pincode = ed.getString(1, 3, 3);
        String address1 = ed.getString(1, 3, 4);
        String address2 = ed.getString(1, 3, 5);
        String district = ed.getString(1, 3, 6);
        String state = ed.getString(1, 3, 7);
        String country = ed.getString(1, 3, 8);
        JSONObject object= new JSONObject();
        given().
                contentType("multipart/form-data").
                multiPart("first_name", firstname).
                multiPart("last_name",lastname).
                multiPart("phone_number",phonenumer).
                multiPart("pincode",pincode).
                multiPart("address1",address1).
                multiPart("address2",address2).
                multiPart("district",district).
                multiPart("state",state).
                multiPart("country",country).
                headers(
                        "Authorization",
                        "JWT " + accesstoken,
                        "Content-Type",
                        "multipart/form-data",
                        "Accept",
                        ContentType.JSON
                ).
                when().
                post("https://plb-be-urtjok3rza-wl.a.run.app/api/provider/profile/").
                then().
                log().body().
                statusCode(HttpStatus.SC_CREATED);
    }
    public void providerget() throws IOException
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
                get("https://plb-be-urtjok3rza-wl.a.run.app/api/provider/profile/").
                then().
                log().body().
                statusCode(HttpStatus.SC_OK);

    }
}
