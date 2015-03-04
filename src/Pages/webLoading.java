package Pages;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import Pages.GetPropertyValues;
import Pages.webLoading;
import static org.testng.Assert.assertEquals;

public class webLoading {
	public WebDriver a_Driver;
	public Boolean Element_Displayed;
	public Boolean Element_Enabled;
	public WebElement Element_Name;
	public Boolean Element_SendKey;
	public String Element_Text;
	public String browserUsage;
	
	GetPropertyValues properties = new GetPropertyValues();
	
	public webLoading(){
		Properties sysProps = System.getProperties();
		browserUsage = sysProps.getProperty("brows");
		int browser_value = Integer.parseInt(browserUsage);
		switch (browser_value) {	
		case 1:
			a_Driver= new FirefoxDriver();
			break;
		case 2:
			System.setProperty("webdriver.chrome.driver", "E:\\SudhaDev\\Java\\chromedriver.exe");
			a_Driver = new ChromeDriver();
			break;
		case 3:
			a_Driver = new InternetExplorerDriver();
			break;
		default:
			break;
		}
		a_Driver.manage().deleteAllCookies();
		 
	}
	
	public  void start(String webPage) throws InterruptedException, IOException {	
		a_Driver.get(properties.getPropValue(webPage));
		Thread.sleep(3000);	
		a_Driver.manage().window().maximize();
		webElementDisplayed("asos_Cookie");
		webElementClick("asos_CookieOK");		
		System.out.println("Currently in " + a_Driver.getTitle() + " Page");

	}
	
	public  void quit() throws InterruptedException, IOException {
		//System.out.println("quit the webpage");
		a_Driver.quit();
//		System.out.println("after web page quit");
//		Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
//		Thread.sleep(5000);
//		Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
//		Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");
	} 
	
	public WebElement webFindElementByXpath(String Element) throws IOException{
		Element_Name = a_Driver.findElement(By.xpath(properties.getPropValue(Element)));
		return Element_Name;
	}
	
	public Boolean webElementDisplayed (WebElement web_Displayed){
		Element_Displayed = web_Displayed.isDisplayed();
		return Element_Displayed;
	}
	public Boolean webElementDisplayed (String xpath) throws IOException{
		Element_Displayed = webFindElementByXpath(xpath).isDisplayed();
		return Element_Displayed;
	}
	
	public Boolean webElementDisplayednEnable (String xpath) throws IOException{
		Element_Displayed = webFindElementByXpath(xpath).isDisplayed();
		if (Element_Displayed.TRUE) {
			Element_Displayed = webFindElementByXpath(xpath).isEnabled();
		}
	
		return Element_Displayed;
	}

	public Boolean webElementEnabled (WebElement web_Enabled){
		Element_Enabled = web_Enabled.isEnabled();
		return Element_Enabled;
	}
	
	public Boolean webElementDisplayXpath (String dElement) throws IOException{
		Element_Name = a_Driver.findElement(By.xpath(properties.getPropValue(dElement)));
		Element_Displayed = Element_Name.isDisplayed();
		return Element_Displayed;
	}
	
	public Boolean webElementEnableXpath (String eElement) throws IOException{
		Element_Name = a_Driver.findElement(By.xpath(properties.getPropValue(eElement)));
		Element_Displayed = Element_Name.isDisplayed();
		return Element_Displayed;
	}
	
	public void webElementClick (String cElement) throws IOException{
		a_Driver.findElement(By.xpath(properties.getPropValue(cElement))).click();
	}
	
	/**
	  * Clicks the link and waits for 3 sec
	  * <p>
	  * <i><b>element</b> type is string</i>
	  * 
	  * @author Sudha Rani
	  * @param element
	  *        name of the xpath from config.properties file
	  * @return None
	  * @throws Throwable
	  */
	public void webElementClicknWait (String cwElement) throws IOException, InterruptedException{
		a_Driver.findElement(By.xpath(properties.getPropValue(cwElement))).click();
		Thread.sleep(3000);
	}
	
	/**
	  * Checks for the presence of text link
	  * <p>
	  * <i><b>element</b> type is string</i>
	  * 
	  * @author Sudha Rani
	  * @param element
	  *        name of the xpath from config.properties file
	  * @return Returns true or false based on the presence of the element
	  * @throws Throwable
	  */
	
	public Boolean webElementIsLink (String iElement) throws IOException {
		Element_Text = a_Driver.findElement(By.xpath(properties.getPropValue(iElement))).getText();
		try{
		a_Driver.findElement(By.linkText(Element_Text));
		}
		catch (NoSuchElementException e) {
			return false;
		}
			return true;
	}
	public void webElementSend (String sElement, String value) throws IOException{
		a_Driver.findElement(By.xpath(properties.getPropValue(sElement))).sendKeys(value);
	}
	
	public void webElementDropDown (String pElement, String value) throws IOException{	
		Select user_Dropdown = new Select(a_Driver.findElement(By.xpath(properties.getPropValue(pElement))));
		user_Dropdown.selectByVisibleText(value);
	}
	
	public Boolean webElementIsText (String tElement, String value) throws IOException{
		String actual =  a_Driver.findElement(By.xpath(properties.getPropValue(tElement))).getText();
		String expected = properties.getPropValue(value);
		if (actual.equals(expected)){
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public void assertTest(Boolean expect, Boolean actual){
		try {assertEquals(expect, actual);}
		catch (NoSuchElementException e)
		{e.getCause();}
	}


}
