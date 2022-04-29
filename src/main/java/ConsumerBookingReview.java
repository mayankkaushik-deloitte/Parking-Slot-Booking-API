import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import java.io.IOException;
import static io.restassured.RestAssured.given;
public class ConsumerBookingReview {
    public void consumerreview() throws IOException
    {
        RestAssured.useRelaxedHTTPSValidation();
        ExcelData ed = new ExcelData();
        String accesstoken = ed.getString(0,1, 5);
        String id = ed.getString(0, 10, 0);
        int id1=Integer.parseInt(id);
        String rating = ed.getString(0,11,1);
        String review = ed.getString(0,11,2);
        JSONObject object= new JSONObject();
        object.put("rating",rating);
        object.put("review",review);
        String dt1 = object.toString();
        data dt = new data(accesstoken);
        given().
                pathParam("id",id1).
                body(dt1).
                contentType(ContentType.JSON).

                headers(
                        "Authorization",
                        "JWT " + accesstoken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                contentType(ContentType.JSON).
                when().
                post("https://plb-be-urtjok3rza-wl.a.run.app/api/consumer/bookings/{id}/review/").
                then().
                log().body().
                statusCode(HttpStatus.SC_CREATED);

    }
    public void consumerreviewget() throws IOException
    {
        RestAssured.useRelaxedHTTPSValidation();
        ExcelData ed = new ExcelData();
        String accesstoken = ed.getString(0,1, 5);
        String id = ed.getString(0, 10, 0);
        int id1=Integer.parseInt(id);
        data dt = new data(accesstoken);
        given().
                pathParam("id",id1).
                contentType(ContentType.JSON).

                headers(
                        "Authorization",
                        "JWT " + accesstoken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                contentType(ContentType.JSON).
                when().
                get("https://plb-be-urtjok3rza-wl.a.run.app/api/consumer/bookings/{id}/review/").
                then().
                log().body().
                statusCode(HttpStatus.SC_OK);

    }
}
