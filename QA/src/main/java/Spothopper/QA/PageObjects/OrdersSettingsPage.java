package Spothopper.QA.PageObjects;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import Spothopper.QA.AbstractComponents.AbstractComponent;







public class OrdersSettingsPage extends AbstractComponent {
	
	WebDriver driver;
	
	
	public OrdersSettingsPage(WebDriver driver) 
		{
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
						
		}
	
	
	@FindBy(xpath ="//input[@ng-model='order_config.has_pick_up']")
	List <WebElement> pickupCheckbox;
	
	@FindBy(xpath ="//input[@ng-model='order_config.has_deliveries']")
	List <WebElement> deliveryCheckbox;
	
	@FindBy(xpath ="//input[@id='in-house-delivery']")
	List <WebElement> inHouseDrivers;
	
	@FindBy(xpath ="//input[@name='CardPayments']")
	List <WebElement> creditCardPayments;
	
	@FindBy(xpath ="//input[@name='CollectPayment']")
	List <WebElement> collectPayment;
	
	@FindBy(xpath ="//input[@ng-model='order_config.delivery_fee']")
	List <WebElement> deliveryFee;
	
	
	@FindBy(xpath ="//input[@ng-model='order_config.tax_rate']")
	List <WebElement> taxRate;
	
	@FindBy(xpath ="//input[@ng-model='order_config.strict_card_authorisation']")
	List <WebElement> stricterAuthorization;
	
	@FindBy(xpath ="//input[@ng-model='order_config.pass_processing_fee_to_consumer']")
	List <WebElement> processingCost;
	
	@FindBy(xpath ="//input[@ng-model='order_config.pick_up_turnaround_hours']")
	List <WebElement> pickupTurnaroundHours;
	
	@FindBy(xpath ="//select[@ng-model='order_config.pick_up_turnaround_minutes']")
	List <WebElement> pickupTurnaroundMinutes;
	
	@FindBy(xpath ="//input[@ng-model='order_config.delivery_turnaround_hours']")
	List <WebElement> deliveryTurnaroundHours;
	
	@FindBy(xpath ="//select[@ng-model='order_config.delivery_turnaround_minutes']")
	List <WebElement> deliveryTurnaroundMinutes;
	
	@FindBy(xpath ="//input[@name='email_address_for_orders_1']")
	List <WebElement> emailAddress_1;
	
	
	
	public void activateOnlineOrders(WebDriver driver){
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
			List <WebElement> activeCheckbox = driver.findElements(By.xpath("//input[@ng-model='order_config.shopping_cart']"));
			if (activeCheckbox.size()!=0) 
			{
				System.out.println("activeCheckbox exist");
				boolean value = activeCheckbox.get(0).isSelected();
				if (!value) {
					System.out.println("activeCheckbox is selected " + value);
					clickJavascriptExecutor(driver, activeCheckbox.get(0)); //ovaj red prekopirati u donje redove
				    System.out.println("activeCheckbox is clicked");
				} 
			    value = activeCheckbox.get(0).isSelected();
			    System.out.println("activeCheckbox is selected " + value);
				
			}
			else 
			{ 
				System.out.println("activeCheckbox not exist");
			}
		}



	public void activatePickup(WebDriver driver){
		if (pickupCheckbox.size()!=0) 
		{
			System.out.println("pickupCheckbox exist");
			boolean value = pickupCheckbox.get(0).isSelected();
			if (!value) {
				System.out.println("pickupCheckbox_ is selected " + value);
				//JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				clickJavascriptExecutor(driver, pickupCheckbox.get(0));
			    //jsExecutor.executeScript("arguments[0].click();", pickupCheckbox);
			    System.out.println("pickupCheckbox_ is clicked");
			} 
		    value = pickupCheckbox.get(0).isSelected();
		    System.out.println("pickupCheckbox is selected " + value);
			
		}
		else 
		{ 
			System.out.println("pickupCheckbox not exist");
		}
	}
	
	public void deactivatePickup(WebDriver driver){
		if (pickupCheckbox.size()!=0) 
		{
			System.out.println("pickupCheckbox exist");
			boolean value = pickupCheckbox.get(0).isSelected();
			if (value) {
				System.out.println("pickupCheckbox_ is selected " + value);
				//JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				clickJavascriptExecutor(driver, pickupCheckbox.get(0));
			    //jsExecutor.executeScript("arguments[0].click();", pickupCheckbox);
			    System.out.println("pickupCheckbox is clicked");
			} 
		    value = pickupCheckbox.get(0).isSelected();
		    System.out.println("pickupCheckbox is selected " + value);
		    
			
		}
		else 
		{ 
			System.out.println("pickupCheckbox not exist");
		}
	}
	
