package com.cg.capbook.pagebeans;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class RegistrationPage {
	@FindBy(how=How.NAME, name="firstName")
	private WebElement firstName;
	@FindBy(how=How.NAME, name="lastName")
	private WebElement lastName;
	@FindBy(how=How.NAME, name="email")
	private WebElement emailId;
	@FindBy(how=How.NAME, name="gender")
	private WebElement gender;
	@FindBy(how=How.NAME, name="password")
	private WebElement password;
	@FindBy(how=How.NAME, name="cnfrmPassword")
	private WebElement confirmPassword;
	@FindBy(how=How.NAME, name="date")
	private WebElement dateOfBirth;
	@FindBy(how=How.NAME, name="Sign Up")
	private WebElement register;
	@FindBy(how=How.ID, id="successs")
	private WebElement successMessage;
	@FindBy(how=How.ID,id="male")
	private WebElement radioButton;
	@FindBy(how=How.NAME, name="securityAnswer")
	private WebElement securityAnswer;
	public RegistrationPage() {
		super();
	}
	public String getSecurityAnswer() {
		return securityAnswer.getAttribute("value");
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer.sendKeys(securityAnswer);
	}
	public RegistrationPage(WebElement firstName, WebElement lastName, WebElement emailId,
			WebElement gender, WebElement password, WebElement confirmPassword, WebElement dateOfBirth,
			WebElement register) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.gender = gender;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.dateOfBirth = dateOfBirth;
		this.register = register;
	}
	public  String getSuccessMessage() {
		return successMessage.getAttribute("value");
	}
	public String getFirstName() {
		return firstName.getAttribute("value");
	}
	public void setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}
	public String getLastName() {
		return lastName.getAttribute("value");
	}
	public void setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}
	public String getEmailId() {
		return emailId.getAttribute("value");
	}
	public void setEmailId(String emailId) {
		this.emailId.sendKeys(emailId);
	}
	public String getGender() {
		return gender.getAttribute("value");
	}
	public void setGender(String gender) {
		this.gender.sendKeys(gender);
	}
	public String getPassword() {
		return password.getAttribute("value");
	}
	public void setPassword(String password) {
		this.password.sendKeys(password);
	}
	public String getConfirmPassword() {
		return confirmPassword.getAttribute("value");
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword.sendKeys(confirmPassword);
	}
	public String getDateOfBirth() {
		return dateOfBirth.getAttribute("value");
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth.sendKeys(dateOfBirth);
	}
	public void onClick() {
		register.click();
	}
	public void onRadioClick() {
		radioButton.click();
	}
}