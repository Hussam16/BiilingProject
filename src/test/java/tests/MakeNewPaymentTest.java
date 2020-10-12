package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CustomersPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PaymentsPage;

import java.util.concurrent.TimeUnit;


public class MakeNewPaymentTest extends TestBase

{

	


	@Test(priority=5)
	public void UserCanPayforcertainCustomer() throws InterruptedException {
		LoginPage LoginObject ;
		DashboardPage DashboardObject;
		PaymentsPage  PaymentObject;
		LoginObject = new LoginPage(driver);
		LoginObject.UserLoginwithoutRememberMe("admin", "admin");
		DashboardObject = new DashboardPage(driver);
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		DashboardObject.GotoPaymentsPage();

		PaymentObject = new PaymentsPage(driver);
		PaymentObject.SearchAllMeters();
		PaymentObject.PaybyCash("30015", driver);
		Assert.assertEquals(PaymentObject.confirmPayment(),"Payment Details");
	}


}