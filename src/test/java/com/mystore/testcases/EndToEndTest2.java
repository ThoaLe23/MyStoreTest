/**
 * 
 */
package com.mystore.testcases;

import org.apache.http.message.BasicListHeaderIterator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderCompletePage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.SignInPage;
import com.mystore.utility.Log;

/**
 * 
 */
public class EndToEndTest2 extends BaseClass{
	IndexPage indexPage;
	SearchResultPage searchPage;
	AddToCartPage addToCartPage;
	SignInPage loginPage;
	OrderPage orderPage;
	HomePage homePage;
	PaymentPage paymentPage;
	AddressPage addressPage;
	OrderCompletePage successPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown(){
		getDriver().quit();
	}
	
//	@Test
//	public void addToCartTest1() throws Throwable {
//		indexPage = new IndexPage();
//		searchPage =indexPage.searchProduct("Simple");
//		addToCartPage=searchPage.clickOnProduct();
//		Thread.sleep(1000);
//		loginPage=addToCartPage.clickOnCheckOut1();
//		Thread.sleep(1000);
//		addToCartPage=loginPage.login2(prop.getProperty("username"), prop.getProperty("password"));
//		boolean result =addToCartPage.validateAddtoCart();
//		Thread.sleep(1000);
//		addToCartPage.enterQuantity("2");
//		orderPage=addToCartPage.clickOnCheckOut2();
//		orderPage.clickOnChecked();
//		Thread.sleep(1000);
//		paymentPage=orderPage.clickOnCheckout2();
//		Thread.sleep(1000);
//		successPage=paymentPage.clickOnPayPal(prop.getProperty("emailpaypal"), prop.getProperty("passpaypal"));
//		String actualTitle = successPage.GetTitle();
//		Assert.assertEquals(actualTitle, "Đơn hàng đặt thành công");
//		Thread.sleep(1000);
//		
//	}
	@Test(groups = "Regression" ,dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void EndToEndTest(String productName, String qty) throws Throwable {
		Log.startTestCase("EndToEndTest");
		indexPage = new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.login1(prop.getProperty("username"), prop.getProperty("password"),homePage);
		searchPage =indexPage.searchProduct(productName);
		addToCartPage=searchPage.clickOnProduct();
		//boolean result = addToCartPage.validateAddtoCart();
		
		addToCartPage.enterQuantity(qty);
		Thread.sleep(1000);
		orderPage=addToCartPage.clickOnCheckOut2();
		orderPage.clickOnChecked();
		Thread.sleep(1000);
		paymentPage=orderPage.clickOnCheckout2();
		Thread.sleep(1000);
		successPage=paymentPage.clickOnLater();
//		String actualURL = paymentPage.getCurrURL();
//		String expectedURL = "http://localhost:3000/orderSuccess";
//		Assert.assertEquals(actualURL, expectedURL );
		String actualTitle = successPage.GetTitle();
		Assert.assertEquals(actualTitle, "Đơn hàng đặt thành công");
		Thread.sleep(1000);
		Log.endTestCase("EndToEndTest");
	}
}






