package PageObjects.ShopingCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
	WebDriver driver;
	 WebDriverWait wait;

	 By btn_bankwire = By.className("bankwire");
	 By btn_cnfrmOrder = By.xpath("//*[@id=\"cart_navigation\"]/button/span");
	 By lbl_orderinfo = By.xpath("//*[@id=\"center_column\"]/div/p/strong");
	 By btn_Payment = By.id("step_end");
	 public PaymentPage(WebDriver driver, WebDriverWait wait){

	        this.driver = driver;
	        this.wait = wait;
	    }

	  public void click_BankWire(){
	    	
	      wait.until(ExpectedConditions.elementToBeClickable(btn_bankwire)).click();;
	        
	    }

	  public void click_ConfirmOrder(){
	    	
	      wait.until(ExpectedConditions.elementToBeClickable(btn_cnfrmOrder)).click();;
	        
	    }
	  
	  public String getOrderInfoText(){
	    	
		     return driver.findElement(lbl_orderinfo).getText();
		        
		    }
	    
	  public Boolean isLastStepDisplayed(){
	    	
		     return driver.findElement(btn_Payment).isDisplayed();
		        
		    }
	  
}
