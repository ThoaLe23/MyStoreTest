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
public class HomePage extends BaseClass{
	
	@FindBy(id="user-name")
	WebElement Username;
	
	@FindBy(id="profile")
	WebElement Profile;
	
	@FindBy(id="my-order")
	WebElement myOrder;
	
	@FindBy(id="log-out")
	WebElement logout;
	
	@FindBy(xpath = "//div[@class='ant-popover-open']")
	WebElement BtnUsername;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateUserName() throws Throwable{
		return Action.isDisplayed(getDriver(), Username);
	}
	
	public String getCurrURL() {
		String homePageURL = getDriver().getCurrentUrl();
		return homePageURL;
	}
}
