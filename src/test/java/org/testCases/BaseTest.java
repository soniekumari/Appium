package org.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.pageObjects.android.FormPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AndroidDriver driver;
	AppiumServiceBuilder appiumServiceBuilder;
	public FormPage formPage;
	
	@BeforeClass(alwaysRun = true)
	public void configurationTest() throws IOException {  
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\data.properties");
		prop.load(fis);
		
		String ipAdr = prop.getProperty("ipAddres");
		String port = prop.getProperty("port");
		String deviceName = prop.getProperty("AndroidDeviceName");
		
		
		appiumServiceBuilder = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\Monoo\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js"))
				.withIPAddress(ipAdr).usingPort(Integer.parseInt(port));
		
		appiumServiceBuilder.build();
		
		
		UiAutomator2Options options = new UiAutomator2Options(); // This is directly interact with android app
		options.setDeviceName("moto g32");
//		options.setApp("C:\\Appium\\resources\\ApiDemos-debug.apk");
		options.setApp(System.getProperty("user.dir") + "\\src\\test\\resources\\General-Store.apk");

		driver = new AndroidDriver(options);
		
		formPage = new FormPage(driver);
	}
	
	public void longClickGesture(WebElement clickElement) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) clickElement).getId(), "Duration", 2000));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDoown() {
		driver.quit();
	}
}
