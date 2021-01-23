package classwork.explicitwaits;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import classwork.LaunchBase;

public class FluentWaitDemo extends LaunchBase{

	public static void main(String[] args) throws Exception {

		FluentWaitDemo obj = new FluentWaitDemo();
		obj.launchBrowser("firefox", "http://automationpractice.com/index.php");
		obj.testFluentWait();
		
	}
	
	public void testFluentWait() {
		
		String logo = "//a[@title='My Store']/img";
		String cart = "//a/b[.='Cart']/following-sibling::span[.='1']";
		
		WebElement logoEle = fluentWait(logo, 50, 10);
		logoEle.click();
		
		WebElement cartEle = fluentWait(cart, 60, 15);
		cartEle.click();
		
	}
	
	
	public WebElement fluentWait(String xapth, int timeout, int polltime) {
		
		Wait wait = new FluentWait(driver)
						.withTimeout(Duration.ofSeconds(timeout))
						.pollingEvery(Duration.ofSeconds(polltime))
						.ignoring(Exception.class);
		
		
		WebElement ele = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
				 							public WebElement apply(WebDriver driver) {
				 								WebElement element = driver.findElement(By.xpath(xapth));
				 								return element;
				 							}
										});
		return ele;

	}

}
