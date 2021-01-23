package classwork.actionapi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import classwork.LaunchBase;

public class DragAndDroDemo extends LaunchBase{

	public static void main(String[] args) throws Exception {
		
		DragAndDroDemo obj = new DragAndDroDemo();
		obj.launchBrowser("Firefox", "https://jqueryui.com/droppable/");
		obj.dragAndDrop();
	}
	
	
	public void dragAndDrop() throws Exception {
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions builer = new Actions(driver);
		
		Action build = builer.dragAndDrop(drag, drop).build();
		build.perform();
		//Action build = builer.dragAndDropBy(drag, 300, 400).build();
		Action build2 = builer.dragAndDropBy(drag, drag.getLocation().getX() + 100, drag.getLocation().getY() + 200).build();
		build2.perform();
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		//driver.quit();
		
	}

}
