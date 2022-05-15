package petstoreapitests;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;



public class getReqresTests {

    final static String url="https://reqres.in/api/users?page=2";

    @Test
    //This will fetch the response body as is and log it. given and when are optional here
    public static void getResponseBody(){
               given().queryParam("status","sold")
                       .when().get(url).then().log()
                       .all();
    }

    @Test
    public static void getResponseStatus(){
        int statusCode= given().queryParam("status","sold")
                .when().get(url).getStatusCode();
        System.out.println("The response status is "+statusCode);

        given().when().get(url).then().assertThat().statusCode(200);
    }

    @Test
    public static void getResponseHeaders(){
        System.out.println("The headers in the response "+
                given().when().get(url).then().extract()
                        .headers());
    }
    @Test
    public static void getResponseTime(){
        System.out.println("The time taken to fetch the response "+given().when().get(url)
                .timeIn(TimeUnit.MILLISECONDS) + " milliseconds");
    }
    @Test
    public static void getResponseContentType(){
        System.out.println("The content type of response "+
                given().when().get(url).then().extract()
                        .contentType());
    }

    @Test
    public static void getSpecificPartOfResponseBody(){

        ArrayList<String> names = given().when().get(url).then().extract().path("data.first_name") ;

        for(String a:names){

            System.out.println("The First name value fetched is "+a);

        }


    }
}
