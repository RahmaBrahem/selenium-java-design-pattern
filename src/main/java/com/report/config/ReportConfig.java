/**
 * Copyright (c) 2025 Rahma Brahem
 * 
 * Licensed under the MIT License.
 * See the LICENSE file in the project root for license information.
 */
package com.report.config;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.config.reader.ConfigReader;
import com.utils.screen.shot.ScreenShotUtils;

public class ReportConfig {

	private ExtentReports extent;
	private ExtentSparkReporter spark;
	private WebDriver driver;
	ConfigReader configReader = new ConfigReader();
	ScreenShotUtils capture = new ScreenShotUtils(driver);
	ITestResult result;
	private static com.aventstack.extentreports.ExtentTest test;

	public ReportConfig(WebDriver driver) throws IOException {
		this.driver = driver;
		this.capture = new ScreenShotUtils(driver);

		new File("target/Spark").mkdirs();
		String reportName = "target/Spark/SparkReport_" + configReader.getActualDateTime() + ".html";
		spark = new ExtentSparkReporter(reportName);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle(configReader.getDocumentTitle());
		spark.config().setReportName(configReader.reportName());
		spark.config().setTimeStampFormat(configReader.getActualDateTime());

		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	public ExtentReports getExtent() {
		return extent;
	}

	public ExtentTest logTestName(String methodName) {
		test = extent.createTest(methodName);
		return test;
	}

	public ExtentTest logTestName() {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		return extent.createTest(methodName);
	}

	public Status afterMethod(ITestResult result) throws IOException {
		if (test == null) {
			logTestName(result.getMethod().getMethodName());
		}

		test.addScreenCaptureFromPath(capture.takeScreenshot("Image_" + result.getMethod().getMethodName()));
		test.log(Status.INFO, "Vidéo ajoutée au rapport : <a href='" + configReader.videoLocation()
				+ "'>Cliquez ici pour voir la vidéo</a>");

		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test passed.");
			return Status.PASS;
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test failed: " + result.getThrowable().getMessage());
			return Status.FAIL;
		} else {
			test.log(Status.SKIP, "Test skipped.");
			return Status.SKIP;
		}
	}

	public void flush() {
		extent.flush();
	}

}
