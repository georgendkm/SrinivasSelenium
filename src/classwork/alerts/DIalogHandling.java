package classwork.alerts;

import org.openqa.selenium.By;

import classwork.LaunchBase;

public class DIalogHandling extends LaunchBase {

	public static void main(String[] args) throws Exception {
		DIalogHandling obj = new DIalogHandling();
		obj.launchBrowser("firefox", "file:///D:/SeleniumTraining/9PMBatch/HTML/Dialog.html");
		obj.handleDialog();
	}
	
	public void handleDialog() throws Exception {
		String loginbtn = "//button[@id='myBtn']";
		String uname = "//input[@id='username']";
		String upwd = "//input[@id='pwd']";
		String lbtn = "//button[@name='Login']";
		
		driver.findElement(By.xpath(loginbtn)).click();
		Thread.sleep(3000);
		if(driver.findElement(By.xpath(uname)).isEnabled()) {
			System.out.println("Found dialog");
		} else {
			throw new Exception("Dialog not found");
		}
		driver.findElement(By.xpath(uname)).sendKeys("admin");
		Thread.sleep(3000);
		driver.findElement(By.xpath(upwd)).sendKeys("admin");
		Thread.sleep(3000);
		driver.findElement(By.xpath(lbtn)).click();
	}

}
