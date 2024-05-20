package pageObjects;


import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {
	public static AndroidDriver Adriver;
	
		public BasePage(AndroidDriver Adriver) {
			this.Adriver = Adriver;
			PageFactory.initElements(new AppiumFieldDecorator(Adriver),this);
	}

}
