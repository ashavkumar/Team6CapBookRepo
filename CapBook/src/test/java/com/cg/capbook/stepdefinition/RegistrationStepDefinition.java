package com.cg.capbook.stepdefinition;

import java.sql.Driver;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.capbook.pagebeans.RegistrationPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationStepDefinition {
	RegistrationPage registrationPage;
	WebDriver driver;
	 
	
	@Given("^User is on the Capbook 'homePage'$")
	public void user_is_on_the_Capbook_homePage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("http://localhost:4200/frontPage");
	    registrationPage=PageFactory.initElements(driver, RegistrationPage.class);
	}

	@When("^User enters all valid details$")
	public void user_enters_all_valid_details() throws Throwable {
		registrationPage.setFirstName("keshav");
		registrationPage.setLastName("Agarwal");
		registrationPage.setEmailId("keshav@capgemini.com");
		registrationPage.setPassword("keshav123");
		registrationPage.setConfirmPassword("keshav123");
		registrationPage.onClick();
	}

	@Then("^User is directed to 'profilePage'$")
	public void user_is_directed_to_profilePage() throws Throwable {
		 String actualAlertMessage= registrationPage.getSuccessMessage();
	        String expectedAlertMessage= "User successfully registered!!";
	        Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
	        driver.close();
	  
	}

	@When("^User does not enters firstName$")
	public void user_does_not_enters_firstName() throws Throwable {
	
	}

	@Then("^User is directed to 'homePage' with enter 'firstName' Error$")
	public void user_is_directed_to_homePage_with_enter_firstName_Error() throws Throwable {

	}
	    

	@When("^User does not enters lastName$")
	public void user_does_not_enters_lastName() throws Throwable {
	 
	}

	@Then("^User is directed to 'homePage' with enter 'lastName' Error$")
	public void user_is_directed_to_homePage_with_enter_lastName_Error() throws Throwable {
	    
	}

	@When("^User does not enters valid emailId$")
	public void user_does_not_enters_valid_emailId() throws Throwable {
	  
	}

	@Then("^User is directed to 'homePage' with  'valid emailId' Error$")
	public void user_is_directed_to_homePage_with_valid_emailId_Error() throws Throwable {
	 
	}

	@When("^User does not enters valid password$")
	public void user_does_not_enters_valid_password() throws Throwable {
	  
	}

	@Then("^User is directed to 'homePage' with  'valid password' Error$")
	public void user_is_directed_to_homePage_with_valid_password_Error() throws Throwable {
	
	}

	@When("^User password does not match$")
	public void user_password_does_not_match() throws Throwable {
	    
	}

	@Then("^User is directed to 'homePage' with 'mismatch password' Error$")
	public void user_is_directed_to_homePage_with_mismatch_password_Error() throws Throwable {
	
	}

	@When("^User does not enters dateOfBirth$")
	public void user_does_not_enters_dateOfBirth() throws Throwable {
	  
	}

	@Then("^User is directed to 'homePage' with enter 'dateOfBirth' Error$")
	public void user_is_directed_to_homePage_with_enter_dateOfBirth_Error() throws Throwable {
	    
	}


}
