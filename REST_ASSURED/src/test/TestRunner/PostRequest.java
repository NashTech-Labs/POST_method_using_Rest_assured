package src.test.TestRunner;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static src.test.TestRunner.ApiAutomation.logger;


public class PostRequest {
    @Test

    public void createRequest() {
        logger.info("updateTicketType");
        String Response = src.test.TestRunner.ApiAutomation.postRequest("morpheus","leader");
        assert Response != null;
        JSONObject ticketTypeObj = new JSONObject(Response);
        if (!ticketTypeObj.getString("name")
                .contains("morpheus")) {
            Assert.fail("Response is not created");
        }
    }
}
