package Spothopper.QA.PageObjects;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.PublicVerificationKey;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import Spothopper.QA.AbstractComponents.AbstractComponent;


public class TMTOrderingMenuPopup extends AbstractComponent {
	
	WebDriver driver;
	
	
	public TMTOrderingMenuPopup(WebDriver driver) {
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);		
	}
	
	
	
	@FindBy(xpath ="//input[@id='pickup']")
	List <WebElement> pickupRadioButton;
	
	@FindBy(xpath ="//input[@id='delivery']")
	List <WebElement> deliveryRadioButton;
	
	
	@FindBy(xpath ="//input[@id='orderNow']")
	List <WebElement> orderNowRadioButton;
	
	
	@FindBy(xpath ="//input[@id='schedule']")
	List <WebElement> scheduleForLaterRadioButton;
	
	
	@FindBy(xpath ="//button[@type='button' and @data-dismiss='modal' and contains(@class, 'btn-success')]")
	List <WebElement> startOrder;
	
	
	
	public void clickPickupDelivery(WebDriver driver,String insertedPickupDelivery){
		switch(insertedPickupDelivery){
		case "pickup":
			if (pickupRadioButton.size()!=0) 
			{
				clickJavascriptExecutor(driver, pickupRadioButton.get(0));
			}
			else 
			{ 
				System.out.println("pickupRadioButton not exist");
			}
			break;
		case "delivery":
			if (deliveryRadioButton.size()!=0) 
			{
				clickJavascriptExecutor(driver, deliveryRadioButton.get(0));
			}
			else 
			{ 
				System.out.println("deliveryRadioButton not exist");
			}
			break;
		
		}
	}
	
	public void clickOrderNow(WebDriver driver){
		
		if (orderNowRadioButton.size()!=0) 
		{
			clickJavascriptExecutor(driver, orderNowRadioButton.get(0));
		}
		else 
		{ 
			System.out.println("orderNowRadioButton not exist");
		}
		
	}
	
	public void clickScheduleForLater(WebDriver driver){
		
		if (scheduleForLaterRadioButton.size()!=0) 
		{
			clickJavascriptExecutor(driver, scheduleForLaterRadioButton.get(0));
		}
		else 
		{ 
			System.out.println("scheduleForLaterRadioButton not exist");
		}
	}
	
	public void clickNowLater(WebDriver driver,String insertedNowLater){
		switch(insertedNowLater){
		case "now":
			if (orderNowRadioButton.size()!=0) 
			{
				clickJavascriptExecutor(driver, orderNowRadioButton.get(0));
			}
			else 
			{ 
				System.out.println("orderNowRadioButton not exist");
			}
			break;
		case "later":
			if (scheduleForLaterRadioButton.size()!=0) 
			{
				clickJavascriptExecutor(driver, scheduleForLaterRadioButton.get(0));
			}
			else 
			{ 
				System.out.println("scheduleForLaterRadioButton not exist");
			}
			break;
		
		}
	}
	
	public void clickStartOrder(WebDriver driver){
		
		if (startOrder.size()!=0) 
		{
			clickJavascriptExecutor(driver, startOrder.get(0));
		}
		else 
		{ 
			System.out.println("startOrder not exist");
		}
	}
	
}
	
	
	

