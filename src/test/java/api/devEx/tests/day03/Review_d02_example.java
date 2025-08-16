package api.devEx.tests.day03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Review_d02_example {

    String bookCartURL="https://bookcart.azurewebsites.net";
    String bookStoreURL="https://bookstore.toolsqa.com";
    @Test
    public void t1_getRequest_with_Contains_2() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when()
                .get(bookCartURL + "/api/Book");
        System.out.println("response.body().asString() = " + response.body().asString());
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");
        Assert.assertTrue(response.body().asString().contains("Wicked and the Wallflower"));

    }

    @Test
    public void t2_bookStore() {
        /** 5 minutes  task
         *  Given accept type is JSON
         *  When user send GET request to "/BookStore/v1/Books"
         *  Then verify that response status code 200
         *  and body is JSON format
         *  and response body has "Eric Elliott"
         */

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when()
                .get(bookStoreURL + "/BookStore/v1/Books");
        System.out.println("response.body().asString() = " + response.body().asString());
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");
        Assert.assertTrue(response.body().asString().contains("Eric Elliott"));
    }
}
