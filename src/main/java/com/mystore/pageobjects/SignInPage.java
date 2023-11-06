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
public class SignInPage extends BaseClass{
	
	@FindBy(id="sign-in-email")
	WebElement userName;
	
	@FindBy(id="sign-in-password")
	WebElement password;
	
	@FindBy(id="submit-login")
	WebElement signInBtn;
	
	@FindBy(xpath = "//span[contains(text(),\"Tạo tài khoản\")]")
	WebElement signUpBtn;
	
	public SignInPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public SignUpPage clickOnSignUp() throws Throwable{
		//Action.fluentWait(signInBtn, 10);
		Action.click(getDriver(), signUpBtn);
		return new SignUpPage();
	}
	
	public HomePage login1(String uname, String passwd,HomePage homePage) throws Throwable {
		Action.scrollByVisibilityOfElement(getDriver(), userName);
		Action.type(userName, uname);
		Action.type(password, passwd);
		Action.click(getDriver(), signInBtn);
		Thread.sleep(2000);
		homePage= new HomePage();
		return homePage;
	}
	public AddToCartPage login2(String uname, String passwd,AddToCartPage addCartPage) throws Throwable {
		Action.scrollByVisibilityOfElement(getDriver(), userName);
		Action.type(userName, uname);
		Action.type(password, passwd);
		Action.click(getDriver(), signInBtn);
		Thread.sleep(2000);
		addCartPage= new AddToCartPage();
		return addCartPage;
	}
	
	public String getCurrURL() {
		String signinPageURL = getDriver().getCurrentUrl();
		return signinPageURL;
	}
}
















