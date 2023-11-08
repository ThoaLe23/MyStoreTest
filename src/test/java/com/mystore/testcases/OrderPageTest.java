/**
 * 
 */
package com.mystore.testcases;

import org.apache.http.message.BasicListHeaderIterator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.SignInPage;
import com.mystore.utility.Log;

/**
 * 
 */
public class OrderPageTest extends BaseClass{
	IndexPage indexPage;
	SearchResultPage searchPage;
	AddToCartPage addToCartPage;
	SignInPage loginPage;
	OrderPage orderPage;
	HomePage homePage;
	
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
//	public void verifyTotalPrice1() throws Throwable{
//		indexPage = new IndexPage();
//		searchPage =indexPage.searchProduct("Simple");
//		addToCartPage=searchPage.clickOnProduct();
//		Thread.sleep(1000);
//		loginPage=addToCartPage.clickOnCheckOut1();
//		Thread.sleep(1000);
//		addToCartPage=loginPage.login2(prop.getProperty("username"), prop.getProperty("password"));
//		boolean result =addToCartPage.validateAddtoCart();
//		Thread.sleep(1000);
//		//addToCartPage.enterQuantity("2");
//		orderPage=addToCartPage.clickOnCheckOut2();
//		orderPage.clickOnChecked();
//		Thread.sleep(1000);
//		Double itemPrice = orderPage.getItemPrice();
//		Double discountPrice = orderPage.getItemDiscountPrice();
//		Double totalPrice = orderPage.getItemTotalPrice();
//		Thread.sleep(1000);
//		Double totalPriceExpecte = (itemPrice*1)-(discountPrice)+20000;
//		Assert.assertEquals(totalPrice, totalPriceExpecte);
////		Thread.sleep(1000);
//	}
	
	@Test(groups = "Regression", dataProvider = "getProduct", dataProviderClass = DataProviders.class )
	public void verifyTotalPrice2(String productName, String qty) throws Throwable{
		Log.startTestCase("verifyTotalPrice2");
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
		Double itemPrice = orderPage.getItemPrice();
		Double discountPrice = orderPage.getItemDiscountPrice();
		Double totalPrice = orderPage.getItemTotalPrice();
		Thread.sleep(1000);
		Double totalPriceExpecte = (itemPrice*(Double.parseDouble(qty)))-(discountPrice)+20000;
		Assert.assertEquals(totalPrice, totalPriceExpecte);
//		Thread.sleep(1000);
		Log.endTestCase("verifyTotalPrice2");
	}
}






