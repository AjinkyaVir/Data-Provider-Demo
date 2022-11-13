package com.dataProviderDemo.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static Properties prop;
	//public static WebDriver driver;
	
	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	@BeforeSuite
	public void loadCofig() {
		
		try {
			prop = new Properties();
			File file = new File("./configuration/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Executed");
		}

	}
	
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}
	
	public void lauchApp(String browser) {
		
		WebDriverManager.chromedriver().setup();
		
		if(browser.equals("chrome")) {
			
			driver.set(new ChromeDriver()); 
			
		}else if(browser.equals("firefox")){
			driver.set(new FirefoxDriver()); 
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//getDriver().get("https://opensource-demo.orangehrmlive.com/");
		getDriver().get(prop.getProperty("url"));
		
		
		
	}
	
}
