package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LATowncarHomePage;
import utility.Helper;

public class VerifyLAtowncarReport {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeTest
	public void Setup()
	{
		report = new ExtentReports(".\\Reports\\latowncarlimoreport.html",true);
		
		logger = report.startTest("verify la town car");
		
		driver = BrowserFactory.getBrowser("Chrome");
		
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
		logger.log(LogStatus.INFO, "Application is up and Running");
	}
	
	@Test
	public void testHomePage()
	{
		LATowncarHomePage home= PageFactory.initElements(driver, LATowncarHomePage.class);
		
		String title = home.getApplicationTitle();
		Assert.assertTrue(title.contains("LAX Town Car Service"));
		System.out.println("My Application Title is "+ title);
		logger.log(LogStatus.PASS, "Homepage Loaded successfully and verified");
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "validationHomePage")));
	
		home.requestaquotelinkclick();
		logger.log(LogStatus.INFO, "Click on Request a Quote Page");
		String title2= driver.getTitle();
		Assert.assertTrue(title2.contains("Request a Quote Online"));
		System.out.println("Request a quote title is :"+ title2);
		logger.log(LogStatus.PASS, "Request a Quote page has been verified");
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "validationrequestPage")));
	
	
		home.termsclick();
		logger.log(LogStatus.INFO, "Click on Terms and Condition Page");
		String title3= driver.getTitle();
		Assert.assertTrue(title3.contains("Terms and Conditions for"));
		System.out.println("Terms and Conditions title is :"+ title3);
		logger.log(LogStatus.PASS, "Terms and Conditions page has been verified");
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "validationTermsandConditions")));
	
	}
	
	
	@AfterMethod
	public void closeBrowser(ITestResult result)
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String Path=Helper.captureScreenShots(driver, result.getName());
			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(Path));
		}
		BrowserFactory.closeBrowser(driver);
		
		report.endTest(logger);
		report.flush();
	}
	

}
