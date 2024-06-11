package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import browserfactory.BrowserFactory;
import dataProvider.ConfigReader;
public class BaseClass {
	
	 public WebDriver driver;
	@BeforeClass
	public void SetUpBowser()
	{
		System.out.println("Log Info:- ************************Setting up the browser**************************");
		driver=BrowserFactory.startBrowser(ConfigReader.getProperty("browser"), ConfigReader.getProperty("url"));
		System.out.println("Log Info:- ************************ Application is Up and Running***********************");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("Log Info:- **************************Browser Closed************************************");
		driver.quit();
	}
	
}
