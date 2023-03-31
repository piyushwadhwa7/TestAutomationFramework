package com.qa.smaartfinancial.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.smartfinancial.factory.BrowserFactory;
import com.qa.smartfinancial.pages.DashboardPage;
import com.qa.smartfinancial.pages.LoginPage;
import com.qa.smartfinancial.pages.creativesPage;

public class BaseTest {
	BrowserFactory bf;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public DashboardPage dashPage; // not initialized because its already done in loginpage 
	public creativesPage creativePage;
	
	@BeforeTest
	public void setup () {
		bf = new BrowserFactory();
		prop = bf.initProp();
		driver = bf.initDriver(prop);
		loginPage = new LoginPage(driver);
		System.out.println(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
