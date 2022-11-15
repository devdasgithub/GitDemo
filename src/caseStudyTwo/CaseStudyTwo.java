package caseStudyTwo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CaseStudyTwo 
{

	WebDriver driver = null;
	WebElement getAttribute = null;
	//WebElement clickLog = null;
	//WebDriverWait wait=new WebDriverWait(driver, 20);
	
	public void setupBrowser(String browser, String url)
	{
		
		String currDir = System.getProperty("user.dir");
				if(browser.equalsIgnoreCase("chrome"))
				{
					//Relative path so in case chromedriver.exe gets moved, it can always be found
					System.setProperty("webdriver.chrome.driver", currDir + "\\drivers\\chromedriverChrome81.exe");
					driver = new ChromeDriver();
				}
				else if(browser.equalsIgnoreCase("firefox"))
				{
					//Relative path so in case firefoxdriver.exe gets moved, it can always be found
					System.setProperty("webdriver.gecko.driver", currDir + "\\drivers\\geckodriver.exe");
					driver = new FirefoxDriver();
				}
				else if(browser.equalsIgnoreCase("htmlunit"))
				{
					driver = new HtmlUnitDriver();//Relative path so in case unit.exe gets moved, it can always be found
					//implement later
					
				}
				
				//Set the load timeout
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				
				//maximize the browser's window
				driver.manage().window().maximize();
				if(url!="")
				{
					driver.get(url);
				}
				else
				{
					driver.get("about:blank");
				}
				
				//Set implicit wait time
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				//set script timeout for asynchronous scripts
				driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
				JavascriptExecutor js = (JavascriptExecutor) driver;  
				js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);"); //wait 5 seconds
				//js.executeAsyncScript((arguments[arguments. Length - 1], 500));
	}
	public void getURL()
	{
		String url = driver.getCurrentUrl();
		if(url.equals("https://www.edureka.co/"))
		{
			System.out.println("We have the correct URL");
		}
		else
		{
			System.out.println("We got the wrong URL");
		}
		
	}
	
	public void findElement(String attribute) throws NoSuchElementException, ElementNotInteractableException
	{
		//by id
			if(attribute.equalsIgnoreCase("id"))
			{
				driver.findElement(By.id("search-inp3")).click();
				getAttribute = driver.findElement(By.id("search-inp-overlay-new"));
				getAttribute.sendKeys("selenium");
				getAttribute.sendKeys(Keys.ENTER);
				
			}
		//by cssSelector
			else if(attribute.equalsIgnoreCase("css selector"))
			{
				driver.findElement(By.id("search-inp3")).click();
				getAttribute = driver.findElement(By.cssSelector("input#search-inp-overlay-new.new-search-inp"));  
				getAttribute.sendKeys("selenium");
				getAttribute.sendKeys(Keys.ENTER);
			}
				   

		//by name
			else if(attribute.equalsIgnoreCase("name"))
			{
				driver.findElement(By.id("search-inp3")).click();
				getAttribute = driver.findElement(By.name("user_v1[query]")); 
				getAttribute.sendKeys("selenium");
				getAttribute.sendKeys(Keys.ENTER);
			}    

		//by xpATH
			else if(attribute.equalsIgnoreCase("xpath"))
			{
				driver.findElement(By.id("search-inp3")).click();
				getAttribute = driver.findElement(By.xpath("//*[@id=\"search-inp-overlay-new\"]")); 
				getAttribute.sendKeys("selenium");
				getAttribute.sendKeys(Keys.ENTER);
			}    
			   
		//by classname
			else if(attribute.equalsIgnoreCase("class name"))
			{
				driver.findElement(By.id("search-inp3")).click();
				getAttribute = driver.findElement(By.className("new-search-inp")); 
				getAttribute.sendKeys("selenium");
				getAttribute.sendKeys(Keys.ENTER);
			}   


			//Explicit wait for us to click on Selenium Certification Course
			WebDriverWait wait=new WebDriverWait(driver, 50);
			getAttribute = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[2]/div[2]/div[2]/div/div[1]/div[2]/a[1]/div[1]")));
			getAttribute.click();
	}
	public void printTitle()
	{
		WebDriverWait wait=new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/section[2]/div/div[1]/div/a"), "Preview this course"));
		String actualTitle = driver.getTitle();
		System.out.println("Page title is " + actualTitle);
		System.out.println("We have found our page");
	}
	
	public void navigateBackAndClickAllCourses(String url)
	{
		
		String currentURL = "https://www.edureka.co/search/selenium";
		if(url.equals(currentURL))
		{
			 driver.navigate().back();
			 WebDriverWait wait=new WebDriverWait(driver, 100);
				getAttribute = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/a")));
				getAttribute.click();//click "All Courses" menu option
		}
		else
		{
			driver.navigate().refresh();
		}
	}
	
	public void FluentWait()
	{
		
		
		 
		 //Fluent wait
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		fluentWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"allc_catlist\"]/li[1]/a"), "All Courses"));
		String actualTitle = driver.getTitle();
		System.out.println("Page title is " + actualTitle);
		System.out.println("We have found our page");
		
	}
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		CaseStudyTwo methodTest = new CaseStudyTwo();
		methodTest.setupBrowser("chrome", "https://www.edureka.co/");
		methodTest.getURL();
		methodTest.findElement("xpath");
		methodTest.printTitle();
		methodTest.navigateBackAndClickAllCourses("https://www.edureka.co/search/selenium");
		methodTest.FluentWait();
		methodTest.closeBrowser();
		
		
	}

}
