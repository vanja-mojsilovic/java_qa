package Spothopper.QA.PageObjects;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import Spothopper.QA.AbstractComponents.AbstractComponent;


public class NewMenusPage extends AbstractComponent {
	
	WebDriver driver;
	
	
	public NewMenusPage(WebDriver driver) {
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);		
	}
	
	
	
	@FindBy(xpath ="//input[@ng-model='newFoodMenu.name']")
	List <WebElement> newMenuName;
	
	@FindBy(xpath ="//button[@ng-click='saveNewFoodMenu();']")
	List <WebElement> saveNewMenu;
	
	@FindBy(xpath ="//input[@ng-model='newFoodMenuSection.name']")
	List <WebElement> newMenuSectionName;
	
	@FindBy(xpath ="//button[@ng-click='saveNewFoodMenuSection();']")
	List <WebElement> saveNewMenuSection;

	@FindBy(xpath ="//input[@ng-model='newMenuItem.name']")
	List <WebElement> newMenuItemName;
	
	@FindBy(xpath ="//input[@ng-model='price.cents']")
	List <WebElement> newMenuItemPrice;
	
	@FindBy(xpath ="//button[@ng-click='saveMenuItem();']")
	List <WebElement> saveNewMenuItem;
	
	public void insertNewMenuName(WebDriver driver, String inserted_name){
		
		if (newMenuName.size()!=0) 
		{
			
			System.out.println(inserted_name); //obrisati
			newMenuName.get(0).clear();
			newMenuName.get(0).sendKeys(inserted_name);;
		}
		else 
		{ 
			System.out.println("newMenuName not exist");
			driver.quit();
		}
	}
	
	public void clickSaveButtonNewMenu(WebDriver driver){
		if (saveNewMenu.size()!=0) 
		{
			System.out.println("saveNewMenu exist");//obrisati
		
			//saveNewMenu.get(0).click();
			clickJavascriptExecutor(driver, saveNewMenu.get(0));
		}
		else 
		{ 
			System.out.println("saveNewMenu not exist");
			driver.quit();
		}
	}
	
	public void insertNewMenuSectionName(WebDriver driver, String inserted_name){
		if (newMenuSectionName.size()!=0) 
		{
			System.out.println("newMenuSectionName exist");
			newMenuSectionName.get(0).clear();
			newMenuSectionName.get(0).sendKeys(inserted_name);
			System.out.println(inserted_name); //obrisati
		}
		else 
		{ 
			System.out.println("newMenuSectionName not exist");
			driver.quit();
		}
	}
	
	public void clickSaveButtonNewMenuSection(WebDriver driver){
		if (saveNewMenuSection.size()!=0) 
		{
			System.out.println("saveNewMenuSection exist");//obrisati
			//saveNewMenu.get(0).click();
			clickJavascriptExecutor(driver, saveNewMenuSection.get(0));
		}
		else 
		{ 
			System.out.println("saveNewMenuSection not exist");
		}
	}
	
	public void insertNewMenuItemName(WebDriver driver, String inserted_name){
		if (newMenuItemName.size()!=0) 
		{
			newMenuItemName.get(0).clear();
			newMenuItemName.get(0).sendKeys(inserted_name);
			System.out.println(inserted_name); //obrisati
		}
		else 
		{ 
			System.out.println("newMenuItemName not exist");
			driver.quit();
		}
	}
	
	public void insertNewMenuItemPrice(WebDriver driver, String inserted_price){
		if (newMenuItemPrice.size()!=0) 
		{
			newMenuItemPrice.get(0).clear();
			newMenuItemPrice.get(0).sendKeys(inserted_price);
			System.out.println(inserted_price); //obrisati
		}
		else 
		{ 
			System.out.println("newMenuItemPrice not exist");
			driver.quit();
		}
	}
	
	public void clickSaveButtonNewMenuItem(WebDriver driver){
		if (saveNewMenuItem.size()!=0) 
		{
			System.out.println("saveNewMenuItem exist");//obrisati
			//saveNewMenu.get(0).click();
			clickJavascriptExecutor(driver, saveNewMenuItem.get(0));
		}
		else 
		{ 
			System.out.println("saveNewMenuItem not exist");
			driver.quit();
		}
	}
	
	public String getMenuNumber(String insertedString) {
        //String string_1 = "https://staging.spotapps.co/admin/spots/5910/food_menus#/8530?menu_type=food&login_token=88a6e5e5d9c04c4381a430052b8cb430";
        String[] parts = insertedString.split("/");
        if (parts.length >= 8) {
            // Retrieve the four-character-long string behind the seventh backslash
            String result = parts[7];
            if (result.length() >= 4) {
                result = result.substring(0, 4);
                return result;
            } else {
                // Handle the case where the string behind the seventh backslash is less than four characters
                return "Error: String behind the seventh backslash is less than four characters";
            }
        } else {
            // Handle the case where there are not enough parts in the URL
            return "Error: Not enough parts in the URL";
        }
    }

	
}
	
	
	

