/**
 * Copyright (c) 2025 Rahma Brahem
 * 
 * Licensed under the MIT License.
 * See the LICENSE file in the project root for license information.
 */
package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.elements.ElementUtils;
import com.utils.wait.WaitUtils;

public class LoginPage {

	WebDriver driver;
	ElementUtils eleutil;
	WaitUtils waitUtils;

	private By usernameField = By.id("user-name");
	final By passwordField = By.id("password");
	private By loginButton = By.id("login-button");
	public By errorMessage = By.xpath("//*[contains(text(),'Epic sadface: Username and password')]");
	public By validMessage = By.xpath("//*[text()='Products']");

	public LoginPage(WebDriver tdriver) {
		this.driver = tdriver;
		this.eleutil = new ElementUtils(driver);
		this.waitUtils = new WaitUtils(driver);
	}

	public void enterUsername(String username) {
		waitUtils.visibilityOf(usernameField);
		eleutil.sendKeys(usernameField, username);
	}

	public void enterPassword(String password) {
		eleutil.sendKeys(passwordField, password);
	}

	public void clickbuttonLogin() {
		waitUtils.elementToBeClickable(loginButton);
		eleutil.click(loginButton);
	}

	public void waitforerrormsg(String errormsg) {
		waitUtils.Textispresent(errorMessage, errormsg);
	}

	public void waitforvalidmsg(String validmsg) {
		waitUtils.Textispresent(validMessage, validmsg);
	}

}
