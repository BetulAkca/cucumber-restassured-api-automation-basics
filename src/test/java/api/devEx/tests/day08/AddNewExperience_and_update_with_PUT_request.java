package api.devEx.tests.day08;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class AddNewExperience_and_update_with_PUT_request {
    @BeforeClass
    public void beforeClass() {
        baseURI = "http://www.eurotech.study";
    }

    /*
        {
          "title": "SDET",
          "company": "Amazon",
          "location": "Boston",
          "from": "2023-01-01",
          "to": "2023-09-15",
          "current": false,
          "description": "string"
        }
     */

    @Test
    public void t40_dx_addNewExperience() {
        Map<String,Object> experienceBody=new HashMap<>();
        experienceBody.put("title","SDET");
        experienceBody.put("company","Google");
        experienceBody.put("location","Berlin");
        experienceBody.put("from","2022-01-01");
        experienceBody.put("to","2022-09-15");
        experienceBody.put("current",false);
        experienceBody.put("description","string");

        given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .header("x-auth-token",Authentication.getToken())
                .and()
                .body(experienceBody)
                .when()
                .post("/api/profile/experience")
                .then()
                .assertThat().statusCode(201);
    }

    @Test
    public void t41_dx_updateExperience_PUT_request() {
        String email="Jashua8@king.com";
        String password="Test1234";
        Map<String,Object> experienceBody=new HashMap<>();
        experienceBody.put("title","SDET");
        experienceBody.put("company","Google");
        experienceBody.put("location","Berlin");
        experienceBody.put("from","2022-01-01");
        experienceBody.put("to","2022-09-15");
        experienceBody.put("current",false);
        experienceBody.put("description","string");

        given().log().all()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                //.header("x-auth-token",Authentication.getToken(email,password)) // first way
                .headers(Authentication.getAccessToken(email,password)) // second way
                .and()
                .body(experienceBody)
                .when()
                .put("/api/profile/experience/1690")
                .then()
                .assertThat().statusCode(204);

    }
}
