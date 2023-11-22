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


public class MenusPage extends AbstractComponent {
	
	WebDriver driver;
	
	
	public MenusPage(WebDriver driver) 
		{
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
						
		}
	
	@FindBy(xpath ="//button[@id='dropDownMenuFoodMenus']")
	List <WebElement> menusDropDown;
	
	@FindBy(xpath ="//a[@id='dropDownMenuFoodMenus']")
	List <WebElement> menusDropDown_1;
	
	public void clickMenusDropDown(WebDriver driver){
			if (menusDropDown.size()!=0) 
			{
				System.out.println("menusDropDown exist");
				menusDropDown.get(0).click();
			}
			else 
			{ 
				System.out.println("menusDropDown not exist");
			}
	}
	
	public void clickAnotherFoodMenu(WebDriver driver){
		if (menusDropDown.size()!=0) 
		{
			System.out.println("menusDropDown exist");
			menusDropDown.get(0).click();
		}
		else 
		{ 
			System.out.println("menusDropDown not exist");
		}
}



	
	}
	
	
	

