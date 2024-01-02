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


public class CustomizeMenuPage extends AbstractComponent {
	
	WebDriver driver;
	
	
	public CustomizeMenuPage(WebDriver driver) 
		{
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
						
		}
	
	@FindBy(xpath ="//button[@id='dropDownMenuFoodMenus']")
	List <WebElement> menusDropDown;
	
	@FindBy(xpath ="//div[@class='menus-wrapper'][1]/a[1]")
	List <WebElement> addAnotherFoodMenu;  // obrisati
	
	@FindBy(xpath ="//button[text()='Configure/Set Hours']")
	List <WebElement> configureSetHours;
	
	@FindBy(xpath ="//button[@class='btn btn-delete' and @ng-click='deleteFoodMenu(activeFoodMenu);']")
	List <WebElement> deleteMenuTrash;
	
	@FindBy(xpath ="//button[@class='btn btn-success' and @ng-click='deleteFoodMenuConfirmed(food_menu_to_delete.id);']")
	List <WebElement> yesDeleteMenu;
	
	
	
	public void clickMenusDropDown(WebDriver driver){
			if (menusDropDown.size()!=0) 
			{
				System.out.println("menusDropDown exist");  // obrisati
				menusDropDown.get(0).click();
			}
			else 
			{ 
				System.out.println("menusDropDown not exist");
			}
	}
	
	public void clickMenuName(WebDriver driver, String m_name){
		List <WebElement> menuNameElement = driver.findElements(By.xpath("//a[@class='ng-binding' and text()='" + m_name + "']"));
		if (menuNameElement.size()!=0) 
		{
			System.out.println("menuNameElement exist"); // obrisati
			menuNameElement.get(0).click();
		}
		else 
		{ 
			System.out.println("menuNameElement for deleting not exist");
			driver.quit();
		}
	}
	
	public void clickConfigureSetHours(WebDriver driver){
		if (configureSetHours.size()!=0) 
		{
			System.out.println("configureSetHours exist"); // obrisati
			configureSetHours.get(0).click();
		}
		else 
		{ 
			System.out.println("configureSetHours not exist");
		}
	}
	
	public void clickDeleteMenuTrash(WebDriver driver){
		if (deleteMenuTrash.size()!=0) 
		{
			System.out.println("deleteMenuTrash exist"); // obrisati
			deleteMenuTrash.get(0).click();
		}
		else 
		{ 
			System.out.println("deleteMenuTrash not exist");
		}
	}
	
	public void clickYesDeleteMenu(WebDriver driver){
		if (yesDeleteMenu.size()!=0) 
		{
			yesDeleteMenu.get(0).click(); // probati sa java scriptom
		}
		else 
		{ 
			System.out.println("yesDeleteMenu not exist");
		}
	}
	
	



	
} // end class
	
	
	

