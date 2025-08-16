package api.devEx.tests.day03;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BodyTest_with_PathMethod {
    String devExURL="http://www.eurotech.study";
    String petStoreURL="https://petstore.swagger.io/v2";

    @Test
    public void t12_devEx_getUserProfile_with_pathMethod() {
        /**
           {
            "id": 109,
            "email": "angelina@mynet.com",
            "name": "Angelina",
            "company": "Apple",
            "status": "Tester",
            "profileId": 52
            }
         */

        Response response = given().accept(ContentType.JSON)
                .and()
                .queryParam("id", 109)
                .when()
                .get(devExURL + "/api/profile/userQuery");
        assertEquals(response.statusCode(),200);
        System.out.println("response.path(\"id\") = " + response.path("id"));
        System.out.println("response.path(\"email\") = " + response.path("email"));
        System.out.println("response.path(\"name\") = " + response.path("name"));
        System.out.println("response.path(\"company\") = " + response.path("company"));

        int actualID= response.path("id");
        String actualEmail=response.path("email");
        String actualName=response.path("name");

        assertEquals(actualID,109);
        assertEquals(actualEmail,"angelina@mynet.com");
        assertEquals(actualName,"Angelina");

    }

    @Test
    public void t13_ps_findPetByID_with_pathParam_with_PathMethod() {
        /**
         {
             "id": 115,
             "category": {
                         "id": 115,
                         "name": "dog"
                         },
             "name": "dicky",
             "photoUrls": [
                             "string"
                           ],
             "tags": [
                     {
                     "id": 115,
                     "name": "string"
                     }
                        ],
             "status": "available"
         }

         */
        Response response = given().accept(ContentType.JSON)
                .and()
                .pathParam("petID", 115)
                .when()
                .get(petStoreURL + "/pet/{petID}");
       // response.prettyPrint();
        assertEquals(response.statusCode(),200);

        int actualID=response.path("id");
        System.out.println("actualID = " + actualID);

        System.out.println("response.path(\"name\") = " + response.path("name"));
        //map to map
        System.out.println("response.path(\"category\") = " + response.path("category"));
        System.out.println("response.path(\"category.name\") = " + response.path("category.name"));
        //map to list
        System.out.println("response.path(\"photoUrls\") = " + response.path("photoUrls"));
        System.out.println("response.path(\"photoUrls[0]\") = " + response.path("photoUrls[0]"));
        //map to list to map
        System.out.println("response.path(\"tags\") = " + response.path("tags"));
        System.out.println("response.path(\"tags[0]\") = " + response.path("tags[0]"));
        System.out.println("response.path(\"tags[0].id\") = " + response.path("tags[0].id"));
        System.out.println("response.path(\"tags.id[0]\") = " + response.path("tags.id[0]"));
        System.out.println("response.path(\"tags.name[0]\") = " + response.path("tags.name[0]"));
        System.out.println("response.path(\"tags[0].name\") = " + response.path("tags[0].name"));

    }
}
