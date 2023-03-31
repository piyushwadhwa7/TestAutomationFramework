package com.qa.smartfinanacial.test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.smaartfinancial.base.BaseTest;
import com.qa.smartfinancial.constants.AppConstants;
public class LoginPageTest extends BaseTest {
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		// we are inheriting the driver from Basetest so that we can initalise driver.get command 
		
		String actualTitle=loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle,AppConstants.Login_Page_Title);
	}
	@Test(priority=2)
	public void loginPageUrlTest(){
		Assert.assertTrue(loginPage.getLoginPageUrl());
	}
	
	@Test(priority=3)
	public void isForgotPasswordLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPasswordExists());
	}
	
	@Test(priority=3)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	
	}
	
	
}
