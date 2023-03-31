package com.qa.smartfinancial.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.smaartfinancial.utils.ElementUtil;
import com.qa.smartfinancial.constants.AppConstants;

public class DashboardPage {

		private WebDriver driver;// this driver needs to be initialized from somehere 
		// this is private because if we make it public then whenever any class will create the object login page and user driver. can get Nullpointerexception
		private ElementUtil eleUtil;
		private By LogoutLink = By.cssSelector("a[class='dropdown-item']");
		private By DashboardText = By.cssSelector(".text-capitalize.mb-0");
		private By StatesSection = By.linkText("States");
		private By SourcesSection = By.linkText("Sources");
		private By CreativesSection = By.cssSelector("a[href='/dashboard#settings-brands']");
		private By PixelSection = By.xpath("//a[normalize-space()='Pixels']");
		private By EmailText = By.cssSelector(".d-none.d-lg-inline-block.ms-2.me-1");
		private By BrandText = By.id("page-header-user-dropdown1");
		private By BrandLink = By.id("42137");
		private By CreativeLink = By.xpath("//span[normalize-space()='Creatives']");
		
		//2. Page constructor...
		public DashboardPage (WebDriver driver ) {
			this.driver = driver;
			eleUtil= new ElementUtil(driver);
		}
		
		//2. page actions 
			public String getDashbaordPageTitle () {
				String title=eleUtil.waitForTitleContains(AppConstants.DEFAULT_TIME_OUT,AppConstants.Dashboard_Page_Title);
				System.out.println(" Dashbaord page title:"+ title);
				return title;
			}
		
			public boolean getDashbaordPageUrl () {
				String url=eleUtil.waitForUrlContains(AppConstants.DEFAULT_TIME_OUT,AppConstants.Dashbord_Page_URL);
				System.out.println(" Dashbaord page url:"+ url);
				if (url.contains(AppConstants.Dashbord_Page_URL)) {
					return true;
				}
				return false;
			}
			
			public boolean isLogoutLinkExists() {
				return eleUtil.doEleIsDisplayed(LogoutLink);

			}
			
			public boolean isDashboardTextExists() {
				return eleUtil.doEleIsDisplayed(DashboardText);
			}
			public boolean isStateTextExists() {
				return eleUtil.doEleIsDisplayed(StatesSection);
			}
			public boolean isSourceTextExists() {
				return eleUtil.doEleIsDisplayed(SourcesSection);
			}
			public boolean isCreativesTextExists() {
				return eleUtil.doEleIsDisplayed(CreativesSection);
			}
			public boolean isPixelTextExists() {
				return eleUtil.doEleIsDisplayed(PixelSection);
			}
			
			public void doClick() {
				eleUtil.doClick(EmailText);
			}
			public void isBrandLinkExists() {
				eleUtil.doEleIsDisplayed(BrandText);
				eleUtil.doClickWithWait(BrandText, 5);
			}
			public void changeBrand() {
				eleUtil.doClick(BrandLink);
			}
			public boolean creativeTextExists() {
				return eleUtil.doEleIsDisplayed(CreativeLink);
			}
			public creativesPage creativeLink() {
				System.out.println("clciking on the creatives");
				if(creativeTextExists()) {
					eleUtil.doClick(CreativeLink);
					return new creativesPage(driver);
				}
				else {
					System.out.println("creative page link does not exists");
					return null;
				}
				
			}
				

	}


