package com.talend.tac.cases.dbConfig;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDbConfigReload extends DbConfig {

	@Test(groups = { "initDB" })
	@Parameters( { "db.url", "db.userName", "db.userPassWd", "db.driver",
			"license.file.path" })
	public void testDbConfigReload(String url, String userName, String userPassWd,
			String driver, String license) {

		this.DbConfigProcess(url, userName, userPassWd, driver);
		//check the number of xpath,3 errors and 2 OK
		waitForCheckConnectionStatus("//div[contains(text(),'Cannot instantiate')]",3);
		waitForCheckConnectionStatus("//div[text()='OK']",2);
		selenium.click("idDbConfigReloadButton");
		waitForCheckConnectionStatus("//div[text()='OK']",5);
		selenium.click("idDbConfigLogoutButton");
		waitForElementPresent("idLoginInput", WAIT_TIME);
	}

	@AfterTest
	public void killBrowser() {
		selenium.stop();
	}

}