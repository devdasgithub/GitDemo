package casestudyone;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CaseStudyOne 
{

	WebDriver driver = null;
	WebElement getAttribute = null;
	WebElement clickLog = null;
	
	public void setupBrowser(String browser, String url, int browserVersion) throws InterruptedException
	{
		
		String currDir = System.getProperty("user.dir");
				if(browser.equalsIgnoreCase("chrome"))
				{
					System.out.println("Using chrome browser"); //This is just to show changes made to the GITHUB in USA timezone
					//Now the developer in Asia will start from here
					if(browserVersion == 98)
					{
						System.out.println("New version of chrome 98"); //Developer in Asia time zone made change
					//Relative path so in case chromedriver.exe gets moved, it can always be found
					System.setProperty("webdriver.chrome.driver", currDir + "\\drivers\\chromedriver98.exe"); //Set to default browser version Chrome
					driver = new ChromeDriver();
					Capabilities caps = ((RemoteWebDriver)driver).getCapabilities();
					String browserName = caps.getBrowserName();
					String browserVersion1 = caps.getVersion();
					System.out.println("Borwser name is: " + browserName +"\n Browser Version is " + browserVersion1);
					
					Thread.sleep(5000);
					}
					
				}
				else if(browser.equalsIgnoreCase("firefox"))
				{
					//Relative path so in case firefoxdriver.exe gets moved, it can always be found
					System.setProperty("webdriver.gecko.driver", currDir + "\\drivers\\geckodriver.exe");
					driver = new FirefoxDriver();
				}
				else if(browser.equalsIgnoreCase("ie"))
				{
					//Relative path so in case IE.exe gets moved, it can always be found
					System.setProperty("webdriver.ie.driver", currDir + "\\drivers\\IEDriverServer.exe");
					driver = new HtmlUnitDriver();//Relative path so in case unit.exe gets moved, it can always be found
					
				}
				
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
	}
	
	public void findElement(String attribute) throws NoSuchElementException, ElementNotInteractableException
	{
		//by id
				if(attribute.equalsIgnoreCase("id"))
						{
							driver.findElement(By.id("search-inp3")).click();
							getAttribute = driver.findElement(By.id("search-inp-overlay-new"));
							getAttribute.sendKeys("selenium");
							
						}
		//by cssSelector
				else if(attribute.equalsIgnoreCase("css selector"))
				{
					driver.findElement(By.id("search-inp3")).click();
					getAttribute = driver.findElement(By.cssSelector("input#search-inp-overlay-new.new-search-inp"));  
					getAttribute.sendKeys("selenium");
					
				}
				   

		//by name
				else if(attribute.equalsIgnoreCase("name"))
				{
					driver.findElement(By.id("search-inp3")).click();
					getAttribute = driver.findElement(By.name("user_v1[query]")); 
					getAttribute.sendKeys("selenium");
				}    

		//by xpATH
				else if(attribute.equalsIgnoreCase("xpath"))
				{
					driver.findElement(By.id("search-inp3")).click();
					getAttribute = driver.findElement(By.xpath("//*[@id=\"search-inp-overlay-new\"]")); 
					getAttribute.sendKeys("selenium");
					
				}    
				   
		//by classname
				else if(attribute.equalsIgnoreCase("class name"))
				{
					driver.findElement(By.id("search-inp3")).click();
					getAttribute = driver.findElement(By.className("new-search-inp")); 
					getAttribute.sendKeys("selenium");
				}   

	}
	
	public void Login(String login)
	{
		//by partail link
		if (login.equalsIgnoreCase("partial link text"))
				{
					clickLog = driver.findElement(By.partialLinkText("Log"));
					clickLog.click();
				}
		
//by link text
		else if(login.equalsIgnoreCase("link text"))
		{
			clickLog = driver.findElement(By.linkText("Log In"));  
			clickLog.click();
		} 
	}
	public void closeBrowser()
	{
		driver.quit();
	}
	
	public void printTitle()
	{
		String title = driver.getTitle();
		System.out.println("Page title is " + title);
	}
	
	public void getPageSource()
	{
		System.out.println(driver.getPageSource()); // will not be used 99.99% of time
	}
	
	public void getURL()
	{
		String url = driver.getCurrentUrl();
		if(url.equals("https://www.edureka.co/"))
		{
			System.out.println("Successfully opened specified web page");
		}
		else
		{
			System.out.println("Could not open specified webpage");
		}
		
	}
	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		System.out.println("Remove this change from GitDemoCopy branch");
		System.out.println("Architect from IST pushed this code"); //GITHUB training
		CaseStudyOne methodTest = new CaseStudyOne();
		methodTest.setupBrowser("chrome", "https://www.edureka.co/", 98);
		methodTest.printTitle();
		methodTest.getURL();
		Thread.sleep(2000);
		methodTest.findElement("id");
		Thread.sleep(2000);
		methodTest.Login("link text");
		Thread.sleep(2000);
		methodTest.closeBrowser();
		
		
	}

}
