package org.automation.pages.google;

import org.automation.base.Page;

/**
 * Created by bhavin.br on 12/7/15.
 */
public class GoogleHomePage extends Page {

	public void landOnHomePage() {
		driver.get(CONFIG.getProperty("testGoogleLandingPageURL"));
		System.out.println(isElementPresent("//*[@id='lst-ib']"));
	}

	public void searchFor(String search){
        input("//input[@id='lst-ib']", search);
		click("//button[@name='btnG']");
		isLinkPresent("Foobar - Wikipedia, the free encyclopedia");
	}
}
