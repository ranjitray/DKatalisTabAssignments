package com.qa.Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.BaseClass.BaseClass;
import com.qa.Constant.Constants;
import com.qa.Pages.CheckOutPage;
import com.qa.Utils.Utils;

public class SuccessfulPaymentTest extends BaseClass {
	
	CheckOutPage chkOutPage;
	
	@BeforeSuite
	public void setup()
	{
		initialization();
		chkOutPage = new CheckOutPage();
	}
	public SuccessfulPaymentTest()
	{
		super();
	}
	
	@Test(priority=1,description="Validation of Successful Payment Transaction")
	public void SuccessfulPaymentTransaction() throws Exception
	{
		logger1 = extent.createTest("Verify Successful Transaction");
		chkOutPage.clickBuyButton();
		chkOutPage.clickCheckOutButton();
		chkOutPage.swithToIframeAndClickContinueButton();
		chkOutPage.ClickOnCreditCard();
		chkOutPage.SubmitSucessfullTransaction();
		Utils.captureScreenshot(driver, "Successfull Transaction");
		logger.info("Completed Successful transaction");
		
	}
	
	@Test(priority = 2, description = "Verify Transaction Success message")
	public void VerifySuccessMessage()
	{
		logger1 = extent.createTest("Verify Successful Transaction Message");
		String actualSuccessMsg = chkOutPage.SuccessMessageDispaly();
		Utils.captureScreenshot(driver,"Verify Success Message");
		assertEquals(actualSuccessMsg, Constants.SUCCESSMESSAGE);
		logger.info("Verified Success transaction message successfully");
		
		
	}
	
	@Test(priority=3, description = "Validation of failed Transaction")
	public void FailedPaymentTransaction() throws Exception
	{
		logger1 = extent.createTest("Verify Failed Transaction ");
		chkOutPage.clickBuyButton();
		logger.info("Successfully clicked on Buy Button");
		
		chkOutPage.clickCheckOutButton();
		
		chkOutPage.swithToIframeAndClickContinueButton();
		chkOutPage.ClickOnCreditCard();
		chkOutPage.SubmitFailedTransaction();
		
		logger.info("Completed failed tranaction!!");
	}
	
	@Test(priority = 4, description = "Verify failed transaction message")
	public void VerifyFailedTransactionMessage()
	{
		logger1 = extent.createTest("Verify Failed Transaction Message ");
		String actulaFailedMsg = chkOutPage.FailedTransactionMessage();
		Utils.captureScreenshot(driver,"Verify Faileds Message");
		assertEquals(actulaFailedMsg, Constants.FAILEDMESSAGE);
		logger.info("Verified failed transaction message successfully");
	}
	
	@Test(priority = 5, description = "Verify failed transaction message")
	public void VerifyFailedTransactionBankMessage()
	{
		logger1 = extent.createTest("Verify Failed transaction message");
		String actulaFailedBankMsg = chkOutPage.FailedTransactionBankMessage();
		Utils.captureScreenshot(driver,"Verify Failed Bank Message");
		assertEquals(actulaFailedBankMsg, Constants.FAILEDMESSAGEBANK);
		logger.info("verify Failed Transaction Message Successfully");
		logger.info("Verify Failed transaction message successfully");
	}
	
	
	
}