	public void activateDelivery(WebDriver driver){
		if (deliveryCheckbox.size()!=0) 
		{
			System.out.println("deliveryCheckbox exist");
			boolean value = deliveryCheckbox.get(0).isSelected();
			if (!value) {
				System.out.println("deliveryCheckbox is selected " + value);
				//JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			    //jsExecutor.executeScript("arguments[0].click();", deliveryCheckbox);
				clickJavascriptExecutor(driver, deliveryCheckbox.get(0));
			    System.out.println("deliveryCheckbox is clicked");
			} 
		    value = deliveryCheckbox.get(0).isSelected();
		    System.out.println("deliveryCheckbox is selected " + value);
			
		}
		else 
		{ 
			System.out.println("deliveryCheckbox not exist");
		}
	}
	
	public void deactivateDelivery(WebDriver driver){
		if (deliveryCheckbox.size()!=0) 
		{
			System.out.println("deliveryCheckbox exist");
			boolean value = deliveryCheckbox.get(0).isSelected();
			if (value) {
				System.out.println("deliveryCheckbox is selected " + value);
				//JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			    //jsExecutor.executeScript("arguments[0].click();", deliveryCheckbox);
				clickJavascriptExecutor(driver, deliveryCheckbox.get(0));
			    System.out.println("deliveryCheckbox is clicked");
			} 
		    value = deliveryCheckbox.get(0).isSelected();
		    System.out.println("deliveryCheckbox is selected " + value);
			
		}
		else 
		{ 
			System.out.println("deliveryCheckbox not exist");
		}
	}
	
	public void chooseInhouseDrivers(WebDriver driver){
		if (inHouseDrivers.size()!=0) 
		{
			System.out.println("inHouseDrivers exist");
			boolean value = inHouseDrivers.get(0).isSelected();
			if (!value) {
				System.out.println("inHouseDrivers is selected " + value);
				clickJavascriptExecutor(driver, inHouseDrivers.get(0));
			    System.out.println("inHouseDrivers is clicked");
			} 
		    value = inHouseDrivers.get(0).isSelected();
		    System.out.println("inHouseDrivers is selected " + value);
		    
			
		}
		else 
		{ 
			System.out.println("inHouseDrivers not exist");
		}
		
	}
	
	public void chooseCredit(WebDriver driver){
		if (creditCardPayments.size()!=0) 
		{
			System.out.println("creditCardPayments exist");
			clickJavascriptExecutor(driver, creditCardPayments.get(0));
			boolean value = creditCardPayments.get(0).isSelected();
		    System.out.println("creditCardPayments is selected " + value);
		}
		else 
		{ 
			System.out.println("creditCardPayments not exist");
		}
	}
	
	public void chooseCollect(WebDriver driver){
		if (collectPayment.size()!=0) 
		{
			System.out.println("collectPayment exist");
			clickJavascriptExecutor(driver, collectPayment.get(0));
			boolean value = collectPayment.get(0).isSelected();
		    System.out.println("collectPayment is selected " + value);
		}
		else 
		{ 
			System.out.println("creditCardPayments not exist");
		}
	}
	
	public void insertDeliveryFee(WebDriver driver, String num){
		if (deliveryFee.size()!=0) 
		{
			System.out.println("deliveryFee exist");
			deliveryFee.get(0).clear();
			deliveryFee.get(0).sendKeys(num);
		}
		else 
		{ 
			System.out.println("deliveryFee not exist");
		}
	}
	
	
	public void insertTaxRate(WebDriver driver, String num){
		if (taxRate.size()!=0) 
		{
			System.out.println("taxRate exist");
			taxRate.get(0).clear();
			taxRate.get(0).sendKeys(num);
		}
		else 
		{ 
			System.out.println("taxRate not exist");
		}
	}
	
	public void activateStricterAuthorization(WebDriver driver){
		if (stricterAuthorization.size()!=0) 
		{
			System.out.println("stricterAuthorization exist");
			boolean value = stricterAuthorization.get(0).isSelected();
			if (!value) {
				System.out.println("stricterAuthorization is selected " + value);
				clickJavascriptExecutor(driver, stricterAuthorization.get(0));
			    System.out.println("stricterAuthorization is clicked");
			} 
		    value = stricterAuthorization.get(0).isSelected();
		    System.out.println("stricterAuthorization is selected " + value);
		}
		else 
		{ 
			System.out.println("stricterAuthorization not exist");
		}
	}
	
	public void deactivateStricterAuthorization(WebDriver driver){
		if (stricterAuthorization.size()!=0) 
		{
			System.out.println("stricterAuthorization exist");
			boolean value = stricterAuthorization.get(0).isSelected();
			if (value) {
				System.out.println("stricterAuthorization is selected " + value);
				clickJavascriptExecutor(driver, stricterAuthorization.get(0));
			    System.out.println("stricterAuthorization is clicked");
			} 
		    value = stricterAuthorization.get(0).isSelected();
		    System.out.println("stricterAuthorization is selected " + value);
		}
		else 
		{ 
			System.out.println("stricterAuthorization not exist");
		}
	}
	
