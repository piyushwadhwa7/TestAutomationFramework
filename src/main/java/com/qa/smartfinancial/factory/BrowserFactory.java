package com.qa.smartfinancial.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initDriver (Properties prop) {
		String browserName= prop.getProperty("browser").toLowerCase();
		System.out.println(" Browser name is :" + browserName);
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();	
			
		}else if (browserName.equals("safari")) {
			driver = new SafariDriver();	
			
		}else {
			System.out.println("please pass the right browser");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("Testurl"));
		
		return driver;

}
	// this method is used to init the config properties 
	//@return prop values stored in config file 
	public Properties initProp() {
		prop =new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/configfiles/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
}
