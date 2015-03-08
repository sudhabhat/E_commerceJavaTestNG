package tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.webLoading;

public class T005_LoginPage {
	public webLoading e_User;
	public LoginPage lPage;
	static Logger log = Logger.getLogger(T005_LoginPage.class.getName());
		
	@BeforeMethod
	public void before_Run() throws InterruptedException, IOException {
		e_User = new webLoading();
		lPage = new LoginPage();
		e_User.start("asos_Home");
	}

	@AfterMethod
	public void after_Run() throws InterruptedException, IOException {
		e_User.quit();
	}
	
	
	// This method will provide data to any test method that declares that its
	// Data Provider
	// is named "test1"
	@DataProvider(name = "test1")
	public Object[][] createData1() {
		return new Object[][] { { "tim.hong@sdfd.com", "testing12", true},
				{ "tim.hong@sdf1d.com", "testing12", false } };
	}

	/**
	 * Test to assert the login functionality of an existing user 1) user
	 * navigates to the sign in page (email option) 2) successfully logs in 3)
	 * assert the login is successful
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "test1")
	public void existing_User_SignUp(String Emailid, String Password, Boolean expected)
			throws IOException, InterruptedException {
		e_User.webElementClicknWait("home_Signin");
		lPage.LoginByEmail(Emailid, Password, e_User);
		if (!expected)
		{
			e_User.assertTest(e_User.webElementDisplayed("signIn_Error_Block"));
			log.debug(expected+"in debug");
			log.info(expected+"in info");
			log.error(expected+"in error");
			
		}
		else
		{
			e_User.assertTest(e_User.webElementIsText("asos_FirstName",
					"user_FirstName"));
		}
		
	}

}
