package com.qa.smartfinanacial.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.smaartfinancial.base.BaseTest;
import com.qa.smartfinancial.constants.AppConstants;

public class DashboardPageTest extends BaseTest {
	
	@BeforeClass
	public void dashboard() {
		dashPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}// we have done this so that we can write our test cases for dashboard page 
	@Test(priority=1)
	public void dashPageTitleTest() {
		String actualPageTitle=dashPage.getDashbaordPageTitle();
		System.out.println(actualPageTitle);
		Assert.assertEquals(actualPageTitle,AppConstants.Dashboard_Page_Title);
	}
	@Test(priority=2)
	public void dashPageUrlTest() {
		Assert.assertTrue(dashPage.getDashbaordPageUrl());
	}
	@Test(priority=4)
	public void isLogoutLinkExistTest() {
		dashPage.doClick();
		Assert.assertTrue(dashPage.isLogoutLinkExists());
	}
	@Test(priority=3)
	public void isDashboardTextExistTest() {
		Assert.assertTrue(dashPage.isDashboardTextExists());
		Assert.assertTrue(dashPage.isStateTextExists());
		Assert.assertTrue(dashPage.isCreativesTextExists());
		Assert.assertTrue(dashPage.isSourceTextExists());
		Assert.assertTrue(dashPage.isPixelTextExists());
		System.out.println("Dashbaord page is visible");
	}
	@Test(priority=4)
	public void isBrandLinkExistsTest() {
		dashPage.isBrandLinkExists();
		dashPage.changeBrand();
	}
	
	

}
