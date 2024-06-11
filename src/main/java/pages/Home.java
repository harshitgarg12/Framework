package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {

	WebDriver driver;
	public Home(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By menu=By.xpath("//img[contains(@src,'burger-menu')]");
	By signOut=By.xpath("//button[text()='Sign out']");
	
	public void signOut()
	{
		driver.findElement(menu).click();
		driver.findElement(signOut).click();
	}
}
