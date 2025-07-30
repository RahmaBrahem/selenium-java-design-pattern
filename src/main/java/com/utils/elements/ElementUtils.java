/**
 * Copyright (c) 2025 Rahma Brahem
 * 
 * Licensed under the MIT License.
 * See the LICENSE file in the project root for license information.
 */
package com.utils.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void sendKeys(By locator, String keysToSend) {
		WebElement element = driver.findElement(locator);
		element.clear();
		element.sendKeys(keysToSend);
	}

	public boolean isDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

	public boolean isSelected(By locator) {
		return driver.findElement(locator).isSelected();
	}

	public void submit(By locator) {
		driver.findElement(locator).submit();
	}

	public boolean isEnabled(By locator) {
		return driver.findElement(locator).isEnabled();
	}

	public void clear(By locator) {
		driver.findElement(locator).clear();
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public Dimension getSize(By locator) {
		return driver.findElement(locator).getSize();
	}
}
