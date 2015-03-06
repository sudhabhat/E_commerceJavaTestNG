package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.webLoading;

public class T006_Footer_Newsletter {
 
public webLoading f_User;
 
@BeforeTest
public void before_Run() throws InterruptedException, IOException{
	f_User = new webLoading();
	f_User.start("asos_Home");
}

@AfterClass
public void after_Run() throws InterruptedException, IOException{
	f_User.quit();
}

/**
 * new test to assert the footer newsletter section
 * 1) footer newsletter is displayed
 * 2) signup element is displayed 
 * 3) emailid, women, men elements are displayed and enabled
 * @throws IOException
 * @throws InterruptedException
 */
@Test
public void assert_Footer_Newsletter() throws IOException, InterruptedException{
	f_User.assertTest(f_User.webElementDisplayed("foot_NewsLetter"));
	f_User.assertTest(f_User.webElementDisplayed("foot_SignUp"));
	f_User.assertTest(f_User.webElementDisplayednEnable("foot_EmailID"));
	f_User.assertTest(f_User.webElementDisplayednEnable("foot_Women"));
	f_User.assertTest(f_User.webElementDisplayednEnable("foot_Men"));
}


}
