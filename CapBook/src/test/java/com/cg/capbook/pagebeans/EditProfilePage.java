package com.cg.capbook.pagebeans;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class EditProfilePage {
	@FindBy(how=How.NAME, name="userBio")
	private WebElement aboutYou;
	@FindBy(how=How.NAME, name="currentCity")
	private WebElement currentCity;
	@FindBy(how=How.NAME, name="workPlace")
	private WebElement workPlace;
	@FindBy(how=How.NAME, name="highestEducation")
	private WebElement highestEducation;
	@FindBy(how=How.NAME, name="relationshipStatus")
	private WebElement relationshipStatus;
	@FindBy(how=How.NAME, name="saveChanges")
	private WebElement saveChanges;
	public EditProfilePage() {
		super();
	}
	public String getAboutYou() {
		return aboutYou.getAttribute("value");
	}
	public void setAboutYou(String aboutYou) {
		this.aboutYou.sendKeys(aboutYou);
	}
	public String getCurrentCity() {
		return currentCity.getAttribute("value");
	}
	public void setCurrentCity(String currentCity) {
		this.currentCity.sendKeys(currentCity);
	}
	public String getWorkPlace() {
		return workPlace.getAttribute("value");
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace.sendKeys(workPlace);
	}
	public String getHighestEducation() {
		return highestEducation.getAttribute("value");
	}
	public void setHighestEducation(String highestEducation) {
		this.highestEducation.sendKeys(highestEducation);
	}
	public String getRelationshipStatus() {
		return relationshipStatus.getAttribute("value");
	}
	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus.sendKeys(relationshipStatus);
	}
	public void onClick() {
		saveChanges.click();
	}
}