import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTML {

	public WebDriver driver;
	
	@BeforeTest

	public void login() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
		
	}
	@Test

	public void sort_item_low_to_high() throws InterruptedException

	{
		
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]")).click();
		
		List <WebElement> thePriceList = driver.findElements(By.className("inventory_item_price"));
		
	   List <Double> newEditedList = new ArrayList<>();
		
		for (int i = 0 ; i < thePriceList.size() ; i++) {
			
			String price = thePriceList.get(i).getText();
			
			
		    String editedPrice = price.replace("$", " ");
		    
			
			
			double val = Double.parseDouble(editedPrice.trim());
			
			newEditedList.add(val);
			
		    
			
		}
		
		for (int k= 0; k < newEditedList.size() ; k++) {
			
			boolean checkProcess = newEditedList.get(0) < newEditedList.get(newEditedList.size()-1);
		Assert.assertEquals(checkProcess, false);
			
			
		}
		
		
		
		
	}
	


		

	@Test

	public void sort_item_high_to_low() throws InterruptedException

	{

		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")).click();
		
		List <WebElement> thePriceList = driver.findElements(By.className("inventory_item_price"));
		
	   List <Double> newEditedList = new ArrayList<>();
		
		for (int i = thePriceList.size()-1 ; i >= 0 ; i--) {
			
			String price = thePriceList.get(i).getText();
			
			
		    String editedPrice = price.replace("$", " ");
		    
			
			
			double val = Double.parseDouble(editedPrice.trim());
			
			newEditedList.add(val);
			
		    
			
		}
		
		
	
		
		for (int k= 0; k > newEditedList.size() ; k++) {
			
			boolean checkProcess = newEditedList.get(0) < newEditedList.get(newEditedList.size()-1);
		Assert.assertEquals(checkProcess, true);
			
			
	}
		
		
	}


}
