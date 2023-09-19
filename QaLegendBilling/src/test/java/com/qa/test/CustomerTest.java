package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.page.CustomerPage;
import com.qa.page.LoginPage;
import com.qa.page.SupplierPage;
import com.qa.utility.FakerUtility;

public class CustomerTest extends BaseTest
{ 
	String customerName=FakerUtility.getRandom();
	
	@Test(priority=1,groups= {"smoke"})
	  public void verifyAddCustomer()
	  {
		  LoginPage lp=new LoginPage(driver);
		  lp.doLogin("admin", "123123");
		  
		  CustomerPage cp=new CustomerPage(driver); 
		  cp.clickContactLink();
		  cp.clickCustomerLink();
		  String actualMsg=cp.addCustomer(customerName,FakerUtility.getNumber(), "BPZ3456","45000", "3000", "25000","abcdef@gmail.com", "7736600496", "7507510264", "04872253567", "Thrissur", "Kerala", "India", "Near Stpauls","First", "Second", "Third", "Fourth");
          String expMsg="Contact added successfully";
	      Assert.assertEquals(actualMsg,expMsg);
	      
	      String actualMessage=cp.searchCustomer(customerName);
		  String expectedMessage=customerName;
		  System.out.println("Retreived text of verifyAddCustomer :"+actualMessage);
		  Assert.assertEquals(actualMessage,expectedMessage);
	      
	  }
	@Test(priority=2,groups= {"smoke"})
	  public void verifySearchCustomer()
	  {
		  LoginPage lp=new LoginPage(driver);
		  lp.doLogin("admin", "123123");
		  
		  CustomerPage cp=new CustomerPage(driver);
		  cp.clickContactLink();
		  cp.clickCustomerLink();
		  
		  String actualMsg=cp.searchCustomer(customerName);
		  
		  String expectedMsg=customerName;
		  Assert.assertEquals(actualMsg,expectedMsg);
	  }
	  @Test(priority=3,groups= {"regression"})
	  public void verifyViewCustomer()
	  {
		  LoginPage lp=new LoginPage(driver);
		  lp.doLogin("admin", "123123");
		  
		  CustomerPage cp=new CustomerPage(driver);
		  cp.clickContactLink();
		  cp.clickCustomerLink();
		  cp.searchCustomer(customerName);
		  String  actualMsg=cp.viewCustomer();
		  
		  String expectedMsg="View Contact";
	      Assert.assertEquals(actualMsg, expectedMsg);
		  
	  }
	  @Test(priority=4,groups= {"regression"})
	  public void verifyEditCustomer()
	  {
		  LoginPage lp=new LoginPage(driver);
		  lp.doLogin("admin", "123123");
		  
		  CustomerPage cp=new CustomerPage(driver);
		  cp.clickContactLink();
		  cp.clickCustomerLink();
		  cp.searchCustomer(customerName);
		  String  actualMsg=cp.editCustomer("9746845755");
		  
		  String expectedMsg="9746845755";
		  Assert.assertEquals(actualMsg,expectedMsg);
		  
	  }
	  
	  @Test(priority=5,groups= {"smoke","regression"})
	  public void verifyDeleteCustomer()
	  {
		  LoginPage lp=new LoginPage(driver);
		  lp.doLogin("admin", "123123");
		  
		  CustomerPage cp=new CustomerPage(driver);
		  cp.clickContactLink();
		  cp.clickCustomerLink();
		  cp.searchCustomer(customerName);
		  String actualMsg=cp.deleteCustomer();
		  
		  String expectedMsg="This contact will be deleted";
	      Assert.assertEquals(actualMsg, expectedMsg);
	      
	      String actualMessage=cp.searchCustomer(customerName);
		  String expectedMessage=customerName;
		  System.out.println("Retreived text of verifyDeleteCustomer :"+actualMessage);
		  Assert.assertEquals(actualMessage,expectedMessage);
}
}
