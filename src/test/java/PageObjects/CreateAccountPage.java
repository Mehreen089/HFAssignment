package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage {

	WebDriver driver;
	WebDriverWait wait;
	
    By chkbx_mr = By.id("id_gender1");
    By chkbx_mrs = By.id("id_gender2");
    By txtbox_fname = By.id("customer_firstname");
    By txtbox_lname = By.id("customer_lastname");
    By txtbox_password = By.id("passwd");
    By dd_days = By.id("days");
    By dd_months = By.id("months");
    By dd_years = By.id("years");
    By txtbox_company = By.id("company");
    By txtbox_address1 = By.id("address1");
    By txtbox_address2 = By.id("address2");
    By txtbox_city = By.id("city");
    By dd_states = By.id("id_state");
    By txtbox_postcode = By.id("postcode");
    By txtbox_additionalInfo = By.id("other");
    By txtbox_homephone = By.id("phone");
    By txtbox_mobphone = By.id("phone_mobile");
    By txtbox_addressalias = By.id("alias");
    By btn_submit = By.id("submitAccount");
    
    public CreateAccountPage(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }

    public void check_Mr(){
    	
        wait.until(ExpectedConditions.visibilityOfElementLocated(chkbx_mr)).click();
        
    }
    
    public void set_FirstName(String fname){
    	
    	driver.findElement(txtbox_fname).sendKeys(fname);
        
    }
 
    public void set_LastName(String lname){
 	
 	driver.findElement(txtbox_lname).sendKeys(lname);
     
    }
 
    public void set_Password(String pass){
 	
 	driver.findElement(txtbox_password).sendKeys(pass);
     
    }
    
    public  void select_Day (String value) {
        Select drop = new Select(driver.findElement(dd_days));
        drop.selectByValue(value);  
    } 
    
    public  void select_Month (String value) {
        Select drop = new Select(driver.findElement(dd_months));
        drop.selectByValue(value);  
    } 
    
    public  void select_Year (String value) {
        Select drop = new Select(driver.findElement(dd_years));
        drop.selectByValue(value);  
    } 
    
    public void set_Company(String company){
     	
     	driver.findElement(txtbox_company).sendKeys(company);
         
        }
    
    public void set_Address1(String address1){
     	
     	driver.findElement(txtbox_address1).sendKeys(address1);
         
        }
    
    public void set_Address2(String address1){
     	
     	driver.findElement(txtbox_address2).sendKeys(address1);
         
        }
    
    public void set_City(String city){
     	
     	driver.findElement(txtbox_city).sendKeys(city);
         
        }
    
    public  void select_State (String text) {
        Select drop = new Select(driver.findElement(dd_states));
        drop.selectByVisibleText(text);  
    } 
    
    public void set_PostCode(String postcode){
     	
     	driver.findElement(txtbox_postcode).sendKeys(postcode);
         
        }
 
    public void set_AdditonalInfo(String info){
  	
  	driver.findElement(txtbox_additionalInfo).sendKeys(info);
      
     }
 
    public void set_HomePhone(String phone){
  	
  	driver.findElement(txtbox_homephone).sendKeys(phone);
      
     }
 
    public void set_MobPhone(String phone){
  	
  	driver.findElement(txtbox_mobphone).sendKeys(phone);
      
     }
 
    public void set_AddressAlias(String alias){
  	
  	driver.findElement(txtbox_addressalias).sendKeys(alias);
      
     }
    
    public void click_Submit(){
      	
      	driver.findElement(btn_submit).click();
          
       }
    
}

