package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.DashboardPage;
import pages.LoginPage;
import pages.CustomersPage;
import pages.DashboardPage;


public class CreateNewCustomerTest extends TestBase {


	@Test(priority = 1)
	public void UserCanCreateNewCustomer() {
		LoginPage LoginObject;
		CustomersPage CustomersObject;
		DashboardPage DashboardObject;
		LoginObject = new LoginPage(driver);
		LoginObject.UserLoginwithoutRememberMe("admin", "admin");
		DashboardObject = new DashboardPage(driver);
		DashboardObject.GotoCustomersPage();
		CustomersObject = new CustomersPage(driver);
		int CustomersNoBefore = CustomersObject.CountCustomers();

		CustomersObject.creatNewCustomer(1, "ACTIVE", "A", "tde@gmail.com", "nayera othman elwi ", "نيرة سيد على", "01067456678", "0225685413");


		int CustomerNoAfter = CustomersObject.CountCustomers();
		boolean SavedorNot =CustomersObject.checkCustomerisSaved("A", "nayera othman elwi ", "نيرة سيد على", "ACTIVE","tde@gmail.com");
		//Assert.assertEquals(CustomerNoAfter, CustomersNoBefore + 1);
		Assert.assertTrue(SavedorNot);



	}


}