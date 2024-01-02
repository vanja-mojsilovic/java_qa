package Spothopper.QA.AbstractComponents;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goTo(String url) 
	{
		driver.get(url);
		
	}
	
	public void waitForElementToAppear(By findBy, int numOfSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(numOfSeconds));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void finshTest(WebDriver driver)
	{
		System.out.println("The test is over!");
		driver.close();
	}
	
	public void clickJavascriptExecutor(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	    jsExecutor.executeScript("arguments[0].click();", element);
	}
	
}
