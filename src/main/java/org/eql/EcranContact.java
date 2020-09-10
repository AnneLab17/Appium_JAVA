package org.eql;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EcranContact extends AbstractBandeau {
	
    private AndroidDriver<AndroidElement> driver;
	
    public EcranContact(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
    @AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_first_name")
    MobileElement prenom;
    @AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_surname")
    MobileElement nom;
    @AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_number")
    MobileElement numero;
    @AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_email")
    MobileElement email;
    @AndroidFindBy(id="com.simplemobiletools.contacts:id/save")
    MobileElement save_button;
    
    public void saisirContact(String pr, String n, String num, String em) {
    prenom.sendKeys(pr);
    nom.sendKeys(n);
    numero.sendKeys(num);
    email.sendKeys(em);
    }
    
    public void save(AndroidDriver<AndroidElement> driver) {
    save_button.click();
    }    
	
    public void suppressionContact() {
    options_button.click();
    choix_delete.click();
	Alert alert_supp = driver.switchTo().alert();
	alert_supp.accept();
    }
}
