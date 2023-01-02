package week1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void queryParam1 () {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("nameContains", "z")
                .when().get("/search");

        System.out.println("response.statusCode() = " + response.statusCode());
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertTrue(response.body().asString().contains("Lorenza"));
    }

    @Test
    public void queryParam2() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("nameContains", "c")
                .and().queryParam("gender", "Female")
                .when().get("/search");

        System.out.println("response.statusCode() = " + response.statusCode());
    }

    @Test
    public void queryParam3() {

        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("nameContains", "c");
        queryMap.put("gender", "Female");

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParams(queryMap)
                .when().get("/search");

        System.out.println("response.statusCode() = " + response.statusCode());
    }
}
