package Pages;

import java.io.IOException;

public class LoginPage {

	//Test
	public Boolean LoginByEmail(String UserID, String Password, webLoading l_driver) throws IOException, InterruptedException{
		l_driver.webElementSend("signIn_Email", UserID);
		l_driver.webElementSend("signIn_Password", Password);
		l_driver.webElementClicknWait("signIn_Button");
		Boolean answer = l_driver.webElementIsText("asos_FirstName", "user_FirstName");
		return answer;
		
	}
	
}


