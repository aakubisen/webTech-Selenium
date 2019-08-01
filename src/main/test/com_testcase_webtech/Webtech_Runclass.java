package com_testcase_webtech;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_base_webtech.Webtech_Baseclass;

import webtech_search_Pages.webtech_etsy;

public class Webtech_Runclass extends Webtech_Baseclass {

	webtech_etsy web;

	@Test(priority =1)
	public void browseropen() {

		browser_initialization();
		web = new webtech_etsy();

	}

	@Test(priority =2)

	public void getquotepagedataTest() {

		web.searchresult();

	}

	@Test(priority =3)

	public void searchresultTest() {

		web.searchresultname();
	}

	@Test(priority =4)

	public void browserclose() {

		driver.quit();
	}

}
