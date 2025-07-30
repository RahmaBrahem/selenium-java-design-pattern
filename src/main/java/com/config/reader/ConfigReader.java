/**
 * Copyright (c) 2025 Rahma Brahem
 * 
 * Licensed under the MIT License.
 * See the LICENSE file in the project root for license information.
 */
package com.config.reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class ConfigReader {
	Properties properties;

	public ConfigReader() {
		try (FileInputStream fis = new FileInputStream(
				"C:\\Users\\Hp\\eclipse-workspace\\SeleniumDesignPattern\\src\\test\\resources\\dataConfig\\data.properties")) {
			properties = new Properties();
			properties.load(fis);
		} catch (IOException e) {
			System.out.println("Impossible de charger le fichier properties : " + e.getMessage());
		}
	}

	public String getBrowserName() {
		return properties.getProperty("browser");
	}

	public Boolean getBrowserMode() {
		String headlessValue = properties.getProperty("headless");
		return Boolean.parseBoolean(headlessValue);
	}

	public int getDurationTime() {
		return Integer.parseInt(properties.getProperty("durationmax"));
	}

	public String getActualDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(properties.getProperty("date"));
		return dateFormat.format(new Date());
	}

	public String getDocumentTitle() {
		return properties.getProperty("DocumentTitle");
	}

	public String reportName() {
		return properties.getProperty("ReportName");
	}

	public String videoLocation() {
		return properties.getProperty("VIDEO_LOCATION");
	}

	public String screenshotLocation() {
		return properties.getProperty("SCREENSHOT_LOCATION");
	}

	public String remplirUserName(String userName) {
		return properties.getProperty(userName);
	}

	public String remplirPassword(String password) {
		return properties.getProperty(password);
	}

	public String getmsg(String msg) {
		return properties.getProperty(msg);
	}

	public String getUrl() {
		return properties.getProperty("url");
	}

}
