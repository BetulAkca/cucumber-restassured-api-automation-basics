package api.devEx.tests.day03;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;


public class UserGetRequest_with_pathParam {
    String petStoreURL="https://petstore.swagger.io/v2";
    String devExURL="http://www.eurotech.study";

    @Test
    public void t3_ps_findPetByID() {
        Response response = given().accept(ContentType.JSON)
                .when()
                .get(petStoreURL + "/pet/115");
        response.prettyPrint();
        assertEquals(response.statusCode(),200);
    }

    @Test
    public void t4_ps_findPetByID_with_pathParam() {
        Response response = given().accept(ContentType.JSON)
                .and()
                .pathParam("petID", 55)
                .when()
                .get(petStoreURL + "/pet/{petID}");
        response.prettyPrint();
        assertEquals(response.statusCode(),200);
    }

    @Test
    public void t5_DevEx_getUserProfileByID_with_pathParam() {
        Response response = given().accept(ContentType.JSON)
                .and()
                .pathParam("userID", 25)
                .when()
                .get(devExURL + "/api/profile/user/{userID}");
        response.prettyPrint();
        assertEquals(response.statusCode(),200);
        assertTrue(response.body().asString().contains("Jr. Dev"));
        assertTrue(response.body().asString().contains("jrdev@gmail.com"));
        assertTrue(response.body().asString().contains("google"));

    }

    @Test
    public void t6_ps_findPetByID_negative() {
        Response response = given().accept(ContentType.JSON)
                .pathParam("petID",115)
                .when()
                .get(petStoreURL + "/pet/{petID}");
        response.prettyPrint();
        assertEquals(response.statusCode(),404);
        assertTrue(response.body().asString().contains("Pet not found"));
    }
}
