package org.automation.action;

import org.automation.pages.google.GoogleHomePage;

/**
 * Created by bhavin.br on 12/8/15.
 */
public class GoogleAction {

	public static void searchString(String search){
		GoogleHomePage gpage = new GoogleHomePage();
		gpage.landOnHomePage();
		gpage.searchFor(search);
	}
}
