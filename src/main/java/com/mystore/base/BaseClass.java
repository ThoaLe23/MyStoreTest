package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	//public static WebDriver driver;
	
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
			
	
	@BeforeSuite(groups = {"Smoke", "Sanity", "Regression"})
	public void loadConfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try {
			prop = new Properties();
			System.out.println("super constructor invoked");
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop.load(ip);
			System.out.println("driver: " + driver);
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	} 
	
	public static void launchApp(String browserName) {
//		WebDriverManager.chromedriver().setup();
//		String browserName = prop.getProperty("browser");

		if(browserName.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set( new ChromeDriver());
		} 
		else if(browserName.contains("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set( new FirefoxDriver());
		} 
		else if(browserName.contains("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set( new InternetExplorerDriver());
		} 
		getDriver().manage().window().maximize();
		Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeOut(getDriver(), 30);
		
		getDriver().get(prop.getProperty("url"));
	}
	@AfterSuite(groups = {"Smoke", "Sanity", "Regression"})
	public void afterSuite() {
		ExtentManager.endReport();
	}
}
