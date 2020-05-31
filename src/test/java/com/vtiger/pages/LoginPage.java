package com.vtiger.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//By txt_userid = By.name("name");
	//By txt_pwd = By.name("user_password");
	//By btn_login = By.name("Login");
	//By img_logo = By.xpath("//img[@src='include/images/vtiger-crm.gif']");
	//By lbl_errormsg= By.xpath("//td[contains(text(),'You must specify a valid username and password.')]");
	
	@FindBy(name = "user_name") 
	WebElement txt_username;
	
	@FindBy(how=How.NAME,using="user_password")
	WebElement txt_pwd;
	
	@FindBy(name = "Login") 
	WebElement btn_login;
	
	@FindBy(xpath = "//img[@src='include/images/vtiger-crm.gif']") 
	List<WebElement> img_logo;
	
	@FindBy(xpath = "//td[contains(text(),'You must specify a valid username and password.')]") 
	WebElement lbl_errormsg;
	
	
	
	public boolean verifyLogo()
	{
		if(img_logo.size()==1)
		{
			return true;
		}
		else
		{
			return true;
		}
	}
	
	public boolean verifyTitle(String ExpTitle)
	{
		if(driver.getTitle().trim().equals(ExpTitle))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public HomePage validLogin(String userid, String pwd)
	{
		try
		{
		
			txt_username.clear();
			txt_username.sendKeys(userid);
			txt_pwd.clear();
			txt_pwd.sendKeys(pwd);
			btn_login.click();
			return new HomePage(driver);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	public void InvalidLogin()
	{
		try
		{
			txt_username.clear();
			txt_username.sendKeys("userid2353");
			txt_pwd.clear();
			txt_pwd.sendKeys("pwd3225");
			btn_login.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
