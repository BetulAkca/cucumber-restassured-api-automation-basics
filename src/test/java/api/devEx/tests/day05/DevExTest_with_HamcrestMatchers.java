package api.devEx.tests.day05;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DevExTest_with_HamcrestMatchers {
    @BeforeClass
    public void setUp() {
        baseURI = "http://www.eurotech.study";
    }

    @Test
    public void t20_dx_getUserProfile_with_qp() {
        /*  class Task d5
            Given accept type is json
            And query param id 528
            When user sends GET request to /api/profile/userQuery
            Then status code 200
            and content type is application/json; charset=utf-8
            verify body => test 21
         */
        given().accept(ContentType.JSON)
                .log().all() // to print on console for request
                .and()
                .queryParam("id", 528)
                .when()
                .get("/api/profile/userQuery")
                .then()
                .log().all() // to print on console for response headers and body
                .statusCode(200)
                .and()
                .assertThat()
                .contentType("application/json; charset=utf-8");
    }

    @Test
    public void t21_dx_getUserProfile_with_qp_HamcrestMatcher_body() {
        /*
            {
                "id": 528,
                "email": "eurotech@gmail.com",
                "name": "Teacher",
                "company": "Eurotech",
                "status": "Instructor",
                "profileId": 276
            }
         */

        given().accept(ContentType.JSON)
                .and()
                .queryParam("id", 528)
                .when()
                .get("/api/profile/userQuery")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .assertThat()
                .contentType("application/json; charset=utf-8")
                .body("id", Matchers.equalTo(528),
                        "email", Matchers.equalTo("eurotech@gmail.com"),
                        "name", equalTo("Teacher"),
                        "company", equalTo("Eurotech"),
                        "status", equalTo("Instructor"),
                        "profileId", equalTo(276)
                );
    }

    @Test
    public void t22_dx_getUserProfile_with_qp_HamcrestMatcher_headers() {
        /*
            {
                "id": 25,
                "email": "jrdev@gmail.com",
                "name": "Jr. Dev",
                "company": "google",
                "status": "Junior Developer",
                "profileId": 1
            }
         */
        given().accept(ContentType.JSON)
                .and().queryParam("id", 25)
                .when().log().all()
                .get("/api/profile/userQuery")
                .then().assertThat().statusCode(200)
                .and()
                .header("Content-Type",equalTo("application/json; charset=utf-8"))
                .and()
                .header("ETag",equalTo("W/\"71-gLRrgzE02ZoB4TdrNnm1Irq0Rhc\""))
                .and()
                .header("Date",notNullValue()) //if date has value
                .and()
                .body("id",equalTo(25),
                        "email",equalTo("jrdev@gmail.com")
                     )
                .log().all();
    }

    @Test
    public void t23_dx_retrieveAllProfile_HamcrestBody_hasItem() {
        /*
        apitesting333@gmail.com
         */
        given().accept(ContentType.JSON)
                .when()
                .get("/api/profile")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .assertThat()
                .contentType("application/json; charset=utf-8")
                .and()
                .body("user.email",hasItem("apitesting333@gmail.com"))
                .log().all();

    }

    @Test
    public void t24_dx_retrieveAllProfile_HamcrestBody_hasItems() {
         /*
        David, Steven Clark, Musa, Rod, ismet, hans, Mable5
        */
        given().accept(ContentType.JSON)
                .when()
                .get("/api/profile")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .assertThat()
                .contentType("application/json; charset=utf-8")
                .and()
                .body("user.name",hasItems("David", "Steven Clark", "Musa", "Rod", "ismet", "hans", "Mable5"));
    }

    @Test
    public void t25_dx_retrieveAllProfile_HamcrestBody() {
        /*
            1- verify that 2. company is "Eurotech"
            2- verify that 2. skills's fifth skill is "API"
            3- verify that 11. website is "thelipagus.com"
            4- verify that 11. email is "Maida48@yahoo.com"
            5- verify that 6. experience's title is "Tester"
         */
        given().accept(ContentType.JSON)
                .when()
                .get("/api/profile")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .assertThat()
                .contentType("application/json; charset=utf-8")
                .and()
                .body("company[1]",equalTo("Eurotech"),
                        "skills[1][4]",equalTo("API"),
                        "website[10]",equalTo("thelipagus.com"),
                        "user[10].email",equalTo("Maida48@yahoo.com"),
                        "experience[5].title[0]",equalTo("Tester")

                );
    }
}
