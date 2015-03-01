package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Util.webLoading;

public class T002_New_User_Login {

	webLoading n_User = new webLoading();
	
	@BeforeTest
	public void before_Run() throws InterruptedException, IOException{
	System.out.println("Before T002 start");
	n_User.start("asos_Home");
	System.out.println("after T002 start");
}

@AfterClass
public void after_Run() throws InterruptedException, IOException{
	n_User.quit();
}

@Test
public void new_User_Login_Email() throws IOException, InterruptedException{
	Thread.sleep(4000);
	n_User.webFindElementByXpath("home_Join").click();
	Thread.sleep(4000);
	n_User.webFindElementByXpath("joinAsos_EmailIcon").click();
	n_User.webElementSend("joinAsos_EmailId", "hd@adb.com");
	n_User.webElementSend("joinAsos_FirstName", "asdf");
	n_User.webElementSend("joinAsos_LastName", "dfdf");
	n_User.webElementSend("joinAsos_Password", "London15");
	n_User.webElementDropDown("joinAsos_DOBDD","4");
	n_User.webElementDropDown("joinAsos_DOBMM", "August");
	n_User.webElementDropDown("joinAsos_DOBYY", "1980");
	n_User.webFindElementByXpath("joinAsos_SignDiscount").click();
	n_User.webFindElementByXpath("joinAsos_SendUpdates").click();
	n_User.webFindElementByXpath("joinAsos_RegisterButton").click();
}
}