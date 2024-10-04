package testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import pages.Home;
import pages.Login;
import pages.ManageCourses;

public class E2ETest extends BaseClass   {

	//Test1
	@Test(dataProvider = "loginDetails", dataProviderClass = CustomDataProvider.class, priority = 1)
	public void LoginToApplication(String email, String password)
	{
		Login login=new Login(driver);
		login.loginToApplication(email,password);
		assertTrue(driver.findElement(By.xpath("//button[text()='Cart']")).isDisplayed());
	}
	
	@Test(dataProvider = "courseDetails", dataProviderClass = CustomDataProvider.class,priority = 2)
	public void addCourse(String file, String courseName, String description, String instructor, String price,
			String startDate, String endDate, String category, String startMonth, String endMonth)
	{
		ManageCourses add=new ManageCourses(driver);
		add.addCourse(file,courseName,description,instructor,price,startDate,endDate,category,startMonth,endMonth);
		assertTrue(driver.findElement(By.xpath("//td[contains(text(),'SeleniumByHarshit')]")).isDisplayed());
	}
	
	@Test(priority = 3)
	public void deleteCourse()
	{
		ManageCourses delete=new ManageCourses(driver);
		delete.deleteCourse();
		int number=driver.findElements(By.xpath("//td[contains(text(),'SeleniumByHarshit')]")).size();
		assertEquals(number, 0);
	}
	
	@Test(priority = 4)
	public void signOut()
	{
		Home home=new Home(driver);
		home.signOut();
		assertTrue(driver.findElement(By.xpath("//a[contains(text(),'New user')]")).isDisplayed());
	}
}
