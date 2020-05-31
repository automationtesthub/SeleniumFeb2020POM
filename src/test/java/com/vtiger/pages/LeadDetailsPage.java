package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadDetailsPage extends HeaderPage {
	
private WebDriver driver;
	
	public LeadDetailsPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public boolean verifyLeadSave(String fname, String lname)
	{
		WebElement elm = driver.findElement(By.xpath("//td[@class='moduleTitle'][text()='Lead:  "+fname+" "+lname+"']"));
		if(elm.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
