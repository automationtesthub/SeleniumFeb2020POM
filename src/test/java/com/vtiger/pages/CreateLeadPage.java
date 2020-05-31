package com.vtiger.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateLeadPage extends HeaderPage {
	
private WebDriver driver;
	
	public CreateLeadPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name = "description") 
	WebElement txt_description;
	
	@FindBy(name = "salutationtype") 
	WebElement lst_salutationtype;
	
	@FindBy(name = "firstname") 
	WebElement txt_firstname;
	
	@FindBy(name = "lastname") 
	WebElement txt_lastname;
	
	@FindBy(name = "company") 
	WebElement txt_company;
	
	@FindBy(name = "button") 
	List<WebElement> btn_save;
	
	@FindBy(name = "assigntype") 
	List<WebElement> rdo_AssignType;
	
	
	public void CreateLeadwithMandatoryFields(String lname, String comp)
	{
		try
		{
		txt_lastname.clear();
		txt_lastname.sendKeys(lname);
		txt_company.clear();
		txt_company.sendKeys(comp);
		btn_save.get(0).click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void CreateLeadwithAllFields(String rdoval,String listVal, String fname,String lname, String comp)
	{
		Select sel = new Select(lst_salutationtype);
		sel.selectByVisibleText(listVal);
		txt_firstname.clear();
		txt_firstname.sendKeys(fname);
		selectRadioAssignTo(rdoval);
		CreateLeadwithMandatoryFields(lname, comp);
		
	}
	
	public void selectRadioAssignTo(String val)
	{
		if(val.equals("team"))
		{
		rdo_AssignType.get(1).click();
		}
		else if(val.equals("admin"))
		{
		rdo_AssignType.get(2).click();
		}
	}

}
