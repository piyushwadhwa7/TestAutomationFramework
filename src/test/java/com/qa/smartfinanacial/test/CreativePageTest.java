package com.qa.smartfinanacial.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.smaartfinancial.base.BaseTest;
import com.qa.smartfinancial.constants.AppConstants;

public class CreativePageTest extends BaseTest {

	@Test(priority=1)
	public void creativePageTitleTest() {
		// we are inheriting the driver from Basetest so that we can initalise driver.get command 
		
		String actualTitle=creativePage.getCreativesPageTitle();
		Assert.assertEquals(actualTitle,AppConstants.CREATIVES_PAGE_TITLE);
	}
	@Test(priority=2)
	public void creativePageUrlTest(){
		Assert.assertTrue(creativePage.getCreativesPageUrl());
	}
	
	@Test(priority=3)
	public void isAllCretivesTextExistTest() {
		Assert.assertTrue(creativePage.isAllCreativesTextExists());
	}
	
	@Test(priority=4)
	public void isSearchBarExistTest() {
		Assert.assertTrue(creativePage.searchBarExists());
	}
	@Test(priority=5)
	public void isTimeFrameDropdownExistTest() {
		Assert.assertTrue(creativePage.timeFrameDropExists());
	}
	
	@Test(priority=6)
	public void isExportButtonExistTest() {
		Assert.assertTrue(creativePage.exportButtonExists());
	}
	@Test(priority=7)
	public void isNewCreativeButtonExistTest() {
		Assert.assertTrue(creativePage.newCreativeButtonExists());
	}
	@Test(priority=8)
	public void isSearchCompletedTest() {
		Assert.assertTrue(creativePage.isSearchSuccessfull());
	}
	
	
}
