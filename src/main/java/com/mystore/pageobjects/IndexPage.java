package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends  BaseClass{
	@FindBy(xpath = "//div[@class='login']" )
	WebElement signInBtn;
	
	@FindBy(id="logo-shop" )
	WebElement myStoreLogo;
	
	@FindBy(id="input-search" )
	WebElement searchProductBox;
	
	@FindBy(xpath = "//h1[text()='Đăng nhập']")
	WebElement formLogin;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public SignInPage clickOnSignIn() throws Throwable{
		Action.click(getDriver(), signInBtn);
		return new SignInPage();
	}
	
	public boolean validateLogo() throws Throwable{
		return Action.isDisplayed(getDriver(), myStoreLogo);
	}
	
	public SearchResultPage searchProduct(String productName) throws Throwable {
		Action.type(searchProductBox, productName);
		return new SearchResultPage();
	}
	
	
}
















