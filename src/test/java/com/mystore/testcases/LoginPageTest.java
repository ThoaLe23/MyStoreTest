/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
public class LoginPageTest extends BaseClass{
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
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = {"Smoke","Sanity"})
	public void loginTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("user is going to click on SignIn");
		loginPage=indexPage.clickOnSignIn();
		Log.info("enter username and password");
		//homePage=loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		homePage=loginPage.login1(uname,pswd,homePage);
		String actualURL = homePage.getCurrURL();
		String expectedURL = "http://localhost:3000/";
		Log.info("Verifying if user is able to login ");
		Assert.assertEquals(actualURL, expectedURL );
		Log.info("Login is succcess ");
		Log.endTestCase("loginTest");
	}
}
