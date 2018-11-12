package com.hellofresh.challenge;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Driver.DriverFactory;
import Driver.DriverType;
import PageObjects.AddtoCartPopupPage;
import PageObjects.AuthenticationPage;
import PageObjects.CreateAccountPage;
import PageObjects.DefaultHomePage;
import PageObjects.MyAccountPage;
import PageObjects.ProductPage;
import PageObjects.WomenProductsPage;
import PageObjects.ShopingCart.AddressPage;
import PageObjects.ShopingCart.PaymentPage;
import PageObjects.ShopingCart.ShippingPage;
import PageObjects.ShopingCart.SummaryPage;
import Utils.Common;

public class WebTest {

	WebDriver driver;
    WebDriverWait wait;
   
    DefaultHomePage obj_HomePage;
    AuthenticationPage obj_AuthPage;
    CreateAccountPage obj_createAccountPage;
    MyAccountPage obj_MyAccountPage;
    WomenProductsPage obj_WomenProductsPage;
    ProductPage obj_ProductPage;
    AddtoCartPopupPage obj_AddtoCartPopupPage;
    SummaryPage obj_SummaryPage;
    AddressPage obj_AddressPage;
    ShippingPage obj_ShippingPage;
    PaymentPage obj_PaymentPage;
    Common common;
    StrBuilder sb;
    
    @BeforeSuite
    public void beforeSuite()
    {
    	sb = new StrBuilder();
    	common = new Common();    
    	common.setConfigProp();
    }
    
    @BeforeMethod
    public void beforeMethod() {
      
    	driver = DriverFactory.getDriver(DriverType.CHROME);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15, 50);
        driver.get("http://automationpractice.com/index.php");
        
