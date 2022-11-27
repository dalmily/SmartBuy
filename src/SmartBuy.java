import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SmartBuy {
	
	
	public WebDriver driver ;
	public int numberOfTry = 1000;
	SoftAssert softassert = new SoftAssert();
	
	
		@BeforeTest()
	
	public void this_is_before_test() {
		
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://smartbuy-me.com/smartbuystore/");
		
		driver.findElement(By.xpath("/html/body/main/header/div[2]/div/div[2]/a")).click();
		driver.manage().window().maximize();
		
		
	}
	
		
	@Test()
		
		public void Test_adding_items_SAMSUNG_50_inch () throws InterruptedException {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Thread.sleep(3000);
			
	
		
			for (int i = 0 ; i <numberOfTry ; i++) {
			
				
			
				
				driver.findElement(By.xpath("//*[@id=\"newtab-Featured\"]/div/div[1]/div/div/div/div[2]/div/div[3]/div[1]/div/div/form[1]/div[1]/button")).click();
				
				
				
				String msg = driver.findElement(By.xpath("//*[@id=\"addToCartLayer\"]/div[1]")).getText();
				
				
				if (msg.contains("Sorry"))
						
						{
					numberOfTry=i;
					driver.findElement(By.xpath("//*[@id=\"addToCartLayer\"]/a[1]")).click();
						}
				else 
				{
					
					driver.findElement(By.xpath("//*[@id=\"addToCartLayer\"]/a[2]")).click();
					
				}
				
					
			}
			
		
			
			
			
			
		}
		
		@Test()
		
		
		public void check_the_correct_price() {
			
			driver.navigate().back();
			
		String the_single_item_price = driver.findElement(By.xpath("//*[@id=\"newtab-Featured\"]/div/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div/div/span[3]")).getText();
			
		String [] the_updated_single_item_price = the_single_item_price.split("JOD");
		
		String the_final_single_item_price = the_updated_single_item_price[0].trim();
		
		
			
		String updated = the_final_single_item_price.replace(",", ".");
		
	 Double final_price = Double.parseDouble(updated);
	 
	 System.out.println(final_price );
	 System.out.println(final_price*numberOfTry );

	//softassert.assertEquals(final_price* numberOfTry, 4.347);
	
	softassert.assertAll();
	
	
	
}
		}
		
		
		

		


