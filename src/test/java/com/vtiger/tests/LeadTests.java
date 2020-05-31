package com.vtiger.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.pages.CreateLeadPage;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadDetailsPage;
import com.vtiger.pages.LoginPage;

public class LeadTests extends BaseTest {
	
	
	
	@BeforeClass
	public void launchApp() throws IOException
	{
		if(driver==null)
		{
		openapplication();
		}
	}
	
	
	@Test
	public void createLeadwithMandatoryFields()
	{
		logger = extent.createTest("createLeadwithMandatoryFields");
		logger.info("Application navigated successfully");	
		//SoftAssert as = new SoftAssert();
		LoginPage lp = new LoginPage(driver);
		HomePage hp = lp.validLogin(prop.getProperty("userid"), prop.getProperty("pwd"));
		//HomePage hp = new HomePage(driver);		
		boolean val = hp.verifyLogout();
		//as.assertEquals(val, true);
		if(val)
		{
		logger.pass("Login successfully");
		}
		else
		{
			logger.fail("Login successfully");
		}
		hp.clickNewLead();
		CreateLeadPage clp = new CreateLeadPage(driver);
		clp.CreateLeadwithMandatoryFields("Modi", "BJP");
		LeadDetailsPage ldp = new LeadDetailsPage(driver);	
		boolean val2 = ldp.verifyLeadSave("", "Modi");
		//as.assertEquals(val2, true);
		//as.assertAll();
		if(val2)
		{
		logger.pass("Lead saved successfully");
		}
		else
		{
			logger.fail("Lead not saved");
		}
		hp.clickLogout();
		extent.flush();
		
	}
	
	@AfterClass
	public void tierdown()
	{
		//driver.quit();
	}

}
