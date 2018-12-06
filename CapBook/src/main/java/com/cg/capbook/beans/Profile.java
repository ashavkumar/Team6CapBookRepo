package com.cg.capbook.beans;
import java.util.Arrays;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
@Entity
public class Profile {
	@Id
	private String  emailId;
	private String password;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String homeTown;
	private String dateOfJoining;
	private String mobileNo;
	//private Image profilePic;
	@Column(columnDefinition="BLOB")
	private byte[] profilePic;
	private String userBio;
	private String currentCity;
	private String designation;
	private String highestEducation;
	private String relationshipStatus;
	@OneToMany
	@MapKey
	private Map<Integer, Friend> friend;
	@ManyToMany
	@MapKey
	private Map<Integer, Page> pages;
	@OneToMany
	@MapKey
	private Map<Integer, Post> posts;
	//private Map<String,Profile>friends;
	//private List<Profile> friends;
	/*	@MapKey
	@OneToMany
	private Map<String, Profile> friends;*/
	public Profile() {
		super();
	}
	public Profile(String emailId, String password, String firstName, String lastName, String dateOfBirth,
			String gender, String homeTown, String dateOfJoining, String mobileNo, byte[] profilePic, String userBio,
			String currentCity, String designation, String highestEducation, String relationshipStatus,
			Map<Integer, Friend> friend, Map<Integer, Page> pages, Map<Integer, Post> posts) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.homeTown = homeTown;
		this.dateOfJoining = dateOfJoining;
		this.mobileNo = mobileNo;
		this.profilePic = profilePic;
		this.userBio = userBio;
		this.currentCity = currentCity;
		this.designation = designation;
		this.highestEducation = highestEducation;
		this.relationshipStatus = relationshipStatus;
		this.friend = friend;
		this.pages = pages;
		this.posts = posts;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public byte[] getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(byte[] profilePic) {
		this.profilePic = profilePic;
	}
	public String getUserBio() {
		return userBio;
	}
	public void setUserBio(String userBio) {
		this.userBio = userBio;
	}
	public String getCurrentCity() {
		return currentCity;
	}
	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getHighestEducation() {
		return highestEducation;
	}
	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
	}
	public String getRelationshipStatus() {
		return relationshipStatus;
	}
	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}
	public Map<Integer, Friend> getFriend() {
		return friend;
	}
	public void setFriend(Map<Integer, Friend> friend) {
		this.friend = friend;
	}
	public Map<Integer, Page> getPages() {
		return pages;
	}
	public void setPages(Map<Integer, Page> pages) {
		this.pages = pages;
	}
	public Map<Integer, Post> getPosts() {
		return posts;
	}
	public void setPosts(Map<Integer, Post> posts) {
		this.posts = posts;
	}
	@Override
	public String toString() {
		return "Profile [emailId=" + emailId + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", homeTown=" + homeTown
				+ ", dateOfJoining=" + dateOfJoining + ", mobileNo=" + mobileNo + ", profilePic="
				+ Arrays.toString(profilePic) + ", userBio=" + userBio + ", currentCity=" + currentCity
				+ ", designation=" + designation + ", highestEducation=" + highestEducation + ", relationshipStatus="
				+ relationshipStatus + "]";
	}
	
}
