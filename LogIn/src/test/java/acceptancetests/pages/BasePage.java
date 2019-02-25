
package acceptancetests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is the base class for page objects. All common elements (e.g. menues, 
 * footers etc.), used by multiple pages of the target application, can be 
 * defined here.
 * 
 * @author qxy1677
 */

public class BasePage {
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    
    public void waitForElementById(ExpectedCondition<WebElement> buttonEditProjectInformation) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(buttonEditProjectInformation);
    }

    public WebElement findByText(String searchText){
        waitForElementById(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '"+searchText+"')]")));
        return driver.findElement(By.xpath("//*[contains(text(), '"+searchText+"')]"));
    }

    public WebElement findByClass(String classString){
//        waitForElementById(ExpectedConditions.visibilityOfElementLocated(By.className(classString)));
        return driver.findElements(By.className(classString)).get(0);
    }
    
    public WebElement findById(String idString){
//        waitForElementById(ExpectedConditions.visibilityOfElementLocated(By.id(idString)));
        return driver.findElement(By.id(idString));
    }

    public WebElement findByXpath(String xpath){
        waitForElementById(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return driver.findElements(By.className(xpath)).get(0);
    }
    
 //   public boolean waitForJSandJQueryToLoad() {

 //   WebDriverWait wait = new WebDriverWait(driver, 30);

    // wait for jQuery to load
  //  ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
  //    @Override
   //   public Boolean apply(WebDriver driverToApply) {
     //   try {
       //   return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
     //   }
       // catch (Exception e) {
        //  // no jQuery present
         // return true;
        //}
     // }
  //  };

    // wait for Javascript to load
 //   ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
  ///    @Override
   //   public Boolean apply(WebDriver driverToApply) {
    //    return ((JavascriptExecutor)driver).executeScript("return document.readyState")
     //   .toString().equals("complete");
    //  }
   // };

 // return wait.until(jQueryLoad) && wait.until(jsLoad);
}
//}
