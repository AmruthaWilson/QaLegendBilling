package com.qa.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utility.ElementUtility;
import com.qa.utility.WaitUtility;

public class LoginPage
{
WebDriver driver;


@FindBy(name="username") 
WebElement userName;

//@FindBy(locator="value")
//WebElement elementname

@FindBy(name="password")
WebElement passWord;
	
@FindBy(name="remember")
List<WebElement> checkBox;

@FindBy(className="btn-primary")
WebElement login;

@FindBy(xpath="//button[@class='btn btn-default btn-sm']")
WebElement  endTour;

@FindBy(xpath="//h1[text()]")
WebElement successMsg;

WaitUtility waitUtil;
ElementUtility elementUtil;
	

	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this );//initiaze webelements declared using @FindBY
		waitUtil=new WaitUtility(driver);
		elementUtil=new ElementUtility(driver);
		
	}
public String doLogin(String username,String password)
{
	elementUtil.sendKeys(userName, username);
	elementUtil.sendKeys(passWord, password);  
	elementUtil.click(checkBox, 0);
    elementUtil.click(login); 
    elementUtil.click(endTour); 
	    
	String actualMsg=elementUtil.getText(successMsg);
    return actualMsg; 
	
}
}
