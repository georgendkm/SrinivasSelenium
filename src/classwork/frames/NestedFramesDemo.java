package classwork.frames;

import org.openqa.selenium.By;

import classwork.LaunchBase;

public class NestedFramesDemo extends LaunchBase{

	public static void main(String[] args) throws Exception {
		NestedFramesDemo obj = new NestedFramesDemo();
		obj.launchBrowser("Firefox", "file:///D:/SeleniumTraining/9PMBatch/HTML/FramesNested.html");
		obj.nestedFrames();
	}
	
	public void nestedFrames() throws Exception{
		
		int size = driver.findElements(By.xpath("//iframe")).size();
		System.out.println("No.of frames in Main: " + size );
		Thread.sleep(5000);
		//Switching to first frame
		driver.switchTo().frame(0);
		size = driver.findElements(By.xpath("//iframe")).size();
		System.out.println("No.of frames in Frame1: " + size );
		Thread.sleep(5000);
		//Switching to second frame
		driver.switchTo().frame(0);
		size = driver.findElements(By.xpath("//iframe")).size();
		System.out.println("No.of frames in Frame2: " + size );
		Thread.sleep(5000);
		//Switching to third frame
		driver.switchTo().frame(0);
		size = driver.findElements(By.xpath("//iframe")).size();
		Thread.sleep(5000);
		System.out.println("No.of frames in Frame3: " + size );
		driver.findElement(By.xpath("//input[@name='userName']")).click();
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='usePwd']")).sendKeys("password");
		System.out.println("entered username and pasword");
		Thread.sleep(5000);
		//Switching to parent frame 2
		driver.switchTo().parentFrame();
		System.out.println("Swiched to frame2");
		driver.findElement(By.xpath("//button[@name='Login']")).click();
		System.out.println("Clicked on login button");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		
		
		
	}

}
