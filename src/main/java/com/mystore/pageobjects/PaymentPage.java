/**
 * 
 */
package com.mystore.pageobjects;

import java.util.Set;

import javax.lang.model.element.UnknownElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * 
 */
public class PaymentPage extends BaseClass{
	@FindBy(xpath="//input[@value = 'fast']")
	WebElement fastship;
	
	@FindBy(xpath="//span[contains(text(),'Thanh toán tiền mặt khi nhận hàng')]")
	WebElement laterMoney;
	
	@FindBy(xpath="//input[@value = 'paypal']")
	WebElement paypalMoney;
	
	@FindBy(id="CheckOut-Btn")
	WebElement checkOutBtn;
	
	@FindBy(id="email")
	WebElement emailPay;
	
	@FindBy(id="btnNext")
	WebElement btnNext;
	
	@FindBy(id="btnLogin")
	WebElement btnLogin;
	
	@FindBy(id="password")
	WebElement passwordPay;
	
	@FindBy(xpath = "//div[contains(text(),\"Complete Purchase\")]")
	WebElement CompleteBtn;
	
	@FindBy(xpath = "/html/body/div/div/div[1]/div/div[1]/img")
	WebElement paypalBtn;
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderCompletePage clickOnLater() throws Throwable {
		Action.click(getDriver(), laterMoney);
		Action.click(getDriver(), checkOutBtn);
		Thread.sleep(1000);
		return new OrderCompletePage();
	}
	
//	public OrderCompletePage clickOnPayPal(String emailPayPal, String pswPayPal) throws Throwable {
//		Action.click(getDriver(), paypalMoney);
//	//	Thread.sleep(2000);
//		Action.fluentWait(paypalBtn, 10);
//		
//		Action.JSClick(getDriver(), paypalBtn);
		//Actions.moveByOffset()
//		//((JavascriptExecutor) getDriver()).executeScript("window.open('https://www.sandbox.paypal.com/checkoutnow?sessionID=uid_52d4cd8b88_mtm6mdg6mza&buttonSessionID=uid_64bc80c5b7_mtm6mtm6mzk&stickinessID=uid_c2d26b8d2b_mtm6ntq6ndm&smokeHash=&fundingSource=paypal&buyerCountry=VN&locale.x=vi_VN&commit=true&clientID=AQXtVWE3egDXfS2WJzjXfnavrsIc5JCARnDlewyBWNHu2KB7ehEseAslYhMV4TfFJ5EKLkFG5Xgk9zC_&env=sandbox&sdkMeta=eyJ1cmwiOiJodHRwczovL3d3dy5wYXlwYWwuY29tL3Nkay9qcz9jbGllbnQtaWQ9QVFYdFZXRTNlZ0RYZlMyV0p6alhmbmF2cnNJYzVKQ0FSbkRsZXd5QldOSHUyS0I3ZWhFc2VBc2xZaE1WNFRmRko1RUtMa0ZHNVhnazl6Q18iLCJhdHRycyI6eyJkYXRhLXVpZCI6InVpZF9wbnpqdmZua3locmFjbHZpc2V3eXdmcnFjY3lwenMifX0&xcomponent=1&version=5.0.406&token=33T56839CF303954W')");
//		String currentWindowHandle = getDriver().getWindowHandle();
//		Set<String> windowHandles = getDriver().getWindowHandles();
//		windowHandles.remove(currentWindowHandle);
//		getDriver().switchTo().window(windowHandles.iterator().next());
//		Action.type(emailPay, emailPayPal);
//		Action.type(passwordPay, pswPayPal);
//		Action.click(getDriver(),  CompleteBtn);
//		return new OrderCompletePage();
//		
//	}
	public String getCurrURL() {
		String paymentPageURL = getDriver().getCurrentUrl();
		return paymentPageURL;
	}
	
	
	
}
