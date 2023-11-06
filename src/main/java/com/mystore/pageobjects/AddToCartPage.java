/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * 
 */
public class AddToCartPage extends BaseClass{
	
	@FindBy(id="user-name")
	WebElement Username;
	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(xpath = "//span[text()='Thêm vào giỏ hàng']")
	WebElement addCartBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Chọn mua')]")
	WebElement checkOutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String num) throws Throwable {
		
		Thread.sleep(1000);	
		Action.type(quantity,num);
		Action.fluentWait(quantity, 10);
	}
	
	public void clicOnAddToCart() throws Throwable {
		Thread.sleep(1000);
		Action.click(getDriver(), addCartBtn);
	}
	
	public boolean validateAddtoCart() throws Throwable{
		Thread.sleep(1000);
		return Action.isDisplayed(getDriver(), Username);
	}
	
	public SignInPage clickOnCheckOut1() throws Throwable {
		Action.JSClick(getDriver(),checkOutBtn);
		return new SignInPage();
	}
	
	public OrderPage clickOnCheckOut2() throws Throwable {
		Action.JSClick(getDriver(),checkOutBtn);
		return new OrderPage();
	}
	
	
	
}
