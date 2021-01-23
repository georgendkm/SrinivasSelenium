package classwork;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FindElementsDemo extends LaunchBase{

	public static void main(String[] args) throws Exception{
		
		FindElementsDemo obj = new FindElementsDemo();
		obj.launchBrowser("chrome", "http://automationpractice.com/index.php");
		obj.elements();

	}
	
	public void elements() {
		
		List<WebElement> inputs = driver.findElements(By.tagName("input"));
		System.out.println("inputs size : " + inputs.size());
		inputs.get(3).click();
		inputs.get(3).sendKeys("Casual dresses");
		
//		System.out.println( "size : " + driver.findElements(By.tagName("input")).size());
//		driver.findElements(By.tagName("input")).get(3).click();
//		driver.findElements(By.tagName("input")).get(3).sendKeys("Summer dresses");
		
		List<WebElement> buttons = driver.findElements(By.tagName("button"));
		System.out.println("buttons size : " + buttons.size());
		buttons.get(0).click();
		
		
	}

}
