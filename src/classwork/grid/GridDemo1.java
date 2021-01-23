package classwork.grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import classwork.poi.ReadDataSheet;

public class GridDemo1 {
	public WebDriver driver;
	public String bname = "Firefox";
	public String url = "http://automationpractice.com/";
	public String hubUrl = "http://localhost:4444/wd/hub";
	public String execSwitch="remote";
	
	@BeforeClass
	public void launchBrowser() throws Exception {
		
		if(execSwitch.equalsIgnoreCase("remote")) {
			 if(bname.equalsIgnoreCase("firefox")) {
				 FirefoxOptions opt = new FirefoxOptions();
				 driver = new RemoteWebDriver(new URL(hubUrl), opt);
			 } else if (bname.equalsIgnoreCase("chrome")) {
				 ChromeOptions opt = new ChromeOptions();
				 driver = new RemoteWebDriver(new URL(hubUrl), opt);
			 }
		} else {
			System.setProperty("webdriver.gecko.driver", "D:\\SeleniumTraining\\softwares\\driverexes\\geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\softwares\\driverexes\\chromedriver.exe");
			 if(bname.equalsIgnoreCase("firefox")) {
				 driver = new FirefoxDriver();

			 } else if (bname.equalsIgnoreCase("chrome")) {
				 driver = new ChromeDriver();
			 }
		}
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
	}
	

	@Test(priority=1, dataProvider="paramData", dataProviderClass=ReadDataSheet.class)
	public void searchDress(String sreach, String email) throws Exception {
		String searchXpath = "//input[@name='search_query']";
		String submitXpath = "//button[@class='btn btn-default button-search'][@name='submit_search']";
		
		driver.findElement(By.xpath(searchXpath)).click();
		driver.findElement(By.xpath(searchXpath)).clear();
		driver.findElement(By.xpath(searchXpath)).sendKeys(sreach);
		Thread.sleep(3000);
		driver.findElement(By.xpath(submitXpath)).click();
		Thread.sleep(3000);
		System.out.println(email);
	}
	@Test(priority=3)
	public void close() throws Exception {
		Thread.sleep(5000);
		System.out.println("closing browser");
		driver.quit();
	}
	
}
