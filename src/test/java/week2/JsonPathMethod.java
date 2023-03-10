package week2;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class JsonPathMethod {

    @BeforeAll
    public static void setUpBase() {
        baseURI = "http://54.234.104.66:8000";
    }

    @Test
    public void test1() {
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/15");

        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getInt("id"));
        System.out.println(jsonPath.getString("name"));
        System.out.println(jsonPath.getLong("phone"));


    }

    @Test
    public void test2() {
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans");

        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getList("id"));
        System.out.println(jsonPath.getList("phone"));

        List<String> genders = jsonPath.getList("gender");
        System.out.println(genders);

        System.out.println(jsonPath.getString("name[4]"));
    }


}
