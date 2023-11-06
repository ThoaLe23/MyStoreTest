/**
 * 
 */
package com.mystore.testcases;

import org.apache.http.message.BasicListHeaderIterator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.SignInPage;

/**
 * 
 */
public class AddressPageTest extends BaseClass{
	IndexPage indexPage;
	SearchResultPage searchPage;
	AddToCartPage addToCartPage;
	SignInPage loginPage;
	OrderPage orderPage;
	HomePage homePage;
	AddressPage addressPage;

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
//	public void ChangeAddressTest1() throws Throwable{
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
//		addressPage=orderPage.clickOnCheckout1();
//		Thread.sleep(1000);
//		addressPage.changeAddress("Trần Thu","0236514781", "123 ABC,phường 9, Q.10, Tp.Hồ Chí Minh" );
//		Thread.sleep(1000);
//		String actualName = addressPage.GetFname();
//		Assert.assertEquals(actualName, "Trần Thu");
//		
//	}
	
	@Test(groups = "Regression" )
	public void ChangeAddressTest2() throws Throwable{
		indexPage = new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.login1(prop.getProperty("username"), prop.getProperty("password"),homePage);
		searchPage =indexPage.searchProduct("Simple");
		addToCartPage=searchPage.clickOnProduct();
		//boolean result = addToCartPage.validateAddtoCart();
		//addToCartPage.enterQuantity("2");
		Thread.sleep(1000);
		orderPage=addToCartPage.clickOnCheckOut2();
		orderPage.clickOnChecked();
		Thread.sleep(1000);
		addressPage=orderPage.clickOnCheckout1();
		Thread.sleep(1000);
		addressPage.changeAddress("Trần Thu","0236514781", "123 ABC,phường 9, Q.10, Tp.Hồ Chí Minh");
		Thread.sleep(2000);
	}
}






