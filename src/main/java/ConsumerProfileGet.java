import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import java.io.IOException;
import static io.restassured.RestAssured.given;
public class ConsumerProfileGet {
    public void ConsumerProfileGet() throws IOException
    {
        RestAssured.useRelaxedHTTPSValidation();
        ExcelData ed = new ExcelData();
        String accesstoken = ed.getString(0,1, 5);
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
                get("https://plb-be-urtjok3rza-wl.a.run.app/api/consumer/profile/").
                then().
                log().body().
                statusCode(HttpStatus.SC_OK);
    }
}