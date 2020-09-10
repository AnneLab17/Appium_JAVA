package org.eql;
import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestContactsPageObject {

	AndroidDriver<AndroidElement> driver;

	// JDD
	String prenom = "Ann";
	String nom = "Lab";
	String numero = "0658451285";
	String email = "anne.lab@yopmail.com";

	@Before
	public void setUp() throws MalformedURLException {

		driver = OutilsTechniques.Config();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {

		driver.quit();		
	}

	@Test
	public void contactsAppPageObjectTest() {

		// Validation accès téléphone
		Alert alert_allow_un = driver.switchTo().alert();
		alert_allow_un.accept();
		Alert alert_allow_deux = driver.switchTo().alert();
		alert_allow_deux.accept();
		
        EcranAccueil ecran_accueil = new EcranAccueil(driver);
		
		// Ajout contact		
        EcranContact ecran_contact = new EcranContact(driver);
        ecran_accueil.ajoutContact(driver);		
		ecran_contact.saisirContact(prenom, nom, numero, email);
		// Sauvegarde du contact
		ecran_contact.save(driver);
		// Visualisation contact nouvellement créé
		ecran_accueil.infoContact(driver);

		// Vérification de l'enregistrement
		assertEquals("Le prenom ne correspond pas", prenom, ecran_contact.prenom.getText());
		assertEquals("Le nom ne correspond pas", nom, ecran_contact.nom.getText());
		assertEquals("Le numero de telephone ne correspond pas", numero, ecran_contact.numero.getText());
		assertEquals("L'email ne correspond pas", email, ecran_contact.email.getText());
		
		//Nettoyage
		ecran_contact.suppressionContact();
	}

}
