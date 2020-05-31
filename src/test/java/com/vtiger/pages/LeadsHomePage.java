package com.vtiger.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsHomePage extends HeaderPage{
	
private WebDriver driver;
	
	public LeadsHomePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname") 
	List<WebElement> txt_lastname;
	
	@FindBy(name = "company") 
	List<WebElement> txt_company;
	
	@FindBy(xpath = "//input[@value='Search'][@type='submit']")
	WebElement btn_search;
	
	@FindBy(xpath = "//td[contains(text(),'Showing')]")
	WebElement lbl_Showing;
	
	public boolean searchLead(String lname, String comp, int count)
	{
		txt_lastname.get(1).clear();
		txt_lastname.get(1).sendKeys(lname);
		txt_company.get(1).clear();
		txt_company.get(1).sendKeys(comp);
		btn_search.click();		
        String txt = lbl_Showing.getText();
        if(txt.contains("of "+count))
		{
			return true;
		}
		else
		{
			return true;
		}
		
		
		
	}

}
