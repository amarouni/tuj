package com.talend.tac.cases.executePlan;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

@SuppressWarnings("deprecation")
public class TestAddTriggerAddSimpleTriggerByUIendbeforestart extends Login {

	TriggerDate date = new TriggerDate();

	// add a simpleTrigger
	@Test(groups = { "plan.addtrigger" })
	@Parameters({ "plan.toaddsimpletrigger.label",
			"plan.simpletrigger.byui.endbeforestart.label" })
	public void testAddTriggerAddSimpleTrigger(String plantoaddsimletrigger,
			String simpletriggerlabel) throws InterruptedException {
		this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium
				.isElementPresent("//div[@class='header-title' and text()='Execution plan']"));
		selenium.setSpeed(MIN_SPEED);
		selenium.click("idSubModuleRefreshButton");
		selenium.mouseDown("//div[text()='" + plantoaddsimletrigger + "']");// select
																			// a
																			// exist
																			// task
		selenium.click("//button[text()='Add trigger...']");// add a trigger
		selenium.click("//a[text()='Add simple trigger']");// add a SimpleTrigger
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"
				+ rb.getString("trigger.action.addSimpleTrigger") + "']"));
		Thread.sleep(5000);
		selenium.setSpeed(MIN_SPEED);
		// type simple trigger label
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='label']",
				simpletriggerlabel);// label
		// type simple trigger description
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='description']",
				"SimpleTrigger");// description
		// type simple trigger start time
		selenium.click("//input[@name='startTime']/parent::div/div[@class='x-form-trigger x-form-date-trigger']");
		selenium.setSpeed(MAX_SPEED);
		// selenium.click("//div[@class=' x-icon-btn x-nodrag x-date-left-icon x-component ']");
		selenium.click("//td[@class='x-date-active']/a/span[text()='" + date.getFuture(48).days + "']");
		selenium.setSpeed(MIN_SPEED);
		// this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='startTime']",
		// date.getFuture("24"));//description
		// type simple trigger end time
		selenium.click("//input[@name='endTime']/parent::div/div[@class='x-form-trigger x-form-date-trigger']");
		selenium.setSpeed(MAX_SPEED);
		// selenium.click("//div[@class=' x-icon-btn x-nodrag x-date-left-icon x-component ']");
		selenium.click("//td[@class='x-date-active']/a/span[text()='" + date.getFuture(24).days + "']");
		selenium.setSpeed(MIN_SPEED);
		// this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='endTime']",
		// date.getFuture("48"));//description
		// type simple trigger repeat count
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='repeatCount']",
				"40");// description
		// type simple trigger repeat interval
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='repeatInterval']",
				"15");// Number of triggerings
		// selenium.click("//span[text()='Add simple trigger']/parent::legend/parent::fieldset/parent::form/parent::div/parent::div/parent::div/parent::div/parent::div//button[@id='idFormSaveButton']");
		selenium.click("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-footer']/div[@class=' x-panel-btns']/div[@class=' x-small-editor x-panel-btns-center x-panel-fbar x-component x-toolbar-layout-ct']/table[@class='x-toolbar-ct']/tbody/tr/td[@class='x-toolbar-left']/table/tbody/tr[@class='x-toolbar-left-row']/td[@class='x-toolbar-cell']/table[@class=' x-btn x-component x-btn-text-icon ']/tbody[@class='x-btn-small x-btn-icon-small-left']/tr/td[@class='x-btn-mc']/em/button[@class='x-btn-text ' and text()='Save']");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isTextPresent("Save failed: End time cannot be before start time -- For more information see your log file"),"SimpleTrigger endTime before startTime failed!");
		Assert.assertFalse(selenium.isElementPresent("//span[text()='"
				+ simpletriggerlabel + "']"),"SimpleTrigger endTime before startTime failed!");
		selenium.setSpeed(MIN_SPEED);
	}

}