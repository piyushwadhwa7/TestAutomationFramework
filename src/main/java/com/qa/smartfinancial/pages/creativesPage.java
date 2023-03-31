package com.qa.smartfinancial.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.smaartfinancial.utils.ElementUtil;
import com.qa.smartfinancial.constants.AppConstants;

public class creativesPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private By creativeText= By.cssSelector(".text-capitalize.text-black.mb-0.font-size-18");
	private By searchBar = By.id("search-bar-0");
	private By timeFrameDrop= By.cssSelector(".select2-selection__value-container.select2-selection__value-container--has-value.css-1hwfws3");
	private By exportButton = By.xpath("//button[normalize-space()='Export']");
	private By newCreativeButton = By.cssSelector("a[class='btn btn-sfpink']");
     
	// page constructor...
	public creativesPage(WebDriver driver) {
		this.driver =driver;
		eleUtil = new ElementUtil(driver);
		
	}
	
	public String getCreativesPageTitle () {
		String title=eleUtil.waitForTitleContains(AppConstants.DEFAULT_TIME_OUT,AppConstants.CREATIVES_PAGE_TITLE);
		System.out.println(" Creatives  page title:"+ title);
		return title;
	}
	public boolean getCreativesPageUrl () {
		String url=eleUtil.waitForUrlContains(AppConstants.DEFAULT_TIME_OUT,AppConstants.CREATIVES_PAGE_URL);
		System.out.println(" creative page url:"+ url);
		if (url.contains(AppConstants.CREATIVES_PAGE_URL)) {
			return true;
		}
		return false;
	}
	public boolean isAllCreativesTextExists() {
		return driver.findElement(creativeText).isDisplayed();
	}
	public boolean searchBarExists() {
		return eleUtil.doEleIsDisplayed(searchBar);
	}
	public boolean timeFrameDropExists() {
		return eleUtil.doEleIsDisplayed(timeFrameDrop);
	}
	public boolean exportButtonExists() {
		return eleUtil.doEleIsDisplayed(exportButton);
	}
	public boolean newCreativeButtonExists() {
		return eleUtil.doEleIsDisplayed(newCreativeButton);
	}
	public boolean isSearchSuccessfull() {
		List<WebElement>searchList=eleUtil.waitForElementsToBeVisible(searchBar, AppConstants.DEFAULT_TIME_OUT);
		if(searchList.size()>0) {
			System.out.println("search is successfully done");
			return true;		
		}
		return false;
	} 
	
	
	

}
