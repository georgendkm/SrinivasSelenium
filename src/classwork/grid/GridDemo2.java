package classwork.grid;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import classwork.poi.ReadDataSheet;
import classwork.pom.pages.SearchPage;
import classwork.pom.pages.SignPage;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;


public class GridDemo2 {

	public WebDriver driver;
	public String bname = "Chrome";
	public String url = "http://automationpractice.com/";
	public String hubUrl = "http://localhost:4444/wd/hub";
	public String execSwitch="remote";
	SearchPage searchPage = null;
	SignPage signInPage = null;
	
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
		searchPage= PageFactory.initElements(driver,SearchPage.class);
		signInPage= PageFactory.initElements(driver,SignPage.class);
	}
	
	@Test(priority=1)
	public void searchDress() {
		boolean rFlag = searchPage.searchDress("Summer Dresses");
		Assert.assertTrue(rFlag, "Failed to peroform search operation");
		String reMsg = searchPage.verifyResults();
		System.out.println("return message : " + reMsg);
		Assert.assertTrue(reMsg.isEmpty(), reMsg);
	}
	@Test(priority=2)
	public void createNewUser() throws Exception {
		boolean rflag = signInPage.createUser("646test1@test484.com");
		Assert.assertTrue(rflag, "Failed to create the user");
	}
	
	@AfterClass
	public void closeBrowser() throws Exception {
		driver.quit();
	}

}
