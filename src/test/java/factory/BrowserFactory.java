package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataProvider.ConfigDataProvider;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver getBrowser(String browsername)
	{
		if(browsername.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			
		}
		
		else if (browsername.equalsIgnoreCase("Chrome"))
		{
			ConfigDataProvider config= new ConfigDataProvider();
			System.setProperty("webdriver.chrome.driver", config.getChromePath());
			driver = new ChromeDriver();
		}
		
		else if(browsername.equalsIgnoreCase("IE"))
		{
			ConfigDataProvider config= new ConfigDataProvider();
			System.setProperty("webdriver.ie.driver", config.getIEPath());
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
				

}
	public static void closeBrowser(WebDriver IDriver)
	{
		driver.quit();
	}
}
