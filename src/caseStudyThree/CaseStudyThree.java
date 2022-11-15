package caseStudyThree;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CaseStudyThree 
{
	WebDriver driver = null;
	WebElement sourceField = null;
	WebElement sourceCountry = null;
	WebElement destField = null;
	WebElement destCountry = null;
	WebElement departureField = null;
	WebElement departureDate = null;
	WebElement passengerField = null;
	WebElement adultIncrease = null;
	WebElement childIncrease = null;
	WebElement done = null;
	WebElement search = null;
	
	public void setupBrowser(String browser)
	{
		
		String currDir = System.getProperty("user.dir");
			if(browser.equalsIgnoreCase("chrome"))
			{
				//Relative path so in case chromedriver.exe gets moved, it can always be found
				System.setProperty("webdriver.chrome.driver", currDir + "\\drivers\\chromedriverVersion96.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("https://www.goindigo.in/?linkNav=home_header");
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				//Relative path so in case firefoxdriver.exe gets moved, it can always be found
				System.setProperty("webdriver.gecko.driver", currDir + "\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get("https://www.goindigo.in/?linkNav=home_header");
			}
			else if(browser.equalsIgnoreCase("htmlunit"))
			{
				driver = new HtmlUnitDriver();//Relative path so in case unit.exe gets moved, it can always be found
				//implement later
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get("https://www.goindigo.in/?linkNav=home_header");
				
			}
			
	}
	public void getURL()
	{
		String url = driver.getCurrentUrl();
		if(url.equals("https://www.goindigo.in/?linkNav=home_header"))
		{
			System.out.println("We have the correct URL");
		}
		else
		{
			System.out.println("We got the wrong URL");
		}
		
	}
	
	public void findOneWayRadioButton(String OneWayRadioButton) throws NoSuchElementException, ElementNotInteractableException
	{
		//by id
			if(OneWayRadioButton.equalsIgnoreCase("id"))
			{
				driver.findElement(By.id("oneWayTrip")).click();
			}
		//by cssSelector
			if(OneWayRadioButton.equalsIgnoreCase("css selector"))
			{
				driver.findElement(By.cssSelector("input#oneWayTrip.form-control.one-way-tab.trip-tabs")).click();
			}				   

		//by name
			else if(OneWayRadioButton.equalsIgnoreCase("name"))
			{
				driver.findElement(By.name("tripTabs")).click();
			}    

		//by xpATH
			else if(OneWayRadioButton.equalsIgnoreCase("xpath"))
			{
				driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[2]/div[1]/label")).click();//*[@id="oneWayTrip"]				
			}    
			   
		//by classname
			else if(OneWayRadioButton.equalsIgnoreCase("class name"))
			{
				driver.findElement(By.className("form-control one-way-tab trip-tabs")).click();
			}   

	}
	public void fillRemainingDetails() throws ElementClickInterceptedException, MoveTargetOutOfBoundsException, InterruptedException, NoSuchElementException
	{
		//We select the "From" dropdown and select Dehli
			
				//driver.findElement(By.xpath("//*[@id=\\\"bookFlightTab\\\"]/form/div[3]/div[1]/div[1]/div/div/input")).clear();
				sourceField = driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[3]/div[1]/div[1]/div/div/input"));
				//sourceField.clear();
				//sourceField.sendKeys("Delhi");
				sourceField.click();
				Thread.sleep(500);
				sourceCountry = driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[3]/div[1]/div[1]/div/div/div/div/div[2]"));
				sourceCountry.click();
				Thread.sleep(500);
			
		//We select the "To" dropdown and select Kolkata
			
				destField = driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[3]/div[1]/div[2]/div/div/input"));
				Thread.sleep(500);
				//destField.sendKeys("bengaluru");
				destField.click();
				destCountry = driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[3]/div[1]/div[2]/div/div/div/div/div[5]"));
				destCountry.click();
				Thread.sleep(500);
							   
		//by any element for Departure Date field.  
			
				departureField = driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[3]/div[2]/div[1]/div/input"));
				departureField.click();
				Thread.sleep(2000);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,200)");
				departureDate = driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-hover']"));
				departureDate.click();
				//driver.findElement(By.xpath("//*[@id=\"dp1588544953317\"]/div/div[1]/table/tbody/tr[2]/td[2]")).click();
				Thread.sleep(1000);
				
		
		//by any element for Return Date field.  
				
				/*returnField = driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[3]/div[2]/div[2]/div/input"));
				returnField.click();
				Thread.sleep(1000);
				JavascriptExecutor returnJSE = (JavascriptExecutor) driver;
				returnJSE.executeScript("window.scrollBy(0,200)");
				returnDate = driver.findElement(By.xpath("//*[@id=\"dp1588542535301\"]/div/div[2]/table/tbody/tr[2]/td[1]/a"));
				returnDate.click();
				Thread.sleep(1000);*/
		//by any element for # of passengers field
			
				passengerField = driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[5]/div[1]/div[1]/input"));
				passengerField.click();
				
				//Increase Adult Number three times
				adultIncrease = driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[5]/div[1]/div[2]/ul/li[1]/div/button[2]"));
				adultIncrease.click();
				adultIncrease.click();
				
		//Increase Children's age twice
				childIncrease = driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[5]/div[1]/div[2]/ul/li[2]/div/button[2]"));
				childIncrease.click();
				childIncrease.click();
				JavascriptExecutor childJSE = (JavascriptExecutor) driver;
				childJSE.executeScript("window.scrollBy(0,150)");	
				Thread.sleep(2000);
		
		//Click done button using xpath
				done = driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[5]/div[1]/div[2]/div[2]/button"));
				done.click();
				Thread.sleep(2000);
				
		//Search our flight
				search = driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[7]/div[6]/button"));
				search.click();
				

	}
	public void waitForPageToLoad() throws InterruptedException
	{
		//Wait for "Modify Search" link be found
		Thread.sleep(10000);
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\\\"mobHeaderId\\\"]/div/div[2]/button"))));	
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		CaseStudyThree methodTest = new CaseStudyThree();
		methodTest.setupBrowser("chrome");
		methodTest.getURL();
		methodTest.findOneWayRadioButton("xpath");
		methodTest.fillRemainingDetails();
		methodTest.waitForPageToLoad();
		methodTest.closeBrowser();
		
		
	}

}
