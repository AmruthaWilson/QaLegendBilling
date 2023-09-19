package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.page.LoginPage;
import com.qa.page.SupplierPage;
import com.qa.utility.ElementUtility;
import com.qa.utility.FakerUtility;

public class SupplierTest extends BaseTest 
{
	String supplierName=FakerUtility.getRandom();
	
  @Test(priority=1,groups= {"smoke"})
  public void verifyAddSupplier()
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin(ElementUtility.getPropertyValue("username"), ElementUtility.getPropertyValue("password"));
	  
	  SupplierPage sp=new SupplierPage(driver);
	  sp.clickContactLink();
	  sp.clickSupplierLink();
	  String actualMsg=sp.addSupplier(supplierName,"Navya Bakers", FakerUtility.getNumber(),"BPZA3456", "450000", "10000", "bc@gmail.com", "7507510264", "9746845755", "04872252302", "Thrissur", "Kerala", "India", "Near Lake", "Custom1", "Custom2","Custom3", "Custom4");
	  String expMsg="Contact added successfully";
      Assert.assertEquals(actualMsg,expMsg);
      
	  String actualMessage=sp.searchSupplier(supplierName);
	  String expectedMessage=supplierName;
	  System.out.println("Retreived text of verifyAddSupplier :"+actualMessage);
	  Assert.assertEquals(actualMessage,expectedMessage);
     
  }
  @Test(priority=2,groups= {"regression"})
  public void verifySearchSupplier()
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin", "123123");
	  
	  SupplierPage sp=new SupplierPage(driver);
	  sp.clickContactLink();
	  sp.clickSupplierLink();
	 
	  String actualMsg=sp.searchSupplier(supplierName);
	  String expectedMsg=supplierName ;
      Assert.assertEquals(actualMsg,expectedMsg);
  }
  @Test(priority=3,groups= {"smoke","regression"})
  public void verifyViewSupplier()
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin", "123123");
	 
	  SupplierPage sp=new SupplierPage(driver);
	  sp.clickContactLink();
	  sp.clickSupplierLink();
	  sp.searchSupplier(supplierName);
	  String actualMsg=sp.viewSupplier();
	  
	  String expectedMsg="View Contact";
      Assert.assertEquals(actualMsg, expectedMsg);
	  
  }
  @Test(priority=4,groups= {"regression"})
  public void verifyEditSupplier()
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin", "123123");
	  
	  SupplierPage sp=new SupplierPage(driver);
	  sp.clickContactLink();
	  sp.clickSupplierLink();
	  sp.searchSupplier(supplierName);
	  String actualMsg=sp.editSupplier("Mango Bakers");
	  
	  String expectedMsg="Mango Bakers";
      Assert.assertEquals(actualMsg,expectedMsg );
	  
  }
  @Test(priority=5,groups= {"smoke"})
  public void verifyDeleteSupplier()
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin", "123123");
	  
	  SupplierPage sp=new SupplierPage(driver);
	  sp.clickContactLink();
	  sp.clickSupplierLink();
	  sp.searchSupplier(supplierName);
	  String actualMsg=sp.deleteSupplier();
	  
	  String expectedMsg="This contact will be deleted";
      Assert.assertEquals(actualMsg, expectedMsg);
	  
      String actualMessage=sp.searchSupplier(supplierName);
	  String expectedMessage=supplierName;
	  System.out.println("Retreived text of verifyDeleteSupplier :"+actualMessage);
	  Assert.assertEquals(actualMessage,expectedMessage);
  }
}