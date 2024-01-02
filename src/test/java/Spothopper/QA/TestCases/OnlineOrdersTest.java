package Spothopper.QA.TestCases;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.testng.annotations.Parameters;

import Spothopper.QA.PageObjects.HoursPage;
import Spothopper.QA.PageObjects.CustomizeMenuPage;
import Spothopper.QA.PageObjects.NewMenusPage;
import Spothopper.QA.PageObjects.TMTOrderingMenuPopup;
import Spothopper.QA.PageObjects.TMTPaymentDetailsPage;
import Spothopper.QA.PageObjects.OrdersSettingsPage;
import Spothopper.QA.PageObjects.TMTOrderingMenuPage;
import Spothopper.QA.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;



	public class OnlineOrdersTest extends BaseTest 
	{
		
		@Test
		public void setHours() throws IOException, InterruptedException
		{	
			
			HoursPage hoursPage = new HoursPage(driver);
			hoursPage.goTo(hoursURL);
			Thread.sleep(1000);
			hoursPage.clickCloseNYPopupButton(driver);
			//hoursPage.clickClosePopupButton(driver);
			hoursPage.expandOperatingHours(driver);
			String currentTimeString = getStringLocalDateTime();
			System.out.println(currentTimeString); //obrisati
			String dayToday = getDayOfTheWeek(); 
			hoursPage.setStartWorkingHour(driver, dayToday);
			hoursPage.setEndWorkingHour(driver, dayToday);
			hoursPage.clickSaveButton(driver);
			Thread.sleep(1000);
			driver.close();
		}
		
		@Test
		public void setMenus() throws IOException, InterruptedException
		{	
			OrdersSettingsPage ordersSettingsPage = new OrdersSettingsPage(driver);
			ordersSettingsPage.goTo(ordersSettingsURL);
			ordersSettingsPage.activateOnlineOrders(driver);
			ordersSettingsPage.activatePickup(driver);
			ordersSettingsPage.activateDelivery(driver);
			ordersSettingsPage.clickSaveSettingsButton(driver);
			CustomizeMenuPage menusPage = new CustomizeMenuPage(driver);
			menusPage.goTo(menusURL);
			Thread.sleep(1000);
			NewMenusPage newMenusPage = new NewMenusPage(driver);
			String currentTimeString = getStringLocalDateTime();
			String menu_name = "Dinner "+currentTimeString;
			String menu_section_name = "Soups "+currentTimeString;
			String menu_item_1_name = "Chicken Soup "+currentTimeString;
			String menu_item_1_price = "35.00";
			String menu_item_2_name = "Beef Soup "+currentTimeString;
			String menu_item_2_price = "38.00";
			newMenusPage.goTo(addNewMenusURL);
			newMenusPage.insertNewMenuName(driver, menu_name);
			Thread.sleep(1000);
			newMenusPage.clickSaveButtonNewMenu(driver);
			Thread.sleep(1000);
			newMenusPage.insertNewMenuSectionName(driver, menu_section_name);
			newMenusPage.clickSaveButtonNewMenuSection(driver);
			Thread.sleep(1000);
			String currentUrl = driver.getCurrentUrl();
	        System.out.println("Current URL: " + currentUrl);
	        String menu_num = newMenusPage.getMenuNumber(currentUrl);
	        System.out.println("Menu number is: "+menu_num); 
	        setMenuNumberString(menu_num);
			newMenusPage.insertNewMenuItemName(driver, menu_item_1_name);
			newMenusPage.insertNewMenuItemPrice(driver, menu_item_1_price);
			newMenusPage.clickSaveButtonNewMenuItem(driver);
			setMenuName(menu_name);
			setMenuItemName_1(menu_item_1_name);
			setMenuItemPrice_1(menu_item_1_price);
			Thread.sleep(1000);
			newMenusPage.insertNewMenuItemName(driver, menu_item_2_name);
			newMenusPage.insertNewMenuItemPrice(driver, menu_item_2_price);
			newMenusPage.clickSaveButtonNewMenuItem(driver);
			setMenuItemName_2(menu_item_2_name);
			setMenuItemPrice_2(menu_item_2_price);
			Thread.sleep(1000);
			driver.close();
		}
		
		
		
		
		
		//@Test(dataProvider="getData", dependsOnMethods = {"setCounter","setHours","setMenus"})
		@Parameters({"dataProviderCounter"})
		@Test(dataProvider="getData")
		public void setOnlineOrders(HashMap<String,String> input) throws IOException, InterruptedException {
			System.out.println("dataProviderCounter = "+dataProviderCounter);
			OrdersSettingsPage ordersSettingsPage = new OrdersSettingsPage(driver);
			ordersSettingsPage.goTo(ordersSettingsURL);
			String pickupDelivery = input.get("pickup_delivery");
			System.out.println("pickup_delivery_"+getCurrentCounter()+" is:" + pickupDelivery);
			ordersSettingsPage.activateOnlineOrders(driver);
			ordersSettingsPage.activatePickup(driver);
			ordersSettingsPage.activateDelivery(driver);
			String creditCollect = input.get("credit_collect");
			System.out.println("credit_collect_"+getCurrentCounter()+" is:" + creditCollect);
			if (creditCollect.equals("credit")) {
				System.out.println("check credit_"+getCurrentCounter());
				ordersSettingsPage.chooseCredit(driver);
			}
			if (creditCollect.equals("collect")){
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
			if(stricterAuthorization.equals("TRUE")) {
				ordersSettingsPage.activateStricterAuthorization(driver);
			} 
			if(stricterAuthorization.equals("FALSE")) {
				ordersSettingsPage.deactivateStricterAuthorization(driver);
			}
			String processingCost = input.get("processing_cost");
			System.out.println("processingCost"+getCurrentCounter()+" is:" + processingCost);
			if(processingCost.equals("TRUE")) {
			ordersSettingsPage.activateProcessingCost(driver);
			} 
			if(processingCost.equals("FALSE")) {
				ordersSettingsPage.deactivateProcessingCost(driver);
			}
			if(pickupDelivery.equals("pickup")) {
				String hour = input.get("turnaround_pickup_hours");
				String minute = input.get("turnaround_pickup_minutes");
				System.out.println("turnaround_pickup_hours and turnaround_pickup_minutes "+hour+" "+minute);
				ordersSettingsPage.setPickupTurnaroundTime(driver,hour,minute);
			}
			if(pickupDelivery.equals("delivery")) {
				String hour = input.get("turnaround_delivery_hours");
				String minute = input.get("turnaround_delivery_minutes");
				System.out.println("turnaround_delivery_hours and turnaround_delivery_minutes "+hour+" "+minute);
				ordersSettingsPage.setDeliveryTurnaroundTime(driver,hour,minute);
			}
			ordersSettingsPage.emailInserted(email);
			ordersSettingsPage.clickSaveSettingsButton(driver);
			Thread.sleep(1000);
			
			// TMT ordering popup
			TMTOrderingMenuPopup orderingMenuPopup = new TMTOrderingMenuPopup(driver);
			orderingMenuPopup.goTo(orderingMenuPopupTMT);
			orderingMenuPopup.clickPickupDelivery(driver, pickupDelivery);
			String nowLater = input.get("now_later");
			System.out.println("now_later "+getCurrentCounter()+" is:" + nowLater);
			orderingMenuPopup.clickNowLater(driver, nowLater);
			orderingMenuPopup.clickStartOrder(driver);
			
			// TMTOrderingMenuPage
			TMTOrderingMenuPage tmtOrderingMenuPage = new TMTOrderingMenuPage(driver);
			tmtOrderingMenuPage.clickMenuName(driver, menuName);
			tmtOrderingMenuPage.clickMenuItemName(driver, menuItemName_1, menuItemPrice_1);
			tmtOrderingMenuPage.clickMenuItemName(driver, menuItemName_2, menuItemPrice_2);
			String subtotal = tmtOrderingMenuPage.getSubtotal(driver);
			System.out.println(subtotal);
			String expectedSubtotal = countSubtotal(menuItemPrice_1, menuItemPrice_2); 
			System.out.println(expectedSubtotal);
			Assert.assertEquals(subtotal, expectedSubtotal, "The subtotal is not equals!");
			Thread.sleep(1000);
			tmtOrderingMenuPage.clickProceedToCheckout(driver);
			Boolean titleShown = tmtOrderingMenuPage.checkoutPageDisplayed(driver);
			Assert.assertEquals(titleShown, true, "The title is not shown!");
			tmtOrderingMenuPage.insertFirstName(driver, customersFirstName);
			tmtOrderingMenuPage.insertLastName(driver, customersLastName);
			tmtOrderingMenuPage.insertPhoneNumber(driver, customersPhoneNumber);
			tmtOrderingMenuPage.insertEmail(driver, customersEmail);
			tmtOrderingMenuPage.insertStreetAddress(driver,pickupDelivery); 
			tmtOrderingMenuPage.clickStreetAddres_1_FRomList(driver,pickupDelivery);
			String restaurantTip = input.get("restaurant_tip");
			tmtOrderingMenuPage.insertRestaurantTip(driver,restaurantTip);
			String discountPercentageAmountNone= input.get("discount_percentage_amount_none");
			String discountCode= input.get("discount_code");
			tmtOrderingMenuPage.insertDiscountCode(driver,discountPercentageAmountNone,discountCode);
			boolean errorMessageShown = tmtOrderingMenuPage.errorMessageExist(driver,discountPercentageAmountNone);
			if(!discountPercentageAmountNone.equals("none")){
				System.out.println("boolean errorMessageShown is: "+errorMessageShown); 
				Assert.assertEquals(errorMessageShown,false,"Discount code is not correct!");
			}
			tmtOrderingMenuPage.clickAddPayment(driver); 
			Thread.sleep(1000);
			//TMTPaymentDetailsPage
			TMTPaymentDetailsPage tmtPaymentDetailsPage = new TMTPaymentDetailsPage(driver);
			tmtPaymentDetailsPage.insertStricterData(
					driver,
					creditCollect,
					stricterAuthorization,
					customersFirstName,
					customersPhoneNumber,
					customersEmail);
			tmtPaymentDetailsPage.insertCardNumber(
					driver,
					creditCollect,
					stricterAuthorization,
					creditCardNumber,
					expiryDate,
					cvcNumber,
					postalCode);
			
			
			// ********** next spot
			increaseCurrentCounter();
			System.out.println("Executed increaseCurrentCounter(), now it is: "+currentCounter);
			System.out.println("Closing page_"+getCurrentCounter()+"!"); 
			//driver.close();
		}
		
		@Test
		public void deleteMenus() throws IOException, InterruptedException
		{	
			CustomizeMenuPage menusPage = new CustomizeMenuPage(driver);
			menusPage.goTo(menusURL);
			Thread.sleep(1000);
			CustomizeMenuPage customizeMenuPage = new CustomizeMenuPage(driver);
			System.out.println("***** "+menuNumberString+" ********"); //obrisati
			customizeMenuPage.goTo(deleteMenuURL);
			customizeMenuPage.clickMenusDropDown(driver);
			System.out.println(menuName); //obrisati
			customizeMenuPage.clickMenuName(driver, menuName);
			customizeMenuPage.clickConfigureSetHours(driver);
			customizeMenuPage.clickDeleteMenuTrash(driver);
			customizeMenuPage.clickYesDeleteMenu(driver);
			System.out.println("menu "+menuName+" deleted"); // obrisati
			driver.close();
		}
			
		
		

	}//close class
