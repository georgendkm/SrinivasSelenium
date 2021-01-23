package classwork.explicitwaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import classwork.LaunchBase;

public class WebDriverWaitDemo extends LaunchBase {

	public static void main(String[] args) throws Exception {
		
		WebDriverWaitDemo obj = new WebDriverWaitDemo();
		obj.launchBrowser("firefox", "http://automationpractice.com/index.php");
		obj.wwait();
		
	}
	
	public void wwait() {
		String logo = "//a[@title='My Store']/img";
//		WebDriverWait wait =new WebDriverWait(driver, 45);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(logo))));
//		
//		WebDriverWait wait2 =new WebDriverWait(driver, 30);
		String cart = "//a/b[.='Cart']/following-sibling::span[.='1']";
//		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(cart)));
		waitUntilVisible(logo, 15);
		waitUntilVisible(cart, 30);
		
	}
	
	public void  waitUntilVisible(String xpath, int timeout) {
		WebDriverWait wait =new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(xpath))));
	}

}
