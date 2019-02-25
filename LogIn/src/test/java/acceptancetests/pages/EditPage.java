package acceptancetests.pages;

import acceptancetests.base.DriverUtil;
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

public class EditPage extends BasePage{
    
    private static final Logger LOG = LoggerFactory.getLogger(EditPage.class);
    
    public static final String URL="#";
    public EditPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(how = How.ID, using = "saveBtn")
    private WebElement btnSaveEntryUpdate;
    
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
    
    public void clickSaveEntryButton() {
        if (DriverUtil.isChrome()) {
            waitForElementById(ExpectedConditions.visibilityOfElementLocated(By.id("saveBtn")));
        }
        btnSaveEntryUpdate.click();
    }
    
    public void updateSubject(String subject) {
        subjectTextField.clear();
        subjectTextField.sendKeys(subject);
    }
    
    public void updateOwner(String owner) {
        ownerTextField.clear();
        ownerTextField.sendKeys(owner);
    }
    
    public void updateDueDate(String dueDate) {
        duedateTextField.sendKeys(Keys.DELETE);
        duedateTextField.sendKeys("25062020");
    }
    
    public void updateStatus(String status) {
        Select selectField = new Select(statusOptionField);
        selectField.selectByVisibleText(status);
    }
    
    public void updateNotes(String notes) {
        notesTextField.clear();
        notesTextField.sendKeys(notes);
    }
    
    public void clickBackToOverviewButton() {
        if (DriverUtil.isChrome()) {
            waitForElementById(ExpectedConditions.visibilityOfElementLocated(By.id("backToOverviewBtn")));
        }
        btnBackToOverview.click();
    }
    
    public String getDueDateValue() {
        WebElement element = driver.findElement(By.id("duedate"));
        String elementval = element.getAttribute("value");
        return elementval;
    }
}
