package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver IDriver)
	{
		this.driver=IDriver;
	}
	
	@FindBy(id="lst-ib") WebElement KeywordSearchbox;
	
	@FindBy(tagName="body") WebElement keystring;


public void keywordStringSearch(String keyword) throws InterruptedException
{
	Thread.sleep(3000);
	KeywordSearchbox.clear();
	KeywordSearchbox.sendKeys(keyword, Keys.ENTER);
	String key= KeywordSearchbox.getAttribute("value");
	String bodytext = keystring.getText();
	if (bodytext.contains("latowncarlimo.com"))
	{
		System.out.println("Congratulations your website is on First Page for : "+key);
	}
	else
	{
		System.out.println("Sorry your website is not on First Page for : "+key);
	}
}


	


}