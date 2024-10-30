package org.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import io.appium.java_client.android.AndroidDriver;

public class AppiumUtils {
	public String getScreenShotPath(String testCaseName, AndroidDriver driver) throws IOException {
		
//		capture and place in folder
		File fileSource = driver.getScreenshotAs(OutputType.FILE); // Capture the screenshot into raw format which will be copy on virtual not on local or physical system and copy the screenshot on destination file
		String destinationFile = System.getProperty("user.dir") + "//reports" + testCaseName + ".png";
		FileUtils.copyFile(fileSource, new File(destinationFile));
		return destinationFile;
//		extent report pick file and attach to report
	}
}
