//This program allows us to launch the http://demo.guru99.com/test/newtours/ site and book a flight
package casestudyone;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookFlightGuru99 
{

	WebDriver everythingDriver = null;
	WebElement selectUserName = null;
	WebElement waitElement = null;
	//WebElement clickLog = null;
	
	/*Two ways to use a method to help launch the browser and make code neat
	 * 1) SetupBrowser method with no parameters
			public void setupBrowser()
			{
				Relative path so in case chromedriver.exe gets moved, it can always be found
					String currDir = System.getProperty("user.dir");
					System.setProperty("webdriver.chrome.driver", currDir + "\\drivers\\chromedriver.exe");
						
				//Absolute path of chromedriver.exe
					System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\Devs HP Pavilion 15i\\Eclipse-Java-Workspace-For-Selenium\\SettingUpSeleniumCorrectly\\drivers\\chromedriver.exe");
						
					WebDriver driver = new ChromeDriver();
					driver.get("https://facebook.com");
			}
		2) setupBrowser method with parameters*/
	public void setupBrowser(String browser, String url)
	{
		//Retreive the current working directory (project's directory) for the browser driver
		String currDir = System.getProperty("user.dir"); 
				if(browser.equalsIgnoreCase("chrome"))
				{
					//Relative path so in case chromedriver.exe gets moved, it can always be found
					System.setProperty("webdriver.chrome.driver", currDir + "\\drivers\\chromedriver.exe");
					everythingDriver = new ChromeDriver();
				}
				else if(browser.equalsIgnoreCase("firefox"))
				{
					//Relative path so in case firefoxdriver.exe gets moved, it can always be found
					System.setProperty("webdriver.gecko.driver", currDir + "\\drivers\\geckodriver.exe");
					everythingDriver = new FirefoxDriver();
				}
				else if(browser.equalsIgnoreCase("ie"))
				{
					//Relative path so in case IE.exe gets moved, it can always be found
					System.setProperty("webdriver.ie.driver", currDir + "\\drivers\\IEDriverServer.exe");
					everythingDriver = new HtmlUnitDriver();//Relative path so in case unit.exe gets moved, it can always be found
					
				}
				
			//Maximize the browser's window
				everythingDriver.manage().window().maximize();
			
			//Check if the URL we give is empty
			if(url!="")
			{
				everythingDriver.get(url);
			}
			else
			{
				everythingDriver.get("about:blank");
			}
			
		}
	
	//Create a method to wait 10 seconds for the "New Tours demo home" web page to load
	public void pageLoadTimeout(int initialTimeout, int FinalTimeout) 
	{
		if(initialTimeout == FinalTimeout)
		{
			everythingDriver.manage().timeouts().pageLoadTimeout(FinalTimeout, TimeUnit.SECONDS);
		}
		else
		{
			throw new WebDriverException();
		}
	}
	
	//Create a method to wait until the "Register" link is displayed and able to be clicked
	public void waitForRegisterLink(int waitTime) throws InterruptedException
	{		
		WebDriverWait waitForRegisterToDisplay = new WebDriverWait(everythingDriver, waitTime);
		waitForRegisterToDisplay.until(ExpectedConditions.elementToBeClickable(By.linkText("REGISTER")));
		
		Thread.sleep(2000);
		everythingDriver.findElement(By.linkText("REGISTER")).click();
	}
	
	//Create a method to Register 
	public void submitNewRegistration(int waitTime) throws InterruptedException, NoSuchElementException
	{	
		//Wait for the the iframe ad to appear in the Registration page before doing anything else
		WebDriverWait waitForAdToClose = new WebDriverWait(everythingDriver, 2);
		waitForAdToClose.until(ExpectedConditions.visibilityOfElementLocated(By.id("flow_close_btn_iframe")));
		
		//Switch to the iframe
			everythingDriver.switchTo().frame(("flow_close_btn_iframe"));
		
		//Close the "x" button on the ad
			everythingDriver.findElement((By.xpath("//*[@id='closeBtn']"))).click();
	
		//Switch back to the parent frame
			everythingDriver.switchTo().parentFrame();
		
		//Click inside the First Name field and enter information
			everythingDriver.findElement(By.name("firstName")).click();
			
		//Before information is entered, let the system sleep for 5 seconds
			Thread.sleep(2000);  
			WebElement selectFirstName = everythingDriver.findElement(By.name("firstName"));
			selectFirstName.sendKeys("Devasish");				
		
		//Click inside the Last Name field and enter information
		everythingDriver.findElement(By.name("lastName")).click();
		
		//Before information is entered, let the system sleep for 5 seconds
		Thread.sleep(2000); 
		WebElement selectLastName = everythingDriver.findElement(By.name("lastName"));
		selectLastName.sendKeys("Das");
		
		
		//Click inside the Phone field and enter a number
		everythingDriver.findElement(By.name("phone")).click();
		
		//Before information is entered, let the system sleep for 5 seconds
		Thread.sleep(2000); 
		WebElement selectPhone = everythingDriver.findElement(By.name("phone"));
		selectPhone.sendKeys("7328675309");
		
		
		//Click inside the Email field and enter an email address
		everythingDriver.findElement(By.id("userName")).click();
		
		//Before information is entered, let the system sleep for 5 seconds
		Thread.sleep(2000); 
		WebElement selectEmail = everythingDriver.findElement(By.id("userName"));
		selectEmail.sendKeys("ddas@polarismanagement.com");
		
		//Click inside the Address field and enter your address (number and street)
		everythingDriver.findElement(By.name("address1")).click();
		
		//Before information is entered, let the system sleep for 5 seconds
		Thread.sleep(2000); 
		WebElement selectAddress = everythingDriver.findElement(By.name("address1"));
		selectAddress.sendKeys("41 Jacksonville State");
		
		//Click inside the City field and enter the city you live in
		everythingDriver.findElement(By.name("city")).click();
		
		//Before information is entered, let the system sleep for 5 seconds
		Thread.sleep(2000); 
		WebElement selectCity = everythingDriver.findElement(By.name("city"));
		selectCity.sendKeys("Jacksonville");
		
		//Click inside the State/Province field
		everythingDriver.findElement(By.name("state")).click();
		
		//Before information is entered, let the system sleep for 5 seconds
		Thread.sleep(2000); 
		WebElement selectStateProv = everythingDriver.findElement(By.name("state"));
		selectStateProv.sendKeys("Florida");
		
		//Click inside the Postal Code field
		everythingDriver.findElement(By.name("postalCode")).click();
		
		//Before information is entered, let the system sleep for 5 seconds
		Thread.sleep(2000); 
		WebElement selectPostalCode = everythingDriver.findElement(By.name("postalCode"));
		selectPostalCode.sendKeys("12345");
		
		//Click inside the Country dropdown
		Select dropCountry = new Select(everythingDriver.findElement(By.name("country")));
		
		//Before selecting an LOV, let the system sleep for 5 seconds
		Thread.sleep(2000);
		dropCountry.selectByVisibleText("UNITED STATES");
		

		//Use an explicit wait for the "User Name" label to be displayed.  Then fill out the page
		WebDriverWait waitForUserNameToDisplay = new WebDriverWait(everythingDriver, waitTime);
		WebElement UserName = everythingDriver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[13]/td[1]/font/b"));
		waitForUserNameToDisplay.until(ExpectedConditions.visibilityOf(UserName));
		
		//Now that we have set a wait time for User Name, go ahead and enter a user name
		everythingDriver.findElement(By.id("email")).click();
		
		//Before information is entered, let the system sleep for 5 seconds
		Thread.sleep(2000);
		selectUserName = everythingDriver.findElement(By.id("email"));
		selectUserName.sendKeys("devdasTestUN");
		
		//Click inside the Password field
		everythingDriver.findElement(By.name("password")).click();
		
		//Before information is entered, let the system sleep for 5 seconds
		Thread.sleep(2000);
		WebElement selectPassword = everythingDriver.findElement(By.name("password"));
		selectPassword.sendKeys("Devdas@2020");
		
		//Click inside the Confirm Password field
		everythingDriver.findElement(By.name("confirmPassword")).click();
		
		//Before information is entered, let the system sleep for 5 seconds
		Thread.sleep(2000);
		WebElement selectConfPassword = everythingDriver.findElement(By.name("confirmPassword"));
		selectConfPassword.sendKeys("Devdas@2020");
		
		//Click the Submit Button
		//Before selecting the Submit button, let the system sleep for 5 seconds
		Thread.sleep(2000);
		everythingDriver.findElement(By.name("submit")).click();
	}
	
	//Create a method to wait until the "Note: Your user name is xyz" is displayed
	public void waitForConfirmation(int waitTime) throws InterruptedException
	{		
		WebDriverWait waitForConfMessage = new WebDriverWait(everythingDriver, waitTime);
		waitForConfMessage.until(ExpectedConditions.invisibilityOfElementWithText
				(By.linkText("Flights"), "Note: Your user name is devdasTestUN"));
	}
	public void bookFlight() throws InterruptedException, NoSuchElementException
	{
		
		//Before clicking the Flights link, let the system sleep for 2 seconds
			Thread.sleep(2000);
			everythingDriver.findElement(By.linkText("Flights")).click();
			
		//Wait for the the iframe ad to appear in the Flights page before doing anything else
			WebDriverWait waitForAdToClose = new WebDriverWait(everythingDriver, 2);
			waitForAdToClose.until(ExpectedConditions.visibilityOfElementLocated(By.id("flow_close_btn_iframe")));
				
		//Switch to the iframe
			everythingDriver.switchTo().frame(("flow_close_btn_iframe"));
				
		//Close the "x" button on the ad
			everythingDriver.findElement((By.xpath("//*[@id='closeBtn']"))).click();
			
		//Switch back to the parent frame
			everythingDriver.switchTo().parentFrame();
			
		//In Flights page, click the "Round Trip" radio button
			Thread.sleep(2000);
			everythingDriver.findElement(By.xpath("//input[1][@name='tripType']")).click();
			
		//Click inside the Passenger dropdown
			Select dropPassenger = new Select(everythingDriver.findElement(By.xpath("//select[@name='passCount']")));
			
		//Before selecting an LOV, let the system sleep for 2 seconds
			Thread.sleep(2000);
			
		//Use a xpath axes to get the value of 2.  The parent node is the dropdown element.  
			//The child node is the axes.  The index is 2
			everythingDriver.findElement(By.xpath("//select[@name='passCount']//child::option[2]"));
			dropPassenger.selectByValue("2");
			//everythingDriver.findElement(By.xpath("//select[@name='passCount']//child::option[2]"));
			
		//Before selecting next field, let the system sleep for 2 seconds
			Thread.sleep(2000);
		
		//Wait for the the "Select Flight" image to be visible
			WebDriverWait waitForImage = new WebDriverWait(everythingDriver, 2);
			waitForImage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img")));
		
		//Find the "Departing From" dropdown and select it
			WebElement dropDepart = everythingDriver.findElement(By.name("fromPort"));
			Select DepartDrop = new Select (dropDepart);
			
			//Use a Java List to get all the LOVs from the Arriving In dropdown and select the fourth option
			List<WebElement> DepartList = DepartDrop.getOptions();
		
			//Before selecting an LOV, let the system sleep for 2 seconds
			Thread.sleep(2000);
			
			//Use a xpath axes to get the value of "New York".  The parent node is the dropdown element.  
			//The axes is the child node, so we use "Following" as the axes.  The index is 4
			//Select 4th option from the List Dropdown
			for(WebElement option: DepartList)
			{
				everythingDriver.findElement(By.xpath("//select[@name='fromPort']//following::option[3]"));
				DepartDrop.selectByValue("New York");
			}
		
		//Click inside the On Month dropdown
			Select dropOnMonth = new Select(everythingDriver.findElement(By.name("fromMonth")));
			
		//Before selecting an LOV, let the system sleep for 2 seconds
			Thread.sleep(2000);
			
		//Use a xpath axes to get the value of "March".  The parent node is the dropdown element.  
			//The axes is the child node.  We use the following axes.  The index is 3
			everythingDriver.findElement(By.xpath("//select[@name='fromMonth']//following::option[2]"));
			dropOnMonth.selectByValue("3");
			
		//Click inside the On Day dropdown
			Select dropOnDay = new Select(everythingDriver.findElement(By.name("fromDay")));
			
		//Before selecting an LOV, let the system sleep for 2 seconds
			Thread.sleep(2000);
			
		//Use a xpath axes to get the value of "March 1st".  The parent node is the dropdown element.  
			//The axes is the child node.  We can use the preceding axes to get value before the one we want
			//The index is 2
			everythingDriver.findElement(By.xpath("//select[@name='fromDay']//preceding::option[8]"));
			dropOnDay.selectByValue("7");
			
		//Before waiting for the "Select Flight" image to be visible, let the system sleep for 2 seconds
			Thread.sleep(2000);
			
		
		//Find the "Arriving In" dropdown and select it
			WebElement dropArrive = everythingDriver.findElement(By.name("toPort"));
			Select arriveDrop = new Select (dropArrive);
			
		//Use a Java List to get all the LOVs from the Arriving In dropdown and select the fourth option
			List<WebElement> arriveList = arriveDrop.getOptions();
		
			//Before selecting an LOV, let the system sleep for 2 seconds
			Thread.sleep(2000);
			
			//Select 4th option from the List Dropdown
			for(WebElement option: arriveList)
			{
				everythingDriver.findElement(By.xpath("//select[@name='fromDay']//preceding::option[5]"));
				arriveDrop.selectByValue("New York");
			}
			
			Thread.sleep(2000);
		
		//Click the "Returning Month" dropdown
			Select dropRetMonth = new Select(everythingDriver.findElement(By.name("toMonth")));
			
			//Before selecting an LOV, let the system sleep for 2 seconds
				Thread.sleep(2000);
				
			//Use a xpath axes to get the value of "March".  The parent node is the dropdown element.  
				//The axes is the child node.  We use the following axes.  The index is 3
				everythingDriver.findElement(By.xpath("//select[@name='toMonth']//following::option[3]"));
				dropRetMonth.selectByValue("4");
				
			//Click inside the Return Day dropdown
				Select dropRetDay = new Select(everythingDriver.findElement(By.name("toDay")));
				
			//Before selecting an LOV, let the system sleep for 2 seconds
				Thread.sleep(2000);
				
			//Use a xpath axes to get the value of "March 1st".  The parent node is the dropdown element.  
				//The axes is the child node.  We can use the preceding axes to get value before the one we want
				//The index is 2
				everythingDriver.findElement(By.xpath("//select[@name='fromDay']//preceding::option[2]"));
				dropRetDay.selectByValue("1");
				
		//Click the "First Class" radio butt
			WebElement firstClassRadio = everythingDriver.findElement(By.xpath("//input[@name = 'servClass'][2]"));
			firstClassRadio.click();
			
		//Click inside the Airline dropdown
			Select airline = new Select(everythingDriver.findElement(By.name("airline")));
			
		//Before selecting an LOV, let the system sleep for 2 seconds
			Thread.sleep(2000);
			
		//Use a xpath axes to get the value of "March 1st".  The parent node is the dropdown element.  
			//The axes is the child node.  We can use the preceding axes to get value before the one we want
			//The index is 2
			everythingDriver.findElement(By.xpath("//select[@name='fromDay']//child::option[2]"));
			airline.selectByVisibleText("Unified Airlines");
			
		//Click the Continue Button
			WebElement continueButton = everythingDriver.
					findElement(By.xpath("//input[@name = 'findFlights']"));
			
			continueButton.click();
	}
	
	
	public void closeBrowser()
	{
		everythingDriver.quit();
	}
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		BookFlightGuru99 methodTest = new BookFlightGuru99();
		methodTest.setupBrowser("chrome", "http://demo.guru99.com/test/newtours/");
		methodTest.pageLoadTimeout(10, 10);
		methodTest.waitForRegisterLink(10); //Set the number of seconds to wait with 500 millisecond interval
		methodTest.submitNewRegistration(5); //Set the number of seconds to wait with 500 millisecond interval
		methodTest.waitForConfirmation(10);
		methodTest.bookFlight();
		methodTest.closeBrowser();		
	}

}
