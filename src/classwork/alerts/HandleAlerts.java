package classwork.alerts;

import org.openqa.selenium.By;

import classwork.LaunchBase;

public class HandleAlerts extends LaunchBase {

	public static void main(String[] args) throws Exception {
		HandleAlerts obj = new HandleAlerts();
		obj.launchBrowser("firefox", "file:///D:/SeleniumTraining/9PMBatch/HTML/Alert.html");
		obj.alertHanding();
	}
	
	public void alertHanding() throws Exception {
		
		String b1 = "//button[@name='btnAlert']";
		String b2 = "//button[@name='btnConfirm']";
		String b3 = "//button[@name='btnPrompt']";
		
		// Handling simple alert
		driver.findElement(By.xpath(b1)).click();
		Thread.sleep(3000);
		String msg = driver.switchTo().alert().getText();
		System.out.println("Message displayed : " + msg);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		System.out.println("accepted alert1");
		
		// Handling Confirm alert
		driver.findElement(By.xpath(b2)).click();
		Thread.sleep(3000);
		msg = driver.switchTo().alert().getText();
		System.out.println("Message displayed : " + msg);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		System.out.println("accepted alert2");
		driver.findElement(By.xpath(b2)).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(3000);
		System.out.println("Dismissed alert2");
		
		// Handling prompt alert
		driver.findElement(By.xpath(b3)).click();
		Thread.sleep(3000);
		msg = driver.switchTo().alert().getText();
		System.out.println("Message displayed : " + msg);
		driver.switchTo().alert().sendKeys(" Happy new Year ");
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		System.out.println("accepted alert3");
		
		driver.findElement(By.xpath(b3)).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(3000);
		System.out.println("Dismissed alert3");
		
	}

}
