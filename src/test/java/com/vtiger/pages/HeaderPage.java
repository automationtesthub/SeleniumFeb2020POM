package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends LeftMenuPage {
	
private WebDriver driver;
	
	public HeaderPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText = "New Lead") 
	WebElement lnk_NewLead;
	
	@FindBy(linkText = "Logout") 
	WebElement lnk_Logout;
	
	@FindBy(linkText = "Leads") 
	WebElement lnk_Leads;
	
	@FindBy(id = "showSubMenu") 
	WebElement img_MouseMenu;
	
	
	public void clickNewLead()
	{
		lnk_NewLead.click();
	}
	
	public void clickLogout()
	{
		lnk_Logout.click();
	}
	
	public boolean verifyLogout()
	{
		if(lnk_Logout.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void clickLeads()
	{
		lnk_Leads.click();
	}

}
