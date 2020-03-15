package com.qa.Constant;

public class Constants {
	public static final String EXTENTREPORTPATH=System.getProperty("user.dir")+"\\ExtentReports\\index.html"; 
	public static final long PAGE_LOAD_TIMEOUT = 30;
	public static final Integer IMPLICIT_WAIT=20;
	public static final Integer EXPLICIT_WAIT=20;
	public static final String SCREENSHOTPATH=System.getProperty("user.dir")+"\\Screenshots";
	public static final String CHROMEDRIVERPATH = System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe";
	
	public static final String SUCCESSMESSAGE ="Thank you for your purchase.";
	public static final String FAILEDMESSAGE="Transaction failed";
	public static final String FAILEDMESSAGEBANK="Your card got declined by the bank";

}
