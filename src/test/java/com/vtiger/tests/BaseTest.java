package com.vtiger.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class BaseTest {
	
	public WebDriver driver;
	public Properties prop;
	public FileInputStream fis;
	
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	@BeforeSuite
	public void reporting()
	{
		DateFormat f = new SimpleDateFormat("ddMMyyyyhhmmss");
		Date d = new Date();
		String file = f.format(d);
		//String file = GenericMethods.getFileName();
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/vtigerextentreport_"+file+".html");
		System.out.println(htmlReporter);
		extent = new ExtentReports();
		// attach only HtmlReporter
		extent.attachReporter(htmlReporter);		
	}
	
	public void openapplication() throws IOException
	{
		prop = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/vtiger/common/config.properties");
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/java/com/vtiger/utilities/chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	
	public static String getscreenshot(String testname,WebDriver driver) throws Exception 
    {
		    DateFormat format=new SimpleDateFormat("yyyyMMddhhmmss");
			Date date=new Date();
			String datestr=format.format(date);
			String filename=System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/Screenshot/"+testname+"_"+datestr+".png";
		 
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           //The below method will save the screen shot in d drive with name "screenshot.png"
            FileUtils.copyFile(scrFile, new File(filename));
            return filename;
    }
	
	

}
