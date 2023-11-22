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
import Spothopper.QA.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;



	public class OnlineOrdersTest extends BaseTest 
	{
		
		
		@Parameters({"dataProviderCounter"})
		@Test
		public void setCounter(String dataProviderCounter) throws IOException
		{	
			
			currentCounter =2*setDataProviderCounter(dataProviderCounter);
			System.out.println("Executed setCounter_"+currentCounter);
			driver.close();
		}
		
		
		@Test(dataProvider="getData")
		public void setOnlineOrders(HashMap<String,String> input) throws IOException, InterruptedException {
			
			ordersSettingsPage = new OrdersSettingsPage(driver);
			ordersSettingsPage.goTo(ordersSettingsURL);
			String pickup_delivery = input.get("pickup_delivery");
			System.out.println("pickup_delivery_"+getCurrentCounter()+" is:" + pickup_delivery);
			ordersSettingsPage.activateOnlineOrders(driver);
			
			if (pickup_delivery.equals("pickup")) {
				System.out.println("activate pickup deactivate delivery_"+getCurrentCounter());
				ordersSettingsPage.activatePickup(driver);
				ordersSettingsPage.deactivateDelivery(driver);
			} 
			
			if (pickup_delivery.equals("delivery")){
				System.out.println("activate delivery deactivate pickup_"+getCurrentCounter());
				ordersSettingsPage.activateDelivery(driver);
				ordersSettingsPage.deactivatePickup(driver);
				ordersSettingsPage.chooseInhouseDrivers(driver);
			}
			
			String credit_collect = input.get("credit_collect");
			System.out.println("credit_collect_"+getCurrentCounter()+" is:" + credit_collect);
			if (credit_collect.equals("credit")) {
				System.out.println("check credit_"+getCurrentCounter());
				ordersSettingsPage.chooseCredit(driver);
			}
			
			if (credit_collect.equals("collect")){
				System.out.println("check collect_"+getCurrentCounter());
				ordersSettingsPage.chooseCollect(driver);
			}
			
			String deliveryFee = input.get("delivery_fee");
			System.out.println("deliveryFee_"+getCurrentCounter()+" is:" + deliveryFee);
			ordersSettingsPage.insertDeliveryFee(driver, deliveryFee);
			
			String taxRate = input.get("tax_rate");
			System.out.println("taxRate"+getCurrentCounter()+" is:" + taxRate);
			ordersSettingsPage.insertTaxRate(driver, taxRate);
			
			String stricterAuthorization = input.get("stricter_authorization");
			System.out.println("stricterAuthorization"+getCurrentCounter()+" is:" + stricterAuthorization);
			if(Boolean.parseBoolean(stricterAuthorization)) {
				ordersSettingsPage.activateStricterAuthorization(driver);
			} else {
				//deactivate stricter autorisation
			}
			
			String processingCost = input.get("processing_cost");
			System.out.println("processingCost"+getCurrentCounter()+" is:" + processingCost);
			if(Boolean.parseBoolean(processingCost)) {
			ordersSettingsPage.activateProcessingCost(driver);
			} else {
				//deactivate processingCost
			}
			
			if(pickup_delivery.equals("pickup")) {
				String hour = input.get("turnaround_pickup_hours");
				String minute = input.get("turnaround_pickup_minutes");
				System.out.println("turnaround_pickup_hours and turnaround_pickup_minutes "+hour+" "+minute);
				ordersSettingsPage.setPickupTurnaroundTime(driver,hour,minute);
			}
			
			if(pickup_delivery.equals("delivery")) {
				String hour = input.get("turnaround_delivery_hours");
				String minute = input.get("turnaround_delivery_minutes");
				System.out.println("turnaround_delivery_hours and turnaround_delivery_minutes "+hour+" "+minute);
				ordersSettingsPage.setDeliveryTurnaroundTime(driver,hour,minute);
			}
			
			ordersSettingsPage.emailInserted(email);
			
			
			//Thread.sleep(5000);
			System.out.println("Closing page_"+getCurrentCounter()+"!");
			increaseCurrentCounter();
			//driver.close();
			
			
		}
		
		@Test(dependsOnMethods = {"setOnlineOrders"})
		public void submitOnlineOrder() throws IOException {
			
			System.out.println("executed after setOnlineOrders");
		}
			
		
		

	}
