package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DashboardPage extends PageBase {
    public DashboardPage(WebDriver driver){
        super(driver);
        jse=(JavascriptExecutor) driver;
        action = new Actions(driver);

    }
    @FindBy(linkText= "Customers")
    WebElement CustomersP;

    @FindBy(linkText = "Payments")
    WebElement PaymentsP;

    @FindBy(linkText ="Meters")
    WebElement MetersP;

    @FindBy(xpath = "/html/body/jhi-main/div/div/jhi-navbar/header/nav/div/ul/li[2]/a/i")
    WebElement SystemSettings;

    public void GotoCustomersPage(){
        jse.executeScript("arguments[0].click();", CustomersP);

    }

    public void GotoPaymentsPage(){
        jse.executeScript("arguments[0].click();", PaymentsP);

    }
    public void GotoMetersPage(){
        jse.executeScript("arguments[0].click();", MetersP);
    }

    public void GotoSettings() { jse.executeScript("arguments[0].click()", SystemSettings);}
}
