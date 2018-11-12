package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DefaultHomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
    By btn_signin = By.className("login");


    public DefaultHomePage(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }


    public void click_SignIn(){
    	
        wait.until(ExpectedConditions.elementToBeClickable(btn_signin)).click();
        
    }
    

}
