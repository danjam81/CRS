package acceptancetests.pages;

import acceptancetests.base.DriverUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OverviewPage extends BasePage{
    
    private static final Logger LOG = LoggerFactory.getLogger(OverviewPage.class);

    public OverviewPage(WebDriver driver) {
        super(driver);
    }
    //@FindBy(how = How.ID, using = "addBtn")
    //private WebElement btnAddEntry;

    @FindBy(how = How.ID, using = "username")
    private WebElement subjectTextField;

   // @FindBy(how = How.ID, using = "owner")
   // private WebElement ownerTextField;

    //@FindBy(how = How.ID, using = "duedate")
    //private WebElement duedateTextField;

    //@FindBy(how = How.ID, using = "status")
    //private WebElement statusOptionField;
    
    //@FindBy(how = How.ID, using = "notes")
    //private WebElement notesTextField;
    
    public void enterUsername(String username) {
        subjectTextField.clear();
        subjectTextField.sendKeys(username);
    }
   /*
    public void enterOwner(String owner) {
        ownerTextField.clear();
        ownerTextField.sendKeys(owner);
    }
    
    public void enterDueDate(String dueDate) {
        duedateTextField.sendKeys(Keys.DELETE);
        duedateTextField.sendKeys(dueDate);
    }
    
    public void enterStatus(String status) {
        Select selectField = new Select(statusOptionField);
        selectField.selectByVisibleText(status);
    }
    
    public void enterNotes(String notes) {
        notesTextField.clear();
        notesTextField.sendKeys(notes);
    }
    
   
    public void clickAddEntryButton() {
        if (DriverUtil.isChrome()) {
            waitForElementById(ExpectedConditions.visibilityOfElementLocated(By.id("addBtn")));
        }
        btnAddEntry.click();
    } */
    
    public void clickUpdateEntryButtonByEntryId(String entryId) {
        if (DriverUtil.isChrome()) {
            waitForElementById(ExpectedConditions.visibilityOfElementLocated(By.id("edit_"+entryId)));
        }
        WebElement btnEditEntry = driver.findElement(By.id("edit_"+entryId));
        btnEditEntry.click();
    }
    
    public void clickRemoveEntryButtonByEntryId(String entryId) {
        if (DriverUtil.isChrome()) {
            waitForElementById(ExpectedConditions.visibilityOfElementLocated(By.id("edit_"+entryId)));
        }
        WebElement btnRemoveEntry = driver.findElement(By.id("remove_"+entryId));
        btnRemoveEntry.click();
    }
    
    public void clickViewEntryByEntryId(String entryId) {
        if (DriverUtil.isChrome()) {
            waitForElementById(ExpectedConditions.visibilityOfElementLocated(By.id("edit_"+entryId)));
        }
        WebElement linkViewEntry = driver.findElement(By.id("item_"+entryId));
        linkViewEntry.click();
    }

    public void clickViewEntryBySubject(String subject) {
//        waitForElementById(ExpectedConditions.visibilityOfElementLocated(By.id("edit_"+entryId)));

        String entryId = getEntryIdBySubject(subject);

        clickViewEntryByEntryId(entryId);
    }
    
    public void sendUsername(String username) {
    	//waitForElementById(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

      WebElement usernameText= driver.findElement(By.xpath("//input[@id='username']"));
      

      usernameText.sendKeys(username);
      }
    /**
     * This method retrieves all Item IDs in the overview page. Since all Table
     * cells like subject etc. contain an element ID with the combination of
     * field_name and entry ID it makes it easy to retrieve further values.
     *
     * @return a List with the contained entry IDs
     */
    public List<String> getAllEntryIds () {
        
        List<String> entryIdList = new ArrayList<>();
       // waitForJSandJQueryToLoad();
        
        List<WebElement> itemRows = driver.findElements(By.className("itemRow"));
        for (Iterator<WebElement> iterator = itemRows.iterator(); iterator.hasNext();) {
            WebElement webElement = iterator.next();
            //Get the first table cell which contains the item ID
            List<WebElement> findElement = webElement.findElements(By.xpath("td"));
            if( findElement.size() > 0 ){
                entryIdList.add(findElement.get(0).getText());
            }
            
        }
        return entryIdList;
    }
    
    /**
     * This method retrieves the amount of existing entries on the overview page.
     *
     * @ return amount of entries
     * */
    
    
    public int getTotalAmountOfEntries () {
        //waitForJSandJQueryToLoad();
        
        List<WebElement> itemRows = driver.findElements(By.className("itemRow"));
        
        return itemRows.size();
    }
    
    public boolean checkIfEntryWithSubjectExists(String subject) {
       // waitForJSandJQueryToLoad();
        List<String> containedIDs = getAllEntryIds();
        
        //iterate over the subjects in order to find the right one
        for (String affectedID : containedIDs) {
            if (subject.equals(findById("subject_"+affectedID).getText())) {
                return true;
            }
        }
        
        return false;
    }

    public boolean checkIfEntryWithOwnerExists(String owner) {
        //waitForJSandJQueryToLoad();
        List<String> containedIDs = getAllEntryIds();

        //iterate over the subjects in order to find the right one
        for (String affectedID : containedIDs) {
            if (owner.equals(findById("owner_"+affectedID).getText())) {
                return true;
            }
        }

        return false;
    }

    
    public boolean checkIfEntryWithDueDateExists(String duedate) {
       // waitForJSandJQueryToLoad();
        List<String> containedIDs = getAllEntryIds();

        //iterate over the subjects in order to find the right one
        for (String affectedID : containedIDs) {
            if (duedate.equals(findById("duedate_"+affectedID).getText())) {
                return true;
            }
        }

        return false;
    }

    public boolean checkIfEntryWithStatusExists(String status) {
       // waitForJSandJQueryToLoad();
        List<String> containedIDs = getAllEntryIds();

        //iterate over the subjects in order to find the right one
        for (String affectedID : containedIDs) {
            if (status.equals(findById("status_"+affectedID).getText())) {
                return true;
            }
        }

        return false;
    }
    
    public String getEntryIdBySubject(String subject) {
       // waitForJSandJQueryToLoad();
        List<String> containedIDs = getAllEntryIds();
        
        //iterate over the subjects in order to find the right one
        for (String affectedID : containedIDs) {
            if (subject.equals(findById("subject_"+affectedID).getText())) {
                return affectedID;
            }
        }
        
        return null;
    }
   
}
