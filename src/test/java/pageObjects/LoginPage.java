package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;
	public LoginPage (WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	} 
	@FindBy(id="email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(xpath="//form[@id='loginForm']/button")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(id="loginPassword")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(id="resetPasswordSubmitButton")
	@CacheLookup
	WebElement btnSignIn;
	
	
	public void setUserName(String username) {
		txtEmail.sendKeys(username);
	}
	
	public void clickContinue() {
		btnLogin.click();
	}
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickSignIn() {
		btnSignIn.click();
		
	}
	
	
	
	

}
