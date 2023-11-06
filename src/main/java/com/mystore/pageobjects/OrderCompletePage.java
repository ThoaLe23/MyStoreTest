/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

/**
 * 
 */
public class OrderCompletePage extends BaseClass{
	@FindBy(xpath ="//h3[contains(text(),'Đơn hàng đặt thành công')]" )
	WebElement titleSuccess;
	
	public OrderCompletePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String GetTitle() {
		String SuccessOrder = titleSuccess.getText();
		return SuccessOrder;
	}
}
