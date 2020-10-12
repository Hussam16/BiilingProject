package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.CustomersPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MetersPage;

public class AddMetersTest extends TestBase

{

    @BeforeTest
	public void navigatetoMetersPage(){


	}

	@Test(priority = 0)
	public void UserCanSyncMeters() {
		LoginPage LoginObject ;
		DashboardPage DashboardObject;
		MetersPage MetersObject;
		LoginObject = new LoginPage(driver);
		LoginObject.UserLoginwithoutRememberMe("admin", "admin");
		DashboardObject = new DashboardPage(driver);
		DashboardObject.GotoMetersPage();
		MetersObject = new MetersPage(driver);
        int MetersNoBefore= MetersObject.MetersCount();
        MetersObject.SyncMeters();
        int MetersNoAfter=MetersObject.MetersCount();
        Assert.assertNotEquals(MetersNoAfter,MetersNoBefore);



	}



}