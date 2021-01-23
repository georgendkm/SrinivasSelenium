package classwork;

import org.openqa.selenium.Point;

public class BrowserManageOptions extends LaunchBase{

	public static void main(String[] args) throws Exception {
		
		BrowserManageOptions obj = new BrowserManageOptions();
		obj.launchBrowser("chrome", "http://google.com");
		obj.mannagOpsCookies();
		obj.manageWindw();
		
	}
	
	public void mannagOpsCookies() {
		System.out.println(" no.of cookies : " + driver.manage().getCookies().size());
		System.out.println("cookies : " + driver.manage().getCookies());
		driver.manage().deleteAllCookies();
		System.out.println(" no.of cookies : " + driver.manage().getCookies().size());
		System.out.println("cookies : " + driver.manage().getCookies());
	}
	
	public void manageWindw() throws Exception {
		Thread.sleep(5000);
		System.out.println("default : " + driver.manage().window().getPosition());
		System.out.println("default : " + driver.manage().window().getSize());
		driver.manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("after maxim : " + driver.manage().window().getPosition());
		System.out.println("after maxim : " + driver.manage().window().getSize());
		driver.manage().window().fullscreen();
		Thread.sleep(5000);
		System.out.println("after fs : " + driver.manage().window().getPosition());
		System.out.println("after fs : " + driver.manage().window().getSize());
		Point p = new Point(100, 500);
		driver.manage().window().setPosition(p);
		System.out.println("after set : " + driver.manage().window().getPosition());
		System.out.println("after set : " + driver.manage().window().getSize());
	}

}
