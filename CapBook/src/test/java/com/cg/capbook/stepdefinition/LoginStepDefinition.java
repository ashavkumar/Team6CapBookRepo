package com.cg.capbook.stepdefinition;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import com.cg.capbook.pagebeans.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class LoginStepDefinition {
	WebDriver driver;
	LoginPage loginPage;
	@Given("^User is on the CapBook home page$")
	public void user_is_on_the_CapBook_home_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/frontPage");
		loginPage=PageFactory.initElements(driver, LoginPage.class);
	}
	@When("^User enters valid details$")
	public void user_enters_valid_details() throws Throwable {
		loginPage.setEmailId("keshav@gmail.com");
		loginPage.setPassword("Keshav123");
		loginPage.onClick();
	}
	@Then("^User is navigated to CapBook Profile Page$")
	public void user_is_navigated_to_CapBook_Profile_Page() throws Throwable {
		String actualTitle= driver.getTitle();
		String expectedTitle="CapBook";
		Assert.assertEquals(expectedTitle, actualTitle);
		driver.close();
	}
	@When("^User enters invalid email Id or User enters invalid password$")
	public void user_enters_invalid_email_Id_or_User_enters_invalid_password() throws Throwable {
		loginPage.setEmailId("kkw1@capgemini.com");
		loginPage.setPassword("keshav");
		loginPage.onClick();
	}
	@Then("^User is navigated to CapBook Home Page with an error message$")
	public void user_is_navigated_to_CapBook_Home_Page_with_an_error_message() throws Throwable {
		String actualTitle= driver.getTitle();
		String expectedTitle="CapBook";
		Assert.assertEquals(expectedTitle, actualTitle);
		driver.close();
	}
}