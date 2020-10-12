package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends PageBase{

public LoginPage(WebDriver driver){
super(driver);
jse=(JavascriptExecutor) driver;
action = new Actions (driver);

}

    @FindBy(id="username")
	WebElement usernameTxtBox;

    @FindBy(id="password")
	WebElement passwordTxtBox;

	@FindBy(id="rememberMe")
	WebElement remebermeChBox;

	@FindBy(xpath="//*[@id=\"page-content-wrapper\"]/jhi-login-page/div[2]/main/div/div/div/div/div[1]/div/form/div[4]/div[1]/button")
	WebElement loginBtn;

	@FindBy (css="btn btn-link px-0")
	WebElement ForgetPasswordLink;



	public void UserLoginwithoutRememberMe (String username, String password){

		setTextElementText(usernameTxtBox, username);
		setTextElementText(passwordTxtBox, password);
		jse.executeScript("arguments[0].click()",loginBtn);
		//clickButton(loginBtn);

	}
	public void UserLoginwithRememberMe (String username, String password){

		setTextElementText(usernameTxtBox, username);
		setTextElementText(passwordTxtBox, password);
		clickButton(remebermeChBox);

		clickButton(loginBtn);

	}
	public void ForgetPassword (){
		clickButton(ForgetPasswordLink);
	}





}
