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


public class TMTPaymentDetailsPage extends AbstractComponent {
	
	WebDriver driver;
	
	
	public TMTPaymentDetailsPage(WebDriver driver) {
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);		
	}
	
	
	@FindBy(xpath ="//input[@id = 'name_on_card']")
	List <WebElement> nameOnCardLocator;
	
	@FindBy(xpath ="//input[@id = 'phone']")
	List <WebElement> phoneOnCardLocator;
	
	@FindBy(xpath ="//input[@id = 'email']")
	List <WebElement> emailOnCardLocator;
	
	@FindBy(xpath ="//input[@id = 'search-input']")
	List <WebElement> billingAddressLocator;
	
	@FindBy(xpath ="//div[@class = 'input-group autocomplete-field']/div/ul/li[1]")
	List <WebElement> billingAddressOnDropDoownLocator;
	
	@FindBy(xpath ="//iframe[@title = 'Secure card payment input frame']")
	List <WebElement> iframeLocator;
	
	@FindBy(xpath ="//input[@name = 'cardnumber']")
	List <WebElement> cardNumberLocator;
	
	@FindBy(xpath ="//input[@name = 'exp-date']")
	List <WebElement> expirationDateLocator;
	
	@FindBy(xpath ="//input[@name = 'cvc']")
	List <WebElement> cvcNumberLocator;
	
	@FindBy(xpath ="//input[@name = 'postal']")
	List <WebElement> postalCodeLocator;
	
	@FindBy(xpath ="//button[@class = 'stripe-button btn-success']")
	List <WebElement> payButtonLocator;
	
	
	
	
	
	public void insertStricterData(
		WebDriver driver,
		String insertedCreditCollect,
		String insertedStricter,
		String insertedFirstName,
		String insertedPhoneNumber,
		String insertedEmail){
		if(insertedCreditCollect.equals("credit")) {
			if(insertedStricter.equals("TRUE")) {
				// Billing address
				if (billingAddressLocator.size()!=0) 
				{
					billingAddressLocator.get(0).clear();
					billingAddressLocator.get(0).sendKeys("11");
				}
				else 
				{ 
					System.out.println("billingAddressLocator not exist");
				}
				// click Billing Address
				if (billingAddressOnDropDoownLocator.size()!=0) 
				{
					billingAddressOnDropDoownLocator.get(0).click();
				}
				else 
				{ 
					System.out.println("billingAddressOnDropDoownLocator not exist");
				}
				// Name
				if (nameOnCardLocator.size()!=0) 
				{
					nameOnCardLocator.get(0).clear();
					nameOnCardLocator.get(0).sendKeys(insertedFirstName);
				}
				else 
				{ 
					System.out.println("nameOnCardLocator not exist");
				}
				// Phone
				if (phoneOnCardLocator.size()!=0) 
				{
					phoneOnCardLocator.get(0).clear();
					phoneOnCardLocator.get(0).sendKeys(insertedPhoneNumber);
				}
				else 
				{ 
					System.out.println("phoneOnCardLocator not exist");
				}
				// Email
				if (emailOnCardLocator.size()!=0) 
				{
					emailOnCardLocator.get(0).clear();
					emailOnCardLocator.get(0).sendKeys(insertedEmail);
				}
				else 
				{ 
					System.out.println("emailOnCardLocator not exist");
				}
			}
			else{
				System.out.println("No need for stricter");
			}
		}
		else{
			System.out.println("No need for payment details");
		}
	}
	
	public void insertBillingAddress(WebDriver driver) {
		if (billingAddressLocator.size()!=0) 
		{
			billingAddressLocator.get(0).clear();
			billingAddressLocator.get(0).sendKeys("11");
		}
		else 
		{ 
			System.out.println("billingAddressLocator not exist");
		}
	}
	
	public void clickBillingAddress(WebDriver driver) {
		if (billingAddressOnDropDoownLocator.size()!=0) 
		{
			billingAddressOnDropDoownLocator.get(0).click();
		}
		else 
		{ 
			System.out.println("billingAddressOnDropDoownLocator not exist");
		}
	}
	
	public void insertCardNumber(
			WebDriver driver,
			String insertedCreditCollect,
			String insertedStricter,
			String insertedCardNumber,
			String insertedExpiryDate,
			String insertedCvcNumber,
			String insertedPostalCode) {
		if(insertedCreditCollect.equals("credit")) {
			if (iframeLocator.size()!=0) 
			{
				driver.switchTo().frame(iframeLocator.get(0));
				System.out.println("switched to iframe");
				// Card number
				if (cardNumberLocator.size()!=0) 
				{	
					cardNumberLocator.get(0).clear();
					cardNumberLocator.get(0).sendKeys(insertedCardNumber);
				}
				else 
				{ 
					System.out.println("cardNumberLocator not exist");
				}
				// Expiration date
				if (expirationDateLocator.size()!=0) 
				{	
					expirationDateLocator.get(0).clear();
					expirationDateLocator.get(0).sendKeys(insertedExpiryDate);
				}
				else 
				{ 
					System.out.println("expirationDateLocator not exist");
				}
				// CVC number
				if (cvcNumberLocator.size()!=0) 
				{	
					cvcNumberLocator.get(0).clear();
					cvcNumberLocator.get(0).sendKeys(insertedCvcNumber);
				}
				else 
				{ 
					System.out.println("cvcNumberLocator not exist");
				}
				// Postal code
				if(insertedStricter.equals("FALSE")){
					if (postalCodeLocator.size()!=0) 
					{	
						System.out.println("postalCodeLocator exist");
						postalCodeLocator.get(0).clear();
						postalCodeLocator.get(0).sendKeys(insertedPostalCode);
					}
					else 
					{ 
						System.out.println("postalCodeLocator not exist");
					}
				}
				System.out.println("swittch to default - exit iframe");
				driver.switchTo().defaultContent();
			}
			else 
			{ 
				System.out.println("iframeLocator not exist");
			}
			if (payButtonLocator.size()!=0) 
			{	
				//payButtonLocator.get(0).click();
			}
			else 
			{ 
				System.out.println("payButtonLocator not exist");
			}
		}
		else{
			System.out.println("No need for payment details");
		}	
			
	}
	
	//driver.switchTo().frame(iframeElement);
	
	
}
	
	
	

