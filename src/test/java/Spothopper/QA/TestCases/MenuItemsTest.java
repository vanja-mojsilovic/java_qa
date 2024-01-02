package Spothopper.QA.TestCases;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Parameters;
import Spothopper.QA.PageObjects.OrdersSettingsPage;
import Spothopper.QA.PageObjects.CustomizeMenuPage;
import Spothopper.QA.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;



	public class MenuItemsTest extends BaseTest 
	{
				
		@Test()
		public void insertMenuItems() {
			
			
			CustomizeMenuPage menusPage = new CustomizeMenuPage(driver);
			menusPage.goTo(menusURL);
			menusPage.clickMenusDropDown(driver);
			
			
			//driver.close();
			
			
		}
		
		
			
		
		

	}
