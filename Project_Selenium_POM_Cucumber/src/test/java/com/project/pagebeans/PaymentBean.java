package com.project.pagebeans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentBean {
	
	@FindBy(id = "txtFirstName")
	private WebElement firstName;

	@FindBy(id="txtLastName")
	private WebElement lastName;
	
	@FindBy(id="txtDebit")
	private WebElement cardNumber;
	
	@FindBy(id="txtCvv")
	private WebElement cvv;
	
	@FindBy(id="txtMonth")
	private WebElement expirationMonth;
	
	@FindBy(id="txtYear")
	private WebElement expirationYear;
	
	@FindBy(xpath = "//input[@type='button']")
	private WebElement register;

	public WebElement getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}

	public WebElement getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}

	public WebElement getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber.sendKeys(cardNumber);
	}

	public WebElement getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv.sendKeys(cvv);
	}

	public WebElement getExpirationMonth() {
		return expirationMonth;
	}

	public void setExpirationMonth(String expirationMonth) {
		this.expirationMonth.sendKeys(expirationMonth);
	}

	public WebElement getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(String expirationYear) {
		this.expirationYear.sendKeys(expirationYear);
	}

	public void submit() {
		this.register.click();
	}
	
	
}
