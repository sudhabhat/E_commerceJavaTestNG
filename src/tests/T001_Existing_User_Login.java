package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert.*;

import Util.LoginPage;
import Util.webLoading;

public class T001_Existing_User_Login {
 public webLoading e_User;
 public LoginPage lPage ;
 
@BeforeTest
public void before_Run() throws InterruptedException, IOException{
	 e_User = new webLoading();
	 lPage = new LoginPage();
	e_User.start("asos_Home");
	
}

@AfterClass
public void after_Run() throws InterruptedException, IOException{
	e_User.quit();
}

@Test
public void existing_User_SignUp() throws IOException, InterruptedException{
	//before_Run();
	e_User.webElementClicknWait("home_Signin");
	Assert.assertTrue(lPage.LoginByEmail("tim.hong@sdfd.com", "testing12", e_User));
}


}
