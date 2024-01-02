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


public class TMTOrderingMenuPage extends AbstractComponent {
	
	WebDriver driver;
	
	
	public TMTOrderingMenuPage(WebDriver driver) {
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);		
	}
	
	
	@FindBy(xpath = "//*[contains(text(),'Total:')]")
	List <WebElement> subtotalPrice;
	
	@FindBy(xpath = "//button[@class='btn btn-success']")
	List <WebElement> proceedToCheckoutButton;
	
	@FindBy(xpath = "//h1[contains(text(), 'Order checkout')]")
	List <WebElement> checkoutTitle;
	
	@FindBy(xpath = "//input[@id='first_name']")
	List <WebElement> firstNameLocator;
	
	@FindBy(xpath = "//input[@id='last_name']")
	List <WebElement> lastNameLocator;
	
	@FindBy(xpath = "//input[@id='phone']")
	List <WebElement> phoneNumberLocator;
	
	@FindBy(xpath = "//input[@id='email']")
	List <WebElement> emailLocator;
	
	@FindBy(xpath = "//input[@placeholder='Address']")
	List <WebElement> streetAddressLocator;
	
	@FindBy(xpath = "//div[@class='input-group autocomplete-field']/div/ul/li[1]")
	List <WebElement> streetAddress_1_FromListLocator;
	
	@FindBy(xpath = "//div[@id='tip_0']")
	List <WebElement> restaurantTip_0_Locator;
	
	@FindBy(xpath = "//div[@id='tip_10']")
	List <WebElement> restaurantTip_10_Locator;
	
	@FindBy(xpath = "//div[@id='tip_15']")
	List <WebElement> restaurantTip_15_Locator;
	
	@FindBy(xpath = "//div[@id='tip_20']")
	List <WebElement> restaurantTip_20_Locator;
	
	@FindBy(xpath = "//input[@placeholder='Discount code']")
	List <WebElement> discountCodeLocator;
	
	@FindBy(xpath = "//button[contains(text(), 'Apply')]")
	List <WebElement> applyDiscountLocator;
	
	@FindBy(xpath = "//label[@class='text-danger']")
	List <WebElement> errorMessageLocator;
	
	@FindBy(xpath = "//button[@type='submit']")
	List <WebElement> nextAddPaymentLocator;
		
	
	
	public void clickMenuName(WebDriver driver, String menuName){
		String xpathExpression = "//*[contains(text(), '" + menuName + "')]";
		List <WebElement> menu = driver.findElements(By.xpath(xpathExpression));
		if (menu.size()!=0) 
		{
			clickJavascriptExecutor(driver, menu.get(0));
		}
		else 
		{ 
			System.out.println("menu not exist");
			driver.close();
		}
	}
	
	public void clickMenuItemName(WebDriver driver, String menuItemName, String menuItemPrice){
		String ariaLabelString = "Add "+menuItemName+", $"+menuItemPrice+" to cart";
		String xpathExpression = "//button[@aria-label='"+ariaLabelString+"']";
		List <WebElement> menuItem = driver.findElements(By.xpath(xpathExpression));
		if (menuItem.size()!=0) 
		{
			clickJavascriptExecutor(driver, menuItem.get(0));
		}
		else 
		{ 
			System.out.println("menuItem not exist");
			driver.close();
		}
	}
	
	public String getSubtotal(WebDriver driver){
		String result = null;
		if (subtotalPrice.size()!=0) 
		{
			String subtotalString = subtotalPrice.get(0).getText();
			int indexOfDollar = subtotalString.indexOf('$');
	        if (indexOfDollar != -1) {
	            result = subtotalString.substring(indexOfDollar + 1);
	        }
		}
		else 
		{ 
			System.out.println("subtotalPrice not exist");
		}
		return result;
	}
	
	public void clickProceedToCheckout(WebDriver driver){
		if (proceedToCheckoutButton.size()!=0) 
		{
			System.out.println("proceedToCheckoutButton exist");
			clickJavascriptExecutor(driver, proceedToCheckoutButton.get(0));
		}
		else 
		{ 
			System.out.println("proceedToCheckoutButton not exist");
		}
	}
	
	public boolean checkoutPageDisplayed(WebDriver driver) {
		if (checkoutTitle.size()!=0) 
		{
			return true;
		}
		else 
		{ 
			System.out.println("checkoutTitle not exist");
			return false;
		}
	}
	
	public void insertFirstName(WebDriver driver, String insertedFirstName){
		if (firstNameLocator.size()!=0) 
		{
			System.out.println("firstName exist"); // obrisati
			firstNameLocator.get(0).clear();
			firstNameLocator.get(0).sendKeys(insertedFirstName);
		}
		else 
		{ 
			System.out.println("firstName not exist");
		}
	}
	
	public void insertLastName(WebDriver driver, String insertedLastName){
		if (lastNameLocator.size()!=0) 
		{
			System.out.println("lastName exist"); // obrisati
			lastNameLocator.get(0).clear();
			lastNameLocator.get(0).sendKeys(insertedLastName);
		}
		else 
		{ 
			System.out.println("lastName not exist");
		}
	}
	
	public void insertPhoneNumber(WebDriver driver, String insertedPhoneNumber){
		if (phoneNumberLocator.size()!=0) 
		{
			System.out.println("phoneNumberLocator exist"); // obrisati
			phoneNumberLocator.get(0).clear();
			phoneNumberLocator.get(0).sendKeys(insertedPhoneNumber);
		}
		else 
		{ 
			System.out.println("phoneNumberLocator not exist");
		}
	}
	
	public void insertEmail(WebDriver driver, String insertedEmail){
		if (emailLocator.size()!=0) 
		{
			System.out.println("emailLocator exist"); // obrisati
			emailLocator.get(0).clear();
			emailLocator.get(0).sendKeys(insertedEmail);
		}
		else 
		{ 
			System.out.println("emailLocator not exist");
		}
	}
	
	public void insertStreetAddress(WebDriver driver, String insertedPickupDelivery) {
		switch (insertedPickupDelivery) {
	    case "delivery":
	    	if (streetAddressLocator.size()!=0) 
			{	
				System.out.println("streetAddressLocator exist"); // obrisati
				streetAddressLocator.get(0).clear();
				streetAddressLocator.get(0).sendKeys("11");
			}
			else 
			{ 
				System.out.println("streetAddressLocator not exist"); 
			}
	        break;
	    case "pickup":
	    	System.out.println("No need for address");
	        break;
		}
	}
	
	
	public void clickStreetAddres_1_FRomList(WebDriver driver,String insertedPickupDelivery){
		if(insertedPickupDelivery.equals("delivery")) {
			if (streetAddress_1_FromListLocator.size()!=0) 
			{
				System.out.println("streetAddress_1_FromListLocator exist"); // obrisati
				streetAddress_1_FromListLocator.get(0).click();
			}
			else 
			{ 
				System.out.println("streetAddress_1_FromListLocator not exist");
			}
		}	
	}
	
	public void insertRestaurantTip(WebDriver driver, String insertedRestaurantTip) {
		switch (insertedRestaurantTip) {
	    case "0":
	    	if (restaurantTip_0_Locator.size()!=0) 
			{	
				System.out.println("restaurantTip_0_Locator exist"); // obrisati
				restaurantTip_0_Locator.get(0).click();
			}
			else 
			{ 
				System.out.println("restaurantTip_0_Locator not exist"); 
			}
	        break;
	    case "10":
	    	if (restaurantTip_10_Locator.size()!=0) 
			{	
				System.out.println("restaurantTip_10_Locator exist"); // obrisati
				restaurantTip_10_Locator.get(0).click();
			}
			else 
			{ 
				System.out.println("restaurantTip_10_Locator not exist"); 
			}
	        break;
	    case "15":
	    	if (restaurantTip_15_Locator.size()!=0) 
			{	
				System.out.println("restaurantTip_15_Locator exist"); // obrisati
				restaurantTip_15_Locator.get(0).click();
			}
			else 
			{ 
				System.out.println("restaurantTip_15_Locator not exist"); 
			}
	    	break;
	    case "20":
	    	if (restaurantTip_20_Locator.size()!=0) 
			{	
				System.out.println("restaurantTip_20_Locator exist"); // obrisati
				restaurantTip_20_Locator.get(0).click();
			}
			else 
			{ 
				System.out.println("restaurantTip_20_Locator not exist"); 
			}
	        break;
		}
	}
	
	public void insertDiscountCode(WebDriver driver, String insertedDiscountType, String insertedDiscountCode) {
		if (insertedDiscountType.equals("amount") || insertedDiscountType.equals("percentage")) {
	    	if (discountCodeLocator.size()!=0) 
			{	
				System.out.println("discountCodeLocator exist"); // obrisati
				discountCodeLocator.get(0).clear();
				discountCodeLocator.get(0).sendKeys(insertedDiscountCode);
				if (applyDiscountLocator.size()!=0) 
				{
					System.out.println("applyDiscountLocator exist"); // obrisati
					applyDiscountLocator.get(0).click();
				}
				else 
				{ 
					System.out.println("applyDiscountLocator not exist");
				}
			}
			else 
			{ 
				System.out.println("discountCodeLocator not exist"); 
			}
		} 
		else {
	    	System.out.println("No need for discount");
		}
	}
	
	public void clickApplyDiscount(WebDriver driver){
		if (applyDiscountLocator.size()!=0) 
		{
			System.out.println("applyDiscountLocator exist"); // obrisati
			applyDiscountLocator.get(0).click();
		}
		else 
		{ 
			System.out.println("applyDiscountLocator not exist");
		}
	}
	
	public boolean errorMessageExist(WebDriver driver, String insertedDiscountType) {
		if (insertedDiscountType.equals("amount") || insertedDiscountType.equals("percentage")) {
			if(errorMessageLocator.size()!=0){
				System.out.println("Voucher not found!");
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	public void clickAddPayment(WebDriver driver){
		if (nextAddPaymentLocator.size()!=0) 
		{
			System.out.println("nextAddPaymentLocator exist"); // obrisati
			nextAddPaymentLocator.get(0).click();
		}
		else 
		{ 
			System.out.println("nextAddPaymentLocator not exist");
		}
	}
}
	
	
	

