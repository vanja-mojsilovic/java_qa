package Spothopper.QA.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.testng.annotations.Parameters;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Spothopper.QA.PageObjects.OrdersSettingsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class BaseTest {
	
	public WebDriver driver;
	public OrdersSettingsPage ordersSettingsPage;
	public int dataProviderCounter;
	public int currentCounter = 0;
	public String email = "vanja.mojsilovic@spothopperapp.com";
	public String spotID = "5910";
	public String loginToken = "88a6e5e5d9c04c4381a430052b8cb430";
	public String stagingDomain = "https://staging.spotapps.co/admin/spots/";
	public String stagingTMTDomain = "https://tmt-front-staging.spotapps.co/";
	public String menuName = "Dinner";
	public String menuItemName_1 = "Chicken Soup";
	public String menuItemPrice_1 = "0.00";
	public String menuItemName_2 = "Beef Soup";
	public String menuItemPrice_2 = "0.00";
	public String menuNumberString = "0"; // ovo upotrebljavamo kod brisanja menija
	public String customersFirstName = "Vanja";
	public String customersLastName = "Mojsilovic";
	public String customersPhoneNumber = "0141112222";
	public String customersEmail = "vanja.mojsilovic@spothopperapp.com";
	public String creditCardNumber = "4242424242424242";
	public String expiryDate = "04/24";
	public String cvcNumber = "242";
	public String postalCode = "42424";
	
	
	public String ordersSettingsURL = stagingDomain+spotID+"/order_inquiries/settings?login_token="+loginToken;
	public String menusURL = stagingDomain+spotID+"/food_menus_landing?login_token="+loginToken;
	public String hoursURL = stagingDomain+spotID+"/hours?login_token="+loginToken;
	public String addNewMenusURL = stagingDomain+spotID+"/food_menus#/new?menu_type=food&login_token="+loginToken;
	public String orderingMenuPopupTMT = stagingTMTDomain+"ordering-menu"+"/?spot_id="+spotID+"&accordion=true&images=yes&login_token="+loginToken;
	public String deleteMenuURL = stagingDomain+spotID+"/food_menus#/"+menuNumberString+"?login_token="+loginToken;
	
	
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Spothopper\\QA\\Resourses\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome") ) {
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			//Firefox
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		return driver;
	}
	
	
	public int setDataProviderCounter(String num) {
		dataProviderCounter = Integer.parseInt(num);
		System.out.println("dataProviderCounter is: " + dataProviderCounter);
		return dataProviderCounter;
	}
	
	public int getCurrentCounter() {
		return currentCounter;
	}
	
	public int increaseCurrentCounter()
	{
		currentCounter++;
		return currentCounter;
	}
	
	
	public List<HashMap<String,String>> getJsonDataToMap(String filePath) throws IOException
	{
		 String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		 ObjectMapper mapper = new ObjectMapper();	
		 List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){ 
		 });
		 return data;
	}
	
	
    public String getStringLocalDateTime() {
    	LocalDateTime curentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd HH mm ss");
        String formattedDateTime = curentTime.format(formatter);
        return formattedDateTime;
    }
    
    public String getDayOfTheWeek() {
    	 LocalDateTime now = LocalDateTime.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE");
         String day = now.format(formatter);
         return day;
    }
	    
	public void setMenuName(String insertedMenuName) {
	    	menuName = insertedMenuName;
	}

	public void setMenuItemName_1(String insertedMenuItemString) {
    	menuItemName_1 = insertedMenuItemString;
	}
	
	public void setMenuItemName_2(String insertedMenuItemName) {
    	menuItemName_2 = insertedMenuItemName;
	}
	
	public void setMenuItemPrice_1(String insertedMenuItemPrice) {
    	menuItemPrice_1 = insertedMenuItemPrice;
	}
	
	public void setMenuItemPrice_2(String insertedMenuItemPrice) {
    	menuItemPrice_2 = insertedMenuItemPrice;
	}
	
	
	public void setMenuNumberString(String insertedMenuNum) {
    	menuNumberString = insertedMenuNum;
	}
	
	public String countSubtotal(String str1, String str2) {
        double num1 = Double.parseDouble(str1);
        double num2 = Double.parseDouble(str2);
        double result = num1 + num2;
        String sum = String.format("%.2f", result);
        return sum;
    }
	
	
	@BeforeMethod
	public void launchApplication() throws IOException
	{	
		driver = initializeDriver();
	}
	
	
	@DataProvider
	public Object[][]  getData() throws IOException {
		
		System.out.println("getting data from json_"+getCurrentCounter());
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Spothopper\\QA\\data\\csvjson.json");
		return new Object[][] {
			{data.get(0)},
			{data.get(3)}
		};
	}
	
	@AfterMethod
	public void closeWindow() {
		
		//System.out.println("Closing page_"+getCurrentCounter()+"!");
		//driver.close();
		
	}
	
	
	
}
