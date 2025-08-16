package api.devEx.tests.day08;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Update_with_PATCH_request {
    @BeforeClass
    public void beforeClass() {
        baseURI = "http://www.eurotech.study";
    }

    @Test
    public void t42_dx_updateExperience_PATCH_request() {
        String email="Jashua8@king.com";
        String password="Test1234";
        Map<String,Object> experienceBody=new HashMap<>();
        experienceBody.put("title","SDET");
        experienceBody.put("company","Google");
        experienceBody.put("location","Berlin");

        given().log().all()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .headers(Authentication.getAccessToken(email,password))
                .and()
                .body(experienceBody)
                .and()
                .pathParam("id",1690)
                .when()
                .patch("/api/profile/experience/{id}")
                .then().log().all()
                .assertThat().statusCode(204);

    }
}
