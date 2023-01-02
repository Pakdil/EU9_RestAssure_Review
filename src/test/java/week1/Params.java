package week1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;

public class Params {


    @BeforeAll
    public static void setUpBase() {
        baseURI = "http://54.234.104.66:8000/api/spartans";

    }

    @Test
    public void pathParams() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 15)
                .when().get("/{id}");

        System.out.println("response.statusCode() = " + response.statusCode());
        response.prettyPrint();
        Assertions.assertTrue(response.body().asString().contains("Meta"));

    }

    @Test
    public void getSpartanNegativeTest() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 4500)
                .when().get("/{id}");

        System.out.println("response.statusCode() = " + response.statusCode());

        Assertions.assertEquals(404, response.statusCode());

        Assertions.assertTrue(response.body().asString().contains("Not Found"));
    }
}
