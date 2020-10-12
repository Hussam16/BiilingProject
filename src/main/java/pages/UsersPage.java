package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UsersPage extends PageBase{
    public UsersPage(WebDriver driver){
        super(driver);
        jse=(JavascriptExecutor) driver;
        action = new Actions (driver);

    }
    @FindBy(xpath = "//*[@id=\"page-content-wrapper\"]/jhi-meter/div[1]/div/div[2]/div/a/i")
    WebElement mainListBtn;

    @FindBy(xpath = " /html/body/jhi-main/div/div/jhi-meter/div[1]/div/div[2]/div/div/a[1]")
    WebElement SyncMetersBtn;

    @FindBy(linkText = " Synch. Readings")
    WebElement SyncReadingsBtn;

    @FindBy (xpath = "/html/body/jhi-main/div/div/jhi-meter/div[2]/table")
    List<WebElement> MetersRows;

public int MetersCount(){
        int count= MetersRows.size();
        return count;


}
    public void SyncMeters(){
        jse.executeScript("arguments[0].click()",mainListBtn);
        jse.executeScript("arguments[0].click()", SyncMetersBtn);
    }

    public void SyncReadings(){
        jse.executeScript("arguments[0].click()",mainListBtn);
        jse.executeScript("arguments[0].click()", SyncReadingsBtn);
    }
}
