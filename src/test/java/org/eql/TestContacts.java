package org.eql;
import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestContacts {
	
	private AndroidDriver <MobileElement> driver;
	
	// JDD
	String prenom = "Ann";
	String nom = "Lab";
	String numero = "0658451285";
	String email = "anne.lab@yopmail.com";
	
		
	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "Anne Nexus");
		desiredCapabilities.setCapability("app", "C:/Users/formation/Desktop/Appium/Simple_Contacts_v4.5.0_apkpure.com.apk");
		desiredCapabilities.setCapability("appPackage", "com.simplemobiletools.contacts");
		desiredCapabilities.setCapability("appActivity", "com.simplemobiletools.contacts.activities.MainActivity");
		
		URL remoteUrl = new URL ("http://localhost:4723/wd/hub");
		
		driver = new AndroidDriver <MobileElement> (remoteUrl, desiredCapabilities);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@After
	public void tearDown() {
		
		driver.quit();
	}
	
	
	@Test
	public void contactsAppTest() {
		
			//Validation accès téléphone
			Alert alert_allow_un = driver.switchTo().alert();
			alert_allow_un.accept();
			Alert alert_allow_deux = driver.switchTo().alert();
			alert_allow_deux.accept();
		
			//Ajout contact
			MobileElement ajout_button = (MobileElement) driver.findElementById("com.simplemobiletools.contacts:id/fragment_fab");
			ajout_button.click();
			MobileElement prenom_el = (MobileElement) driver.findElementById("com.simplemobiletools.contacts:id/contact_first_name");
			MobileElement nom_el = (MobileElement) driver.findElementById("com.simplemobiletools.contacts:id/contact_surname");
			MobileElement numero_el = (MobileElement) driver.findElementById("com.simplemobiletools.contacts:id/contact_number");
			MobileElement email_el = (MobileElement) driver.findElementById("com.simplemobiletools.contacts:id/contact_email");
			prenom_el.sendKeys(prenom);
			nom_el.sendKeys(nom);
			numero_el.sendKeys(numero);
			email_el.sendKeys(email);
			//Sauvegarde du contact
			MobileElement save_button = (MobileElement) driver.findElementById("com.simplemobiletools.contacts:id/save");
			save_button.click();
			//Visualisation contact nouvellement créé
			MobileElement info_contact_button = (MobileElement) driver.findElementById("com.simplemobiletools.contacts:id/contact_tmb");
			info_contact_button.click();
			
			//Vérification de l'enregistrement
			MobileElement prenom_el_bis = (MobileElement) driver.findElementById("com.simplemobiletools.contacts:id/contact_first_name");
			MobileElement nom_el_bis = (MobileElement) driver.findElementById("com.simplemobiletools.contacts:id/contact_surname");
			MobileElement numero_el_bis = (MobileElement) driver.findElementById("com.simplemobiletools.contacts:id/contact_number");
			MobileElement email_el_bis = (MobileElement) driver.findElementById("com.simplemobiletools.contacts:id/contact_email");
			assertEquals("Le prenom ne correspond pas", prenom, prenom_el_bis.getText());
			assertEquals("Le nom ne correspond pas", nom, nom_el_bis.getText());
			assertEquals("Le numero de telephone ne correspond pas", numero, numero_el_bis.getText());
			assertEquals("L'email ne correspond pas", email, email_el_bis.getText());
			
			//Nettoyage
			MobileElement options_button = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"More options\"]");
		    options_button.click();
		    MobileElement choix_delete = (MobileElement) driver.findElementByXPath("//android.widget.ListView/android.widget.LinearLayout[2]");
		    choix_delete.click();
			Alert alert_supp = driver.switchTo().alert();
			alert_supp.accept();
		
	}
	

}
