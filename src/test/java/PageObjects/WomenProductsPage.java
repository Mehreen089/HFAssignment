package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WomenProductsPage {
	 WebDriver driver;
	 WebDriverWait wait;
 
	 By link_ShortFadedSleve = By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li");
	 
	 public WomenProductsPage(WebDriver driver, WebDriverWait wait){

	        this.driver = driver;
	        this.wait = wait;
	    }

	  public void click_ShortFadedSleve(){
	    	
	    driver.findElement(link_ShortFadedSleve).click();
	        
	    }
}
