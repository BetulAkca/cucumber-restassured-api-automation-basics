package api.devEx.tests.day08;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DeleteRequest {
    @BeforeClass
    public void beforeClass() {
        baseURI = "http://www.eurotech.study";
    }

    @Test
    public void t43_dx_deleteExperience() {
        String email="Jashua8@king.com";
        String password="Test1234";
        given().log().all()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .headers(Authentication.getAccessToken(email,password))
                .and()
                .pathParam("id",1776)
                .when()
                .delete("/api/profile/experience/{id}")
                .then().log().all()
                .assertThat().statusCode(200);

    }
}
