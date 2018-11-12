package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

	 WebDriver driver;
	 WebDriverWait wait;

	 By btn_addtocart = By.name("Submit");
	 By txt_Quantity = By.id("quantity_wanted");
	 public ProductPage(WebDriver driver, WebDriverWait wait){

	        this.driver = driver;
	        this.wait = wait;
	    }

	  public void click_AddToCart(){
	    	
	      wait.until(ExpectedConditions.visibilityOfElementLocated(btn_addtocart)).click();
	        
	    }
	  
	  
	  public void set_Quantity(){
	    	
	      wait.until(ExpectedConditions.visibilityOfElementLocated(txt_Quantity)).sendKeys("2");
	        
	    }
}
