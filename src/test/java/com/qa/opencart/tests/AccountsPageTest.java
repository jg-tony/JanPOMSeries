package com.qa.opencart.tests;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.Error;
	
public class AccountsPageTest extends BaseTest{
	
		
	@BeforeClass
	public void acctPageSetup() {
	accPage=loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		
	}
	
	
	@Test
	public void acctPageTitleTest() {
	String title =	accPage.getAccPageTitle();
	System.out.println("Accounts page title is : " + title);
		Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE, Error.ACC_PAGE_TITLE_ERROR);
		
		//comments
		
		
	}
	
	@Test
	public void accPageHeaderTest() {
	String header = accPage.getAccountPageHeader();
	System.out.println("acc page header is : " + header);
	Assert.assertEquals(header, Constants.ACCOUNTS_PAGE_HEADER, Error.ACC_PAGE_HEADER_ERROR);
	
	}
	
	@Test
	public void accSectionsListTest() {
	List<String> secList =	accPage.getAccountsSectionsList();
	secList.stream().forEach(e -> System.out.println(e));
	Collections.sort(Constants.ExP_ACC_SEC_LIST);
	
	Assert.assertEquals(secList, Constants.ExP_ACC_SEC_LIST);
	
	}
	
	
	@Test
	public void logoutLinkTest() {
		Assert.assertTrue(accPage.isLogoutExist(), Error.LOGOUT_LINK_NOT_PRESENT);
	}
	

}
