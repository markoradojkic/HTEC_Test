package htec.selenium.webdriver;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import htec.selenium.webdriver.CheckMessage;


public class CheckMessage {

	public static void main(String[] args) {
		
		//Instantiate objects. Set properties, define location
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\Automation\\Drivers\\Selenium chrome driver v2.35\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		CheckMessage myObj = new CheckMessage();

		//Call the method that will set up the browser
		driver = myObj.invokeBrowser(driver);
		
		
		//Log in with first user and leave two messages in two topics
		
		
		//Go to the login page
		driver.navigate().to("https://tenant.staging-9mentors.com/login");
		
		//Wait for an element to load and become clickable - login button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div/div/div[2]/form/button")));
		
		//Assert that login page was successfully loaded
		assertTrue("Element not found!", elementExists("/html/body/div/div/div/div/div/div[2]/form/button", driver));
		
		//Type in username - email
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/form/input[1]")).sendKeys("marko.radojkic@yopmail.com");
		
		//Type in the correct password
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/form/input[2]")).sendKeys("123123");
				
		//Click the Log in button
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/form/button")).click();
		
		//Wait for an element to load and become clickable - My Groups button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div[1]/ul/li[2]/a")));
				
		//Assert that login was successful by checking that My Groups button has loaded properly
		assertTrue("Element not found!", elementExists("/html/body/div/div[3]/div[1]/ul/li[2]/a", driver));
		
		//Click the My Groups button
		driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/ul/li[2]/a")).click();
		
		//Wait for an element to load and become clickable - Test Automation Group
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[4]/div[1]/div/div/div[2]/div/div[1]/div/div/div/div[1]/h3/a")));
		
		//Assert that Test Automation Group has loaded properly
		assertTrue("Element not found!", elementExists("/html/body/div/div[4]/div[1]/div/div/div[2]/div/div[1]/div/div/div/div[1]/h3/a", driver));
				
		//Click on the Test Automation Group
		driver.findElement(By.xpath("/html/body/div/div[4]/div[1]/div/div/div[2]/div/div[1]/div/div/div/div[1]/h3/a")).click();
		
		//Wait for an element to load and become clickable - First topic
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='topic-navigation']/div[2]/div/ul/li/a/div/div/div")));
		
		//Assert that First topic has loaded properly
		assertTrue("Element not found!", elementExists("//*[@id='topic-navigation']/div[2]/div/ul/li/a/div/div/div", driver));
		
		//Click on the First topic
		driver.findElement(By.xpath("//*[@id='topic-navigation']/div[2]/div/ul/li/a/div/div/div")).click();
		
