package com.talend.tac.cases.executePlan;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;
public class TestAddAddSimpleTriggerUseOutdatedTimeByUI extends Login{
    	
	TriggerDate date = new TriggerDate();
   
	// add a simpleTrigger
	@Test(groups={"plan.addtrigger"})
	@Parameters({ "plan.toaddsimpletrigger.label", "plan.simpletrigger.outdated.label"})
	public void testAddTriggerAddSimpleTriggerOutdated(String plantoaddsimletrigger, String simpletriggeroutdated) {
		this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
    	selenium.setSpeed(MID_SPEED);
    	Assert.assertTrue(selenium.isElementPresent("//div[@class='header-title' and text()='Execution plan']"));
    	selenium.setSpeed(MIN_SPEED);
    	selenium.click("idSubModuleRefreshButton");
    	selenium.mouseDown("//div[text()='"+plantoaddsimletrigger+"']");//select a exist task
		selenium.click("//button[text()='Add trigger...']");//add a trigger
		selenium.click("//a[text()='Add simple trigger']");//add a SimpleTrigger
        Assert.assertTrue(selenium.isElementPresent("//span[text()='"+rb.getString("trigger.action.addSimpleTrigger")+"']"));
        selenium.setSpeed(MID_SPEED);
        //type simple trigger label
        this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='label']",simpletriggeroutdated );//label
		//type simple trigger description
        this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='description']", "SimpleTriggerOutdated");//description
        //type simple trigger start time
//        this.typeString("//input[@name='startTime']", date.getPast("48"));
//        selenium.typeKeys("//input[@name='startTime']", date.getPast("48"));
          //selenium.typeKeys("//input[@name='startTime']", "2011-04-10 09:30:15");
//        this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='startTime']", date.getFuture("24"));//description
       
        selenium.click("//input[@name='startTime']/parent::div/div[@class='x-form-trigger x-form-date-trigger']");
        selenium.setSpeed(MAX_SPEED);
//        selenium.click("//div[@class=' x-icon-btn x-nodrag x-date-left-icon x-component ']");
        selenium.click("//td[@class='x-date-active']/a/span[text()='"+date.getPast(48).days+"']");
        selenium.setSpeed(MIN_SPEED);
        //type simple trigger end time
//        selenium.typeKeys("//input[@name='endTime']", date.getPast("24"));
//        selenium.typeKeys("//input[@name='endTime']", "2011-04-16 09:08:34");
//        this.typeString("//input[@name='endTime']", date.getPast("24"));
//        this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='endTime']", date.getFuture("48"));//description
        selenium.click("//input[@name='endTime']/parent::div/div[@class='x-form-trigger x-form-date-trigger']");
        selenium.setSpeed(MAX_SPEED);
//        selenium.click("//div[@class=' x-icon-btn x-nodrag x-date-left-icon x-component ']");
        selenium.click("//td[@class='x-date-active']/a/span[text()='"+date.getPast(24).days+"']");
        selenium.setSpeed(MIN_SPEED);
        //type simple trigger repeat count
        this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='repeatCount']", "40");//description
	    //type simple trigger repeat interval
        this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='repeatInterval']", "15");//Number of triggerings
//	    selenium.click("//span[text()='Add simple trigger']/parent::legend/parent::fieldset/parent::form/parent::div/parent::div/parent::div/parent::div/parent::div//button[@id='idFormSaveButton']");
	    //click save button
        selenium.setSpeed(MAX_SPEED); 
        selenium.click("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-footer']/div[@class=' x-panel-btns']/div[@class=' x-small-editor x-panel-btns-center x-panel-fbar x-component x-toolbar-layout-ct']/table[@class='x-toolbar-ct']/tbody/tr/td[@class='x-toolbar-left']/table/tbody/tr[@class='x-toolbar-left-row']/td[@class='x-toolbar-cell']/table[@class=' x-btn x-component x-btn-text-icon ']/tbody[@class='x-btn-small x-btn-icon-small-left']/tr/td[@class='x-btn-mc']/em/button[@class='x-btn-text ' and text()='Save']");
//	    Assert.assertTrue(selenium.isTextPresent("Save failed: Start time has to be set with a date greater than server time  "), "simpleTriggerOutdated added failed!");
	    Assert.assertFalse(selenium.isElementPresent("//span[text()='"+simpletriggeroutdated+"']"));
	    selenium.setSpeed(MIN_SPEED);
	}

}