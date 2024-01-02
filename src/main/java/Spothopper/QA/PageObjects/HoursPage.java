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


public class HoursPage extends AbstractComponent {
	
	WebDriver driver;
	
	
	public HoursPage(WebDriver driver) 
		{
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
						
		}
	
	@FindBy(xpath ="//button[@ng-click='modal_instagram_not_connected.dismiss()']")
	List <WebElement> closeButton;
	
	@FindBy(xpath ="//button[@ng-click='$dismiss()']")
	List <WebElement> closeNYButton;
	
	@FindBy(xpath ="//i[@ng-if='operatingHoursCollapsed']")
	List <WebElement> expandOperatingHoursButton;
	
	@FindBy(xpath ="//input[@ng-model='spot.hours_of_operation_24[$index][0]']")
	List <WebElement> startWorkingHour;
	
	@FindBy(xpath ="//div[@class='ui-timepicker-wrapper'][last()]/ul[@class='ui-timepicker-list']/li[1]")
	List <WebElement> startHour;
	
	@FindBy(xpath ="//input[@ng-model='spot.hours_of_operation_24[$index][1]']")
	List <WebElement> endWorkingHour;
	
	@FindBy(xpath ="//div[@class='ui-timepicker-wrapper'][last()]/ul[@class='ui-timepicker-list']/li[48]")
	List <WebElement> endHour;
	
	@FindBy(xpath ="//button[@ng-click = 'submit($event)'][1]")
	List <WebElement> submitHours;
	
	
	public void clickClosePopupButton(WebDriver driver){
			if (closeButton.size()!=0) 
			{
				closeButton.get(0).click();
			}
			else 
			{ 
				System.out.println("closeButton not exist");
			}
	}
	
	public void clickCloseNYPopupButton(WebDriver driver){
		if (closeNYButton.size()!=0) 
		{
			closeNYButton.get(0).click();
		}
		else 
		{ 
			System.out.println("closeNYButton not exist");
		}
}
	
	public void expandOperatingHours(WebDriver driver){
		if (expandOperatingHoursButton.size()!=0) 
		{
			expandOperatingHoursButton.get(0).click();
		}
		else 
		{ 
			System.out.println("expandOperatingHoursButton not exist");
		}
	}
	
	public void setStartWorkingHour(WebDriver driver, String day){
		if (startWorkingHour.size()!=0) 
		{
			System.out.println("today is: "+day); //obrisati
			Integer numDay=0;
			switch (day) {
			case "Sunday":
				numDay=0;
                break;
            case "Monday":
            	numDay=1;
                break;
            case "Tuesday":
            	numDay=2;
                break;
            case "Wednesday":
            	numDay=3;
                break;
            case "Thursday":
            	numDay=4;
                break;
            case "Friday":
            	numDay=5;
                break;
            case "Saturday":
            	numDay=6;
                break;
            default:
            	numDay=0;
                System.out.println("Irregular day input");
		}
			startWorkingHour.get(numDay).click();
			startHour.get(0).click();
			
		}
		else 
		{ 
			System.out.println("startworkingHour not exist");
		}
	}
	
	public void setEndWorkingHour(WebDriver driver, String day){
		if (endWorkingHour.size()!=0) 
		{
			System.out.println("today is: "+day); //obrisati
			Integer numDay=0;
			switch (day) {
			case "Sunday":
				numDay=0;
                break;
            case "Monday":
            	numDay=1;
                break;
            case "Tuesday":
            	numDay=2;
                break;
            case "Wednesday":
            	numDay=3;
                break;
            case "Thursday":
            	numDay=4;
                break;
            case "Friday":
            	numDay=5;
                break;
            case "Saturday":
            	numDay=6;
                break;
            default:
            	numDay=0;
                System.out.println("Irregular day input");
		}
			endWorkingHour.get(numDay).click();
			endHour.get(0).click();
				
		}
		else 
		{ 
			System.out.println("endWorkingHour not exist");
		}
	}
	
	public void clickSaveButton(WebDriver driver){
		if (submitHours.size()!=0) 
		{
			submitHours.get(0).click();
		}
		else 
		{ 
			System.out.println("submitHours not exist");
		}
	}
	
		
}
	
	
	

