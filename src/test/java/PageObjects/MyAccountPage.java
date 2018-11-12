package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {
	
	 WebDriver driver;
	 WebDriverWait wait;
	
	 By lbl_heading = By.cssSelector("h1");
	 By btn_accountname = By.className("account");
	 By lbl_accountinfo = By.className("info-account");
	 By btn_SignOut = By.className("info-account");
	 By btn_women = By.linkText("Women");
	 
	 public MyAccountPage(WebDriver driver, WebDriverWait wait){

	        this.driver = driver;
	        this.wait = wait;
	    }

	    public String getHeaderText(){
	    	
	     return  wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_heading)).getText();
	        
	    }
	    
	    public String getAccountNameText(){
	    	
		     return driver.findElement(btn_accountname).getText();
		        
		    }
	    
	    public String getAccountInfoText(){
	    	
		     return driver.findElement(lbl_accountinfo).getText();
		        
		    }
	    
	    public Boolean isSignOutDisplayed(){
	    	
		     return driver.findElement(btn_SignOut).isDisplayed();
		        
		    }
	    
	    public void click_WomenTab(){
	    	
		      wait.until(ExpectedConditions.visibilityOfElementLocated(btn_women)).click();
		        
		    }
	    
	  
}
