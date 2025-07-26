package com.driver.factory;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public WebDriver initializeBrowser(String browserName, boolean headlessMode) {
		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--kiosk");
			options.addArguments("--disable-namespace-sandbox");
			options.addArguments("ignore-certificate-errors");
			options.setExperimentalOption("excludeSwitches", Arrays.asList("test-type"));
			options.addArguments("--safebrowsing-disable-download-protection");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			if (headlessMode) {
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
			}

			WebDriverManager.chromedriver().setup();
			tdriver.set(new ChromeDriver(options));

		} else if (browserName.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			if (headlessMode) {
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
			}

			WebDriverManager.firefoxdriver().setup();
			tdriver.set(new FirefoxDriver(options));

		} else if (browserName.equalsIgnoreCase("edge")) {
			EdgeOptions option = new EdgeOptions();
			option.setAcceptInsecureCerts(true);
			option.addArguments("ignore-certificate-errors");
			option.addArguments("--remote-allow-origins=*");
			if (headlessMode) {
				option.addArguments("--headless");
				option.addArguments("--window-size=1920,1080");
			}

			WebDriverManager.edgedriver().setup();
			tdriver.set(new EdgeDriver(option));

		} else {
			System.out.println("** BROWSER IS NOT DEFINED");
		}

		return tdriver.get();
	}

}
