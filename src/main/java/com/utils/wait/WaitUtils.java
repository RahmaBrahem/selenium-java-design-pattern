/**
 * Copyright (c) 2025 Rahma Brahem
 * 
 * Licensed under the MIT License.
 * See the LICENSE file in the project root for license information.
 */
package com.utils.wait;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.reader.ConfigReader;

public class WaitUtils {

	WebDriver driver;
	WebDriverWait wait;
	private static ConfigReader configReader = new ConfigReader();

	public WaitUtils(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(configReader.getDurationTime()));
	}

	public void alertIsPresent() {
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void Textispresent(By locator, String Text) {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, Text));
	}

	public void elementToBeClickable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void elementToBeSelected(By locator) {
		wait.until(ExpectedConditions.elementToBeSelected(locator));
	}

	public void frameToBeAvailableAndSwitchToIt(By frameLocator) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	public void invisibilityOfTheElementLocated(By locator) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void invisibilityOfElementWithText(By locator, String text) {
		wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
	}

	public void presenceOfAllElementsLocatedBy(By locator) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public void presenceOfElementLocated(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void textToBePresentInElementLocated(By locator, String text) {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	public void textToBePresentInElementValue(By locator, String value) {
		wait.until(ExpectedConditions.textToBePresentInElementValue(locator, value));
	}

	public void titleIs(String title) {
		wait.until(ExpectedConditions.titleIs(title));
	}

	public void titleContains(String title) {
		wait.until(ExpectedConditions.titleContains(title));
	}

	public void visibilityOf(By locator) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
	}

	public void visibilityOfAllElements(List<WebElement> elements) {
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	public void visibilityOfAllElementsLocatedBy(By locator) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public void visibilityOfElementLocated(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static ConfigReader getConfigReader() {
		return configReader;
	}

	public static void setConfigReader(ConfigReader configReader) {
		WaitUtils.configReader = configReader;
	}

}
