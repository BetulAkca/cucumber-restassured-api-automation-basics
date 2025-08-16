package api.devEx.tests.day06;

import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.util.Map;

public class Gson_Example {

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
    @Test
    public void t32_dx_jsonToJava() {
        //JSON to Java collection--> De-serialization
        Gson gson=new Gson();

        String jsonBody="{\n" +
                "            \"id\": 528,\n" +
                "            \"email\": \"eurotech@gmail.com\",\n" +
                "            \"name\": \"Teacher\",\n" +
                "            \"company\": \"Eurotech\",\n" +
                "            \"status\": \"Instructor\",\n" +
                "            \"profileId\": 276\n" +
                "        }";
        System.out.println("jsonBody = " + jsonBody);

        //gson converting to map
        Map<String,Object> dataMap=gson.fromJson(jsonBody,Map.class);
        System.out.println("********************\n");
        System.out.println("dataMap = " + dataMap);

        System.out.println("********************\n");
        //gson converting to object
        EurotechUser oneUser=gson.fromJson(jsonBody, EurotechUser.class);
        System.out.println("oneUser.getEmail() = " + oneUser.getEmail());
        System.out.println("********************\n");
        // Serialization => Java collection or POJO to Json
        EurotechUser eurotechUser=new EurotechUser(11.0,"test123@gmail.com",
                "mike","Eurotech","instructor",25.0);
        String jsonNewUser=gson.toJson(eurotechUser);
        System.out.println("jsonNewUser = " + jsonNewUser);
        System.out.println("********************\n");

    }
}
