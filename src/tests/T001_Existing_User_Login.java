package tests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.webLoading;

public class T001_Existing_User_Login {
	public webLoading e_User;
	public LoginPage lPage;

	@BeforeTest
	public void before_Run() throws InterruptedException, IOException {
		e_User = new webLoading();
		lPage = new LoginPage();
		e_User.start("asos_Home");

	}

	@AfterTest
	public void after_Run() throws InterruptedException, IOException {
		e_User.quit();
	}

	/**
	 * Test to assert the login functionality of an existing user 1) user
	 * navigates to the sign in page (email option) 2) successfully logs in 3)
	 * assert the login is successful
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Parameters({ "email-id", "pass-word" })
	@Test
	public void existing_User_SignUp(String Emailid, String Password)
			throws IOException, InterruptedException {
		e_User.webElementClicknWait("home_Signin");
		e_User.assertTest(lPage.LoginByEmail(Emailid, Password, e_User));
	}

}
