package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class InvoicesPage extends PageBase {

    public InvoicesPage (WebDriver driver){

        super (driver);
        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);

    }


}
