package com.qa.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.BaseClass.BaseClass;
import com.qa.Utils.Utils;

public class CheckOutPage extends BaseClass{
	
	

	@FindBy(xpath="//a[@class='btn buy']")
	WebElement BuyButton;
	
	@FindBy(xpath=" //div[@class='cart-checkout']")
	WebElement CheckOut;
	
	@FindBy(xpath="//iframe[@id='snap-midtrans']")
	WebElement iFrame;

	@FindBy(xpath="//a[@class='button-main-content']")
	WebElement ContinueButton;
	
	@FindBy(xpath="//div[@class='list-title text-actionable-bold'][contains(text(),'Credit Card')]")
	WebElement CreditCard;
	
	@FindBy(xpath="//input[@name='cardnumber']")
	WebElement CreditCardNumber;
	
	@FindBy(xpath="//input[@type='tel'][@placeholder='MM / YY']")
	WebElement ExpiryDate;
	
	@FindBy(xpath="//input[@type='tel'][@placeholder='123'][@inputmode='numeric']")
	WebElement CVV;
	
	@FindBy(xpath="//a[@class='button-main-content']")
	WebElement PayNow;
	
	@FindBy(xpath="//iframe[@src='https://api.sandbox.veritrans.co.id/v2/token/rba/redirect/481111-1114-00655475-964b-41bd-87f2-4dfcb74227f1']")
	WebElement iFramePass;

	@FindBy(xpath="//input[@id='PaRes']")
	WebElement Password;
	
	@FindBy(xpath="//button[@class='btn btn-sm btn-success']")
	WebElement OK;
	
	@FindBy(css="class.text-bold")
	WebElement SuccessMsg;
	
	
	@FindBy(xpath="//span[@data-reactid='.0.0.0.2.0.1.0.0:0']")
	WebElement SuccessThankYouMsg;
	
//	@FindBy(xpath="//div[@class='text-failed text-bold'][@span=(contains(text(),'Transaction failed'))]")
//	WebElement TransactionFailedMsg1;
//	
//	@FindBy(xpath="//div[@class='text-failed'][@span=(contains(text(),'Your card got declined by the bank'))]")
//	WebElement TransactionFailedMsg2;
	
	@FindBy(xpath="//a[@class='button-main-content']")
	WebElement RetryButton;
	
	@FindBy(xpath="//div[@class='text-failed text-bold']//span")
	WebElement FailedTransaction;
	
	@FindBy(xpath="//div[@class='text-failed']//span")
	WebElement FailedTransactionBank;
	
	
	public CheckOutPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickBuyButton() 
	{
		BuyButton.click();
	}
	public void clickCheckOutButton() 
	{
		Utils.explicitlyWait(driver, CheckOut);
		CheckOut.click();
	}
	
	public void swithToIframeAndClickContinueButton() throws Exception
	{
		
		driver.switchTo().frame(iFrame);
		Utils.explicitlyWait(driver, ContinueButton);
		ContinueButton.click();
		
	}
	
	public void ClickOnCreditCard() 
	{
		CreditCard.click();
	}
	
	
	
	
	public void SubmitSucessfullTransaction()
	{
		
		CreditCardNumber.sendKeys(prop.getProperty("CardNumber_Success"));
		ExpiryDate.sendKeys(prop.getProperty("ExpiryDate"));
		CVV.sendKeys(prop.getProperty("CVV"));
		PayNow.click();
		driver.switchTo().frame(0);
		Utils.explicitlyWait(driver, Password);
		Password.sendKeys(prop.getProperty("OTP"));
		Utils.explicitlyWait(driver, OK);
		OK.click();
		driver.switchTo().defaultContent();
//		driver.switchTo().parentFrame();
//		Utils.explicitlyWait(driver, SuccessMsg);
//		System.out.println("Transaction Message: "+ SuccessMsg.getText());
		System.out.println("Success Message: "+ SuccessThankYouMsg.getText());
		
	}
	
	public String SuccessMessageDispaly()
	{
		return SuccessThankYouMsg.getText();
	}
	
	public String FailedTransactionMessage()
	{
		return FailedTransaction.getText();
	}
	
	public String FailedTransactionBankMessage() 
	{
		return FailedTransactionBank.getText();
		
	}
	
	public void SubmitFailedTransaction()
	{
		
		CreditCardNumber.sendKeys(prop.getProperty("CardNumber_Failed"));
		ExpiryDate.sendKeys(prop.getProperty("ExpiryDate"));
		CVV.sendKeys(prop.getProperty("CVV"));
		PayNow.click();
		driver.switchTo().frame(0);
		Utils.explicitlyWait(driver, Password);
		Password.sendKeys(prop.getProperty("OTP"));
		Utils.explicitlyWait(driver, OK);
		OK.click();
		driver.switchTo().defaultContent();
		Utils.explicitlyWait(driver, iFrame);
		driver.switchTo().frame(iFrame);
		
	}
	
}
