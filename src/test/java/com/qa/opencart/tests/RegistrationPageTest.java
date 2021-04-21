package com.qa.opencart.tests;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest{
	
	@BeforeClass
	public void setupRegister() {
		registrationPage =	loginPage.navigateToRegisterPage();
	}
	
	
	public String Email = getRandomEmail();

//	public  String randomString() {
//		
//		String generatedString = RandomStringUtils.randomAlphabetic(8);
//		
//		return generatedString;
//	}
//	
//	
//	public static String randomNum() {
//		String generatedString2 = RandomStringUtils.randomNumeric(4);
//		return generatedString2;
//	}
//	
	
	public String getRandomEmail() {
		String generatedAlphabets = RandomStringUtils.randomAlphabetic(8);
		String generatedNumbers = RandomStringUtils.randomNumeric(4);
		String email = generatedAlphabets+generatedNumbers+"@gmail.com";
		return email;

	}
	
	
	
	@DataProvider
	public Object[][] getRegisterData() {
	Object regData[][] =	ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return regData;
	}
	
	
	@Test(dataProvider = "getRegisterData")
	public void userRegistrationTest(String firstName, String lastName,String telephone, String password, String subscribe) {
		
	//Assert.assertTrue(registrationPage.accountRegistration("Tony123", "Jo123", "tony12233@gmail.com", "1233122312", "tony123@123", "yes"));
	
		String email = getRandomEmail();
		Assert.assertTrue(registrationPage.accountRegistration(firstName, lastName, email, telephone, password, subscribe));
		System.out.println(email);
		
		
	}
	
	
	
}
	