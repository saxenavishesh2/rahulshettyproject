package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.BaseClass;

public class ValidatePageTitleTest extends BaseClass{
	
	public WebDriver driver;
	
	@Test
	public void getTitle() throws IOException {
		
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		HomePage hp= new HomePage(driver);
		String title=hp.getPageTitle().getText();
		System.out.println(title);
		Assert.assertEquals(title, "FEATURED COURSES");
	}

	@AfterTest
	  public void tearDown() {
		  driver.close();
	  }
}
