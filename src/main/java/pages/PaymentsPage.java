package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;

public class PaymentsPage extends PageBase {

    public PaymentsPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);

    }

    // 1- Search
    @FindBy(id = "Prepaid")
    WebElement PrepaidPBtn;


    @FindBy(id = "Postpaid")
    WebElement PostpaidPBtn;

    @FindBy(id = "field_unitNo")
    WebElement fieldunitBox;

    @FindBy(id = "field_serial")
    WebElement serialBox;

    @FindBy(id = "field_nameEN")
    WebElement nameENBox;

    @FindBy(id = "field_nameAR")
    WebElement nameARBox;

    @FindBy(id = "field_email")
    WebElement emailBox;

    @FindBy(xpath = "//*[@id=\"page-content-wrapper\"]/jhi-payment-update/div[2]/div/div/div/div/div[7]/div/button[2]")
   //@FindBy(css = "button.btn btn-primary")
    WebElement SearchBtn;

    @FindBy(linkText = "Reset")
    WebElement ResetBtn;

    public void SearchAllMeters() {
        //clickButton(SearchBtn);
       // action.moveToElement(SearchBtn).click().perform();
        jse.executeScript("arguments[0].click()", SearchBtn);
    }

    // 2- Select

    @FindBy(xpath = "//*[@id=\"page-content-wrapper\"]/jhi-payment-update/div[2]/div/div/div/div/div[1]/table")
    WebElement CustomersTable;

    WebElement CustomerPayLink;
    WebElement CustomerBalance;

    @FindBy(xpath ="//*[@id=\"page-content-wrapper\"]/jhi-payment-update/div[2]/div/div/div/div/div[1]/table/tbody/tr[1]/td[8]/a")
    WebElement paytemplink;
    public WebElement PayforCustomerByID(String customerID) {


        List<WebElement> rows = (List<WebElement>) CustomersTable.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cells = (List<WebElement>) row.findElements(By.tagName("//td"));
            for (WebElement cell : cells) {
                if (cell.getText().equals(customerID))
                    CustomerPayLink = cells.get(8);
            }
        }
        return CustomerPayLink;


    }

    public WebElement GetCustomerBalance(String customerID) {


        List<WebElement> rows = (List<WebElement>) CustomersTable.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cells = (List<WebElement>) row.findElements(By.tagName("//td"));
            for (WebElement cell : cells) {
                if (cell.getText().equals(customerID))
                    CustomerBalance = cells.get(7);
            }
        }
        return CustomerBalance;


    }
    public void movetoDetailsSection( String CustomerName){
        clickButton(PayforCustomerByID(CustomerName));
    }
    // 3- Details Section
    @FindBy(xpath ="//*[@id=\"page-content-wrapper\"]/jhi-payment-update/div[2]/div/div/div/div/form/div[6]/div/button[1]")
    WebElement NextBtn;

    public void movetoPaySection(){
        clickButton(NextBtn);

    }

    // 4- Pay Section
    @FindBy(id="field_paymentCenter")
    WebElement PaymentCenterDropDownList;

    @FindBy(id="cash_type")
    WebElement CashBtn;

    @FindBy(id="visa_type")
    WebElement VisaBtn;

    @FindBy(id="cheque_type")
    WebElement ChequeBtn;

    @FindBy(id="field_totalAmt")
    WebElement AmounttoPay;

    @FindBy(xpath="//*[@id=\"page-content-wrapper\"]/jhi-payment-update/div[2]/div/div/div/div/form/div[10]/div/button[1]")
    WebElement PayBtn;

    @FindBy(xpath = "/html/body/ngb-modal-window/div/div/jhi-confirmation-dialog/div[3]/button[2]")
    WebElement AlertOkBtn;

    @FindBy( xpath = "//*[@id=\"page-content-wrapper\"]/jhi-payment-detail/div/div/h1")
    WebElement PaymentDoneTitle;


    public void PaybyCash(String CustomerID, WebDriver driver) throws InterruptedException{
       // action.moveToElement(PayforCustomerByName(CustomerName)).click().perform();
       // jse.executeScript("arguments[0].click()",PayforCustomerByID(CustomerID));
        jse.executeScript("arguments[0].click()",paytemplink);
       // clickButton(CashBtn);
        //scrollToBottom();
        jse.executeScript("window.scrollBy(0,1000)");
        jse.executeScript("arguments[0].click()", NextBtn);
        jse.executeScript("arguments[0].click()",CashBtn);
        Select selectState = new Select(PaymentCenterDropDownList);
        selectState.selectByValue("1: Object");
        setTextElementText(AmounttoPay, "100");
        jse.executeScript("arguments[0].click()", PayBtn);
        jse.executeScript("arguments[0].click()", AlertOkBtn);
        //AcceptAlert();
        /*try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            jse.executeScript("arguments[0].click()", AlertOkBtn);
            alert.accept();
        }
        catch (Exception e){

        }*/



    }
    public String confirmPayment (){
        return PaymentDoneTitle.getText();
    }



}