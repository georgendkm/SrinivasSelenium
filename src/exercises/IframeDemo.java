package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import classwork.LaunchBase;

public class IframeDemo extends LaunchBase{
	
	public static void main(String[] args) throws Exception {
		IframeDemo myObj = new IframeDemo();
		myObj.launchBrowser("chrome", "https://jqueryui.com/");
		myObj.iFrameMethod();
	}

	public void iFrameMethod() throws Exception {
        
      String inputXpath = "//a[text()='Sortable']";
      
      driver.findElement(By.xpath(inputXpath)).click();
      Thread.sleep(3000);

      WebElement frameElmt = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
      driver.switchTo().frame(frameElmt);
      System.out.println("Switched to frame");
      Thread.sleep(5000);
      
      WebElement sortElmt =  driver.findElement(By.xpath("//ul[@id='sortable']//li[contains(text(),'Item 1')]"));
      new Actions(driver).dragAndDropBy(sortElmt, 0, 50).build().perform();
      Thread.sleep(5000);
      driver.switchTo().defaultContent();
      driver.findElement(By.xpath("//a[text()='Selectable']")).click();
      Thread.sleep(5000);
      driver.quit();
	}

}
