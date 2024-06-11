package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import helper.Utility;

public class ManageCourses {
	
	WebDriver driver;
	public ManageCourses(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By manage=By.xpath("//span[text()='Manage']");
	By manageCourses =By.xpath("//a[text()='Manage Courses']");
	By addCourse=By.xpath("//button[contains(text(),'Add New Course')]");
	By file=By.xpath("//input[@id='thumbnail']");
	By courseName=By.xpath("//input[@id='name']");
	By description=By.xpath("//textarea[@id='description']");
	By instructor=By.xpath("//input[@id='instructorNameId']");
	By price=By.xpath("//input[@id='price']");
	By startDate=By.xpath("//input[@name='startDate']");
	By nextMonth=By.xpath("//button[contains(@class,'next')]");
	By endDate=By.xpath("//input[@name='endDate']");
	By category=By.xpath("//button//div[contains(text(),'Select')]");
	By select=By.xpath("//button[contains(text(),'Selenium')]");
	By save=By.xpath("//button[text()='Save']");
	By month=By.xpath("//div[contains(@class,'current')]");
	By delete=By.xpath("//button[text()='Delete']");
	
	
	public void addCourse(String f, String course, String desc, String inst, String cost,
			String start, String end, String categ, String stMonth, String enMonth)
	{
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(manage)).perform();
		driver.findElement(manageCourses).click();
		driver.findElement(addCourse).click();
		driver.findElement(file).sendKeys(f);
		driver.findElement(courseName).sendKeys(course);
		driver.findElement(description).sendKeys(desc);
		driver.findElement(instructor).sendKeys(inst);
		driver.findElement(price).clear();
		driver.findElement(price).sendKeys(cost);
		driver.findElement(startDate).click();
		
		while(true)
		{
			String value=driver.findElement(month).getText();
			if(value.contains(stMonth))
			{
				break;
			}
			driver.findElement(nextMonth).click();
		}
		driver.findElement(By.xpath("//div[contains(text(),"+start+") and contains(@class,'day')]")).click();
		
		driver.findElement(endDate).click();
		while(true)
		{
			String value=driver.findElement(month).getText();
			if(value.contains(enMonth))
			{
				break;
			}
			driver.findElement(nextMonth).click();
		}
		driver.findElement(By.xpath("//div[contains(text(),"+end+") and contains(@class,'day')]")).click();
		
		
		driver.findElement(category).click();
		driver.findElement(select).click();
		driver.findElement(save).click();
	}
	
	public void deleteCourse()
	{
		driver.findElement(delete).click();  
		Utility.waitForSeconds(1);
	}
}
