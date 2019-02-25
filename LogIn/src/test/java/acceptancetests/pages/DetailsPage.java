package acceptancetests.pages;

import acceptancetests.base.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DetailsPage extends BasePage{
    
    private static final Logger LOG = LoggerFactory.getLogger(DetailsPage.class);
    
    public static final String URL="#";
    public DetailsPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(how = How.ID, using = "backToOverviewBtn")
    private WebElement btnBackToOverview;
    
    @FindBy(how = How.ID, using = "subject")
    private WebElement subjectTextField;
    
    @FindBy(how = How.ID, using = "owner")
    private WebElement ownerTextField;
    
    @FindBy(how = How.ID, using = "duedate")
    private WebElement duedateTextField;
    
    @FindBy(how = How.ID, using = "status")
    private WebElement statusOptionField;
    
    @FindBy(how = How.ID, using = "notes")
    private WebElement notesTextField;
    
    public void clickBackToOverviewButton() {
        if (DriverUtil.isChrome()) {
            waitForElementById(ExpectedConditions.visibilityOfElementLocated(By.id("backToOverviewBtn")));
        }
        btnBackToOverview.click();
    }
    
    public boolean checkSubject(String subject) {
        if (DriverUtil.isChrome()) {
            waitForElementById(ExpectedConditions.visibilityOfElementLocated(By.id("subject")));
        }
        return subjectTextField.getText().equals(subject);
    }
    
    public boolean checkOwner(String owner) {
        if (DriverUtil.isChrome()) {
            waitForElementById(ExpectedConditions.visibilityOfElementLocated(By.id("owner")));
        }
        return ownerTextField.getText().equals(owner);
    }
    
    public boolean checkDueDate(String dueDate) {
        if (DriverUtil.isChrome()) {
            waitForElementById(ExpectedConditions.visibilityOfElementLocated(By.id("duedate")));
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++The value of the duedate is:  " + duedateTextField.getText());
        return duedateTextField.getText().equals(dueDate);
    }
    
    public boolean checkStatus(String status) {
        if (DriverUtil.isChrome()) {
            waitForElementById(ExpectedConditions.visibilityOfElementLocated(By.id("status")));
        }
        return statusOptionField.getText().equals(status);
    }
    
    public boolean checkNotes(String notes) {
        if (DriverUtil.isChrome()) {
            waitForElementById(ExpectedConditions.visibilityOfElementLocated(By.id("notes")));
        }
        return notesTextField.getText().equals(notes);
    }
}
