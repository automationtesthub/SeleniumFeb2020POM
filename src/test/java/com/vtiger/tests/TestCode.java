package com.vtiger.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Selenium_Software\\chromedriver.exe");
	       	WebDriver driver = new ChromeDriver();	     	
			driver.get("http://localhost:100");
			driver.manage().window().maximize();
		
			driver.findElement(By.name("user_name")).sendKeys("admin");			
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.name("Login")).click();
			
			driver.findElement(By.linkText("Leads")).click();
			
			driver.findElements(By.name("lastname")).get(1).sendKeys("Modi");			
			driver.findElements(By.name("company")).get(1).sendKeys("BJP");
			driver.findElement(By.xpath("//input[@value='Search'][@type='submit']")).click();
			
			String txt = driver.findElement(By.xpath("//td[contains(text(),'Showing')]")).getText();
			System.out.println(txt);
			*/
		    int i = 4;
			String val = "Showing 1 - 4 of 4";
			if(val.contains("of "+i))
			{
				System.out.println("Passed");
			}
			else
			{
				System.out.println("Failed");
			}
			
			
			

	}

}
