package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	WebDriver driver;
	public Login(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By email=By.id("email1");
	By password=By.id("password1");
	By signIn=By.xpath("//button[text()='Sign in']");
	
	public void loginToApplication(String emailId, String pass)
	{
		driver.findElement(email).sendKeys(emailId);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(signIn).click();
	}
}