        obj_HomePage = new DefaultHomePage(driver,wait);
        obj_AuthPage = new AuthenticationPage(driver,wait);
        obj_createAccountPage = new CreateAccountPage(driver, wait);
        obj_MyAccountPage = new MyAccountPage(driver, wait);
        obj_WomenProductsPage = new WomenProductsPage(driver, wait);
        obj_ProductPage = new ProductPage(driver, wait);
        obj_AddtoCartPopupPage = new AddtoCartPopupPage(driver, wait);
        obj_SummaryPage = new SummaryPage(driver, wait);
        obj_AddressPage = new AddressPage(driver, wait);
        obj_ShippingPage = new ShippingPage(driver, wait);
        obj_PaymentPage = new PaymentPage(driver, wait);
       
    }

    @Test
    public void signInTest() throws IOException, AssertionError  {
    	int failure = 0;
    	try
    	{
    	sb.appendln(String.valueOf(new Date().getTime())+ ": Executing signInTest");
    	Faker faker = new Faker();
    	String fname = faker.name().firstName();
    	String lname = faker.name().lastName();
    	String fullname = fname + " " + lname;
    	obj_HomePage.click_SignIn();
    	
    	String email = lname+common.getRandomNumber(1, 100)+fname+"@hf.com";
    	obj_AuthPage.set_Email(email);
    	obj_AuthPage.click_CreateAccount();
    	
    	obj_createAccountPage.check_Mr();
    	
    	obj_createAccountPage.set_FirstName(fname);
    	obj_createAccountPage.set_LastName(lname);
    	obj_createAccountPage.set_Password("Password1234");
    	obj_createAccountPage.select_Day(Integer.toString(common.getRandomNumber(1, 31)));
    	obj_createAccountPage.select_Month(Integer.toString(common.getRandomNumber(1, 12)));
    	obj_createAccountPage.select_Year(Integer.toString(common.getRandomNumber(1900, 2018)));
    	obj_createAccountPage.set_Company(faker.company().name());
    	obj_createAccountPage.set_Address1(faker.address().streetAddress() + "," + faker.address().zipCode());
    	obj_createAccountPage.set_Address2(faker.address().buildingNumber());
    	obj_createAccountPage.set_City(faker.address().city());
    	obj_createAccountPage.select_State(common.getRandomState());
    	obj_createAccountPage.set_PostCode(common.getRandomString(5));
    	obj_createAccountPage.set_AdditonalInfo("Nothing");
    	obj_createAccountPage.set_HomePhone(common.getRandomString(9));
    	obj_createAccountPage.set_MobPhone(common.getRandomString(9));
    	obj_createAccountPage.set_AddressAlias(faker.address().cityPrefix());
    	obj_createAccountPage.click_Submit();

        assertEquals(obj_MyAccountPage.getHeaderText(), "MY ACCOUNT");
    	assertEquals(obj_MyAccountPage.getAccountNameText(), fullname);
        assertTrue(obj_MyAccountPage.getAccountInfoText().contains("Welcome to your account."));
        assertTrue(obj_MyAccountPage.isSignOutDisplayed());
        assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
    	}
    	catch (AssertionError | Exception ex)
    	{
    		failure++;
    		sb.appendln(String.valueOf(new Date().getTime())+ ": Encountered Exception: " + ex);
    		String scrrenshotName = "signInTest" + new Date().getTime() + ".png";
    		sb.appendln(String.valueOf(new Date().getTime())+ ": see screenshot " + scrrenshotName);
    		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	    FileUtils.copyFile(screenshotFile, new File("src/test/resources/ScreenShots/"+scrrenshotName));
    	}
    	if(failure > 0)
    	{
    		Assert.fail();
    	}
    }

    @Test
    public void logInTest() throws IOException {
    	
    	int failure = 0;
    	try
    	{
    	sb.appendln(String.valueOf(new Date().getTime())+ ": Executing logInTest");
        String fullName = "Joe Black";
        
        obj_HomePage.click_SignIn();
        
        SignIn(common.getConfigProp().getProperty("existingUserEmail"),common.getConfigProp().getProperty("existingUserPassword"));
        
        assertEquals(obj_MyAccountPage.getHeaderText(), "MY ACCOUNT");
        assertEquals(obj_MyAccountPage.getAccountNameText(), fullName);
        assertTrue(obj_MyAccountPage.getAccountInfoText().contains("Welcome to your account."));
        assertTrue(obj_MyAccountPage.isSignOutDisplayed());
        assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
    	}
    	catch (AssertionError | Exception ex)
    	{
    		failure++;
    		sb.appendln(String.valueOf(new Date().getTime())+ ": Encountered Exception: " + ex);
    		String scrrenshotName = "signInTest" + new Date().getTime() + ".png";
    		sb.appendln(String.valueOf(new Date().getTime())+ ": see screenshot " + scrrenshotName);
    		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	    FileUtils.copyFile(screenshotFile, new File("src/test/resources/ScreenShots/"+scrrenshotName));
    	}
    	if(failure > 0)
    	{
    		Assert.fail();
    	}

    }

    @Test
    public void checkoutTest() throws IOException {
    	
    	int failure = 0;
    	try
    	{
    	
        obj_HomePage.click_SignIn();
      
        SignIn(common.getConfigProp().getProperty("existingUserEmail"),common.getConfigProp().getProperty("existingUserPassword"));
        
        
        obj_MyAccountPage.click_WomenTab();
        obj_WomenProductsPage.click_ShortFadedSleve();
        obj_WomenProductsPage.click_ShortFadedSleve();
        obj_ProductPage.click_AddToCart();
        
        obj_AddtoCartPopupPage.click_ProceedToCheckout();
        
        obj_SummaryPage.click_ProceedToCheckout();
        
        obj_AddressPage.click_ProceedToCheckout();
        
        obj_ShippingPage.click_CheckTerms();
        obj_ShippingPage.click_ProceedToCheckout();

        obj_PaymentPage.click_BankWire();
        obj_PaymentPage.click_ConfirmOrder();
        
        assertEquals("ORDER CONFIRMATION", obj_MyAccountPage.getHeaderText());

        assertTrue(obj_PaymentPage.isLastStepDisplayed());
        assertTrue(obj_PaymentPage.getOrderInfoText().contains("Your order on My Store is complete."));
        assertTrue(driver.getCurrentUrl().contains("controller=order-confirmation"));
    }
	catch (AssertionError | Exception ex)
	{
		failure++;
		sb.appendln(String.valueOf(new Date().getTime())+ ": Encountered Exception: " + ex);
		String scrrenshotName = "signInTest" + new Date().getTime() + ".png";
		sb.appendln(String.valueOf(new Date().getTime())+ ": see screenshot " + scrrenshotName);
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshotFile, new File("src/test/resources/ScreenShots/"+scrrenshotName));
	}
	if(failure > 0)
	{
		Assert.fail();
	}
    }
    
    // Signin function
    void SignIn(String username, String Password)
    {
    	obj_AuthPage.set_EmailSignin(username);
        obj_AuthPage.set_PasswordSignin(Password);
        obj_AuthPage.click_SubmitLogin();
    }

    @AfterMethod
    public void afterMethod()
    {
    	sb.appendln(String.valueOf(new Date().getTime())+ ": Test ended ");
    	driver.quit();
    }
    
    @AfterSuite
    public void afterSuite()
    {
    	try
    	{
    	    String filename= "src/test/resources/Log.txt";
    	    FileWriter fw = new FileWriter(filename,true); 
    	    fw.write(sb.toString());
    	    fw.close();
    	}
    	catch(IOException ioe)
    	{
    	    System.err.println("IOException: " + ioe.getMessage());
    	}
    }
   
}
