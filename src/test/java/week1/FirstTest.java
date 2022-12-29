package week1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FirstTest {

    String baseUrl = "http://54.234.104.66:8000/api/spartans";

    @Test
    public void test1 () {

        Response response = RestAssured.get(baseUrl);

       System.out.println("response.statusCode() = " + response.statusCode());

       // response.prettyPrint();

        Assertions.assertEquals(200, response.statusCode());

     //   response.prettyPeek();

    }
}
