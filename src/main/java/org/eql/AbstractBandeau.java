package org.eql;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public abstract class AbstractBandeau {
	
    @AndroidFindBy(xpath="//android.widget.ImageView[@content-desc=\"More options\"]")
    MobileElement options_button;
    
    @AndroidFindBy(xpath="//android.widget.ListView/android.widget.LinearLayout[2]")
    MobileElement choix_delete;
    
    
}
