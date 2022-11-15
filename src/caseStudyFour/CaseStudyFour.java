//Module 5
package caseStudyFour;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class CaseStudyFour 
{

	WebDriver driver = null;
	WebElement usernameField = null;
	WebElement passwordField = null;
	WebElement personalDetails = null;
	String username = "devdas@optonline.net";
	String password = "devdas@1234";
	WebElement noThanks = null;
	//boolean mistakeClick = false; 
	
	
	public void setupBrowser(String browser, String url)
	{
		
		String currDir = System.getProperty("user.dir");
			if(browser.equalsIgnoreCase("chrome"))
			{
				//Relative path so in case chromedriver.exe gets moved, it can always be found
				System.setProperty("webdriver.chrome.driver", currDir + "\\drivers\\chromedriverVersion96.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("https://www.edureka.co/");
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				//Relative path so in case firefoxdriver.exe gets moved, it can always be found
					System.setProperty("webdriver.gecko.driver", currDir + "\\drivers\\geckodriver.exe");
					driver = new ChromeDriver();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.get("https://www.edureka.co/");
			}
			else if(browser.equalsIgnoreCase("htmlunit"))
			{
				driver = new HtmlUnitDriver();//Relative path so in case unit.exe gets moved, it can always be found
				//implement later
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("https://www.edureka.co/");
			}
			
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
	
	//Login method goes here
	
	public void loginToEdureka() throws NullPointerException, InterruptedException
	{
		
		
		//Click the Log In button on Home page
		driver.findElement(By.xpath("//*[@id=\"header-II\"]/section/nav/div/a[2]")).click();
		
		/*//Get the username for valid user
			JavascriptExecutor jsusername = (JavascriptExecutor) driver;
			jsusername.executeScript("window.promptResponse=prompt('Please enter the correct User Id')");
			username = (String) jsusername.executeScript("return window.promptResponse");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //wait 10 seconds for a response*/
			
		//Click inside the username field and enter the username from the prompt
		usernameField = driver.findElement(By.xpath("//*[@id=\'si_popup_email\']"));
		usernameField.click();
		usernameField.sendKeys(username);
		Thread.sleep(1000);
			
		/*//Get the password for valid user
			JavascriptExecutor jspw = (JavascriptExecutor) driver;
			jspw.executeScript("window.promptResponse=prompt('Please enter the correct User Id')");
			password = (String) jspw.executeScript("return window.promptResponse");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //wait 10 seconds for a response*/
				
		//Click inside the username field and enter the password from the prompt
		passwordField = driver.findElement(By.xpath("//*[@id=\'si_popup_passwd\']"));
		passwordField.click();
		passwordField.sendKeys(password);
		Thread.sleep(1000);
			
		//Click the Login Button
		driver.findElement(By.xpath("//*[@id=\"new_sign_up_mode\"]/div/div/div[2]/div[3]/form/button")).click();
		
		//Use Assertion to get the correct URL after Login
		String actualURL = "https://learning.edureka.co/mycourses";
		String expectedURL = driver.getCurrentUrl();
		if(actualURL.equalsIgnoreCase(expectedURL))
		{
			System.out.println("Test Case Passed");
		}
		else
		{
			System.out.println("Test Case Failed");
		}
	}
	
	public void getToMyProfile() throws InterruptedException
	{
		Thread.sleep(1000);
		//Click the Person Icon next to signed-In user
		driver.findElement(By.xpath("/html/body/app-root/app-mycourse-main/section/app-header/header/nav/div/div[3]/ul/li[8]/div/button/img")).click();
		
		Thread.sleep(1000);
		//Click the "My Profile" button
		driver.findElement(By.xpath("/html/body/app-root/app-mycourse-main/section/app-header/header/nav/div/div[3]/ul/li[8]/div/ul/li[1]/a")).click();
		
		//Verify we are at correct page
		String actualURL = "https://learning.edureka.co/my-profile";
		String expectedURL = driver.getCurrentUrl();
		if(actualURL.equalsIgnoreCase(expectedURL))
		{
			System.out.println("Test Case Passed");
		}
		else
		{
			System.out.println("Test Case Failed");
		}
	
	}
	public void editProfessionalDetails() throws InterruptedException 
	{
		Thread.sleep(1000);
		//Click the "edit" icon
			driver.findElement(By.xpath("/html/body/app-root/app-profile-main/div/div/div[2]/app-myprofilenew/div/div/div/div[2]/div[1]/div[1]/a/i")).click();
		
			Thread.sleep(1000);
			//Come to the "Professional Details" section first
			driver.findElement(By.xpath("//*[@id='onboarding']/div/div[1]/div[1]/app-onboarding-leftnav/ul/li[4]/a")).click();
			
			Thread.sleep(1000);
		//Edit the "Most Accurately Describes your current Job Level
			driver.findElement(By.xpath("//*[@id=\"onboarding\"]/div/div[1]/div[2]/div[2]/app-onboarding-professional-details/accordion/accordion-group/div/div[2]/div/form/div[2]/select")).click();
		
			Thread.sleep(1000);
		//Select "entry Level"
			driver.findElement(By.xpath("/html/body/app-root/app-onboarding-main/div/div/div[1]/div[2]/div[2]/app-onboarding-professional-details/accordion/accordion-group/div/div[2]/div/form/div[2]/select/option[5]")).click();
		
			Thread.sleep(1000);
		//Finish the process by selecting Next button
			driver.findElement(By.xpath("/html/body/app-root/app-onboarding-main/div/div/div[1]/div[2]/div[2]/app-onboarding-professional-details/accordion/accordion-group/div/div[2]/div/form/button[2]")).click();
			
			Thread.sleep(1000);
	}
	public void editPersonalDetails() throws InterruptedException 
	{
		//Click the "personal Details" section on left side
		driver.findElement(By.xpath("//*[@id=\"onboarding\"]/div/div[1]/div[1]/app-onboarding-leftnav/ul/li[2]/a")).click();
		
		Thread.sleep(1000);
		//Edit the "Name" field
			personalDetails = driver.findElement(By.xpath("//*[@id=\"collapseOne\"]/div/div/form/div[1]/input"));
			personalDetails.click();
			
			Thread.sleep(1000);
			personalDetails.clear();
			
			Thread.sleep(1000);
			personalDetails.sendKeys("Devasish Nicholas Das");
			
			Thread.sleep(1000);
		
		//Select "Continue Button" to save results
			driver.findElement(By.xpath("/html/body/app-root/app-onboarding-main/div/div/div[1]/div[2]/div[2]/app-onboarding-personal-details/div[1]/div/div/div/div/div/form/div[1]/input")).click();
		
			Thread.sleep(1000);
		
	}
	public void navigateToPages() throws InterruptedException, NullPointerException
	{
		driver.navigate().to("https://www.edureka.co/blog/");
		Thread.sleep(1000);
		
		//Click No Thanks button on popup
		driver.findElement(By.xpath("//*[@id=\'wzrk-cancel\']")).click();
				
		//Click the Artificial Intelligence blog
		driver.findElement(By.xpath("/html/body/section[1]/div/div/div[1]")).click();
		
		Thread.sleep(1000);
		
		//Navigate back to Home page
		driver.navigate().to("https://www.edureka.co/");
		
		Thread.sleep(1000);
		/*if(driver.findElement(By.xpath("//*[@id=\'wzrk-cancel\']")) != null)
				{
					noThanks.click();
				}
		else
		{
			//Click the Artificial Intelligence blog
			driver.findElement(By.xpath("/html/body/section[1]/div/div/div[1]")).click();
			
			Thread.sleep(1000);
			
			//Navigate back to Home page
			driver.navigate().to("https://www.edureka.co/");
			
			Thread.sleep(1000);
		}*/
		
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}	
	
	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		CaseStudyFour methodTest = new CaseStudyFour();
		methodTest.setupBrowser("chrome", "https://www.edureka.co/");
		methodTest.getURL();
		methodTest.loginToEdureka();
		methodTest.getToMyProfile();
		methodTest.editProfessionalDetails();
		methodTest.editPersonalDetails();
		methodTest.navigateToPages();
		methodTest.closeBrowser();
		
		
	}

}
