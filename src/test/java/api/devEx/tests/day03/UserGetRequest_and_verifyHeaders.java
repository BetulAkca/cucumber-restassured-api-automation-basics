package api.devEx.tests.day03;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserGetRequest_and_verifyHeaders {

    String devExURL="http://www.eurotech.study";
    @Test
    public void t11_headersTest() {
        Response response = given().accept(ContentType.JSON)
                .when()
                .get(devExURL + "/api/profile");
        System.out.println("response.header(\"Content-Type\") = " + response.header("Content-Type"));
        System.out.println("response.header(\"Content-Length\") = " + response.header("Content-Length"));
        System.out.println("response.header(\"Date\") = " + response.header("Date"));
        System.out.println("response.header(\"Connection\") = " + response.header("Connection"));

        assertEquals(response.header("Content-Type"),"application/json; charset=utf-8");
        assertEquals(response.header("Content-Length"),"701601");
        assertEquals(response.header("Connection"),"keep-alive");
        assertTrue(response.headers().hasHeaderWithName("Date"));

    }
}
