package classwork.alerts;

import java.util.Set;

import org.openqa.selenium.By;

import classwork.LaunchBase;

public class HandleMultiWindows extends LaunchBase {

	public static void main(String[] args) throws Exception {
		HandleMultiWindows obj = new HandleMultiWindows();
		obj.launchBrowser("chrome", "file:///D:/SeleniumTraining/9PMBatch/HTML/MultiWindows.html");
		obj.multiWin();
	}
	
	public void multiWin() throws Exception {
		
		String winid = driver.getWindowHandle();
		System.out.println("Window handle : " + winid);
		Thread.sleep(5000);
		String b1 = "//button[@id='nwindow1']";
		driver.findElement(By.xpath(b1)).click();
		System.out.println("Clicked on new window button");
		
		Set<String> winids = driver.getWindowHandles();
		System.out.println("Windows size : " + winids.size());
		Thread.sleep(5000);
		// Second window
		
		for(String wid : winids) {
			System.out.println("win handle id : " + wid);
			if(!wid.equals(winid)) {
				System.out.println("Switching to second window");
				driver.switchTo().window(wid);
				break;
			}
		}
		Thread.sleep(5000);
		String fd = "//button[.='FREE DEMO']";
		String sb = "//button[@id='simpleContactSubmitButton']";
		driver.findElement(By.xpath(fd)).click();
		if (driver.findElement(By.xpath(sb)).isDisplayed()) {
			System.out.println("Found the dialog");
		}
		Thread.sleep(5000);
		driver.close();
		Thread.sleep(5000);
		//switching to original
		driver.switchTo().window(winid);
		Thread.sleep(5000);
		if (driver.findElement(By.xpath("//button[.='New Tab']")).isDisplayed()) {
			System.out.println("back to main page");
		}
		Thread.sleep(5000);
		
		driver.quit();
		
	}


}
