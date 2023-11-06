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
public class OrderPage extends BaseClass{
	@FindBy(xpath = "//*[@id=\"checked-item\"]")
	WebElement checkItem;
	
	@FindBy(id="Order-Btn")
	WebElement CheckOutBtn;
	
	@FindBy(id="price-item")
	WebElement priceItem;
	
	@FindBy(id="discount-price")
	WebElement pricedisCount;
	
	
	@FindBy(id="total-price")
	WebElement Totalprice;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public void clickOnChecked() throws Throwable{
		Thread.sleep(1000);
		Action.click(getDriver(), checkItem);
		
	}
	public double getItemPrice(){
		//Action.fluentWait(priceItem, 10);
		String itemPrice = priceItem.getText();
		String price = itemPrice.replaceAll("[^z0-9 ]", "");
		double finalPrice = Double.parseDouble(price);
		return finalPrice;
	}
	
	public double getItemTotalPrice() throws InterruptedException {
		String totalPrice = Totalprice.getText();
		String total = totalPrice.replaceAll("[^z0-9 ]", "");
		double finalTotalPrice = Double.parseDouble(total);
		Thread.sleep(1000);
		return finalTotalPrice;
	}
	
	public double getItemDiscountPrice() throws InterruptedException {
		String discountPrice = pricedisCount.getText();
		String discount = discountPrice.replaceAll("[^z0-9 ]", "");
		double finalDiscountPrice = Double.parseDouble(discount);
		Thread.sleep(1000);
		return finalDiscountPrice;
	}
	
	public AddressPage clickOnCheckout1() throws Throwable{
		Action.click(getDriver(), CheckOutBtn);
		return new AddressPage();	
	}
	public PaymentPage clickOnCheckout2() throws Throwable{
		Action.click(getDriver(), CheckOutBtn);
		return new PaymentPage();	
	}
	public String getCurrURL() {
		String orderPageURL = getDriver().getCurrentUrl();
		return orderPageURL;
	}
}
