package helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	public static String captureScreenshotFromBase64(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		String screenshot=ts.getScreenshotAs(OutputType.BASE64);
		return screenshot;
	}
	
	public static String getCurrentTime()
	{
		String value=new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());
		return value;
	}
	
	public static void waitForSeconds(int seconds)
	{
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
