package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftMenuPage {
	
private WebDriver driver;
	
	public LeftMenuPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "theClockLayer") 
	WebElement img_clock;
	
	@FindBy(name = "calculator") 
	WebElement img_calc;
	
	
	public boolean CalcExist()
	{
		if(img_calc.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean ClockExist()
	{
		if(img_clock.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
