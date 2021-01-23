package classwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UsingWebElement extends LaunchBase {

	public static void main(String[] args) throws Exception {
		UsingWebElement obj = new UsingWebElement();
		obj.launchBrowser("chrome", "http://automationpractice.com/index.php");
		obj.elementsDemo();

	}

	
	public void elementsDemo() throws Exception {
		
		WebElement searchInput = driver.findElement(By.id("search_query_top")); // using id locator
		searchInput.click();
		searchInput.sendKeys("T-Shirts");
		
		Thread.sleep(5000);
		
		WebElement searchBtn = driver.findElement(By.name("submit_search")); //Using name locator
		searchBtn.click();
		Thread.sleep(5000);
		
		
		WebElement womenLnk = driver.findElement(By.linkText("Women")); //Using linkText locator
		womenLnk.click();
		Thread.sleep(5000);
		
		WebElement tLnk = driver.findElement(By.partialLinkText("-shirts")); //Using partial link text locator
		tLnk.click();
		Thread.sleep(5000);
		WebElement srch = driver.findElement(By.className("search_query"));// using class name
		srch.click();
		srch.sendKeys("Summer dresses");
		Thread.sleep(5000);
		WebElement srBtn = driver.findElement(By.tagName("button")); // using tagName
		srBtn.click();
		
		//driver.findElement(By.tagName("button")).click();
		
		Thread.sleep(5000);
		driver.close();
		
	}
}
