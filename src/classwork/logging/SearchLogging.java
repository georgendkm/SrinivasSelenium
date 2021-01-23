package classwork.logging;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import classwork.poi.ReadDataSheet;

public class SearchLogging {
	public WebDriver driver;
	public String bname = "Firefox";
	public String url = "http://automationpractice.com/";
	Logger log;
	
	@BeforeClass
	public void launchBrowser() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "D:\\SeleniumTraining\\softwares\\driverexes\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\softwares\\driverexes\\chromedriver.exe");
			
		if(bname.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
	}
	
	@BeforeMethod
	public void initLog(Method m) throws Exception {
		SimpleDateFormat formater = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String dateTime = formater.format(new Date());
		String logfile="logs"+File.separator + m.getName()+dateTime+".xml";
		System.out.println(logfile);
		log = Logger.getLogger(logfile);
		log.setLevel(Level.ALL);
		FileHandler handler = new FileHandler(logfile);
		log.addHandler(handler);
		//handler.setFormatter(new SimpleFormatter());
		handler.setFormatter(new XMLFormatter());
	}
	
	@AfterMethod
	public void relLog() {
		for(Handler h: log.getHandlers()){
			h.close();   
		}
	}

	@Test(priority=1, dataProvider="paramData", dataProviderClass=ReadDataSheet.class)
	public void searchDress(String searchStr, String email) throws Exception {
		log.severe("Sample severe message");
		log.warning("This sample warning message");
		String searchXpath = "//input[@name='search_query']";
		String submitXpath = "//button[@class='btn btn-default button-search'][@name='submit_search']";
		log.info("xapth --> " + searchXpath);
		driver.findElement(By.xpath(searchXpath)).click();
		driver.findElement(By.xpath(searchXpath)).clear();
		driver.findElement(By.xpath(searchXpath)).sendKeys(searchStr);
		log.info("Search key entered.." + searchStr);
		Thread.sleep(3000);
		driver.findElement(By.xpath(submitXpath)).click();
		log.info("Clicked on Serch button");
		Thread.sleep(3000);
	}
	@Test(priority=3)
	public void close() throws Exception {
		Thread.sleep(5000);
		log.info("closing browser");
		driver.quit();
	}
}
