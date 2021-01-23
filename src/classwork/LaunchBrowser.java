package classwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser {

	public static void main(String[] args) throws Exception {
		
		String browser = "chrome";
		
		System.setProperty("webdriver.gecko.driver", "D:\\SeleniumTraining\\softwares\\driverexes\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\softwares\\driverexes\\chromedriver.exe");
		
		WebDriver driver;
		
		if(browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		driver.get("http://selenium.dev");
		Thread.sleep(5000);

		String cururl = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		System.out.println("Page url : " + cururl);
		System.out.println("Page title : " + title);
		
		String psource = driver.getPageSource();
		System.out.println("Page Source : " + psource);
		
		driver.close();
		

	}

}
