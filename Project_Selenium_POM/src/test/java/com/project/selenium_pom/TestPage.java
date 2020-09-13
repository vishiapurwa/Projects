package com.project.selenium_pom;

import static org.testng.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPage extends FunctionalTest {
	
	@Test
	public void a_search() {
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		SearchPage searchPage=new SearchPage(driver);
		assertTrue(searchPage.isInitialized());
		searchPage.searchLink("gmail");
		LinkPage linkPage=searchPage.clickOnSearch();
		assertTrue(linkPage.isInitialized());
	}
	
	@Test
	public void b_linkPage() {
		LinkPage linkPage=new LinkPage(driver);
		assertTrue(linkPage.isInitialized());
		GmailPage gmailPage=linkPage.clickOnLink();
		assertTrue(gmailPage.isInitialized());
		
	}
	
	@Test
	public void c_gmailPage() {
		GmailPage gmailPage=new GmailPage(driver);
		assertTrue(gmailPage.isInitialized());
		SignInPage signInPage = gmailPage.clickOnSignInButton();
		assertTrue(gmailPage.switchToNewWindow() == true);
		assertTrue(signInPage.isInitialized());

	}

	@Test
	public void d_signInPage() {
		SignInPage signInPage = new SignInPage(driver);
		assertTrue(signInPage.isInitialized());
		signInPage.sendEmail("vishiapurwa");
		
	}
	 
	

}
