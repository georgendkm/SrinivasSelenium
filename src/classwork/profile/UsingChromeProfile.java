package classwork.profile;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class UsingChromeProfile {
	
	public WebDriver driver;
	@Test
	public void launch() throws InterruptedException {

		//System.setProperty("webdriver.gecko.driver","D:\\SeleniumTraining\\softwares\\driverexes\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","D:\\SeleniumTraining\\softwares\\driverexes\\chromedriver.exe");
		  // Setting new download directory path
        Map<String, Object> prefs = new HashMap<String, Object>();
         
        // Use File.separator as it will work on any OS
        prefs.put("download.default_directory", "D:\\SeleniumTraining\\9PMNew\\JavaSelenium\\downloads\\");
        prefs.put("plugins.always_open_pdf_externally", true);
        // Adding capabilities to ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        // Launching browser with desired capabilities
        driver= new ChromeDriver(options);
		
    	driver.get("file:///D:/SeleniumTraining/9PMNew/HTML/FileUpLoad.html");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Download Me']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@id='fileToUpload']")).sendKeys("D:\\SeleniumTraining\\9PMNew\\HTML\\JDK_and_Eclipse_Setup.pdf");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@name='uploadfile']")).click();
		Thread.sleep(5000);
		driver.quit();
	}
}
