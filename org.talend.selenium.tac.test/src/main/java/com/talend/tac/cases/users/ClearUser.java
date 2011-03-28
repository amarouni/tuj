package com.talend.tac.cases.users;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class ClearUser extends Login{
  
	@Test(dependsOnGroups={"ModifyUser"})
	@Parameters({"userName","_FirstName","_LastName"})
	public void clearUsers(String userName,String FirstName,String LastName) throws Exception {
   	 List<String> users = new ArrayList<String>(); 
	 this.clickWaitForElementPresent("idMenuUserElement");
	 users = this.findSpecialMachedStrings(".*@[a-zA-Z0-9]*\\.com");
	 for(int i=0;i<users.size();i++) {
		 System.out.println(users.get(i));
		 if(!"admin@company.com".equals(users.get(i))) {
			selenium.mouseDown("//div[text()='"+users.get(i)+"']");
				selenium.chooseOkOnNextConfirmation();
				selenium.click("idSubModuleDeleteButton");
				selenium.setSpeed(MAX_SPEED);
			    Assert.assertTrue(selenium.getConfirmation().matches("^"+other.getString("delete.User.confirmation")+" [\\s\\S]$"));
		    selenium.setSpeed(MIN_SPEED);
		 } 
	 }
	    
     selenium.mouseDown("//div[text()='"+userName+"']");//Select Login user
	 selenium.setSpeed(MAX_SPEED);
	 selenium.type("idUserFirstNameInput", FirstName);
	 selenium.fireEvent("idUserFirstNameInput", "blur");
	 selenium.type("idUserLastNameInput", LastName);
	 selenium.fireEvent("idUserLastNameInput", "blur");
	 selenium.setSpeed(MAX_SPEED);
	 selenium.click("idFormSaveButton");
     selenium.setSpeed(MIN_SPEED);
	
	}
	
	
}
