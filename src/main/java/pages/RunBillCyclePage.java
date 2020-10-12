package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RunBillCyclePage extends PageBase {

    public RunBillCyclePage(WebDriver driver){
        super(driver);
        jse=(JavascriptExecutor) driver;
        action = new Actions (driver);

    }

    @FindBy(linkText = "All Customers")
    WebElement AllCustomerslink;

    @FindBy(linkText = "Active Customers")
    WebElement ActiveCustomerslink;

    @FindBy(linkText = "InActive Customers")
    WebElement InactiveCustomerslink;

    @FindBy(linkText = "Custom Search")
    WebElement Customsearchlink;

    @FindBy(xpath = "//*[@id=\"page-content-wrapper\"]/jhi-customer/div[1]/div/div[2]/a[1]")
    WebElement AddCustomerlink;

    @FindBy(id = "prepaid")
    WebElement prepaidBtn;

    @FindBy(id = "postpaid")
    WebElement postpaidBtn;


    @FindBy(xpath = "/html/body/jhi-main/div/div/jhi-customer-update/form/div[1]/div[3]/div[2]/div/div[2]/select")
    WebElement statusdropdownlist;

    @FindBy(id = "field_group")
    WebElement groupdropdownlist;


    @FindBy(id = "field_nameEN")
    WebElement field_nameENBox;


    @FindBy(id = "field_nameAR")
    WebElement field_nameARBox;


    @FindBy(id = "field_email")
    WebElement field_emailBox;

    @FindBy(id = "field_mobile")
    WebElement field_mobileBox;

    @FindBy(id = "field_phone")
    WebElement field_phoneBox;

    @FindBy(xpath = "//*[@id=\"page-content-wrapper\"]/jhi-customer-update/form/div[2]/div/div/button[1]")
    WebElement saveBtn;

    @FindBy(xpath = "//*[@id=\"page-content-wrapper\"]/jhi-customer-update/form/div[2]/div/div/button[2]")
    WebElement cancelBtn;

    @FindBy (xpath = "//*[@id=\"page-content-wrapper\"]/jhi-customer/div[2]/table")
    WebElement CustomersTable;

    @FindBy(xpath = "//*[@id=\"field_status\"]/option")
            WebElement ActiveOption;

    WebElement CustomerID;

    @FindBy(xpath="/html/body/jhi-main/div/div/jhi-customer/div[2]/table/tbody/tr[6]/td[3]")
    WebElement CustomerNameAfterCreation;

    @FindBy(xpath = "//*[@id=\"page-content-wrapper\"]/jhi-customer/div[2]/table/tbody/tr")
    List<WebElement> rows;


    //@FindBy(tagName = "tr")
    //List<WebElement> Customersrows;

    //@FindBy(tagName = "td")
    //List<WebElement> Customerdataresult;

    public void creatNewCustomer
            (int meterType, String Status, String Group, String email, String ENName, String ARName,
             String mobile, String phone) {

       // clickButton(AddCustomerlink);
        jse.executeScript("arguments[0].click();", AddCustomerlink);
        if(meterType == 1)
        //clickButton(prepaidBtn);
        jse.executeScript("arguments[0].click();", prepaidBtn);
        else
           // clickButton(postpaidBtn);
        jse.executeScript("arguments[0].click();", postpaidBtn);

       //jse.executeScript("arguments[0].click()", statusdropdownlist);


      //  selectState2.selectByIndex(1);
        //selectState2.selectByVisibleText("ACTIVE");

        //jse.executeScript("arguments[0].click()", statusdropdownlist);

        Select statusselect = new Select(statusdropdownlist);

        statusselect.selectByVisibleText("ACTIVE");
        Select selectState = new Select(groupdropdownlist);

        //selectState.selectByValue("A");
        selectState.selectByVisibleText("B");

        //action.moveToElement(statusdropdownlist).click().moveToElement(ActiveOption).click().perform();
        //jse.executeScript("arguments[0].click()", statusdropdownlist);
       // Select statusselect = new Select(statusdropdownlist);

        //Thread.sleep(5000);
        //action.moveToElement(ActiveOption).click().perform();

        //List <WebElement> elementCount = selectState2.getOptions();
        // jse.executeScript("jQuery('#assignee').css('display','block')");
        //jse.executeScript("arguments[0].click()", ActiveOption);
        //clickButton(ActiveOption);
       // statusselect.selectByVisibleText("ACTIVE");

        setTextElementText(field_nameENBox, ENName);
        setTextElementText(field_nameARBox, ARName);
        setTextElementText(field_emailBox, email);
        setTextElementText(field_mobileBox, mobile);
        setTextElementText(field_phoneBox, phone);

        //clickButton(saveBtn);
        jse.executeScript("arguments[0].click();", saveBtn);

    }
    public int CountCustomers(){
        int count= rows.size();
        return count;

    }

    public WebElement getCusomerIDUsingName (String customerName){


        List<WebElement> rows = (List<WebElement>) CustomersTable.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cells = (List<WebElement>) row.findElements(By.tagName("//td"));
            for (WebElement cell : cells) {
                if (cell.getText().equals(customerName))
                    CustomerID = cells.get(1);
                return CustomerID;
            }
        }
return CustomerID;
    }
}
