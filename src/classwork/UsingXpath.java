package classwork;

import org.openqa.selenium.By;

public class UsingXpath extends LaunchBase{

	public static void main(String[] args)  throws Exception{
		UsingXpath obj = new UsingXpath();
		obj.launchBrowser("firefox", "http://automationpractice.com/index.php");
		obj.searchXpath();
		
		
	}
	
	public void searchXpath() throws Exception {
		
		String searchXpath = "//input[@name='search_query']";
		String submitXpath = "//button[@class='btn btn-default button-search'][@name='submit_search']";
		
		
		driver.findElement(By.xpath(searchXpath)).click();
		driver.findElement(By.xpath(searchXpath)).sendKeys("Winter dresses");
		Thread.sleep(3000);
		driver.findElement(By.xpath(submitXpath)).click();
		
		//button[contains(@class,'btn')][@name='submit_search']  - using contains
		//button[contains(@class,'btn')  and (@name='submit_search')] - using and
		//button[contains(@class,'btnzzzz')  or  (@name='submit_search')] - using or 
		
		//input[starts-with(@id,'customer_first')] - using starts-with
		
		//a[text()='Women'] - using text() - finding women link
		
		//a[(text()='Women') and (@title='Women')] - using both text() and title
		//button/span[.='Search'] - using . in place of text()
		
		String linkXpath = "//a[text()='dyntext']"; // dynamic

		driver.findElement(By.xpath(linkXpath.replace("dyntext", "Women"))).click();
		driver.findElement(By.xpath(linkXpath.replace("dyntext", "T-Shirts"))).click();
		driver.findElement(By.xpath(linkXpath.replace("dyntext", "Dresses"))).click();
//		String wPath = linkXpath.replace("dyntext", "Women");
//		String tPath = linkXpath.replace("dyntext", "T-shirt");
//		String dPath = linkXpath.replace("dyntext", "Dresses");
		
		//a[normalize-space(text())='Sign in']  - using nomalize space - removes trailing and leading spaces while comparing 
		
		//form/input[not(contains(@type,'hidden'))] - using not and contains
		//form/input[not(@type='hidden')] - not and with equals
		
		//form/input[not(@type='hidden') and (@name='search_query')] - this not & and
		
		//div/form/input - navigating to immediate child from Div->form->input ( single slash)
		
		//div//input - navigating to grand child or descendant
		//div/descendant::input - navigating to grand child or descendant
		
		//input/parent::form- using immediate parent
		//input/.. - using immediate parent
		//input/ancestor::div[1] - immediate grand parent or ancestor
		
		//input/parent::form[@id='searchbox']/ancestor::div[1]- using both parent and ancestor		
		
		//div/following::input - using following (similar to descendant)
		
		//div/following::input[@id='newsletter-input'][1]  using following along with index and attribute
		
		//form/input/following-sibling::input[3] - using following-sibling ( top -> bottom)
		
		//form/button/preceding-sibling::input[1] - using preceding-sibling ( bottom -> top)
		
		//label[contains(text(),'First name')]/following-sibling::input[@id='firstname'] // finding inputbox with label
		//input[@id='firstname']/preceding-sibling::label // finding label based on input using preceding-sibling
		
		//*[@id='firstname']//self::input - to refer to self based on dynamic tag name
		
		
	}

}
