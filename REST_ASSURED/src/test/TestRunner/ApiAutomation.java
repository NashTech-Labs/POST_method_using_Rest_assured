package src.test.TestRunner;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static io.restassured.RestAssured.given;



public class ApiAutomation {
    static Logger logger =  LogManager.getLogger();
    public static String postRequest(String name,String job){
        logger.info("postRequest");
        String reqBody=" {\n" +
                "    \"name\": \""+ name +"\",\n" +
                "    \"job\": \""+ job +"r\"\n" +
                "}";
        logger.info(" JSON : " + reqBody);
        Response response = given().header("Content-Type", "application/json")
                .body(reqBody).when().post("https://reqres.in/api/users").then().extract().response();
        String responseString = response.asString();
        logger.info("response : " + responseString);
        if(responseString.contains("The server was not able to produce a timely response to your request")){
            return null;}
        else{
            return responseString;
        }
    }
}
