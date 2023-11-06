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
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

/**
 * 
 */
public class SearchResultPageTest extends BaseClass{
	IndexPage indexPage;
	SearchResultPage searchPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown(){
		getDriver().quit();
	}
	@Test(groups = "Smoke" , dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
	public void productAvialabilityTest(String productName) throws Throwable {
		Log.startTestCase("productAvialabilityTest");
		indexPage = new IndexPage();
		searchPage =indexPage.searchProduct(productName);
		boolean result =searchPage.isProduct();
		Assert.assertTrue(result);
	}
}






