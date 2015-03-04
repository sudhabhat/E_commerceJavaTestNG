package Pages;

import java.io.IOException;

public class LoginPage {


/**
 * Performs existing user login functionality (when email option is selected)
 * > Accepts Userid, password and the driver
 * > Verifies the user login is successful by checking the user firstname after login 
 * @return returns a boolean true or false on the success of the Login
 * @throws IOException
 * @throws InterruptedException
 */
	public Boolean LoginByEmail(String UserID, String Password, webLoading l_driver) throws IOException, InterruptedException{
		l_driver.webElementSend("signIn_Email", UserID);
		l_driver.webElementSend("signIn_Password", Password);
		l_driver.webElementClicknWait("signIn_Button");
		Boolean answer = l_driver.webElementIsText("asos_FirstName", "user_FirstName");
		return answer;
		
	}
	
}


