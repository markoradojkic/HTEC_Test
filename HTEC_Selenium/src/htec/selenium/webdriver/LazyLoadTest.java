package htec.selenium.webdriver;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class LazyLoadTest {

	public static void main(String[] args) {
		//Instantiate objects. Set properties, define location
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\Automation\\Drivers\\Selenium chrome driver v2.35\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		CheckMessage myObj = new CheckMessage();
		JavascriptExecutor js = (JavascriptExecutor) driver;
				
		//Call the method that will set up the browser
		driver = myObj.invokeBrowser(driver);

		//Log in with first user and test lazy load (scroll)
				
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
		
		//Wait 3 seconds - stability reasons
		wait3Seconds();
		
		//Assert that the very last element in the list loads properly by scrolling down until all elements lazy-load into the list
		
		//Use a while loop to reach the end of the list
		WebElement element1 = driver.findElement(By.xpath("/html/body/div/div[4]/div/div[1]/div/div[1]/div[2]/div[1]"));
		String attribute1 = element1.getAttribute("data-id");
		WebElement element2 = driver.findElement(By.xpath("/html/body/div/div[4]/div/div[1]/div/div[1]/div[2]/div[last()]"));
		String attribute2 = element2.getAttribute("data-id");
		
				
		while(!attribute2.equals(attribute1)) {
			element1 = driver.findElement(By.xpath("/html/body/div/div[4]/div/div[1]/div/div[1]/div[2]/div[last()]"));
			attribute1 = element1.getAttribute("data-id");
			//System.out.println("Atribute1: " +attribute1);
			js.executeScript("arguments[0].scrollIntoView(true);", element1);
			wait3Seconds();
			element2 = driver.findElement(By.xpath("/html/body/div/div[4]/div/div[1]/div/div[1]/div[2]/div[last()]"));
			attribute2 = element2.getAttribute("data-id");
			//System.out.println("Atribute2: " +attribute2);
		}
		
		//Assert that the last element has loaded properly
		assertTrue("Element not found!", elementExists("/html/body/div/div[4]/div/div[1]/div/div[1]/div[2]/div[last()]", driver));
					
		//Print no assertions failed
		System.out.println("Finished. All assertions have passed with no issues!");
		
		//Final log out
		//Wait for an element to load and become clickable - profile link's dropdown arrow
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div[3]/span[5]/md-menu/a")));
										
		//Assert that the profile link's dropdown arrow has loaded properly
		assertTrue("Element not found!", elementExists("/html/body/div[1]/div[2]/div/div[3]/span[5]/md-menu/a", driver));
				
		//Click on the profile link's dropdown arrow
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/span[5]/md-menu/a")).click();
				
		//Wait for an element to load and become clickable - log out option
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu_container_3']/md-menu-content/md-menu-item[4]/a/div/p")));
		//*[@id='menu_container_3']/md-menu-content/md-menu-item[4]/a/div/p						
		//Assert that the log out option has loaded properly
		assertTrue("Element not found!", elementExists("//*[@id='menu_container_3']/md-menu-content/md-menu-item[4]/a/div/p", driver));
								
		//Click on the log out option
		driver.findElement(By.xpath("//*[@id='menu_container_3']/md-menu-content/md-menu-item[4]/a/div/p")).click();	
		
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
