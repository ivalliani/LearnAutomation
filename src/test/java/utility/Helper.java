package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public static String captureScreenShots(WebDriver driver, String screenshotName)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		//Path for short DOES NOT WORK WITH EXTENTREPORT
		//String destination="./ScreenShots/"+screenshotName+System.currentTimeMillis()+".png";
		
		//CORRCT PATH FOR EXTENTREPORTS
		String destination="C:\\Users\\anoosha\\eclipse-workspace\\com.maven.KeywordSearch\\ScreenShots"+screenshotName+System.currentTimeMillis()+".png";
		
		try {
			FileUtils.copyFile(src, new File(destination));
		} catch (IOException e) {
			System.out.println("Failed to capture Screenshots"+e.getMessage());
		}
		
		return destination;
		
	}

}
