package week1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class SpartanTest {

    String baseUrl = "http://54.234.104.66:8000/api/spartans";


    @Test
    public void bodyValidation() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(baseUrl);

        System.out.println(response.body().asString().contains("Nels"));


    }

    @Test
    public void getHeaders() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(baseUrl);

        System.out.println(response.getHeaders());
    }

    @Test
    public void getHeadersList() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(baseUrl);

        List<Headers> headers = Collections.singletonList(response.headers());

        System.out.println(headers.toString());

       // System.out.println(headers.get(0).toString());

    }

    @Test
    public void hasHeader() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(baseUrl);

        response.headers().hasHeaderWithName("Content-Type");
        response.headers().hasHeaderWithName("Connection");
    }

    @Test
    public void headerValue() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(baseUrl);

        System.out.println("response.header(\"Date\") = " + response.header("Date"));
        System.out.println("response.header(\"Transfer-Encoding\") = " + response.header("Transfer-Encoding"));
        System.out.println("response.header(\"Content-Type\") = " + response.header("Content-Type"));
        System.out.println("response.contentType() = " + response.contentType());
    }

}
