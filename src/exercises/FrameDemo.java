package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import classwork.LaunchBase;


public class FrameDemo extends LaunchBase{

	public static void main(String[] args) throws Exception {
		FrameDemo fo = new FrameDemo();
		fo.launchBrowser("chrome", "https://docs.oracle.com/javase/8/docs/api/index.html");
		fo.frameDemo();

	}
	
	public void frameDemo() throws Exception{
		
		String frame1Xpath = "//frame[@name='packageListFrame']";
		String frame2Xpath = "//frame[@name='packageFrame']";
		String frame3Xpath = "//frame[@name='classFrame']";
		WebElement frame1 = driver.findElement(By.xpath(frame1Xpath));
		WebElement frame2 = driver.findElement(By.xpath(frame2Xpath));
		WebElement frame3 = driver.findElement(By.xpath(frame3Xpath));
		// Switching to first frame
		driver.switchTo().frame(frame1);
		System.out.println("Switched to Frame1");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li/a[text()='java.applet']")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("switched to main");
		
		//Switching to second frame
		driver.switchTo().frame(frame2);
		System.out.println("Switched to Frame2");
		driver.findElement(By.xpath("//li/a[.='Applet']")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("switched to main");
		
		//Switching to third frame
		driver.switchTo().frame(frame3);
		System.out.println("Switched to Frame3");
		boolean tFlag = driver.findElement(By.xpath("//h2[@title='Class Applet']")).isDisplayed();
		System.out.println("Expected page display status : " + tFlag);
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("switched to main");
		
		driver.quit();
	}

}
