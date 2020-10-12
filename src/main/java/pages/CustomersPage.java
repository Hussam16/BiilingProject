package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import org.openqa.selenium.support.FindBy;

public class CustomersPage extends PageBase {

    public CustomersPage(WebDriver driver){
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


        jse.executeScript("arguments[0].click();", AddCustomerlink);
        if(meterType == 1)

        jse.executeScript("arguments[0].click();", prepaidBtn);
        else
        jse.executeScript("arguments[0].click();", postpaidBtn);

        Select statusselect = new Select(statusdropdownlist);

        statusselect.selectByVisibleText("ACTIVE");
        Select selectState = new Select(groupdropdownlist);

        //selectState.selectByValue("A");
        selectState.selectByVisibleText("B");



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

    public boolean checkCustomerisSaved (String Group, String NameEN, String NameAR, String Status, String Email){
        boolean result =false;
        for(WebElement row : rows ) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            int i=1;
            url
            driver.navigate().t


            for (WebElement col : cols) {
                if (Group!=col.getText())
                    break;
                else if((col==cols)&(col.getText()==Email)){
                    result=true;


                }



            }

        }


        return result;
            }

    public boolean checkCustomerisSavedthroughEditPage ( ){
        boolean result=false;

        /*for(WebElement row : rows ){
           List<WebElement> cols= row.findElements(By.tagName("td"));
           int i=1;


           for(WebElement col: cols){

               if(i==6) {


                   jse.executeScript("arguments[0].click();", col);
                  // WebDriverWait wait= new WebDriverWait(driver, 50);
                  // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/a")));
                  // WebElement EditBtn= driver.findElement(By.xpath("/html/body/div/div/a"));
                   //jse.executeScript("arguments[0].click();", EditBtn);
                   //System.out.println(col.getText()+"\t");
                   Wait<WebDriver> FWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).
pollingEvery(Duration.ofSeconds(2)).ignoring(NullPointerException.class);

                   WebElement EditBtn=FWait.until(new Function<WebDriver,WebElement>()
                   { public WebElement apply(WebDriver d)
                   {return d.findElement(By.xpath("/html/body/div/div/a"));}

                   });
               }
               i++;

           }






        }*/
        return result;
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
