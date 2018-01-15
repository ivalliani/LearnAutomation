package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;

public class VerifyHomePage {
	
	WebDriver driver;
	
	@BeforeTest
	public void openBrowser()
	{
		driver = BrowserFactory.getBrowser("Chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}
	@Test
	public void testHomePage() throws InterruptedException
	{
		HomePage home= PageFactory.initElements(driver, HomePage.class);
		
		int rownum=1;
		for (int i=0; i<rownum; i++)
		{
		home.keywordStringSearch((DataProviderFactory.getExcel().getData(0, rownum, 0)));
		rownum=rownum+1;
		}
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	}

}
