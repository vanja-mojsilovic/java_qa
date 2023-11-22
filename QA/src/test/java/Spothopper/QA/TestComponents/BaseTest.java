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


import org.testng.annotations.Parameters;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Spothopper.QA.PageObjects.OrdersSettingsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public OrdersSettingsPage ordersSettingsPage;
	public int dataProviderCounter;
	public int currentCounter;
	public String email = "vanja.mojsilovic@spothopperapp.com";
	public String ordersSettingsURL = "https://staging.spotapps.co/admin/spots/5910/order_inquiries/settings?login_token=88a6e5e5d9c04c4381a430052b8cb430" ;
	public String menusURL = "https://staging.spotapps.co/admin/spots/5910/food_menus?login_token=88a6e5e5d9c04c4381a430052b8cb430" ;
	
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
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public int getDataProviderCounter() {
		return dataProviderCounter;
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
	
	
	
	@BeforeMethod
	public OrdersSettingsPage launchApplication() throws IOException
	{	
		//treba podesiti da se ova metoda pokreće samo kod određenih testova, ne kod svih
		driver = initializeDriver();
		ordersSettingsPage = new OrdersSettingsPage(driver);
		//ordersSettingsPage.goTo(ordersSettingsURL);
		return ordersSettingsPage;
	}
	
	
	
	
	@DataProvider
	public Object[][]  getData() throws IOException {
		
		System.out.println("getting data from json_"+getCurrentCounter());
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Spothopper\\QA\\data\\csvjson.json");
		return new Object[][] {{data.get(dataProviderCounter*2)},{data.get(dataProviderCounter*2+1)}};
	}
	
	@AfterMethod
	public void closeWindow() {
		
		//System.out.println("Closing page_"+getCurrentCounter()+"!");
		//driver.close();
		
	}
	
	
	
}
