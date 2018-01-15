package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LATowncarHomePage {
	
	WebDriver driver;
	
	public LATowncarHomePage (WebDriver IDriver)
	{
		this.driver=IDriver;
	}
	
	@FindBy (xpath=".//*[@id='menu-main-nav']/li[1]/a") WebElement requestaquotelink;
	@FindBy (xpath=".//*[@id='menu-main-nav']/li[2]/a/span/span") WebElement airportrates;
	@FindBy (xpath=".//*[@id='menu-main-nav']/li[4]") WebElement terms;
	
	
	public void requestaquotelinkclick()
	{
		requestaquotelink.click();
	}
	
	public void airportratesclick()
	{
		airportrates.click();
	}
	
	public void termsclick()
	{
		terms.click();
	}
	
	public String getApplicationTitle()
	{
		return driver.getTitle();
	}
	

}
