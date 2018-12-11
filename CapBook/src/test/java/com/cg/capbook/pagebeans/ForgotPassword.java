package com.cg.capbook.pagebeans;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class ForgotPassword {
	@FindBy(how=How.NAME, name="emailId")
	private WebElement emailId;
	@FindBy(how=How.NAME, name="securityAnswer")
	private WebElement securityAnswer;
	@FindBy(how=How.ID, id="retrievePassword")
	private WebElement retrievePassword;
	@FindBy(how=How.NAME, name="securityQuestion")
	private WebElement securityQuestion ;
	public String getSecurityQuestion() {
		return securityQuestion.getAttribute("value");
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion.sendKeys(securityQuestion);;
	}
	public ForgotPassword() {
		super();
	}
	public String getEmailId() {
		return emailId.getAttribute("value");
	}
	public void setEmailId(String emailId) {
		this.emailId.sendKeys(emailId);
	}
	public String getSecurityAnswer() {
		return securityAnswer.getAttribute("value");
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer.sendKeys(securityAnswer);
	}
	public void onClick() {
		retrievePassword.submit();
	}
}