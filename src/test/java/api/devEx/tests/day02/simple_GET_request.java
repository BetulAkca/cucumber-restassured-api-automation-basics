package api.devEx.tests.day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class simple_GET_request {

    String devExBaseURL="http://www.eurotech.study";
    String petStoreBaseURL="https://petstore.swagger.io/v2";

    @Test
    public void t1_basicGetRequest(){
        Response response = RestAssured.get(devExBaseURL+"/api/profile");
        //print status code
        System.out.println("response.statusCode() = " + response.statusCode());
        //print body
        response.prettyPrint();
    }

    @Test
    public void t2_basic_getRequest_PS() {
        Response response = RestAssured.get(petStoreBaseURL + "/store/inventory");
        System.out.println("response.statusCode() = " + response.statusCode());
        response.prettyPrint();
    }

    @Test
    public void t3_getRequestWithHeader() {
        /** CT d01 TC03
         * given accept type is JSON
         * When user sends a GET request all profiles
         * Then verify that status code is 200
         * And body is JSON format
         */

        Response response = RestAssured.given().accept(ContentType.JSON) // hey api , please send me json response
                .when()
                .get(devExBaseURL + "/api/profile");
        //verify that status code is 200
        Assert.assertEquals(response.statusCode(),200);
        //verify that body is JSON format
        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8"); // hey client ı am sending you JSON
    }

    @Test
    public void t4_verifyWith_RestAssured() {
        //verify test case with using restAssured library
        RestAssured.given().accept(ContentType.JSON)
                .when()
                .get(devExBaseURL+"/api/profile")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .assertThat()
                .contentType("application/json; charset=utf-8");
    }

    @Test
    public void t5_getRequestWithContainsMethod() {
        // verify that body has "Ms. Keith Pacocha"
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when()
                .get(devExBaseURL + "/api/profile");
        //verify status code
        Assert.assertEquals(response.statusCode(),200);
        // first way
        //Assert.assertTrue(response.prettyPrint().contains("Ms. Keith Pacocha"));
        //second way
        Assert.assertTrue(response.body().asString().contains("Ms. Keith Pacocha"));
        // contains method => response validation method
    }
}
