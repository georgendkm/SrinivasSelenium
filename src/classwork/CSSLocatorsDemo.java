package classwork;

import org.openqa.selenium.By;

public class CSSLocatorsDemo extends LaunchBase {

	public static void main(String[] args) throws Exception {

		CSSLocatorsDemo obj = new CSSLocatorsDemo();
		obj.launchBrowser("Firefox", "http://automationpractice.com/index.php");
		obj.cssLocators();
	}
	
	public void cssLocators() throws Exception {
		// syntax :  tagname#idvalue
		String seachCss = "input#search_query_top"; // with id
		//input#search_query_top[type=text]  -  with id and an attribute
		//input[name=search_query]  -  with name attribute
		//input#search_query_top.search_query   -  both id and class
//		/input#search_query_top[name='search_query']  - id and name
		
		//input[name^=search]// prefix of name attribute
		//form input + input + input + input - with sibling
		//form input:nth-child(4) - using nth-child
		driver.findElement(By.cssSelector(seachCss)).click();
		driver.findElement(By.cssSelector(seachCss)).sendKeys("Casual dresses");
		Thread.sleep(3000);
		
		
		
		//String searchBtncss = "button.btn"; // with class
		String searchBtncss = "button.btn[name=submit_search]"; //with class and name attribute
		//button.btn[name=submit_search][type=submit] // with class and 2 attributes
		//button[name$=search]  -  post fix of attribute
		//button[name*='t_s'] - Substring attribute
		//button[name*='t_s'][type^=submit] - substring and starts with(prefix)
		driver.findElement(By.cssSelector(searchBtncss)).click();
		
		//form > button - immediate parent
		//div > form > button - prent and grand parent
		// div form > button - grand and immeidate parent
				
	}
	


}
