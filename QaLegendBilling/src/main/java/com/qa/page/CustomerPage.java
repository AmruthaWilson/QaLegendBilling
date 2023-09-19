package com.qa.page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.utility.ElementUtility;
import com.qa.utility.WaitUtility;

public class CustomerPage 
{
WebDriver driver;

@FindBy(xpath="//*[text()='Contacts']")
WebElement  contacts;

@FindBy(xpath="//*[contains(text(),'Customers')]")
WebElement  customer;

@FindBy(xpath="//button[contains(@class,'primary btn-modal')]")
WebElement  add;

@FindBy(xpath="//select[@id='contact_type']")
WebElement contactType;

@FindBy(xpath="//input[@id='name']")
WebElement name;

@FindBy(xpath="//input[@id='contact_id']")
WebElement contactID ;

@FindBy(xpath="//input[@id='tax_number']")
WebElement taxNum;

@FindBy(xpath="//input[@id='opening_balance']")
WebElement openingBalance;

@FindBy(xpath="//input[@id='pay_term_number']")
WebElement payTerm;

@FindBy(xpath="//select[@id='customer_group_id']")
WebElement customerGroup;

@FindBy(xpath="//input[@id='credit_limit']")
WebElement creditLimit ;

@FindBy(xpath="//input[@id='email']")
WebElement email;

@FindBy(xpath="//input[@id='mobile']")
WebElement mobNum;

@FindBy(xpath="//input[@id='alternate_number']")
WebElement alternateNum;

@FindBy(xpath="//input[@id='landline']")
WebElement landlineNum;

@FindBy(xpath="//input[@id='city']")
WebElement  city ;

@FindBy(xpath="//input[@id='state']")
WebElement  state ;

@FindBy(xpath="//input[@id='country']")
WebElement country ;

@FindBy(xpath="//input[@id='landmark']")
WebElement landMark;

@FindBy(xpath="//input[@id='custom_field1']")
WebElement customField1 ;

@FindBy(xpath="//input[@id='custom_field2']")
WebElement customField2;

@FindBy(xpath="//input[@id='custom_field3']")
WebElement customField3 ;

@FindBy(xpath="//input[@id='custom_field4']")
WebElement customField4 ;

@FindBy(xpath="//button[text()='Save']")
WebElement save ;

@FindBy(xpath="//input[contains(@class,'form-control input-sm')]")
WebElement search ;

@FindBy(xpath="//table[@id='contact_table']//tbody//tr[1]//td[8]//button")
WebElement actions;

@FindBy(xpath="//table[@id='contact_table']//tbody//tr[1]//td[8]//a[contains(text(),' View')]")
WebElement view ;

@FindBy(xpath="//table[@id='contact_table']//tbody//tr[1]//td[8]//a[contains(text(),'Edit')]")
WebElement edit;

@FindBy(xpath="//button[text()='Update']")
WebElement update;

@FindBy(xpath="//table[@id='contact_table']//tbody//tr[1]//td[8]//a[contains(text(),'Delete')]")
WebElement delete;

@FindBy(xpath="//button[text()='OK']")
WebElement ok;

@FindBy(xpath="//*[text()='Contact added successfully']")
WebElement addMsg;

@FindBy(xpath="//table[@id='contact_table']//tbody//tr[1]//td[2]")
WebElement searchMsg;

@FindBy(xpath="//h1[text()='View Contact']")
WebElement viewMsg;

@FindBy(xpath="//table[@id='contact_table']//tbody//tr[1]//td[2]")
WebElement editMsg;

@FindBy(xpath="//div[text()='This contact will be deleted']")
WebElement deleteMsg;


@FindBy(xpath= "//table[@id='contact_table']//tbody//tr//td[2]")	 
List<WebElement>  contacttable;

String searchNamecolumn="2";
String editNamecolumn="5";


WaitUtility waitUtil;
ElementUtility elementUtil;
	
