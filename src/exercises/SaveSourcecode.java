package exercises;

import java.io.FileWriter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SaveSourcecode {
	
public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "D:\\SeleniumTraining\\softwares\\driverexes\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\softwares\\driverexes\\chromedriver.exe");
		
		
		String url = "http://google.com";
		WebDriver driver = null;
		String browser = "FF";
		
		if(browser.equalsIgnoreCase("ff")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		driver.get(url);
		Thread.sleep(5000);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		driver.manage().deleteAllCookies();
		Thread.sleep(1000);
		String curl = driver.getCurrentUrl();
		System.out.println("Current url ->" + curl);
		System.out.println("_________________________________________________");

		String title = driver.getTitle();
		System.out.println("Title ->" + title);
		System.out.println("_________________________________________________");

		String psource = driver.getPageSource();
	    FileWriter oStream = null;
        try {
        	oStream = new FileWriter("PageSource.html");
        	oStream.write(psource);
        } finally {

            if (oStream != null) {
            	oStream.close();
            }
        }
        System.out.println("Page Source File Created");
				
		driver.close(); // Close the current browser
	}


}
