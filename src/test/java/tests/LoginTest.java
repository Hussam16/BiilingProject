package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import pages.LoginPage;


public class LoginTest extends TestBase
{



	@Test(priority=2)
	public void UserCanLoginSuccssfully()
	{
		LoginPage LoginObject ;
		LoginObject = new LoginPage(driver);
		LoginObject.UserLoginwithoutRememberMe("admin","admin");
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://10.0.61.23:9090/#/login" );


	}
	/*@AfterTest
	public void ExitPage(){
		driver.quit();
	}
	@Test(priority=3)
	public void UserCanLoginSuccssfullyandsavecredentials()
	{
		LoginPage LoginObject ;
		LoginObject = new LoginPage(driver);
		LoginObject.UserLoginwithRememberMe("admin","admin");
		//Assert.assertTrue(Login.getText().contains("http://10.0.61.23:9090/#/" ));


	}*/
	@AfterClass
	public void ExitPage2(){
		driver.quit();
	}
}