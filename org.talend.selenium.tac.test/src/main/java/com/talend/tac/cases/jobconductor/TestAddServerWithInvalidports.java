package com.talend.tac.cases.jobconductor;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.testng.Assert;

import com.talend.tac.cases.Login;

public class TestAddServerWithInvalidports extends Login {
	@Test(groups = { "else" })
	@Parameters({ "ServerLablename", "PortInvalidServer", "ServerDescription",
			"ServerHost", "ServerCommondport", "ServerFiletransfortport",
			"ServerMonitorport", "ServerTimeout", "ServerUsername",
			"ServerPassword" })
	public void addServerInvalid(String lable, String invalidLable,
			String description, String host, String commondport,
			String transfortport, String monitorport, String time,
			String username, String password) {
		selenium.setSpeed(MAX_SPEED);
		if (selenium.isVisible("!!!menu.executionServers.element!!!")) {
			selenium.click("!!!menu.executionServers.element!!!");
			waitForElementPresent("idSubModuleAddButton", 30000);

		} else {
			selenium.click("!!!menu.jobConductor.element!!!");
			selenium.setSpeed(MID_SPEED);
			selenium.click("!!!menu.executionServers.element!!!");
			waitForElementPresent("idSubModuleAddButton", 30000);

		}
		selenium.setSpeed(MAX_SPEED);
		// System.out.println("click add before !");
		if (selenium.isElementPresent("idSubModuleAddButton")) {
			addServerwithInvalideports(invalidLable);
			// save
			selenium.setSpeed(MAX_SPEED);
			selenium.click("idFormSaveButton");
			// refresh
			selenium.click("idSubModuleRefreshButton");
//			if (selenium.isElementPresent("//div[text()='" + lable + "']")) {
//
//			} else {
//				Assert.fail("Server added failed !");
//			}
			Assert.assertFalse(selenium.isElementPresent("//div[text()='" + lable + "']"),"Test add server with invalid ports failed!");
		} else {
			Assert.fail("add button can not be seen !");

		}
		selenium.setSpeed(MIN_SPEED);

	}

	
	public void addServerwithInvalideports(String invalideServername) {
		selenium.click("idSubModuleAddButton");
		// lable
		this.typeString(other.getString("inputname.id.server.add.label"),
				invalideServername);
		selenium.setSpeed(MIN_SPEED);

		// description
		this.typeString(other.getString("inputname.id.server.add.description"),
				"description");

		// host
		this.typeString(other.getString("inputname.id.server.add.host"),
				"localhost");

		// port1 invalid with characters
		this.typeString(other.getString("inputname.id.server.add.commandPort"),
				"1023");

		// if the warning img present,it's true
		// Assert.assertTrue(selenium.isElementPresent(""), "");
		// port valid
		this.typeString(
				other.getString("inputname.id.server.add.fileTransfertPort"),
				"1024");
		// port invalid with characters
		this.typeString(
				other.getString("inputname.id.server.add.monitoringPort"),
				"888s");
		// count the warning images
		if (selenium.getXpathCount("//img[@class='gwt-Image x-component ' and @role='alert']").intValue() != 2) {// Xpath of warning
															// image
			Assert.fail("ports verify failed!");
		} else {
			selenium.click("idFormCancelButton");
		}
		selenium.setSpeed(MIN_SPEED);

	}
	
}