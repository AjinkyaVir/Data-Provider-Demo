package com.dataProviderDemo.testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.dataProviderDemo.base.Base;
import com.dataProviderDemo.utility.ReadDataFromExcelFile;

public class ForgetPasswordTest extends Base{
	
	@Test(dataProvider = "forgetPasswordData", dataProviderClass = ReadDataFromExcelFile.class)
	public void forgetPasswordTest(String username) {
		
		
		lauchApp("chrome");
		getDriver().findElement(By.xpath("//p[text()='Forgot your password? ']")).click();
		
		getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		
		
		
	}
	

}
