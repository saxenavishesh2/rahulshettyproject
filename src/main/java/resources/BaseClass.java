package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		
		prop= new Properties();
		FileInputStream inp=new FileInputStream("D:\\EclipseWorkspace\\RahulShettyProject\\src\\main\\java\\Properties\\config.properties");
		prop.load(inp);
		
		String browser=System.getProperty("browser");
		System.out.println(browser);
		if(browser.contains("chrome")){
			WebDriverManager.chromedriver().setup();
			ChromeOptions options= new ChromeOptions();
			if(browser.contains("headless")) {
				options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
		}else if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("ie")){
			WebDriverManager.iedriver().setup();
			driver=new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public void captureScreenshot(String filename,WebDriver driver) throws IOException {
		
		File ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(ss,new File(System.getProperty("user.dir")+"\\reports\\"+filename+".png"));
		
	}

}
