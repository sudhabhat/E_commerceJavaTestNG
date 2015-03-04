package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.webLoading;

public class T006_Footer_Newsletter {
 
public webLoading f_User = new webLoading();
 
@BeforeTest
public void before_Run() throws InterruptedException, IOException{
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
	System.out.println("inside assert footer start");
	Assert.assertTrue(f_User.webElementDisplayed("foot_NewsLetter"));
	Assert.assertTrue(f_User.webElementDisplayed("foot_SignUp"));
	Assert.assertTrue(f_User.webElementDisplayednEnable("foot_EmailID"));
	Assert.assertTrue(f_User.webElementDisplayednEnable("foot_Women"));
	Assert.assertTrue(f_User.webElementDisplayednEnable("foot_Men"));
	System.out.println("inside assert footer end");
}


}
