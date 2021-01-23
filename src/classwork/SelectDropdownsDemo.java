package classwork;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownsDemo extends LaunchBase {

	public static void main(String[] args) throws Exception {
		SelectDropdownsDemo obj = new SelectDropdownsDemo();
		obj.launchBrowser("chrome", "file:///D:/SeleniumTraining/9PMBatch/HTML/SelectDropdowns.html");
		//obj.multiSelector();
		obj.selectNewDropdown();
	}
	
	public void multiSelector() throws Exception {
		
		String destXpath = "//select[@id='destination']";
		String multiXpath = "//select[@name='cars']";
		
		
		Select dest = new Select(driver.findElement(By.xpath(destXpath)));
		dest.selectByVisibleText("Las Vegas");
		Thread.sleep(2000);
		dest.selectByValue("someotherplace");
		Thread.sleep(2000);
		System.out.println("Is dest is multi selector ? "+ dest.isMultiple());
		
		Select multi = new Select(driver.findElement(By.xpath(multiXpath)));
		System.out.println("Is multi is multi selector ? "+ multi.isMultiple());
		multi.selectByVisibleText("Volvo");
		Thread.sleep(2000);
		multi.selectByIndex(3);
		Thread.sleep(2000);
		multi.selectByValue("vw");
		Thread.sleep(5000);
		
		multi.deselectByIndex(3);
		Thread.sleep(2000);
		multi.deselectByVisibleText("Volvo");
		Thread.sleep(2000);
		multi.deselectByValue("vw");
		
		Thread.sleep(5000);
		
		multi.selectByVisibleText("Opel");
		multi.selectByVisibleText("Toyota");
		Thread.sleep(5000);
		multi.deselectAll();
		System.out.println("--------- Getting options values ----------");
		List<WebElement> options =  multi.getOptions();
		for(WebElement ele : options) {
			System.out.println(ele.getAttribute("value"));
		}
	}
	
	public void selectNewDropdown() throws Exception {
		
		driver.get("https://jqueryui.com/selectmenu/");
		Thread.sleep(5000);
		
		driver.switchTo().frame(0);
		
		String speedXpath = "//span[@id='speed-button']";
		String eleXpath = "//ul[@id='speed-menu']/li/div[text()='Faster']";
		
		
		driver.findElement(By.xpath(speedXpath)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(eleXpath)).click();
		Thread.sleep(2000);
	}

}
