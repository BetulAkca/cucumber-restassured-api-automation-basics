package api.devEx.tests.day06;

import api.devEx.tests.pojoTest.DevEx;
import api.devEx.tests.pojoTest.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class POJO_deserializationTest {
    @BeforeClass
    public void beforeClass() {
        baseURI="http://www.eurotech.study";
    }

    @Test
    public void t29_dx_getUserProfile_with_qp_POJO() {
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
        Response response = given().accept(ContentType.JSON)
                .and()
                .queryParam("id", 528)
                .when()
                .get("/api/profile/userQuery");
        assertEquals(response.statusCode(),200);

        // convert json to --> POJO (Java Object)
        EurotechUser oneUser=response.body().as(EurotechUser.class);

        //print all information
        System.out.println("oneUser.getId() = " + oneUser.getId());
        System.out.println("oneUser.getEmail() = " + oneUser.getEmail());
        System.out.println("oneUser.getName() = " + oneUser.getName());
        System.out.println("oneUser.getCompany() = " + oneUser.getCompany());
        System.out.println("oneUser.getStatus() = " + oneUser.getStatus());
        System.out.println("oneUser.getProfileId() = " + oneUser.getProfileId());

        //verify all information
        assertEquals(oneUser.getId(),528.0);
        assertEquals(oneUser.getEmail(),"eurotech@gmail.com");
        assertEquals(oneUser.getName(),"Teacher");
        assertEquals(oneUser.getCompany(),"Eurotech");
        assertEquals(oneUser.getStatus(),"Instructor");
        assertEquals(oneUser.getProfileId(),276.0);

    }

    @Test
    public void t30__dx_getUserProfile_with_qp_POJO_from_jsonToSchema() {
        Response response = given().accept(ContentType.JSON)
                .and()
                .queryParam("id", 528)
                .when()
                .get("/api/profile/userQuery");
        assertEquals(response.statusCode(),200);

        EutorechUserFromJsonschema2pojo user2=response.body().as(EutorechUserFromJsonschema2pojo.class);
        System.out.println("user2.getName() = " + user2.getName());
        System.out.println("user2.getCompany() = " + user2.getCompany());
        System.out.println("user2.getEmail() = " + user2.getEmail());
    }

    @Test
    public void t31_dx_getUserProfileByID_pp_POJO_3() {
        Response response = given().accept(ContentType.JSON)
                .and()
                .pathParam("userID", 109)
                .when()
                .get("/api/profile/user/{userID}");
        assertEquals(response.statusCode(),200);
        DevEx devEXUser=response.body().as(DevEx.class);
        System.out.println("devEXUser.getCompany() = " + devEXUser.getCompany());

        //print user id, name and email
        User user=devEXUser.getUser();
        System.out.println("user.getId() = " + user.getId());
        System.out.println("user.getEmail() = " + user.getEmail());
        System.out.println("user.getName() = " + user.getName());


        //print skills info
        List<String> skills = devEXUser.getSkills();
        System.out.println("skills.size() = " + skills.size());
        System.out.println("skills.get(0) = " + skills.get(0));
    }
}
