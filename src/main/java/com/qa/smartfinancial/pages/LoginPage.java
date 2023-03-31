package com.qa.smartfinancial.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.smaartfinancial.utils.ElementUtil;
import com.qa.smartfinancial.constants.AppConstants;

public class LoginPage {
	
	private WebDriver driver;// this driver needs to be initialized from somehere 
	// this is private because if we make it public then whenever any class will create the object login page and user driver. can get Nullpointerexception
	private ElementUtil eleUtil;
	//1. By locator 
	private By emailId = By.cssSelector("input[placeholder='Enter email']");
	private By password = By.cssSelector("input[placeholder='Enter Password']");
	private By LoginBtn = By.cssSelector("button[type='submit']");
	private By ForgotPasswordLnk = By.linkText("Forgot your password?");
	
	//2. Page constructor...
	public LoginPage(WebDriver driver ) {
		this.driver =driver;
		eleUtil= new ElementUtil(driver);
	}
	
	
	//2. page actions 
	public String getLoginPageTitle () {
		String title=eleUtil.waitForTitleContains(AppConstants.DEFAULT_TIME_OUT,AppConstants.Login_Page_Title);
		System.out.println(" Login page title:"+ title);
		return title;
	}
	public boolean getLoginPageUrl () {
		String url=eleUtil.waitForUrlContains(AppConstants.DEFAULT_TIME_OUT,AppConstants.Login_Page_URL);
		System.out.println(" Login page url:"+ url);
		if (url.contains(AppConstants.Login_Page_URL)) {
			return true;
		}
		return false;
	}
	public boolean isForgotPasswordExists() {
		return eleUtil.doEleIsDisplayed(ForgotPasswordLnk);

	}
	
	public DashboardPage doLogin(String username , String pwd) {
		System.out.println(" user creds are :"+username + pwd);
		eleUtil.doSendKeysWithWait(emailId,AppConstants.DEFAULT_TIME_OUT ,username);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(LoginBtn);
		return new DashboardPage(driver);
		
	}
	
	

}
