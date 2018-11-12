package PageObjects.ShopingCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage {
	 WebDriver driver;
	 WebDriverWait wait;

	 By btn_checkout = By.name("processAddress");
	 
	 public AddressPage(WebDriver driver, WebDriverWait wait){

	        this.driver = driver;
	        this.wait = wait;
	    }

	  public void click_ProceedToCheckout(){
	    	
	      wait.until(ExpectedConditions.elementToBeClickable(btn_checkout)).click();;
	        
	    }
}
