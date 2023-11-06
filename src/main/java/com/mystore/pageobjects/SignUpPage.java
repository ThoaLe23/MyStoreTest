/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * 
 */
public class SignUpPage extends BaseClass{
	
	@FindBy(id="sign-up-email")
	WebElement userName;
	
	@FindBy(id="sign-up-password")
	WebElement password;
	
	@FindBy(id="sign-up-confirm-password")
	WebElement comfirmPassword;
	
	@FindBy(id="submit-signup")
	WebElement signUpBtn;
	
	@FindBy(xpath = "//h1[text()='Đăng ký']")
	WebElement formSignUp;
	
	public SignUpPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateSignUp() throws Throwable{
		return Action.isDisplayed(getDriver(), formSignUp);
	}
	
	public SignInPage signUp(String uname, String passwd, String compasswd) throws Throwable {
		Action.type(userName, uname);
		Action.type(password, passwd);
		Action.type(comfirmPassword, compasswd);
		Action.click(getDriver(), signUpBtn);
		Thread.sleep(1000);
		return new SignInPage();
	}
	
	public String getCurrURL() {
		String signPageURL = getDriver().getCurrentUrl();
		return signPageURL;
	}
}