	public void activateProcessingCost(WebDriver driver){
		if (processingCost.size()!=0) 
		{
			System.out.println("processingCost exist");
			boolean value = processingCost.get(0).isSelected();
			if (!value) {
				System.out.println("processingCost is selected " + value);
				clickJavascriptExecutor(driver, processingCost.get(0));
			    System.out.println("processingCost is clicked");
			} 
		    value = processingCost.get(0).isSelected();
		    System.out.println("processingCost is selected " + value);
		}
		else 
		{ 
			System.out.println("processingCost not exist");
		}
	}
	
	public void deactivateProcessingCost(WebDriver driver){
		if (processingCost.size()!=0) 
		{
			System.out.println("processingCost exist");
			boolean value = processingCost.get(0).isSelected();
			if (value) {
				System.out.println("processingCost is selected " + value);
				clickJavascriptExecutor(driver, processingCost.get(0));
			    System.out.println("processingCost is clicked");
			} 
		    value = processingCost.get(0).isSelected();
		    System.out.println("processingCost is selected " + value);
		}
		else 
		{ 
			System.out.println("processingCost not exist");
		}
	}
	
	public void setPickupTurnaroundTime(WebDriver driver, String hour, String minute){
		if (pickupTurnaroundHours.size()!=0) 
		{
			System.out.println("pickupTurnaroundHours exist");
			pickupTurnaroundHours.get(0).clear();
			System.out.println("pickupTurnaroundHours cleared");
			pickupTurnaroundHours.get(0).sendKeys(hour);
		} 
		else { 
			System.out.println("2 not exist");
		}
		if (pickupTurnaroundMinutes.size()!=0) {
			System.out.println("pickupTurnaroundMinutes exist");
			//clickJavascriptExecutor(driver, pickupTurnaroundMinutes.get(0));
			pickupTurnaroundMinutes.get(0).click();
			String min = "0";
			switch (minute) {
            case "0":
                min = "1";
                break;
            case "15":
            	min = "2";
                break;
            case "30":
            	min = "3";
                break;
            case "45":
            	min = "4";
                break;
			}
			String element = "//select[@ng-model='order_config.pick_up_turnaround_minutes']/option["+min+"]";
			List <WebElement> pickupTurnaroundMinutes_choose = driver.findElements(By.xpath(element));
			if (pickupTurnaroundMinutes_choose.size()!=0) {
				System.out.println("pickupTurnaroundMinutes_choose exist");
				//clickJavascriptExecutor(driver, pickupTurnaroundMinutes_choose.get(0));
				pickupTurnaroundMinutes_choose.get(0).click();
			}
		} 
		else { 
			System.out.println("pickupTurnaroundMinutes not exist");
		}
	}
	
	public void setDeliveryTurnaroundTime(WebDriver driver, String hour, String minute){
		if (deliveryTurnaroundHours.size()!=0) 
		{
			System.out.println("deliveryTurnaroundHours exist");
			deliveryTurnaroundHours.get(0).clear();
			System.out.println("deliveryTurnaroundHours cleared");
			deliveryTurnaroundHours.get(0).sendKeys(hour);
		} 
		else { 
			System.out.println("deliveryTurnaroundHours not exist");
		}
		if (deliveryTurnaroundMinutes.size()!=0) 
		{
			System.out.println("deliveryTurnaroundMinutes exist");
			//clickJavascriptExecutor(driver, deliveryTurnaroundMinutes.get(0));
			deliveryTurnaroundMinutes.get(0).click();
			String min = "0";
			switch (minute) {
            case "0":
                min = "1";
                break;
            case "15":
            	min = "2";
                break;
            case "30":
            	min = "3";
                break;
            case "45":
            	min = "4";
                break;
        }
			
		String element = "//select[@ng-model='order_config.delivery_turnaround_minutes']/option["+min+"]";
		List <WebElement> deliveryTurnaroundMinutes_choose = driver.findElements(By.xpath(element));
		if (deliveryTurnaroundMinutes_choose.size()!=0) {
			System.out.println("deliveryTurnaroundMinutes_choose exist");
			//clickJavascriptExecutor(driver, deliveryTurnaroundMinutes_choose.get(0));
			deliveryTurnaroundMinutes_choose.get(0).click();
		}
		
		} 
		else { 
			System.out.println("deliveryTurnaroundMinutes not exist");
		}
	}
	
	public void emailInserted(String email) {
		if (emailAddress_1.size()!=0){
			 String elementText = emailAddress_1.get(0).getAttribute("value"); 
		     if(elementText.isEmpty()) {
		    	 emailAddress_1.get(0).clear();
		    	 emailAddress_1.get(0).sendKeys(email);
		    	 System.out.println("emailAddress_1 inserted "+email);
		     };
		}
	}
	
	
	
}
