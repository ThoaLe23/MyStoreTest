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
public class AddressPage extends BaseClass{
	@FindBy(id = "Change-address2")
	WebElement btnChangeAddress;
	
	@FindBy(xpath = "//*[@name='name']")
	WebElement fullName;
	
	@FindBy(xpath = "//*[@name='phone']")
	WebElement Wphone;
	
	@FindBy(xpath = "//*[@name='address']")
	WebElement Waddress;
	
	@FindBy(xpath = "//span[text()='OK']")
	WebElement BtnOk;
	
	@FindBy(xpath = "//span[text()='Cancel']")
	WebElement BtnCancel;
	
	@FindBy(id="fname")
	WebElement nameChange;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public PaymentPage changeAddress(String fname,  String phone,String address) throws Throwable {
		Action.click(getDriver(), btnChangeAddress);
		Action.type(fullName, fname);
		Thread.sleep(1000);
		Action.type( Wphone,phone);
		Thread.sleep(1000);
		Action.type( Waddress,address);
		Thread.sleep(1000);
		Action.click(getDriver(), BtnOk);
		return new PaymentPage();
	}
	
	public PaymentPage clickOnCancel() throws Throwable{
		Action.click(getDriver(), BtnCancel);
		return new PaymentPage();
	}
	
	public PaymentPage clickOnOk() throws Throwable{
		Action.click(getDriver(), BtnOk);
		return new PaymentPage();
		
	}
	public boolean validateFullName() throws Throwable{
		return Action.isDisplayed(getDriver(), nameChange);
	}
	
	
	public String GetFname() {
		String fNameChange = nameChange.getText();
		return fNameChange;
	}
	
}