	public CustomerPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this );
		waitUtil=new WaitUtility(driver);
		elementUtil=new ElementUtility(driver);
	}
	public void clickContactLink()
	{
		waitUtil.waitForClick(contacts);
		elementUtil.click(contacts);
		  
	}
	public void clickCustomerLink()
	{
		 
		waitUtil.waitForClick(customer);
		elementUtil.click(customer);
		  
	}
	
	public String addCustomer(String name1,String contactid1,String taxnum1,String openingbalance1,String payterm1,String cl1,String email1,String mobnum1,String alternatenum1,String landlinenum1,String city1,String state1,String country1,String landmark1,String cf1,String cf2,String cf3,String cf4)
	{
		elementUtil.click(add);
		
		elementUtil.selectByIndex(contactType, 2);
		
		waitUtil.waitForVisibility(name);
		elementUtil.sendKeys(name, name1);
		elementUtil.sendKeys(contactID, contactid1);
		elementUtil.sendKeys(taxNum,taxnum1); 
		elementUtil.sendKeys(openingBalance,openingbalance1);
		elementUtil.sendKeys(payTerm,payterm1);
		elementUtil.selectByIndex(customerGroup, 4);
		elementUtil.sendKeys(creditLimit,cl1); 
		elementUtil.sendKeys(email,email1); 
		elementUtil.sendKeys(mobNum,mobnum1);  
		elementUtil.sendKeys(alternateNum,alternatenum1);
		elementUtil.sendKeys(landlineNum,landlinenum1); 
		elementUtil.sendKeys(city,city1); 
		elementUtil.sendKeys(state,state1); 
		elementUtil.sendKeys(country,country1); 
		elementUtil.sendKeys(landMark,landmark1);	
		elementUtil.sendKeys(customField1,cf1);
		elementUtil.sendKeys(customField2,cf2);
		elementUtil.sendKeys(customField3,cf3);
		elementUtil.sendKeys(customField4,cf4);
	    elementUtil.click(save);
		
		String actualMsg=elementUtil.getText(addMsg);
		System.out.println("Retreived text of verifyAddCustomer: "+actualMsg);
		 
		 if(actualMsg!=null) 
		 {
		 return  actualMsg;
		 }
		 else 
		 {
		 return null;
		 }
		 
	}
	
	public String searchCustomer(String searchName)
	{ 
		
		waitUtil.waitForClick(search);
	    elementUtil.sendKeys(search, searchName);
		
	    By locator=By.xpath("//table[@id='contact_table']//tbody//tr//td[contains(text(),'"+searchName+"')]");
		waitUtil.waitForVisibility(locator);
		List<WebElement> contacttable=driver.findElements(By.xpath("//table[@id='contact_table']//tbody//tr//td["+searchNamecolumn+"]"));
		waitUtil.waitForVisibility(contacttable);
		int row=elementUtil.getTableDataRowCount(contacttable, searchName);
		String actualMsg="";
		if(row!=0) {
			WebElement tableRow=driver.findElement(By.xpath("//table[@id='contact_table']//tbody//tr["+row+"]//td["+searchNamecolumn+"]"));
			actualMsg=tableRow.getText();
		}
		System.out.println("Retreived text of verifySearchCustomer: "+actualMsg);
		return actualMsg;
	}
	
	public String viewCustomer()
	{
		
		
		elementUtil.click(actions);
		elementUtil.click(view);
		
		String actualMsg=elementUtil.getText(viewMsg);
		System.out.println("Retreived text of verifyViewCustomer: "+actualMsg);
		return actualMsg;
	}
	
	public String editCustomer(String edited)
	{
	     elementUtil.click(actions);
	     waitUtil.waitForVisibility(edit);
	     elementUtil.click(edit);
	     elementUtil.clear(mobNum);
		 elementUtil.sendKeys(mobNum, edited);
		 waitUtil.waitForVisibility(update);
		 waitUtil.waitForClick(update);
	     elementUtil.click(update);
		 
	     By locator=By.xpath("//table[@id='contact_table']//tbody//tr//td[contains(text(),'"+edited+"')]");
			waitUtil.waitForVisibility(locator);
			List<WebElement> contacttable=driver.findElements(By.xpath("//table[@id='contact_table']//tbody//tr//td["+editNamecolumn+"]"));
			waitUtil.waitForVisibility(contacttable);
			int row=elementUtil.getTableDataRowCount(contacttable,edited);
			String actualMsg="";
			if(row!=0) {
				WebElement tableRow=driver.findElement(By.xpath("//table[@id='contact_table']//tbody//tr["+row+"]//td["+editNamecolumn+"]"));
				actualMsg=tableRow.getText();
			}
			System.out.println("Retreived text of verifyEditSupplier: "+actualMsg);
			return actualMsg;
	}
	
	public String deleteCustomer()
	{   
		
		elementUtil.click(actions);
		elementUtil.click(delete);
		elementUtil.click(ok);
		
		 String actualMsg=elementUtil.getText(deleteMsg);
		 System.out.println("Retreived text of verifyDeleteCustomer: "+actualMsg);
		 return actualMsg;
		
	}
		  
}
