/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SignInPage;
import com.mystore.utility.Log;

/**
 * 
 */
public class HomePageTest extends BaseClass{
	IndexPage indexPage;
	SignInPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class )
	public void verifyUserName(String uname, String pswd) throws Throwable {
		Log.startTestCase("verifyUserName");
		indexPage = new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage = loginPage.login1(uname,pswd,homePage);
		boolean result = homePage.validateUserName();
		Assert.assertTrue(result);
		Log.endTestCase("verifyUserName");
	
	}
}



















