package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage {

	WebDriver driver;
	WebDriverWait wait;
	
    By lbl_authentication = By.id("authentication");
    By txtbox_Email = By.id("email_create");
    By btn_createAccount = By.id("SubmitCreate");
    By txtbox_emailsignin = By.id("email");
    By txtbox_passwordsignin = By.id("passwd");
    By btn_submitlogin = By.id("SubmitLogin");

    public AuthenticationPage(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }


    public void set_Email(String email){
    	
    	driver.findElement(txtbox_Email).sendKeys(email);
        
    }
    
    public void click_CreateAccount(){
    	
    	driver.findElement(btn_createAccount).click();
        
    }
    
    public void set_EmailSignin(String email){
    	
    	driver.findElement(txtbox_emailsignin).sendKeys(email);
        
    }

    public void set_PasswordSignin(String pass){
	
	driver.findElement(txtbox_passwordsignin).sendKeys(pass);
    }
    
    public void click_SubmitLogin(){
    	
    	driver.findElement(btn_submitlogin).click();
        
    }
	
}
