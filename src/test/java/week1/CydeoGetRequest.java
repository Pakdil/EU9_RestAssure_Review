package week1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class CydeoGetRequest {

    String baseURI = "https://api.training.cydeo.com";

    @Test
    public void getAllStudents() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(baseURI + "/student/all");

        System.out.println("response.statusCode() = " + response.statusCode());

       // response.prettyPrint();

    }

    @Test
    public void getByStudentId() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(baseURI +"/teacher/all");

        System.out.println("response.statusCode() = " + response.statusCode());
    }
}
