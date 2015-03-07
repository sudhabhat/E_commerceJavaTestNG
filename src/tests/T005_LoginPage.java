package tests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.webLoading;

public class T005_LoginPage {
	public webLoading e_User;
	public LoginPage lPage;

	// This method will provide data to any test method that declares that its
	// Data Provider
	// is named "test1"
	@DataProvider(name = "test1")
	public Object[][] createData1() {
		return new Object[][] { { "tim.hong@sdfd.com", "testing12" },
				{ "tim.hong@sdf1d.com", "testing12" }, };
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
	public void existing_User_SignUp(String Emailid, String Password)
			throws IOException, InterruptedException {
		e_User = new webLoading();
		lPage = new LoginPage();
		e_User.start("asos_Home");
		System.out.println("in test annotation class");
		e_User.webElementClicknWait("home_Signin");
		e_User.assertTest(lPage.LoginByEmail(Emailid, Password, e_User));
		System.out.println("after test annotation class");
		e_User.quit();
	}

}
