package com.talend.tac.cases.executePlan;

import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestPlanExecutionLogsDisplay extends Plan {
	@Test
	 @Parameters({ "planexecutionlogsdisplay.plan.label",
	 "planexecutionlogsdisplay.plan.roottask"})
	public void testCheckPlanLogsPerpage(String planLabel,String taskLabel) {
		// this.addPlan(planLabel, rootTask, "treeManagePlan");
		this.addPlan(planLabel, taskLabel, "testPlanlogsdisplay");
		this.runPlanAndCheck(planLabel, taskLabel, 15);
		this.clickWaitForElementPresent("//span[@class='x-tab-strip-text  ' and text()='History']");
		this.clickWaitForElementPresent("//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//table[contains(@class,'x-btn x-component x-btn-icon')]");
		int defaultCounts = Integer.parseInt(selenium.getValue("//div[@class=' x-form-field-wrap  x-component ' and @title='Enter the number of items per page']//input"));
		Assert.assertTrue(selenium.getXpathCount("//img[@class='gwt-Image' and @title='Ok']").intValue()==defaultCounts, "test plan execution logs per page failed!");
	}
	
	@Test(dependsOnMethods="testCheckPlanLogsPerpage")
	 @Parameters({ "planexecutionlogsdisplay.plan.label",
	 "planexecutionlogsdisplay.plan.roottask"})
	public void testCheckPlanLogsPerpageChange(String planLabel,String taskLabel) {
		// this.addPlan(planLabel, rootTask, "treeManagePlan");
		this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Execution Plan']",
				WAIT_TIME);
		Assert.assertTrue(selenium
				.isElementPresent("//div[@class='header-title' and text()='Execution Plan']"));
		this.waitForElementPresent("//span[text()='" + planLabel + "']",
				WAIT_TIME);
		this.clickWaitForElementPresent("//span[@class='x-tab-strip-text  ' and text()='History']");
		this.clickWaitForElementPresent("//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//table[contains(@class,'x-btn x-component x-btn-icon')]");
		int newNum = 5;
		typeAndPressEnter("//div[@class='my-paging-text x-component ' and text()='Page']//ancestor::td[@class='x-toolbar-cell']/following-sibling::td//input[@class='gwt-TextBox x-component ']", "1");
		typeAndPressEnter("//div[@class=' x-form-field-wrap  x-component ' and @title='Enter the number of items per page']//input", ""+newNum);
		this.sleep(3000);
		Assert.assertTrue(selenium.getXpathCount("//img[@class='gwt-Image' and @title='Ok']").intValue()==newNum, "test plan execution logs per page failed!");
	}
	
	public void typeAndPressEnter(String xpath,String value){
		selenium.type(xpath, value);
		selenium.keyDown(xpath,"\\13");
	}
	
}