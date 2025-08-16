package api.devEx.tests.day07;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;


public class PostRequestDemo {

    @BeforeClass
    public void beforeClass() {
        baseURI = "http://www.eurotech.study";
    }

    /**
     * CT D07 create user
     * given accept type and content type is JSON
     * And request jsonBody is
     * {
     * "email": "Jashua4@king.com",
     * "password": "Test1234",
     * "name": "Jashua King",
     * "google": "Jashua_google",
     * "facebook": "Jashua_face",
     * "github": "Jashua_github"
     * }
     * When user sends POST request to '/api/users'
     * Then status code 200
     * And token should be created
     */


    @Test
    public void t33_dx_registerUser_POST_newUser1() {
        String jsonBody = "{\n" +
                "         \"email\": \"Jashua4@king.com\",\n" +
                "         \"password\": \"Test1234\",\n" +
                "         \"name\": \"Jashua King\",\n" +
                "         \"google\": \"Jashua_google\",\n" +
                "         \"facebook\": \"Jashua_face\",\n" +
                "         \"github\": \"Jashua_github\"\n" +
                "     }";

        Response response = given().accept(ContentType.JSON) // hey api send me body as json format
                .and()
                .contentType(ContentType.JSON)//hey api I am sending json body
                .and()
                .body(jsonBody)
                .when()
                .post("/api/users");

        assertEquals(response.statusCode(), 200);
        response.prettyPrint();
        assertTrue(response.body().asString().contains("token"));

    }

    @Test
    public void t34_dx_registerUser_POST_newUser2() {

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("email", "Jashua5@king.com");
        requestMap.put("password", "Test1234");
        requestMap.put("name", "Test1234");
        requestMap.put("google", "Jashua_google");
        requestMap.put("facebook", "Jashua_face");
        requestMap.put("github", "Jashua_github");

        Response response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(requestMap)
                .when()
                .post("/api/users");
        assertEquals(response.statusCode(), 200);
        response.prettyPrint();
        assertTrue(response.body().asString().contains("token"));

    }

    @Test
    public void t35_dx_registerUser_POST_newUserInfo_1() {
        NewUserInfo newUserInfo = new NewUserInfo();

        newUserInfo.setEmail("Jashua6@king.com");
        newUserInfo.setPassword("Test1234");
        newUserInfo.setName("Jashua King");
        newUserInfo.setGoogle("Jashua_google");
        newUserInfo.setFacebook("Jashua_face");
        newUserInfo.setGithub("Jashua_github");

        Response response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(newUserInfo) // Serialization java to Json
                .when()
                .post("/api/users");
        assertEquals(response.statusCode(), 200);
        response.prettyPrint();
        assertTrue(response.body().asString().contains("token"));
    }

    @Test
    public void t36_dx_registerUser_POST_newUserInfo_2() {
        NewUserInfo newUserInfo = new NewUserInfo("Jashua7@king.com", "Test1234",
                "Jashua King", "Jashua_google", "Jashua_face", "Jashua_github");
        Response response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(newUserInfo) // Serialization => java to Json
                .when()
                .post("/api/users");
        assertEquals(response.statusCode(), 200);
        response.prettyPrint();
        assertTrue(response.body().asString().contains("token"));

    }
}
