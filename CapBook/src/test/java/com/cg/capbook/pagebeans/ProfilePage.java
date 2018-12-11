package com.cg.capbook.pagebeans;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class ProfilePage {
	@FindBy(how=How.ID, id="accountSettingss")
	private WebElement accountSetting;
	@FindBy(how=How.ID, id="changePassword")
	private WebElement changePassword;
	@FindBy(how=How.NAME, name="currentPassword")
	private WebElement currentPassword;
	@FindBy(how=How.NAME, name="newPassword")
	private WebElement newPassword;
	@FindBy(how=How.NAME, name="retypeNewPassword")
	private WebElement retypeNewPassword;
	@FindBy(how=How.NAME, name="saveChanges")
	private WebElement saveChanges;
	@FindBy(how=How.ID, id="editProfile")
	private WebElement editProfile;
	public ProfilePage() {
		super();
	}
	public ProfilePage(WebElement accountSetting, WebElement changePassword, WebElement currentPassword,
			WebElement newPassword, WebElement retypeNewPassword, WebElement saveChanges) {
		super();
		this.accountSetting = accountSetting;
		this.changePassword = changePassword;
		this.currentPassword = currentPassword;
		this.newPassword = newPassword;
		this.retypeNewPassword = retypeNewPassword;
		this.saveChanges = saveChanges;
	}
	public String getCurrentPassword() {
		return currentPassword.getAttribute("value");
	}
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword.sendKeys(currentPassword);;
	}
	public String getNewPassword() {
		return newPassword.getAttribute("value");
	}
	public void setNewPassword(String newPassword) {
		this.newPassword.sendKeys(newPassword);;
	}
	public String getRetypeNewPassword() {
		return retypeNewPassword.getAttribute("value");
	}
	public void setRetypeNewPassword(String retypeNewPassword) {
		this.retypeNewPassword.sendKeys(retypeNewPassword);
	}
	public void onClick() {
		saveChanges.click();
	}
	public void onClick1() {
		editProfile.click();
	}
	public void onClickAccountSetting() {
		accountSetting.submit();
	}
	public void onClickChangePassword() {
		changePassword.click();
	}
}