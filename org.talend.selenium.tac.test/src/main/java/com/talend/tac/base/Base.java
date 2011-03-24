package com.talend.tac.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class Base {
	public Selenium selenium;

	public Locale currentLocale = new Locale("en", "US");	// set the locale that you want to test
	public ResourceBundle rb = ResourceBundle.getBundle("messages", currentLocale);
	
	public ResourceBundle other = ResourceBundle.getBundle("other", currentLocale);

	public static String MID_SPEED = "3000";
	public static String MIN_SPEED = "0";
	public static String MAX_SPEED = "5000";
	public static int WAIT_TIME = 20;
	
	
	@BeforeClass
	@Parameters({"server", "port", "browser", "url", "language", "country", "root"})
	public void initSelenium(String server, String port, String browser, String url, String language, String country, String root) {
		server = this.setDefaultValue(server, "localhost");
		port = this.setDefaultValue(port, 4444+"");
		browser = this.setDefaultValue(browser, "*firefox");
		url = this.setDefaultValue(url, "http://localhost:8080/");
		root = this.setDefaultValue(root, "/org.talend.administrator/");
		
		language = this.setDefaultValue(language, "en");
		country = this.setDefaultValue(country, "US");
		currentLocale = new Locale(language, country);
		rb = ResourceBundle.getBundle("messages", currentLocale);
		
System.out.println("Server: " + server + ", port: " + port + ", broser: " + browser + ", " + url);
System.out.println("language: " + language + ", country: " + country);
		selenium = new DefaultSelenium(server, Integer.parseInt(port), browser, url);  //4444 is default server port

		selenium.start();
		selenium.open(root);
	}
	public String setDefaultValue(String variable, String value) {
		String setValue = variable;
		if("".equals(variable) || variable == null) {
			setValue = value;
		}
		return setValue;
	}
	
	public String getString(String key, String[] params) {
		String value = rb.getString(key);
		
		for(int i=0; i<params.length; i++) {
			Pattern pattern = Pattern.compile(".*{"+ i +"}.*");
			Matcher matcher = pattern.matcher(value);
			if(matcher.matches()) {
				value = value.replace("{"+ i +"}", params[i]);
			}
//System.out.println(value);
		}
		return value;
	}
	
	public String getString(String key, String param) {
		if("".equals(param) || param == null) {
			return rb.getString(key);
		} else {
			return this.getString(key, new String[]{param});
		}
		
	}
	
	public void waitForElementPresent(String locator, int seconds) {
		for (int second = 0;; second++) {
			if (second >= seconds)
				org.testng.Assert.fail("wait for element "+ locator + " to be present,time out");
			try {
				if (selenium.isElementPresent(locator))
					break;
			} catch (Exception e) {
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void clickWaitForElementPresent(String locator) {
		this.waitForElementPresent(locator, Base.WAIT_TIME);
		selenium.click(locator);
	}
	
	
	/**
	 * find the first String which match regex
	 * 
	 * @param regex
	 * @return
	 */
	public String findSpecialMachedString(String regex) 
	{
		String findedString = "";
		String[] texts;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher;

		String text = selenium.getBodyText();
		texts = text.split("\n");
		for (int i = 0; i < texts.length - 1; i++) {
// System.out.println("text " + i +": " + texts[i]);
			matcher = pattern.matcher(texts[i].trim());
			if (matcher.matches()) {
				findedString = texts[i].trim();
				break;
// System.out.println(texts[i].trim());
			}
		}
		return findedString;
	}
	
	/**
	 * find the first String which match regex
	 * 
	 * @param regex
	 * @return
	 */
	public List<String> findSpecialMachedStrings(String regex) 
	{
		List<String> strs = new ArrayList<String>();
		String findedString = "";
		String[] texts;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher;

		String text = selenium.getBodyText();
//System.out.println(text);
		texts = text.split("\n");
		for (int i = 0; i < texts.length - 1; i++) {
// System.out.println("text " + i +": " + texts[i]);
			matcher = pattern.matcher(texts[i].trim());
			if (matcher.matches()) {
				findedString = texts[i].trim();
				strs.add(findedString);
//System.out.println(texts[i].trim());
				continue;
			}
		}
		return strs;
	}
	
	public void typeString(String xpath, String value) {
		selenium.click(xpath);
		selenium.type(xpath, value);
		selenium.fireEvent(xpath, "blur");
	}
}