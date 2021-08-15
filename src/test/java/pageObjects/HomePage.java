package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@id=\"homepage\"]/header/div[1]/div/nav/ul/li[4]/a/span") WebElement login;
	@FindBy(xpath="//*[@id=\"content\"]/div/div/h2") WebElement pageTitle;
	
	public WebElement clickLogin() {
		return login;
	}
	
	public WebElement getPageTitle() {
		return pageTitle;
	}

}
