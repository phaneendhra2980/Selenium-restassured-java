package petstoreapitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class postReassuredRequests {

    private static String postrequestBody = "{\n" +
            "  \"title\": \"foo\",\n" +
            "  \"body\": \"bar\",\n" +
            "  \"userId\": \"1\" \n}";

    private static String putrequestBody = "{\n" +
            "  \"title\": \"foo\",\n" +
            "  \"body\": \"baz\",\n" +
            "  \"userId\": \"1\",\n" +
            "  \"id\": \"1\" \n}";

    private static String patchrequestBody = "{\n" +
            "  \"title\": \"bax\" \n}";

    @BeforeClass
    public static void setup() {
        baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public static void postRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(postrequestBody)
                .when()
                .post("/posts")
                .then()
                .extract().response();

        Assertions.assertEquals(201, response.statusCode());
        Assertions.assertEquals("foo", response.jsonPath().getString("title"));
        Assertions.assertEquals("bar", response.jsonPath().getString("body"));
        Assertions.assertEquals("1", response.jsonPath().getString("userId"));
        Assertions.assertEquals("101", response.jsonPath().getString("id"));
    }


    @Test
    public void putRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(putrequestBody)
                .when()
                .put("/posts/1")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("foo", response.jsonPath().getString("title"));
        Assertions.assertEquals("baz", response.jsonPath().getString("body"));
        Assertions.assertEquals("1", response.jsonPath().getString("userId"));
        Assertions.assertEquals("1", response.jsonPath().getString("id"));
    }


    @Test
    public void patchRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(patchrequestBody)
                .when()
                .patch("/posts/1")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("bax", response.jsonPath().getString("title"));
        Assertions.assertEquals("1", response.jsonPath().getString("userId"));
        Assertions.assertEquals("1", response.jsonPath().getString("id"));
    }

    @Test
    public void deleteRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("/posts/1")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }
}
