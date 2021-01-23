package classwork.jse;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import classwork.LaunchBase;

public class MiscDemo extends LaunchBase{

	public static void main(String[] args) throws Exception {
		MiscDemo obj = new MiscDemo();
		obj.launchBrowser("chrome", "http://selenium.dev");
		obj.pointDemo();
	}
	
	public void pointDemo() throws Exception {
		Thread.sleep(5000);
		WebElement header = driver.findElement(By.xpath("//input[@name='search']"));
		
		Point pobj = header.getLocation();
		System.out.println(" Point x " + pobj.getX());
		System.out.println(" Point y " + pobj.getY());
		System.out.println(pobj);
		Thread.sleep(2000);
		
		Dimension dim = header.getSize();
		System.out.println(" Height " + dim.height);
		System.out.println(" width " + dim.width);
		System.out.println(dim);
		
		Rectangle rt = header.getRect();
		System.out.println(" rect Height " + rt.height);
		System.out.println(" rect width " + rt.width);
		System.out.println(" rect x " + rt.getX());
		System.out.println(" rect y " + rt.getY());
		
		captureScreen("seleniun_home.png");
		
		KillProcess.killDrivers();
		
		//driver.quit();
	}

	public void captureScreen(String fileName) throws Exception {
		
		TakesScreenshot obj = (TakesScreenshot) driver;
		
		File ss = obj.getScreenshotAs(OutputType.FILE);
		
//		Path srcFilePath = Paths.get(ss.getAbsolutePath());
//		Path destDir = Paths.get(fileName);
//		Files.copy(srcFilePath, destDir, StandardCopyOption.REPLACE_EXISTING);
		
		FileHandler.copy(ss, new File(fileName));
		
	}

	
}
