import org.json.JSONObject;
import java.io.IOException;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class ProviderSignup {
    public void Providersignuppost() throws IOException {
        RestAssured.useRelaxedHTTPSValidation();
        ExcelData ed = new ExcelData();
        String pusername = ed.getString(1, 1, 0);
        String prole = ed.getString(1, 1, 1);
        String pemail = ed.getString(1, 1, 2);
        String ppassword = ed.getString(1, 1, 3);
        String prepassword = ed.getString(1, 1, 4);
        JSONObject object= new JSONObject();
        object.put("username",pusername);
        object.put("role",prole);
        object.put("email",pemail);
        object.put("password",ppassword);
        object.put("re_password",prepassword);
        String dt = object.toString();
        Response response = given().
                body(dt).
                contentType(ContentType.JSON).
                when().
                post("https://plb-be-urtjok3rza-wl.a.run.app/api/users/").
                then().
                log().body().
                statusCode(HttpStatus.SC_CREATED).extract().response();
    }
    public void userRegister() throws IOException {
        RestAssured.useRelaxedHTTPSValidation();
        ExcelData ed = new ExcelData();
        String email = ed.getString(1, 1, 2);
        String password = ed.getString(1, 1, 3);
        JSONObject object= new JSONObject();
        object.put("email",email);
        object.put("password",password);
        String dt = object.toString();
        Response response = given().
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
        excelData.writeToken(ObjToken, 1, 1,5);
    }
    public void userLogin() throws IOException {
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
                get("https://plb-be-urtjok3rza-wl.a.run.app/api/users/").
                then().
                log().body().
                statusCode(HttpStatus.SC_OK);
    }
}
