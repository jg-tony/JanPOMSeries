package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;

public class ProductInfoTest extends BaseTest{

	SoftAssert SoftAssert = new SoftAssert();
	
	@BeforeClass
	public void productInfoSetUp() {
	accPage = 	loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@DataProvider
	public Object[][] searchData() {
		return new Object[][] {{"Macbook"}, {"iMac"}, {"iPhone"}};
	}
	
	
	@Test(dataProvider = "searchData")
	public void ProductCountTest(String productName) {
		searchResultPage=	accPage.doSearch(productName);
	Assert.assertTrue(searchResultPage.getProductResultsCount()>0);
	}
	
	@Test(enabled = false)
	public void productInfoTest() {
		searchResultPage=	accPage.doSearch("iMac");
		productInfoPage =searchResultPage.selectProductFromResults("iMac");
		Assert.assertEquals(productInfoPage.getProductHeaderText(), "iMac");
		
	}
	
	
	@Test(enabled = false)
	public void prodcutImagesTest() {
		searchResultPage=	accPage.doSearch("Macbook");
		productInfoPage =searchResultPage.selectProductFromResults("MacBook Pro");
		Assert.assertTrue(productInfoPage.getProdcutImagesCount() ==4);
		
	}
	
	@Test(enabled = false)
	public void getProductInfoTest() {
		searchResultPage=	accPage.doSearch("Macbook");
		productInfoPage = searchResultPage.selectProductFromResults("MacBook Pro");
		
	Map<String, String> actProductMetaData =	productInfoPage.getProductInformation();
	actProductMetaData.forEach((k,v)-> System.out.println(k +" : " + v)) ;

		
		
	}
	
	@Test(enabled = false)
	public void addToCartTest() {
		
		
	}

}
