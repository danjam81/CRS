package acceptancetests.steps;

import acceptancetests.base.DriverUtil;
import acceptancetests.base.TestDataHelper;
//import acceptancetests.pages.DetailsPage;
//import acceptancetests.pages.EditPage;
import acceptancetests.pages.OverviewPage;
import cucumber.api.java8.En;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class WebSteps implements En {

    private static final Logger LOG = LoggerFactory.getLogger(WebSteps.class);
    
    OverviewPage overviewPage;
   // EditPage editPage;
   // DetailsPage detailsPage;
    
    public WebSteps() {

/*
        Then("^I can verify the changed data \"([^\"]*)\" and \"([^\"]*)\" in the details view$", (String field, String value) -> {
            detailsPage = new DetailsPage(DriverUtil.getDriver());
            
            switch(field) {
                case "subject":
                    Assert.assertTrue(detailsPage.checkSubject(value));
                    break;
                case "owner":
                    Assert.assertTrue(detailsPage.checkOwner(value));
                    break;
                case "status":
                    Assert.assertTrue(detailsPage.checkStatus(value));
                    break;
                case "dueDate":
                    Assert.assertFalse(detailsPage.checkDueDate(value));
                    break;
                case "notes":
                    Assert.assertTrue(detailsPage.checkNotes(value));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field!");
            }

            detailsPage.clickBackToOverviewButton();
        }); */
       /* 
        Then("^I can update the \"([^\"]*)\" with \"([^\"]*)\"$", (String field, String newValue) -> {
            editPage = new EditPage(DriverUtil.getDriver());
            
            switch(field) {
                case "subject":
                    editPage.updateSubject(newValue);
                    break;
                case "owner":
                    editPage.updateOwner(newValue);
                    break;
                case "status":
                    editPage.updateStatus(newValue);
                    break;
                case "dueDate":
//                    String containedDueDate = editPage.getDueDateValue(); // it has the format mm/dd/yyyy
//                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
//                    Date date;
//                    Calendar cal = Calendar.getInstance();
//                    try {
//                        date = sdf.parse(containedDueDate);
//                        cal.setTime(date);
//                        cal.add(Calendar.DATE, Integer.parseInt(newValue));
//                    } catch (ParseException ex) {
//                        date = new Date();
//                    }
//                    System.out.println("+++++++++++++++++++++++++++++++++ The updated duedate will be: " + sdf.format(cal.getTime()));
//                    editPage.updateDueDate(sdf.format(cal.getTime()));
                    break;
                case "notes":
                    editPage.updateNotes(newValue);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field!");
            }
            
            //save the changes
            editPage.clickSaveEntryButton();
            //let's return to the overview Page
            editPage.clickBackToOverviewButton();
        });

        Then("^the new entry \"([^\"]*)\" appears in list of entries$", (String subject) -> {
            Assert.assertTrue(overviewPage.checkIfEntryWithSubjectExists(subject));
        });*/

        /**
         * OVERVIEW PAGE
         */

        // 
        Given("^I navigate to the WEB UI$", () -> {
            WebDriver driver = DriverUtil.getDriver();
            driver.navigate().to(DriverUtil.getTargetWebUrl());
            overviewPage = new OverviewPage(driver);
            TestDataHelper.entriesBeforeTest=overviewPage.getTotalAmountOfEntries();

        });

        // 
        When("^I enter the value \"([^\"]*)\" into the \"([^\"]*)\" field$", (String value, String field) -> {

            switch(field) {
                case "user1":
                    overviewPage.findById(value);
                    break;
                case "owner":
                  //  overviewPage.enterOwner(value);
                    break;
                case "date":
                    // overviewPage.enterDueDate(value);
                    break;
                case "status":
                    //overviewPage.enterStatus(value);
                    break;
                case "note":
                    //overviewPage.enterNotes(value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field!");
            }
        });

        When("^I click on Add$", () -> {
           // overviewPage.clickAddEntryButton();
        });
        
        When("^I click on Save$", () -> {
           // new EditPage(DriverUtil.getDriver()).clickSaveEntryButton();
        });
        
        When("^I click on Back$", () -> {
           // new EditPage(DriverUtil.getDriver()).clickBackToOverviewButton();
        });

        When("^I click  on \"([^\"]*)\" entry with subject \"([^\"]*)\"$", (String function, String subject) -> {

            switch(function) {
                case "update":
                    overviewPage.clickUpdateEntryButtonByEntryId(overviewPage.getEntryIdBySubject(subject));
                    break;
                case "remove":
                    overviewPage.clickRemoveEntryButtonByEntryId(overviewPage.getEntryIdBySubject(subject));
                    break;
                case "view":
                    LOG.info(subject);
                    overviewPage.clickViewEntryByEntryId(overviewPage.getEntryIdBySubject(subject));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid function!" + function);
            }

        });

        When("^I click on view entry with entry id \"([^\"]*)\"$", (String entryId) -> {

            overviewPage.clickViewEntryByEntryId(entryId);
        });

        When("^I click on view entry with subject \"([^\"]*)\"$", (String subject) -> {

            overviewPage.clickViewEntryByEntryId(overviewPage.getEntryIdBySubject(subject));
        });

        // 
        Then("^the amount of total web entries was increased by (\\d+)$", (Integer increase) -> {
            Assert.assertEquals(overviewPage.getTotalAmountOfEntries(), TestDataHelper.entriesBeforeTest + increase);
        });
        
        Then("^the amount of total web entries was decreased by (\\d+)$", (Integer decrease) -> {
            Assert.assertEquals(overviewPage.getTotalAmountOfEntries(), TestDataHelper.entriesBeforeTest - decrease);
        });

        Then("^The subject \"([^\"]*)\" does not exist in the overview$", (String subject) -> {
            Assert.assertFalse(overviewPage.checkIfEntryWithSubjectExists(subject));
        });
        
        // 
        Then("^the subject \"([^\"]*)\" exists on the overview page$", (String subject) -> {
            Assert.assertTrue(overviewPage.checkIfEntryWithSubjectExists(subject));
        });

        Then("^the subject \"([^\"]*)\" does not exist in the overview$", (String subject) -> {
            Assert.assertFalse(overviewPage.checkIfEntryWithSubjectExists(subject));
        });

        Then("^the owner \"([^\"]*)\" exists on the overview page$", (String owner) -> {
            Assert.assertTrue(overviewPage.checkIfEntryWithOwnerExists(owner));
        });

        Then("^the owner \"([^\"]*)\" does not exist in the overview$", (String owner) -> {
            Assert.assertFalse(overviewPage.checkIfEntryWithOwnerExists(owner));
        });

        Then("^the due date \"([^\"]*)\" exists on the overview page$", (String dueDate) -> {
            Assert.assertTrue(overviewPage.checkIfEntryWithDueDateExists(dueDate));
        });

        Then("^the due date \"([^\"]*)\" does not exist in the overview$", (String dueDate) -> {
            Assert.assertFalse(overviewPage.checkIfEntryWithDueDateExists(dueDate));
        });

        Then("^the status \"([^\"]*)\" exists on the overview page$", (String status) -> {
            Assert.assertTrue(overviewPage.checkIfEntryWithStatusExists(status));
        });

        Then("^the status \"([^\"]*)\" does not exist in the overview$", (String status) -> {
            Assert.assertFalse(overviewPage.checkIfEntryWithStatusExists(status));
        });

        Then("^the notes \"([^\"]*)\" exists on the overview page$", (String notes) -> {
            //Assert.assertTrue(detailsPage.checkNotes(notes));
        });

        /**
         * DETAIL PAGE
         */
/*
        Then("^the field \"([^\"]*)\" exists with value \"([^\"]*)\" on the detail page$", (String field, String value) -> {
            detailsPage = new DetailsPage(DriverUtil.getDriver());

            switch(field.toLowerCase()) {
                case "subject":
                    Assert.assertTrue(detailsPage.checkSubject(value));
                    break;
                case "owner":
                    Assert.assertTrue(detailsPage.checkOwner(value));
                    break;
                case "date":
                case "due date":
                    Assert.assertTrue(detailsPage.checkDueDate(value));
                    break;
                case "status":
                    Assert.assertTrue(detailsPage.checkStatus(value));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field!" + field);
            }
        });
*/
       

         Given("^The subject \"([^\"]*)\" exists in the overview$", (String subject) -> {
            Assert.assertTrue(overviewPage.checkIfEntryWithSubjectExists(subject));
         });

        // -> K-I-S-S: See individual steps definitions
         When("^I enter valid data on the overview page \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$", (String username, String owner, String date, String status, String notes) -> {
            overviewPage.enterUsername(username);
            //overviewPage.enterOwner(owner);
            //overviewPage.enterDueDate(date);
            //overviewPage.enterStatus(status);
            //overviewPage.enterNotes(notes);
         });

    }
}
