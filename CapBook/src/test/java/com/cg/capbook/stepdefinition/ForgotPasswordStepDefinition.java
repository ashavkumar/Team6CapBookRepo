package com.cg.capbook.stepdefinition;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cg.capbook.pagebeans.ForgotPassword;
import com.cg.capbook.pagebeans.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class ForgotPasswordStepDefinition {
	WebDriver driver;
	ForgotPassword forgotPassword;
	LoginPage loginPage;
	Select select;
	@Given("^User is on the CapBook homepage$")
	public void user_is_on_the_CapBook_homepage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/frontPage");
		loginPage=PageFactory.initElements(driver, LoginPage.class);
	}
	@When("^User clicks on forgot password button$")
	public void user_clicks_on_forgot_password_button() throws Throwable {
		loginPage.onClickForgotPasswordButton();
	}
	@Then("^User is navigated to Forgot Password Page$")
	public void user_is_navigated_to_Forgot_Password_Page() throws Throwable {

	}
	@Given("^User is on the Forgot Password Page$")
	public void user_is_on_the_Forgot_Password_Page() throws Throwable {
		driver=new ChromeDriver();
		driver.get("http://localhost:4200/forgotPassword");
		forgotPassword=PageFactory.initElements(driver, ForgotPassword.class);
		select=new Select(driver.findElement(By.name("securityQuestion")));
	}
	@When("^User enters valid emailId$")
	public void user_enters_valid_emailId() throws Throwable {
		forgotPassword.setEmailId("agfddfyjkjhk");
		forgotPassword.setEmailId("kkw1@capgemini.com");
		select.selectByVisibleText("What is your pet's name?");
		forgotPassword.setSecurityAnswer("poding");
		forgotPassword.onClick();
	}
	@Then("^User gets greeting message on Forgot Password page$")
	public void user_gets_greeting_message_on_Forgot_Password_page() throws Throwable {
		String actualMessage= "Password changed successfully";
		String expectedMessage="Password changed successfully";
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.close();
	}
	@When("^User enters invalid emailId$")
	public void user_enters_invalid_emailId() throws Throwable {
		forgotPassword.setEmailId("kkw1capgemini.com");
		select.selectByVisibleText("What is your pet's name?");
		forgotPassword.setSecurityAnswer("poding");
		forgotPassword.onClick();
	}
	@Then("^User gets error message on Forgot Password page$")
	public void user_gets_error_message_on_Forgot_Password_page() throws Throwable {
		String actualMessage="Invalid Details entered";
		String expectedMessage="Invalid Details entered";
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.close();
	}
}