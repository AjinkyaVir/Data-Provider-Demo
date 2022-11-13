package com.dataProviderDemo.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.dataProviderDemo.base.Base;
import com.dataProviderDemo.utility.ReadDataFromExcelFile;

public class Login extends Base{

	@Test(dataProvider = "loginData", dataProviderClass = ReadDataFromExcelFile.class)
	public void TC001_LoginApp(String name,String password) {
		
		
		lauchApp("chrome");
		
		getDriver().findElement(By.name("username")).sendKeys(name);
		getDriver().findElement(By.name("password")).sendKeys(password);
		getDriver().findElement(By.xpath("//button[@type='submit']")).click();
		

		
		//getDriver().close();
		
	}
	
	
}
