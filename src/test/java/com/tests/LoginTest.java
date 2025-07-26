package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.de.test.BaseDeTest;

public class LoginTest extends BaseDeTest {

	@Test(priority = 1)
	public void failedLoginTest() {
		loginPage.enterUsername(configReader.remplirUserName("usernameinvalid"));
		loginPage.enterPassword(configReader.remplirPassword("passwordinvalid"));
		loginPage.clickbuttonLogin();
		loginPage.waitforerrormsg(configReader.getmsg("errormsgLogin"));

		Assert.assertTrue(eleutill.isDisplayed(loginPage.errorMessage), "Error message not displayed!");
	}

	@Test(priority = 2)
	public void successfulLoginTest() {
		loginPage.enterUsername(configReader.remplirUserName("usernamevalid"));
		loginPage.enterPassword(configReader.remplirPassword("passwordvalid"));
		loginPage.clickbuttonLogin();
		loginPage.waitforvalidmsg(configReader.getmsg("validmsgLogin"));

		Assert.assertTrue(eleutill.isDisplayed(loginPage.validMessage), "Products page not displayed!");
	}

}
