package caseStudyThree;

import java.util.concurrent.TimeUnit;

//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeTest;

public class TicketBooking {

	
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Devs HP Pavilion 15i\\Downloads\\chromedriver_win32 (2)\\chromedriverChrome81.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.goindigo.in/?linkNav=home_header");

		// Desitination Section
		driver.findElement(By.xpath("//label[@for='oneWayTrip']")).click();//*[@id="bookFlightTab"]/form/div[2]/div[1]/label/label
		
		driver.findElement(By.xpath("//input[@class='form-control or-src-city']")).sendKeys("Bengaluru");
		WebElement dest = driver.findElement(By.xpath("//input[@class='form-control or-dest-city']"));
		dest.click();
		Thread.sleep(1000);
		dest.sendKeys("Lucknow");

		WebElement Date = driver.findElement(By.name("or-depart"));

		Date.click();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)");

		// Dates selection

		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).click();
		

		Thread.sleep(1000);

		// passenger Selection

		driver.findElement(By.xpath("//input[@name='passenger']")).click();
		driver.findElement(By.xpath("(//span[@class='icon-plus'])[1]")).click();
		driver.findElement(By.xpath("(//span[@class='icon-plus'])[1]")).click();
		driver.findElement(By.xpath("(//span[@class='icon-plus'])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='icon-plus'])[2]")).click();

		jse.executeScript("window.scrollBy(0,150)");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@class=\"btn btn-primary pax-done btn-pad-y\"]")).click();
		Thread.sleep(2000);

		jse.executeScript("window.scrollBy(0,-500)");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[@class='hp-src-btn']")).click();
		
		
		Thread.sleep(5000);
		driver.close();
	}
}