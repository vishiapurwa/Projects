package com.project.pagebeans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ConferenceBean {
	@FindBy(id="txtFirstName")
	private WebElement firstName;
	
	@FindBy(id="txtLastName")
	private WebElement lastName;
	
	@FindBy(id="txtEmail")
	private WebElement email;
	
	@FindBy(id="txtPhone")
	private WebElement contactNo;
	
	@FindBy(name = "size")
	private WebElement noOfPeopleAttending;
	
	@FindBy(id="txtAddress1")
	private WebElement address1;
	
	@FindBy(id="txtAddress2")
	private WebElement address2;
	
	@FindBy(name="city")
	private WebElement city;
	
	@FindBy(name="state")
	private WebElement state;
	
	@FindBy(xpath = "//input[@value='member']")
	private WebElement member;
	
	@FindBy(xpath = "//input[@value='non-member']")
	private WebElement non_member;
	
	@FindBy(linkText = "Next")
	private WebElement nextButton;

	public WebElement getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}

	public WebElement getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email.sendKeys(email);
	}

	public WebElement getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo.sendKeys(contactNo);
	}

	public boolean getNoOfPeopleAttending() {
		return noOfPeopleAttending.isSelected();
	}

	public void setNoOfPeopleAttending(int noOfPeopleAttending) {
		Select select=new Select(this.noOfPeopleAttending);
		select.selectByIndex(noOfPeopleAttending);
	}

	public WebElement getAddress1() {
		return address1;
	}

	public void setAddress1(String address) {
		this.address1.sendKeys(address);
	}
	
	public WebElement getAddress2() {
		return address2;
	}

	public void setAddress2(String address) {
		this.address2.sendKeys(address);
	}

	public WebElement getCity() {
		return city;
	}

	public void setCity(int index) {
		Select select=new Select(this.city); 
		select.selectByIndex(index);
	}

	public WebElement getState() {
		return state;
	}

	public void setState(int index) {
		Select select=new Select(this.state); 
		select.selectByIndex(index);
	}

	public boolean getMemberStatus() {
		return member.isSelected();
	}

	public void selectMember() {
		this.member.click();
	}

	public boolean getNonmemberStatus() {
		return non_member.isSelected();
	}

	public void selectNonmember() {
		this.non_member.click();
	}
	
	public void submit() {
		nextButton.click();
	}
	

}
