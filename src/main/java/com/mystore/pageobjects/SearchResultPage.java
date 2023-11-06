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
public class SearchResultPage extends BaseClass{
	
	@FindBy(xpath = "//*[@id=\"container\"]/div[2]/div[1]")
	WebElement productSearch;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public boolean isProduct()throws Throwable {
		Thread.sleep(2000);
		return Action.isDisplayed(getDriver(), productSearch);
	}
	
	public AddToCartPage clickOnProduct()throws Throwable {
		Thread.sleep(2000);
		Action.click(getDriver(), productSearch);
		return new AddToCartPage();
	}
	
	
	
	
}
