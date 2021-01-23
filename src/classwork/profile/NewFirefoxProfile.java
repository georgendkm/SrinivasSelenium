package classwork.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class NewFirefoxProfile {
public WebDriver driver;
	

	@Test
	public void launch() throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver","D:\\SeleniumTraining\\softwares\\driverexes\\geckodriver.exe");
		
		// Creating firefox profile
	        FirefoxProfile profile = new FirefoxProfile();
	 
	        // Instructing firefox to use custom download location
	        profile.setPreference("browser.download.folderList", 2);
	 
	        // Setting custom download directory
	        profile.setPreference("browser.download.dir","D:\\SeleniumTraining\\9PMNew\\JavaSelenium\\downloads");
	 
	        // Skipping Save As dialog box for types of files with their MIME
	        //profile.setPreference("browser.helperApps.neverAsk.saveToDisk", 
	        //        "multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,text/csv,application/java-archive, application/x-msexcel,application/excel,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/vnd.microsoft.portable-executable");
	        profile.setPreference("pdfjs.disabled", true);
	  		 String mimes = "application/pdf,application/x-pdf,"
    		 + "application/zip,application/x-7z-compressed,application/x-zip-compressed,application/x-compressed,application/octet-stream,"
    		 + "text/csv,text/html,text/plain,"
    		 + "application/java-archive,"
    		 + "application/x-msexcel,application/excel,application/x-excel"
    		 + "image/png,image/jpeg,"
    		 + "application/msword,"
    		 + "application/xml";
    		 
	        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",mimes);
	        
	        // Creating FirefoxOptions to set profile
	        FirefoxOptions option = new FirefoxOptions();
	        option.setProfile(profile);
	        // Launching browser with desired capabilities
	        driver = new FirefoxDriver(option);
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
