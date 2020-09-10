package org.eql;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class OutilsTechniques {
	
	static AndroidDriver <AndroidElement> driver;

	static AndroidDriver<AndroidElement> Config() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "Anne Nexus");
		desiredCapabilities.setCapability("app", "C:/Users/formation/Desktop/Appium/Simple_Contacts_v4.5.0_apkpure.com.apk");
		desiredCapabilities.setCapability("appPackage", "com.simplemobiletools.contacts");
		desiredCapabilities.setCapability("appActivity", "com.simplemobiletools.contacts.activities.MainActivity");
		
		URL remoteUrl = new URL ("http://localhost:4723/wd/hub");
		
		driver = new AndroidDriver <AndroidElement> (remoteUrl, desiredCapabilities);
		
		return driver;		

	}
	
}
