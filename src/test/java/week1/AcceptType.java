package week1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class AcceptType {

    String baseUrl = "http://54.234.104.66:8000/api/spartans";

    @Test
    public void acceptType() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(baseUrl);

        System.out.println("response.statusCode() = " + response.statusCode());

       // response.prettyPeek();

        System.out.println("response.contentType() = " + response.contentType());
    }
}
