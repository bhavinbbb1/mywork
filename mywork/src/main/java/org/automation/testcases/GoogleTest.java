package org.automation.testcases;

import org.automation.action.GoogleAction;
import org.automation.base.Page;
import org.automation.pages.google.GoogleHomePage;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by bhavin.br on 12/7/15.
 */
public class GoogleTest {

	@Test
	public void googleTest() {
		GoogleAction.searchString("Foo");
	}
    @AfterClass
	public void afterFinish(){
		Page.close();
	}
}
