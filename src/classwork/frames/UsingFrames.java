package classwork.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import classwork.LaunchBase;

public class UsingFrames extends LaunchBase{

	public static void main(String[] args) throws Exception {
		UsingFrames obj = new UsingFrames();
		obj.launchBrowser("Firefox", "file:///D:/SeleniumTraining/9PMBatch/HTML/Frames.html");
		boolean rFlag = obj.handleFrames();
		if(rFlag) {
			System.out.println("Frames handling successful");
		} else {
			System.out.println("Failed to execute");
		}
	}
	
	public boolean handleFrames() throws Exception {
		
		//finding no.of frames in page
		int size = driver.findElements(By.xpath("//frame")).size();
		System.out.println("No of frames in Main page : " + size);
		
		// switching to first frame
		driver.switchTo().frame(0);
		
		String f1InputXpath = "//input[@id='Frame1txt']";
		if (driver.findElement(By.xpath(f1InputXpath)).isDisplayed()) {
			System.out.println("In frame 1");
			driver.findElement(By.xpath(f1InputXpath)).clear();
			driver.findElement(By.xpath(f1InputXpath)).sendKeys(" Frame1 Text ");
			Thread.sleep(2000);
		} else {
			System.out.println("Failed to switch frame1");
			return false;
		}
		driver.switchTo().defaultContent(); // Switch to page
		
		//Switching to second frame
		driver.switchTo().frame("frame_b");
		String f2InputXpath = "//input[@id='Frame2txt']";
		if (driver.findElement(By.xpath(f2InputXpath)).isDisplayed()) {
			System.out.println("In frame 2");
			driver.findElement(By.xpath(f2InputXpath)).clear();
			driver.findElement(By.xpath(f2InputXpath)).sendKeys(" Frame2 Text ");
			Thread.sleep(2000);
		} else {
			System.out.println("Failed to switch frame2");
			return false;
		}
		driver.switchTo().defaultContent(); // Switch to page
		
		//Switching to third frame
		WebElement f3 = driver.findElement(By.xpath("//frame[@name='frame_c']"));
		driver.switchTo().frame(f3);
		String f3InputXpath = "//input[@id='Frame3txt']";
		if (driver.findElement(By.xpath(f3InputXpath)).isDisplayed()) {
			System.out.println("In frame 3");
			driver.findElement(By.xpath(f3InputXpath)).clear();
			driver.findElement(By.xpath(f3InputXpath)).sendKeys(" Frame3 Text ");
			Thread.sleep(2000);
		} else {
			System.out.println("Failed to switch frame3");
			return false;
		}
		driver.switchTo().defaultContent(); // Switch to page
		return true;
	}

}
