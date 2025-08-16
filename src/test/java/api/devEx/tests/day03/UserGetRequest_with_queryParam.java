package api.devEx.tests.day03;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class UserGetRequest_with_queryParam {

    String petStoreURL="https://petstore.swagger.io/v2";
    String devExURL="http://www.eurotech.study";

    @Test
    public void t7_ps_findPetByStatus_with_queryParam() {
        /** Class Task D3
         *  Given accept type is JSON
         *  and query param is status sold
         *  When the user sends GET request to  /pet/findByStatus
         *  Then verify that status code is 200
         *  and verify that body is JSON format
         *  and "nostrud proident" should be in payload/body
         */
        Response response = given().accept(ContentType.JSON)
                .and()
                .queryParam("status", "sold")
                .when()
                .get(petStoreURL + "/pet/findByStatus");

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json");
        assertEquals(response.header("Content-Type"),"application/json");
        assertTrue(response.body().asString().contains("nostrud proident"));

    }

    @Test
    public void t8_devEx_getUserProfile_with_queryParam() {
        Response response = given().accept(ContentType.JSON)
                .and()
                .queryParam("id", 25)
                .and()
                .queryParam("email", "jrdev@gmail.com")
                .when()
                .get(devExURL + "/api/profile/userQuery");
        response.prettyPrint();
        assertEquals(response.statusCode(),200);
        assertTrue(response.body().asString().contains("Jr. Dev"));
        assertEquals(response.header("Content-Type"),"application/json; charset=utf-8");
    }

    @Test
    public void t9_ps_findPetByStatus_with_queryParam_with_map() {
        Map<String, Object> queryMap=new HashMap<>();
        queryMap.put("status","pending");

        Response response = given().accept(ContentType.JSON)
                .and()
                .queryParams(queryMap)
                .when()
                .get(petStoreURL + "/pet/findByStatus");

        assertEquals(response.statusCode(),200);
        assertEquals(response.header("Content-Type"),"application/json");
        assertTrue(response.body().asString().contains("consequat"));

    }

    @Test
    public void t10_devEx_getUserProfile_with_queryParam_with_map() {
        Map<String ,Object> queryMap=new HashMap<>();
        queryMap.put("id",25);
        queryMap.put("email","jrdev@gmail.com");


        Response response = given().accept(ContentType.JSON)
                .and()
                .queryParams(queryMap)
                .when()
                .get(devExURL + "/api/profile/userQuery");
        response.prettyPrint();
        assertEquals(response.statusCode(),200);
        assertTrue(response.body().asString().contains("Jr. Dev"));
        assertEquals(response.header("Content-Type"),"application/json; charset=utf-8");
    }

}
