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
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.SignInPage;
import com.mystore.utility.Log;

/**
 * 
 */
public class AddToCartPageTest extends BaseClass{
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
	
	@Test(groups = { "Regression","Sanity"}, dataProvider = "getProduct", dataProviderClass = DataProviders.class )
	public void addToCartTest1(String productName, String qty) throws Throwable {
		Log.startTestCase("addToCartTest2");
		indexPage = new IndexPage();
		searchPage =indexPage.searchProduct(productName);
		addToCartPage=searchPage.clickOnProduct();
		Thread.sleep(1000);
		loginPage=addToCartPage.clickOnCheckOut1();
		Thread.sleep(1000);
		addToCartPage=loginPage.login2(prop.getProperty("username"), prop.getProperty("password"),addToCartPage);
		boolean result =addToCartPage.validateAddtoCart();
		Thread.sleep(1000);
		addToCartPage.enterQuantity(qty);
		orderPage=addToCartPage.clickOnCheckOut2();
		Thread.sleep(1000);
		String actualURL = orderPage.getCurrURL();
		String expectedURL = "http://localhost:3000/oder";
		Assert.assertEquals(actualURL, expectedURL );
		Log.endTestCase("addToCartTest2");
		
	}
	@Test(groups = { "Regression","Sanity"}, dataProvider = "getProduct", dataProviderClass = DataProviders.class )
	public void addToCartTest2(String productName, String qty) throws Throwable {
		Log.startTestCase("addToCartTest2");
		indexPage = new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.login1(prop.getProperty("username"), prop.getProperty("password"), homePage);
		searchPage =indexPage.searchProduct(productName);
		addToCartPage=searchPage.clickOnProduct();
		//boolean result = addToCartPage.validateAddtoCart();
		
		addToCartPage.enterQuantity(qty);
		Thread.sleep(1000);
		orderPage=addToCartPage.clickOnCheckOut2();
		Thread.sleep(1000);
		String actualURL = orderPage.getCurrURL();
		String expectedURL = "http://localhost:3000/oder";
		Assert.assertEquals(actualURL, expectedURL );
		Log.endTestCase("addToCartTest2");
	}
}






