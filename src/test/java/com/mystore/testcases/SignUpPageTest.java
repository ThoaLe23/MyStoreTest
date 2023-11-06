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
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SignInPage;
import com.mystore.pageobjects.SignUpPage;
import com.mystore.utility.Log;

/**
 * 
 */
public class SignUpPageTest extends BaseClass{
	IndexPage indexPage;
	SignInPage loginPage;
	SignUpPage signupPage;
	SignInPage signinPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() throws InterruptedException  {
		Thread.sleep(2000);
		getDriver().quit();
	}
	@Test(groups = "Sanity", dataProvider = "email", dataProviderClass = DataProviders.class )
	public void signUpTest(String email, String psw, String compsw) throws Throwable {
	Log.startTestCase("signUpTest");
		indexPage = new IndexPage();
	loginPage=indexPage.clickOnSignIn();
	signupPage =loginPage.clickOnSignUp();
	signinPage =signupPage.signUp(email, psw, compsw);
	String actualURL = signinPage.getCurrURL();
	String expectedURL = "http://localhost:3000/sign-in";
	Assert.assertEquals(actualURL,expectedURL);
	Log.endTestCase("signUpTest");
	}
}
