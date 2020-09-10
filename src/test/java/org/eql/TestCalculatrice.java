package org.eql;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;



import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestCalculatrice {

	private AndroidDriver <MobileElement> driver;
	
	//JDD
	String premier_choix = "4";
	String deuxieme_choix = "3";
	Integer resultat = Integer.valueOf(premier_choix) * Integer.valueOf(deuxieme_choix);
	
	
	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "Anne Nexus");
		desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
		desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		URL remoteUrl = new URL ("http://localhost:4723/wd/hub");
		
		driver = new AndroidDriver <MobileElement> (remoteUrl, desiredCapabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() {

		driver.quit();		
	}
	
	@Test
	public void calculatriceAppTest( ) {
		MobileElement touche_premier = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_"+premier_choix);
		MobileElement touche_multi = (MobileElement) driver.findElementById("com.android.calculator2:id/op_mul");
		MobileElement touche_deuxieme = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_"+deuxieme_choix);
		MobileElement touche_egal = (MobileElement) driver.findElementById("com.android.calculator2:id/eq");
		MobileElement result = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
		
		touche_premier.click();
		touche_multi .click();
		touche_deuxieme.click();
		touche_egal.click();
		assertEquals("Le resultat est incorrect", resultat.toString(), result.getText());
	}
}
