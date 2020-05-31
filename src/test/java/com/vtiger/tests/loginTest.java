package com.vtiger.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.vtiger.common.config;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

public class loginTest extends BaseTest {
	
	
	@BeforeClass
	public void launchApp() throws IOException
	{
		if(driver == null)
		{
		openapplication();
		}
	}
	
	
	@Test
	public void verifytitle() throws Exception
	{
		logger = extent.createTest("verifytitle");
		logger.info("Application navigated successfully");	
		LoginPage lp = new LoginPage(driver);
		boolean val = lp.verifyTitle("vtiger CRM - Commercial Open Source CRM123");
		if(val)
		{
		logger.pass("Title matched successfully");
		}
		else
		{
			String path = BaseTest.getscreenshot("verifytitle", driver);			
			logger.fail("Title did not match", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		extent.flush();
	}
	
	@Test
	public void verifyValidLogin()
	{
		logger = extent.createTest("verifyValidLogin");
		logger.info("Application navigated successfully");	
		LoginPage lp = new LoginPage(driver);
		HomePage hp = lp.validLogin(prop.getProperty("userid"), prop.getProperty("pwd"));
		logger.pass("Login successfully");
		hp.clickLogout();
		logger.pass("Logout successfully");
		extent.flush();
	}
	
	@AfterClass
	public void tierdown()
	{
		//driver.quit();
	}

}
