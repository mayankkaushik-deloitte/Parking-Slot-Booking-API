import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.IOException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class ConsumerSignup {
    @Test(priority = 1)
    public void userRegister() throws IOException {
        RestAssured.useRelaxedHTTPSValidation();
        ExcelData ed = new ExcelData();
        String email = ed.getString(0, 1, 0);
        String password = ed.getString(0, 1, 1);
        data dt = new data(email, password);
        Response response=given().
                body(dt).
                contentType(ContentType.JSON).
                when().
                post("https://plb-be-urtjok3rza-wl.a.run.app/api/jwt/create/").
                then().
                log().body().
                statusCode(HttpStatus.SC_OK).extract().response();
        JSONObject jsonObject = new JSONObject(response.asString());
        Object ObjToken = jsonObject.get("access");
        System.out.println(ObjToken);
        ExcelData excelData = new ExcelData();
        excelData.writeToken(ObjToken,1,2);
    }
    @Test(priority = 2)
    public void userLogin() throws IOException {
        RestAssured.useRelaxedHTTPSValidation();
        ExcelData ed = new ExcelData();
        String accesstoken = ed.getString(0,1, 2);
        data dt = new data(accesstoken);
                given().
                //body("JWT " +dt).
                        headers(
                        "Authorization",
                        "JWT " + accesstoken,
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
}
