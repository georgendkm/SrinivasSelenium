package classwork.actionapi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import classwork.LaunchBase;
import exercises.IframeDemo;

public class UsingActions extends LaunchBase {

		public static void main(String[] args) throws Exception {
			UsingActions myObj = new UsingActions();
			myObj.launchBrowser("chrome", "https://jqueryui.com/");
			myObj.performActions();
		}
		
		public void performActions() throws Exception {
			
			Actions builder = new Actions(driver);
			
			WebElement we = driver.findElement(By.xpath("//li/a[.='Selectable']"));
			Action build = builder.click(we).build();
			build.perform();
			driver.switchTo().frame(0);
			Thread.sleep(5000);
			
			WebElement we2 = driver.findElement(By.xpath("//ol/li[.='Item 1']"));
			Action build2 = builder.click(we2).pause(2000).contextClick().pause(2000).doubleClick(we2).build();
			build2.perform();
			Thread.sleep(5000);
			
			driver.switchTo().defaultContent();
			
			WebElement we3 = driver.findElement(By.xpath("//li/a[.='Tooltip']"));
			Action build3 = builder.click(we3).build();
			build3.perform();
			driver.switchTo().frame(0);
			Thread.sleep(5000);
			
			WebElement we4 = driver.findElement(By.xpath("//a[.='Tooltips']"));
			Action build4 = builder.moveToElement(we4).build();
			build4.perform();
			Thread.sleep(5000);
			
			Action build5 = builder.sendKeys(Keys.ENTER).sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, "a")).build();
			build5.perform();
			
			build5 = builder.keyDown(Keys.SHIFT).sendKeys(Keys.ARROW_DOWN).keyUp(Keys.SHIFT).build();
			build5.perform();
			
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
			
			WebElement we5 = driver.findElement(By.xpath("//a[.='Button']"));
			new Actions(driver).click(we5).build().perform();
			new Actions(driver).keyDown(Keys.SHIFT).sendKeys(Keys.ARROW_DOWN).keyUp(Keys.SHIFT).build().perform();
			Thread.sleep(5000);
			driver.quit();
			
		}



}
