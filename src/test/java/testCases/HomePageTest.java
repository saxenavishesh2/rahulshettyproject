package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.BaseClass;

public class HomePageTest extends BaseClass {
	
	public WebDriver driver;
	
  @Test(dataProvider = "getData")
  public void homePage(String email,String password,String textmsg) throws IOException {
	  
	  driver=initializeDriver();
	  driver.get(prop.getProperty("url"));
	  
	  HomePage hp=new HomePage(driver);
	  hp.clickLogin().click();
	  
	  LoginPage lp= new LoginPage(driver);
	  lp.getEmail().sendKeys(email);
	  lp.getPassword().sendKeys(password);
	  lp.loginBtn().click();
	  System.out.println(textmsg);
  }
  
  @DataProvider
  public Object[][] getData(){
	  Object[][] data= new Object[3][3];
	  System.out.println(data.length);
		/*
		 * for(int i=0;i<data[0].length;i++) { for(int j=0;j<data[0].length;j++) {
		 * data[i][j]="" } }
		 */
	  data[0][0]="abc@gmail.com";
	  data[0][1]="pass123";
	  data[0][2]="Data 1 Submitted";
	  
	  data[1][0]="xyz@gmail.com";
	  data[1][1]="pass234";
	  data[1][2]="Data 2 Submitted";
	  
	  data[2][0]="pqr@gmail.com";
	  data[2][1]="pass456";
	  data[2][2]="Data 3 Submitted";
	  
	  return data;
  }
  
  @AfterTest
  public void tearDown() {
	  driver.close();
  }
  
}
