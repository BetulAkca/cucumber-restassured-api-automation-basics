package api.devEx.tests.day05;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class JsonToJava {
    @BeforeClass
    public void setUp() {
        baseURI = "http://www.eurotech.study";
    }

    @Test
    public void t26_dx_getUserProfile_with_qp_jsonDataMap() {
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
        response.prettyPrint();

        //response body --> convert json to Java --> De-Serialization
        Map<String ,Object> jsonDataMap=response.body().as(Map.class);
        // java is starting
        System.out.println("jsonDataMap = " + jsonDataMap);
        Object company=jsonDataMap.get("company");
        System.out.println("company = " + company);
        Object actualEmail=  jsonDataMap.get("email");
        assertEquals(actualEmail,"eurotech@gmail.com");
    }
    @Test
    public void t27_dx_retrieveAllProfile_jsonDataList() {
        Response response = given().accept(ContentType.JSON)
                .when()
                .get("/api/profile");
        assertEquals(response.statusCode(),200);
        List <Map<String,Object>> allBody  = response.body().as(List.class);
        //System.out.println("allBody = " + allBody);

        //print and verify third company is Siemens
        String expectedCompany="Siemens";
        String actualCompany= (String) allBody.get(2).get("company");
        assertEquals(actualCompany,expectedCompany);

        System.out.println("*********************\n");
        // get third users body
        Map<String,Object> thirdUser=allBody.get(2);//we got all information related to third user
        System.out.println("thirdUser = " + thirdUser);
        System.out.println("*********************\n");
        // get user body information of third users
        Map< String,Object> userInfo = (Map<String, Object>) thirdUser.get("user");
        String name= (String) userInfo.get("name");
        System.out.println("name = " + name);

        String email= (String) userInfo.get("email");
        System.out.println("email = " + email);
        assertEquals(email,"gokhanyildirim@gmail.com");

        List<String> skills= (List<String>) thirdUser.get("skills");
        System.out.println("skills = " + skills);

        /*  HW
            * everyone find their user
            * verify id, name, email
            * skills

         */
    }

    @Test
    public void t28_dx_retrieveAllProfile_sixthUser() {

           /*
                 /api/profile end point
                 print sixth user's skills and verify that
                 "Java",
                 "TestNG",
                 "Cucumber"
                 and verify that experience title and company
                 "Tester" "Amazon"
            */
        Response response = get("api/profile"); // short way
        assertEquals(response.statusCode(),200);

        List<Map<String,Object>> allBody=response.body().as(List.class);
        Map<String, Object> sixthUser = allBody.get(5);
        System.out.println("sixthUser = " + sixthUser);

        List<String> actualSkills = (List<String>) sixthUser.get("skills");
        System.out.println("actualSkills = " + actualSkills);

        List<String> expectedSkills=new ArrayList<>();
        expectedSkills.add("Java");
        expectedSkills.add("TestNG");
        expectedSkills.add("Cucumber");

        System.out.println("expectedSkills = " + expectedSkills);

        assertEquals(actualSkills,expectedSkills);
        /** HW Task
         * and verify that experience title and company
         *             "Tester" Amazon
         *
         */

        List<Map<String,Object>> experience= (List<Map<String, Object>>) sixthUser.get("experience");
        System.out.println("experience = " + experience);
        // 2. way =>  allBody.get(5) = sixthUser
        List<Map<String,Object>> experience1= (List<Map<String, Object>>) allBody.get(5).get("experience");
        System.out.println("experience1 = " + experience1);

        Map<String,Object> firstExperience=experience.get(0);
        System.out.println("firstExperience.get(\"title\") = " + firstExperience.get("title"));
        assertEquals(firstExperience.get("title"),"Tester");
        System.out.println("firstExperience.get(\"company\") = " + firstExperience.get("company"));
        assertEquals(firstExperience.get("company"),"Amazon");


    }
}
