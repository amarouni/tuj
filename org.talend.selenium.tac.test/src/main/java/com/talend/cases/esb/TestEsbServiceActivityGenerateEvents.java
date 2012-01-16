package com.talend.cases.esb;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestEsbServiceActivityGenerateEvents extends Esb {
	@Test
	@Parameters({"esb.monitor.karafurl","esb.monitor.receivenewevents.consumer","esb.monitor.generateNumForTest"})
	public void testGenerateEventsForPageDisplay(String karafUrl,String consumerName,String intNum){
		this.generateEvents(karafUrl, consumerName, Integer.parseInt(intNum));
	}
	
	@Test
	@Parameters({"esb.conf.serviceActivityMonitorServer","esb.monitor.karafurl","esb.monitor.receivenewevents.consumer"})
	public void changeSamServerURL(String localServer, String karafUrl,String consumerName){
	    //go to configuration page 
	    this.clickWaitForElementPresent("idMenuConfigElement");
		  
	    this.mouseDownWaitForElementPresent("//div[contains(text(),'ESB')]");	   

		this.modifySAMServer(localServer, other.getString("esb.conf.ServiceActivityMonitorServerStatusIconLocator"));
		
	}
}
