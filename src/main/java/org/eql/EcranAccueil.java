package org.eql;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EcranAccueil extends AbstractBandeau {
	
    private AndroidDriver<AndroidElement> driver;
    
    public EcranAccueil(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.simplemobiletools.contacts:id/fragment_fab")
    MobileElement  ajout_button;
    @AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_tmb")
    MobileElement info_contact_button;
    
    public void ajoutContact(AndroidDriver<AndroidElement> driver) {
    ajout_button.click();
    }
    
    public void infoContact(AndroidDriver<AndroidElement> driver) {
    info_contact_button.click();
    }    
   
}
