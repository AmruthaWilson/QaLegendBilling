package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.constants.Constants;
import com.qa.page.LoginPage;
import com.qa.utility.ExcelRead;



public class LoginTest extends BaseTest
{
  @Test(priority=1,groups= {"smoke"},dataProvider = "userData",retryAnalyzer = generalTests.Retry.class)
  public void verifyLoginPage(String username,String password)
  {
	  LoginPage lp=new LoginPage(driver);
	  String actualMsg=lp.doLogin(username,password);
	  
	  String expectedMsg="Welcome admin,";
	  Assert.assertEquals(actualMsg, expectedMsg);
	  
  }
  @DataProvider
  public Object[][] userData() throws Exception
  {

		Object[][] data=ExcelRead.getDataFromExcel(Constants.testData,"loginData");
	    return data;
  }
}
