package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {
	
	private WebDriver driver;
	
	private ElementUtil elementUtil;
	
	//1 . By locators:
	
	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@type='submit']");
	private By forgotPwdLink = By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']");
	private By registerLink = By.linkText("Register");
	
	  private By loginErrorMessg = By.cssSelector("div.alert.alert-danger.alert-dismissible");
	
	//2. constructors of the page.
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		
		
	}
	
	
	// 3.Page  Actions (methods)	
	@Step("getting login pate title")
	public String getLoginPageTitle() {
	  return elementUtil.waitForTitle(5, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Step("getting login url title")
	public String getLoginPageUrl() {
		return elementUtil.getPageUrl();
	}
	
	@Step("getting forgot pwd is exit")
	public boolean isForgotPwdLinkExist() {
	//return driver.findElement(forgotPwdLink).isDisplayed();
		
		return elementUtil.doIsDisplayed(forgotPwdLink);
	}
	
	@Step("login with username: {0} and password {1}" )
	public AccountsPage doLogin(String un, String pwd) {
//		driver.findElement(username).sendKeys(un);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginButton).click();
//		
		elementUtil.doSendKeys(username, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		
		return new AccountsPage(driver);
		
		
	}
	
	@Step("login with username : {0} and password : {1}")
	public boolean doLoginWrongData(String un, String pwd) {
		elementUtil.doSendKeys(username, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		return elementUtil.doIsDisplayed(loginErrorMessg);
	}
		
	
	
	
	
	
	
	@Step("Naigating to the registration page.")
	public RegistrationPage navigateToRegisterPage() {
		elementUtil.doClick(registerLink);
		return new RegistrationPage(driver);
	}
	
	
	
	
	

}
