package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.webLoading;


public class T004_Assert_TextLinks_HomePage {

		webLoading a_link = new webLoading();
	@BeforeTest
	public void before_Run() throws InterruptedException, IOException{
		a_link.start("asos_Home");
	}

	@AfterClass
	public void after_Run() throws InterruptedException, IOException{
		a_link.quit();
	}


/**
 * Test to assert the header links on homepage
 * 1) user navigates to the home page
 * 2) asserts the links/tabs on the header are clickable
 * @throws IOException
 * @throws InterruptedException
 */
	@Test
	public void assert_Header_HomePage() throws IOException, InterruptedException{
		Boolean expected = true;
		a_link.assertTest(a_link.webElementIsLink("home_Signin"), expected);
		a_link.assertTest(a_link.webElementIsLink("home_Header_Asos"), expected);
		a_link.assertTest(a_link.webElementIsLink("home_Header_Boutiques"), expected);
		a_link.assertTest(a_link.webElementIsLink("home_Header_Outfit"), expected);
		
	}
	
}
