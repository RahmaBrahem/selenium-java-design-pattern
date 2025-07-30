/**
 * Copyright (c) 2025 Rahma Brahem
 * 
 * Licensed under the MIT License.
 * See the LICENSE file in the project root for license information.
 */
package com.utils.screen.shot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.config.reader.ConfigReader;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class ScreenShotUtils {

	private WebDriver driver;
	private ATUTestRecorder recorder;
	private String methodName;

	private ConfigReader configReader;

	public ScreenShotUtils(WebDriver driver) {
		this.driver = driver;
		this.configReader = new ConfigReader();
	}

	public String getVideoFileName() {
		return "Video_" + methodName + "_" + configReader.getActualDateTime();
	}

	public void startRecording() throws ATUTestRecorderException {
		new File(configReader.videoLocation()).mkdirs();
		recorder = new ATUTestRecorder(configReader.videoLocation(), getVideoFileName(), false);
		recorder.start();
	}

	public void setupBeforeMethod(ITestResult result) {
		this.methodName = result.getMethod().getMethodName();
		try {
			startRecording();
		} catch (ATUTestRecorderException e) {
			e.printStackTrace();
		}
	}

	public void stopRecording() throws ATUTestRecorderException {
		if (recorder != null) {
			recorder.stop();
		}
	}

	public String takeScreenshot(String imageName) throws IOException {
		new File(configReader.screenshotLocation()).mkdirs();
		String actualImageName = configReader.screenshotLocation() + "\\" + imageName + "_"
				+ configReader.getActualDateTime() + ".png";
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFileImg = new File(actualImageName);
		FileUtils.copyFile(sourceFile, destFileImg);
		return actualImageName;
	}

}
