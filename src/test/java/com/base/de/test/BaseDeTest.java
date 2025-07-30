/**
 * Copyright (c) 2025 Rahma Brahem
 * 
 * Licensed under the MIT License.
 * See the LICENSE file in the project root for license information.
 */
package com.base.de.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.config.reader.ConfigReader;
import com.driver.factory.DriverFactory;
import com.pages.LoginPage;
import com.report.config.ReportConfig;
import com.utils.elements.ElementUtils;
import com.utils.screen.shot.ScreenShotUtils;

import atu.testrecorder.exceptions.ATUTestRecorderException;

public class BaseDeTest {

	public static ReportConfig reportManager;
	protected WebDriver driver;
	public static ConfigReader configReader;
	protected ScreenShotUtils screenShot;
	public static DriverFactory driverfactory;
	public static ElementUtils eleutill;
	protected LoginPage loginPage;

	@BeforeSuite
	public void setupBeforeSuite() {
		configReader = new ConfigReader();
	}

	@BeforeClass
	public void setupBeforeClass() throws IOException {
		driverfactory = new DriverFactory();
		driver = driverfactory.initializeBrowser(configReader.getBrowserName(), configReader.getBrowserMode());
		driver.manage().window().maximize();
		driver.get(configReader.getUrl());
		eleutill = new ElementUtils(driver);
		reportManager = new ReportConfig(driver);
		loginPage = new LoginPage(driver);
	}

	@BeforeMethod
	public void setUpTest(ITestResult result) throws ATUTestRecorderException {
		screenShot = new ScreenShotUtils(driver);
		reportManager.logTestName(result.getMethod().getMethodName());
		screenShot.setupBeforeMethod(result);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException, ATUTestRecorderException {
		reportManager.afterMethod(result);
		screenShot.stopRecording();
	}

	@AfterClass
	public void tearDownClass() {
		if (driver != null)
			driver.quit();

	}

	@AfterSuite
	public void tearDownSuite() {
		reportManager.flush();
	}

}
