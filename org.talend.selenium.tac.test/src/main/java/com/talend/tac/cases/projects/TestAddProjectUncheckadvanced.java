package com.talend.tac.cases.projects;

import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class TestAddProjectUncheckadvanced extends Login {
	TestDeletepro delete = new TestDeletepro();

	@Test
	@Parameters({ "ProjectType", "Prolanguage" })
	public void testAddPerlproject(String type, String language)
			throws InterruptedException {
		this.waitForElementPresent("!!!menu.project.element!!!", 30);
		String namecommon = "JavaDefaultPro";
		selenium.setSpeed(MID_SPEED);
		selenium.click("!!!menu.project.element!!!");
		selenium.click("idSubModuleAddButton");
		Thread.sleep(5000);
		selenium.setSpeed(MID_SPEED);
		// add the type select option selenium.setSpeed("2000");
		if (selenium.isVisible("idProjectTypeComboBox")) {
			selenium.click("idProjectTypeComboBox");
			selenium.mouseDownAt(("//div[text()='" + type + "']"),""+KeyEvent.VK_ENTER);
//			selenium.fireEvent("idProjectTypeComboBox", "blur");
			
		}
		// type project label
		this.typeString("idLabelInput", namecommon);
	
		// select project language
		if (!"Java".equals(language) && !"".equals(language)) {
			selenium.click("idLanguageInput");
			selenium.mouseDownAt("//div[@role='listitem'][2]", ""
					+ KeyEvent.VK_ENTER);
		}
		//check the acvanced check box and type parameters ****************
		//check advanced checkbox
		selenium.click("idAdvanceInput");
		//type project svn url
		this.typeString("idUrlInput",  "wrongurl");
		//type svn username
		this.typeString("idLoginInput", "user");
		//type svn password
		this.typeString("idPasswordInput","password");
		//select svn commit mode 
		selenium.click("idSvnCommitInput");
		selenium.mouseDownAt("//div[@role='listitem'][2]", ""
				+ KeyEvent.VK_ENTER);
		//select svn lock mode
		selenium.click("idSvnLockInput");
		selenium.mouseDownAt("//div[@role='listitem'][2]", ""
				+ KeyEvent.VK_ENTER);
		//check svn user log checkbox
		selenium.click("idSvnUserLogInput");
		
		//**************************************************************
		//then cancel advanced check box
		selenium.click("idAdvanceInput");
		//**************************************************************
		selenium.setSpeed(MAX_SPEED);
		this.typeString("idDescriptionInput", "javadefault");
		// selenium.focus("idFormSaveButton");
		// selenium.keyDownNative(""+KeyEvent.VK_ENTER);
		// selenium.keyUpNative(""+KeyEvent.VK_ENTER);
		System.out.println("before click "+selenium.getValue("idProjectTypeComboBox"));
		selenium.click("idFormSaveButton");
		Thread.sleep(5000);
		Assert.assertTrue(
				selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
						+ namecommon + "')]")
						&& (selenium.isElementPresent("//img[@title='java']")),
				"javadefault project added failed");

		delete.okDelete(selenium, namecommon);
		selenium.setSpeed(MIN_SPEED);
	}
}