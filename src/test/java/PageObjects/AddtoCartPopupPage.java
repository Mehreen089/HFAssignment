package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtoCartPopupPage {

	 WebDriver driver;
	 WebDriverWait wait;

	 By btn_checkout = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span");
	 
	 public AddtoCartPopupPage(WebDriver driver, WebDriverWait wait){

	        this.driver = driver;
	        this.wait = wait;
	    }

	  public void click_ProceedToCheckout(){
	    	
	      wait.until(ExpectedConditions.elementToBeClickable(btn_checkout)).click();
	        
	    }
}
