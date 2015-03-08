package Pages;

import java.io.IOException;

public class LoginPage {
	GetPropertyValues prop = new GetPropertyValues();
	/**
	 * Performs existing user login functionality (when email option is
	 * selected) > Accepts Userid, password and the driver > Verifies the user
	 * login is successful by checking the user firstname after login
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void LoginByEmail(String UserID, String Password,
			webLoading l_driver) throws IOException, InterruptedException {
		l_driver.webElementSend("signIn_Email", UserID);
		l_driver.webElementSend("signIn_Password", Password);
		l_driver.webElementClicknWait("signIn_Button");

	}
	
	public void LoginByEmail(webLoading l_driver) throws IOException, InterruptedException {
		l_driver.webElementSend("signIn_Email",prop.getPropValue("user_EmailId"));
		l_driver.webElementSend("signIn_Password", prop.getPropValue("user_Password"));
		l_driver.webElementClicknWait("signIn_Button");
	}

}
