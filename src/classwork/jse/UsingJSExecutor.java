package classwork.jse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import classwork.LaunchBase;

public class UsingJSExecutor extends LaunchBase{

	public static void main(String[] args) throws Exception  {
		
		UsingJSExecutor obj = new UsingJSExecutor();
		obj.launchBrowser("firefox", "http://automationpractice.com/");
		obj.jsExecutor();

	}
	
	public void jsExecutor() throws Exception {
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String purl = (String) js.executeScript("return document.URL;");
		
		System.out.println("Url --> " + purl);
		String ptitle = js.executeScript("return document.title;").toString();
		System.out.println("Title --> " + ptitle);
		
		WebElement search = driver.findElement(By.name("search_query"));
		
		js.executeScript("arguments[0].value='T-Shirts';", search);
		Thread.sleep(3000);
		
		WebElement searchBtn = driver.findElement(By.name("submit_search"));
		
		js.executeScript("arguments[0].click();", searchBtn);
		Thread.sleep(3000);
		
		WebElement gettxt = driver.findElement(By.xpath("//h1//span"));
		js.executeScript("return arguments[0].text;", gettxt);
		Thread.sleep(3000);
		
		//Navigating to different url
		js.executeScript("window.location = 'http://selenium.dev/'");
		Thread.sleep(3000);
		
		js.executeScript("window.scrollBy(0,700)");
		
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(5000);
		
		WebElement header = driver.findElement(By.xpath("//a[@class='headerLink']"));
		js.executeScript("arguments[0].scrollIntoView();", header);
		
		Thread.sleep(5000);
		

		
		driver.quit();
		
		
	}
	
	


}