		//Wait for an element to load and become clickable - message field
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='topics']/div/div/div[5]/div[3]/textarea")));
				
		//Assert that the message field has loaded properly
		assertTrue("Element not found!", elementExists("//*[@id='topics']/div/div/div[5]/div[3]/textarea", driver));
						
		//Type in the first message
		driver.findElement(By.xpath("//*[@id='topics']/div/div/div[5]/div[3]/textarea")).sendKeys("Test1");
		
		//Click the send message button
		driver.findElement(By.xpath("//*[@id='topics']/div/div/div[5]/div[4]/button")).click();
		
		//Assert that the second topic has loaded properly
		assertTrue("Element not found!", elementExists("//*[@id='topic-navigation']/div[2]/div/ul/li/ul/li[1]/a/div/div/div/div", driver));
		
		//Click the second topic (in this case I selected: Topic 2018-02-20 54.716)
		driver.findElement(By.xpath("//*[@id='topic-navigation']/div[2]/div/ul/li/ul/li[1]/a/div/div/div/div")).click();
		
		//Wait for an element to load and become clickable - message field
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='topics']/div/div/div[5]/div[3]/textarea")));
		
		//Assert that the message field has loaded properly
		assertTrue("Element not found!", elementExists("//*[@id='topics']/div/div/div[5]/div[3]/textarea", driver));
		
		//Type in the second message
		driver.findElement(By.xpath("//*[@id='topics']/div/div/div[5]/div[3]/textarea")).sendKeys("Test2");
		
		//Click the send message button
		driver.findElement(By.xpath("//*[@id='topics']/div/div/div[5]/div[4]/button")).click();
		
		//Wait for an element to load and become clickable - profile link's dropdown arrow
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div[3]/span[5]/md-menu/a")));
				
		//Assert that the profile link's dropdown arrow has loaded properly
		assertTrue("Element not found!", elementExists("/html/body/div[1]/div[2]/div/div[3]/span[5]/md-menu/a", driver));
		
		//Click on the profile link's dropdown arrow
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/span[5]/md-menu/a")).click();		
			
		//Wait for an element to load and become clickable - log out option
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu_container_3']/md-menu-content/md-menu-item[4]/a/div/p")));
						
		//Assert that the log out option has loaded properly
		assertTrue("Element not found!", elementExists("//*[@id='menu_container_3']/md-menu-content/md-menu-item[4]/a/div/p", driver));
				
		//Click on the log out option
		driver.findElement(By.xpath("//*[@id='menu_container_3']/md-menu-content/md-menu-item[4]/a/div/p")).click();	
		
		
		//Log in with second user and assert if messages are displayed
		
		
		//Wait for an element to load and become clickable - login button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div/div/div[2]/form/button")));
				
		//Assert that login page was successfully loaded
		assertTrue("Element not found!", elementExists("/html/body/div/div/div/div/div/div[2]/form/button", driver));
				
		//Type in username - email
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/form/input[1]")).sendKeys("marko.radojkic2@yopmail.com");
				
		//Type in the correct password
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/form/input[2]")).sendKeys("123123");
						
		//Click the Log in button
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/form/button")).click();
		
		//Wait for an element to load and become clickable - My Groups button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div[1]/ul/li[2]/a")));
						
		//Assert that  My Groups button has loaded properly
		assertTrue("Element not found!", elementExists("/html/body/div/div[3]/div[1]/ul/li[2]/a", driver));
				
		//Click the My Groups button
		driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/ul/li[2]/a")).click();
					
		//Wait for an element to load and become clickable - table view
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[4]/div[1]/div/div/div[1]/div/a[3]/span")));
								
		//Assert that table view button has loaded properly
		assertTrue("Element not found!", elementExists("/html/body/div/div[4]/div[1]/div/div/div[1]/div/a[3]/span", driver));
						
		//Click the table view button
		driver.findElement(By.xpath("/html/body/div/div[4]/div[1]/div/div/div[1]/div/a[3]/span")).click();		
				
		//Wait for an element to load and become clickable - Test Automation Group
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[4]/div[1]/div/div/div[3]/div/table/tbody/tr[1]/td[1]/span")));
										
		//Assert that Test Automation Group has loaded properly
		assertTrue("Element not found!", elementExists("/html/body/div/div[4]/div[1]/div/div/div[3]/div/table/tbody/tr[1]/td[1]/span", driver));
								
		//Click the Test Automation Group
		driver.findElement(By.xpath("/html/body/div/div[4]/div[1]/div/div/div[3]/div/table/tbody/tr[1]/td[1]/span")).click();	
		
		//Wait for an element to load and become clickable - new message
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='topics']/div/div/div[2]/div/div[2]/div[2]/div[last()]/div/div[1]/div[last()]/span/pre")));
												
		//Assert that the new message has loaded properly
		assertTrue("Element not found!", elementExists("//*[@id='topics']/div/div/div[2]/div/div[2]/div[2]/div[last()]/div/div[1]/div[last()]/span/pre", driver));
		
		//Assert that the new message contains the proper text
		String actualString = driver.findElement(By.xpath("//*[@id='topics']/div/div/div[2]/div/div[last()-1]/div[2]/div[last()]/div/div[1]/div[last()]/span/pre")).getText();
		assertTrue(actualString.contains("Test1"));
		
		//Wait for an element to load and become clickable - second topic (Topic 2018-02-20 54.716)
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='topic-navigation']/div[2]/div/ul/li/ul/li[1]/a/div/div/div/div")));
												
		//Assert that second topic (Topic 2018-02-20 54.716) has loaded properly
		assertTrue("Element not found!", elementExists("//*[@id='topic-navigation']/div[2]/div/ul/li/ul/li[1]/a/div/div/div/div", driver));
										
		//Click the second topic (Topic 2018-02-20 54.716)
		driver.findElement(By.xpath("//*[@id='topic-navigation']/div[2]/div/ul/li/ul/li[1]/a/div/div/div/div")).click();	
		
		//Wait for an element to load and become clickable - new message in second topic (Topic 2018-02-20 54.716)
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='topics']/div/div/div[2]/div/div[2]/div[2]/div[last()]/div/div[1]/div[last()]/span/pre")));
														
		//Assert that the new message has loaded properly
		assertTrue("Element not found!", elementExists("//*[@id='topics']/div/div/div[2]/div/div[2]/div[2]/div[last()]/div/div[1]/div[last()]/span/pre", driver));
				
		//Assert that the new message contains the proper text
		String actualString1 = driver.findElement(By.xpath("//*[@id='topics']/div/div/div[2]/div/div[last()-1]/div[2]/div[last()]/div/div[1]/div[last()]/span/pre")).getText();
		assertTrue(actualString1.contains("Test2"));
		
		
		//Clean Up (Delete older messages so that the script is reusable)
		
		
		//Log out
		//Wait for an element to load and become clickable - profile link's dropdown arrow
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div[3]/span[5]/md-menu/a")));
						
		//Assert that the profile link's dropdown arrow has loaded properly
		assertTrue("Element not found!", elementExists("/html/body/div[1]/div[2]/div/div[3]/span[5]/md-menu/a", driver));
				
		//Click on the profile link's dropdown arrow
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/span[5]/md-menu/a")).click();		
					
		//Wait for an element to load and become clickable - log out option
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu_container_10']/md-menu-content/md-menu-item[4]/a/div/p")));
								
		//Assert that the log out option has loaded properly
		assertTrue("Element not found!", elementExists("//*[@id='menu_container_10']/md-menu-content/md-menu-item[4]/a/div/p", driver));
					
		//Click on the log out option
		driver.findElement(By.xpath("//*[@id='menu_container_10']/md-menu-content/md-menu-item[4]/a/div/p")).click();	
		
		//Log in with first user again
		
		//Wait for an element to load and become clickable - login button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div/div/div[2]/form/button")));
				
		//Assert that login page was successfully loaded
		assertTrue("Element not found!", elementExists("/html/body/div/div/div/div/div/div[2]/form/button", driver));
				
		//Type in username - email
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/form/input[1]")).sendKeys("marko.radojkic@yopmail.com");
				
		//Type in the correct password
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/form/input[2]")).sendKeys("123123");
						
		//Click the Log in button
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/form/button")).click();
				
		//Wait for an element to load and become clickable - My Groups button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div[1]/ul/li[2]/a")));
						
		//Assert that login was successful by checking that My Groups button has loaded properly
		assertTrue("Element not found!", elementExists("/html/body/div/div[3]/div[1]/ul/li[2]/a", driver));
				
		//Click the My Groups button
		driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/ul/li[2]/a")).click();
				
		//Wait for an element to load and become clickable - Test Automation Group
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[4]/div[1]/div/div/div[2]/div/div[1]/div/div/div/div[1]/h3/a")));
				
		//Assert that Test Automation Group has loaded properly
		assertTrue("Element not found!", elementExists("/html/body/div/div[4]/div[1]/div/div/div[2]/div/div[1]/div/div/div/div[1]/h3/a", driver));
						
		//Click on the Test Automation Group
		driver.findElement(By.xpath("/html/body/div/div[4]/div[1]/div/div/div[2]/div/div[1]/div/div/div/div[1]/h3/a")).click();
				
		//Wait for an element to load and become clickable - First topic
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='topic-navigation']/div[2]/div/ul/li/a/div/div/div")));
				
		//Assert that First topic has loaded properly
		assertTrue("Element not found!", elementExists("//*[@id='topic-navigation']/div[2]/div/ul/li/a/div/div/div", driver));
	
		//Wait 3 seconds - stability reasons
		wait3Seconds();
		
		//Click on the First topic
		driver.findElement(By.xpath("//*[@id='topic-navigation']/div[2]/div/ul/li/a/div/div/div")).click();
			
		//Wait for an element to load and become clickable - first message
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='topics']/div/div/div[2]/div/div[last()-1]/div[2]/div[last()]/div/div[1]/div[last()]/span/pre")));
						
		//Assert that first message has loaded properly
		assertTrue("Element not found!", elementExists("//*[@id='topics']/div/div/div[2]/div/div[last()-1]/div[2]/div[last()]/div/div[1]/div[last()]/span/pre", driver));
			
		//Click on the First message
		driver.findElement(By.xpath("//*[@id='topics']/div/div/div[2]/div/div[last()-1]/div[2]/div[last()]/div/div[1]/div[last()]/span/pre")).click();
		
		//Click on the Delete button for this message
		driver.findElement(By.xpath("//*[@id='topics']/div/div/div[2]/div/div[last()-1]/div[2]/div[last()]/div/div[2]/div[1]/div/a[4]")).click();
		
		//Wait 3 seconds - stability reasons
		wait3Seconds();
		
		//Confirm delete
		driver.findElement(By.xpath("//*[@id='topics']/div/div/div[2]/div/div[last()-1]/div[2]/div[last()]/div/div[2]/div[1]/div/a[1]")).click();
									
		//Wait 3 seconds - stability reasons
		wait3Seconds();
		
		//Wait for an element to load and become clickable - newly deleted message in first topic (Main)
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='topics']/div/div/div[2]/div/div[last()-1]/div[2]/div[last()]/div/div[1]/div[last()]/span/pre")));
																
		//Assert that the newly deleted message's text (This post has been deleted by post Author.) has loaded properly
		assertTrue("Element not found!", elementExists("//*[@id='topics']/div/div/div[2]/div/div[last()-1]/div[2]/div[last()]/div/div[1]/div[last()]/span/pre", driver));
						
		//Assert that the newly deleted message displays the proper text
		String actualString2 = driver.findElement(By.xpath("//*[@id='topics']/div/div/div[2]/div/div[last()-1]/div[2]/div[last()]/div/div[1]/div[last()]/span/pre")).getText();
		assertTrue(actualString2.contains("This post has been deleted by post Author."));
			
		//Wait for an element to load and become clickable - second topic (Topic 2018-02-20 54.716)
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='topic-navigation']/div[2]/div/ul/li/ul/li[1]/a/div/div/div/div")));
		
		//Assert that second topic (Topic 2018-02-20 54.716) has loaded properly
		assertTrue("Element not found!", elementExists("//*[@id='topic-navigation']/div[2]/div/ul/li/ul/li[1]/a/div/div/div/div", driver));
			
		//Click on the second topic (Topic 2018-02-20 54.716)
		driver.findElement(By.xpath("//*[@id='topic-navigation']/div[2]/div/ul/li/ul/li[1]/a/div/div/div/div")).click();
					
		//Wait for an element to load and become clickable - second message
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='topics']/div/div/div[2]/div/div[last()-1]/div[2]/div[last()]/div/div[1]/div[last()]/span/pre")));
				
		//Assert that second message has loaded properly
		assertTrue("Element not found!", elementExists("//*[@id='topics']/div/div/div[2]/div/div[last()-1]/div[2]/div[last()]/div/div[1]/div[last()]/span/pre", driver));
					
		//Click on the second message
		driver.findElement(By.xpath("//*[@id='topics']/div/div/div[2]/div/div[last()-1]/div[2]/div[last()]/div/div[1]/div[last()]/span/pre")).click();
				
		//Click on the Delete button for this message
		driver.findElement(By.xpath("//*[@id='topics']/div/div/div[2]/div/div[last()-1]/div[2]/div[last()]/div/div[2]/div[1]/div/a[4]")).click();
		
		//Wait 3 seconds - stability reasons
		wait3Seconds();
				
		//Confirm delete
		driver.findElement(By.xpath("//*[@id='topics']/div/div/div[2]/div/div[last()-1]/div[2]/div[last()]/div/div[2]/div[1]/div/a[1]")).click();
			
		//Wait 3 seconds - stability reasons
		wait3Seconds();
				
		//Wait for an element to load and become clickable - newly deleted message in second topic (Topic 2018-02-20 54.716)
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='topics']/div/div/div[2]/div/div[last()-1]/div[2]/div[last()]/div/div[1]/div[last()]/span/pre")));
		
		//Assert that the newly deleted message's text (This post has been deleted by post Author.) has loaded properly
		assertTrue("Element not found!", elementExists("//*[@id='topics']/div/div/div[2]/div/div[last()-1]/div[2]/div[last()]/div/div[1]/div[last()]/span/pre", driver));
		
		//Assert that the newly deleted message displays the proper text
		String actualString3 = driver.findElement(By.xpath("//*[@id='topics']/div/div/div[2]/div/div[last()-1]/div[2]/div[last()]/div/div[1]/div[last()]/span/pre")).getText();
		assertTrue(actualString3.contains("This post has been deleted by post Author."));
	
		//Final log out
		//Wait for an element to load and become clickable - profile link's dropdown arrow
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div[3]/span[5]/md-menu/a")));
								
		//Assert that the profile link's dropdown arrow has loaded properly
		assertTrue("Element not found!", elementExists("/html/body/div[1]/div[2]/div/div[3]/span[5]/md-menu/a", driver));
		
		//Click on the profile link's dropdown arrow
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/span[5]/md-menu/a")).click();
		
		//Wait for an element to load and become clickable - log out option
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu_container_18']/md-menu-content/md-menu-item[4]/a/div/p")));
						
		//Assert that the log out option has loaded properly
		assertTrue("Element not found!", elementExists("//*[@id='menu_container_18']/md-menu-content/md-menu-item[4]/a/div/p", driver));
							
		//Click on the log out option
		driver.findElement(By.xpath("//*[@id='menu_container_18']/md-menu-content/md-menu-item[4]/a/div/p")).click();	
		
		//Print no assertions failed
		System.out.println("Finished. All assertions have passed with no issues!");
	}
		
		//Setup browser
		public WebDriver invokeBrowser(WebDriver driver1) {
			driver1.manage().deleteAllCookies();
			driver1.manage().window().maximize();
			return driver1;
		}
		
		//method for checking if an element exists on the page. boolean
		static boolean elementExists(String xpath1, WebDriver driver1) {
		    try {
		        driver1.findElement(By.xpath(xpath1));
		    } catch (NoSuchElementException e) {
		        return false;
		    }
		    return true;
		}
		
		//method that will create a 3 second delay in script execution - for stability reasons
		public static void wait3Seconds() {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
	

}
