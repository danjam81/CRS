package acceptancetests.steps;

import acceptancetests.base.DriverUtil;
import acceptancetests.base.TestDataHelper;
import entity.LopListEntry;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import io.restassured.response.ValidatableResponse;
import java.util.Calendar;
import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestSteps implements En{
    private static final Logger LOG = LoggerFactory.getLogger(RestSteps.class);
    
    final ValidatableResponse[] response = new ValidatableResponse[1];
    
    public RestSteps() {

    }
    
    @Given("^I use the REST API$")
    public void iUseTheRestApi() {
        RestAssured.baseURI= DriverUtil.getTargetRestUrl();
        //record the amount of total entries before the start of test execution
        TestDataHelper.entriesBeforeTest = getTotalEntriesREST();
    }
    
    @When("^I call webservice AddNewEntry with \"([^\"]*)\" \"([^\"]*)\" (\\d+) \"([^\"]*)\" \"([^\"]*)\"$")
    public void iCallTheWebServiceToAddNewEntry(String subject, String owner, Integer date, String status, String notes) {
        //First we apply the date
        Calendar entityDate = Calendar.getInstance();
        entityDate.add(Calendar.DATE, date);
        
        //We create a new loplist entry object
        LopListEntry newEntry = new LopListEntry(subject, owner, entityDate.getTime(), status, notes);
        response[0]=given().relaxedHTTPSValidation("TLS").contentType("application/json").
                when().body(newEntry.getEntryAsJson()).post("/entry/add").then().log().all();
    }
    
    @When("^I call webservice RemoveIfEntry with subject \"([^\"]*)\"$")
    public void removeIfEntryExistsBySubject(String subject) {
        String itemId = expect().statusCode(200).given().relaxedHTTPSValidation("TLS").contentType("application/json").
                when().get("/entry/itemid-by-subject/"+subject).body().jsonPath().get("itemId");
        
        // make sure we receive an itemId
        Assert.assertNotNull(itemId, "No item ID found for subject " + itemId);
        
        response[0]=given().relaxedHTTPSValidation("TLS").contentType("application/json").
                when().delete("/entry/delete?itemID="+itemId).then().log().all();
    }
    
    @Then("^the entry disappears from the list of entries$")
    public void theEntryDissapearsFromList(){
        LOG.info("It disappears!!!");
    }
    
    @Then("^I get the returncode (\\d+)$")
    public void iGetTheReturnCode(Integer returnCode) {
        LOG.info("Returncode "+ returnCode);
        response[0].statusCode(returnCode);
    }
    
    @Then("^the amount of total rest entries was increased by (\\d+)$")
    public void amountOfTotalRestEntriesIncreasedBy(Integer increase) {
        Assert.assertEquals(TestDataHelper.entriesBeforeTest + increase , getTotalEntriesREST());
    }
    
    @Then("^the amount of total rest entries was decreased by (\\d+)$")
    public void amountOfTotalRestEntriesDecreasedBy (Integer decrease) {
        Assert.assertEquals(TestDataHelper.entriesBeforeTest - decrease , getTotalEntriesREST());
    }
    
    
    public int getTotalEntriesREST() {
        RestAssured.baseURI= DriverUtil.getTargetRestUrl();
        return given().relaxedHTTPSValidation("TLS").contentType("application/json").when().get("/entry/amount").getBody().as(Integer.class);
    }
}
