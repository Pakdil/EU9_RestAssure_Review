package week2;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RedirectSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PathMethodReview {

    @BeforeAll
    public static void setUpBase() {
        baseURI = "http://54.234.104.66:8000";
    }

    @Test
    public void test1() {

        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/15");

        System.out.println(response.statusCode());
        response.prettyPrint();

        System.out.println(response.path("name").toString());
        System.out.println(response.path("phone").toString());
    }


    @Test
    public void test2() {

        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans");

        //response.prettyPrint();
        System.out.println(response.path("name").toString());
        System.out.println(response.path("name[9]").toString());

    }

    @Test
    public void test3() {
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("nameContains", "m")
                .when().get("/api/spartans/search");

       // response.prettyPrint();
        System.out.println(response.path("content.phone[1]").toString());
        List<String> names = response.path("content.name");
        System.out.println("names = " + names);
    }
}
