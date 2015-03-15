package Pages;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import Pages.GetPropertyValues;
import Pages.webLoading;

import org.testng.Assert;
import org.testng.Reporter;

/*
 * 
 * 
 * 
 * 
 */
public class webLoading {
	public WebDriver a_Driver;
	public Boolean Element_Displayed;
	public WebElement Element_Name;
	public Boolean Element_SendKey;
	public String Element_Text;
	public String browserUsage;
	private static Map verificationFailuresMap = new HashMap();
	static List<Throwable> verificationFailures= new ArrayList<Throwable>();
	GetPropertyValues properties = new GetPropertyValues();

	/**
	 * Instantiate a browser of user interest based on the arguments sent via
	 * ant
	 * 
	 * @throws IOException
	 * 
	 */
	public webLoading() throws IOException {
		Properties sysProps = System.getProperties();
		browserUsage = sysProps.getProperty("brows");
		int browser_value = Integer.parseInt(browserUsage);
		switch (browser_value) {
		case 1:
			a_Driver = new FirefoxDriver();
			break;
		case 2:
			System.setProperty("webdriver.chrome.driver",
					properties.getPropValue("chrome_Exe"));
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

	/**
	 * Navigate to the url of interest, maximize the window, closes the cookies
	 * policy
	 */
	public void start(String webPage) throws InterruptedException, IOException {
		a_Driver.get(properties.getPropValue(webPage));
		a_Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		a_Driver.manage().window().maximize();
		assertTest(webElementDisplayed("asos_Cookie"));
		webElementClick("asos_CookieOK");
		System.out.println("Currently in " + a_Driver.getTitle() + " Page");

	}

	/**
	 * closes the browser or window
	 */
	public void quit() throws InterruptedException, IOException {
		a_Driver.quit();
	}

	/**
	 * Checks if the webelement is displayed
	 * <p>
	 * <i><b>element</b> type is string</i>
	 * 
	 * @author Sudha Rani
	 * @param element
	 *            name of the xpath from config.properties file
	 * @return Boolean value
	 * @throws Throwable
	 */

	public Boolean webElementDisplayXpath(String dElement) throws IOException {
		return (a_Driver
				.findElement(By.xpath(properties.getPropValue(dElement)))
				.isDisplayed());
	}

	/**
	 * Checks if the webelement is enabled
	 * <p>
	 * <i><b>element</b> type is string</i>
	 * 
	 * @author Sudha Rani
	 * @param element
	 *            name of the xpath from config.properties file
	 * @return Boolean value
	 * @throws Throwable
	 */

	public Boolean webElementEnableXpath(String eElement) throws IOException {
		return (a_Driver
				.findElement(By.xpath(properties.getPropValue(eElement)))
				.isEnabled());
	}

	/**
	 * Finds a webelement by xpath
	 * <p>
	 * <i><b>element</b> type is string</i>
	 * 
	 * @author Sudha Rani
	 * @param element
	 *            name of the xpath from config.properties file
	 * @return None
	 * @throws Throwable
	 */

	public void webElementClick(String cElement) throws IOException {
		a_Driver.findElement(By.xpath(properties.getPropValue(cElement)))
				.click();
	}

	/**
	 * Clicks the link and waits for 3 sec
	 * <p>
	 * <i><b>element</b> type is string</i>
	 * 
	 * @author Sudha Rani
	 * @param element
	 *            name of the xpath from config.properties file
	 * @return None
	 * @throws Throwable
	 */
	public void webElementClicknWait(String cwElement) throws IOException,
			InterruptedException {
		webElementClick(cwElement);
		a_Driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	/**
	 * Checks for the presence of text link
	 * <p>
	 * <i><b>element</b> type is string</i>
	 * 
	 * @author Sudha Rani
	 * @param element
	 *            name of the xpath from config.properties file
	 * @return Returns true or false based on the presence of the element
	 * @throws Throwable
	 */

	public Boolean webElementIsLink(String iElement) throws IOException {
		Element_Text = a_Driver.findElement(
				By.xpath(properties.getPropValue(iElement))).getText();
		try {
			a_Driver.findElement(By.linkText(Element_Text));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	/**
	 * Passes a value to the input field
	 * <p>
	 * <i><b>element</b> type is string</i>
	 * 
	 * @author Sudha Rani
	 * @param element
	 *            name of the xpath from config.properties file
	 * @return None
	 * @throws Throwable
	 */

	public void webElementSend(String sElement, String value)
			throws IOException {
		a_Driver.findElement(By.xpath(properties.getPropValue(sElement)))
				.sendKeys(value);
	}

	/**
	 * Sets a value for a dropdown input field
	 * <p>
	 * <i><b>element</b> type is string</i>
	 * 
	 * @author Sudha Rani
	 * @param element
	 *            name of the xpath from config.properties file
	 * @return None
	 * @throws Throwable
	 */

	public void webElementDropDown(String pElement, String value)
			throws IOException {
		Select user_Dropdown = new Select(a_Driver.findElement(By
				.xpath(properties.getPropValue(pElement))));
		user_Dropdown.selectByVisibleText(value);
	}

	/**
	 * Verifies the text on the webelement and matches it with the expected
	 * value
	 * <p>
	 * <i><b>element</b> type is string</i>
	 * 
	 * @author Sudha Rani
	 * @param element
	 *            name of the xpath from config.properties file
	 * @return Boolean value
	 * @throws Throwable
	 */

	public Boolean webElementIsText(String tElement, String value)
			throws IOException {
		String actual = a_Driver.findElement(
				By.xpath(properties.getPropValue(tElement))).getText();
		String expected = properties.getPropValue(value);
		if (actual.equals(expected)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Assert expected and actual value in various tests
	 * <p>
	 * <i><b>element</b> type is boolean</i>
	 * 
	 * @author Sudha Rani
	 * @param element
	 *            name of the xpath from config.properties file
	 * @return None
	 * @throws Throwable
	 */

	public void assertTest(Boolean expect, Boolean actual) {
		try {
			Assert.assertEquals(expect, actual);
		} catch (Exception e) {
			addVerificationFailure(e);
			e.printStackTrace();
		}
	}

	public void assertTest(Boolean actual) {
		try {
			Assert.assertTrue(actual);
		} catch (Throwable e) {
			addVerificationFailure(e);
		}
	}
	
 
	public static List<Throwable> getVerificationFailures() {
		return verificationFailures == null ? new ArrayList() : verificationFailures;
	}
 
	public static void addVerificationFailure(Throwable e) {
		verificationFailures.add(e);
	}

	public WebElement webFindElementByXpath(String Element) throws IOException {
		Element_Name = a_Driver.findElement(By.xpath(properties
				.getPropValue(Element)));
		return Element_Name;
	}

	public Boolean webElementDisplayed(WebElement web_Displayed) {
		return (web_Displayed.isDisplayed());
	}

	public Boolean webElementDisplayed(String xpath) throws IOException {
		return (webFindElementByXpath(xpath).isDisplayed());
	}

	@SuppressWarnings("static-access")
	public Boolean webElementDisplayednEnable(String xpath) throws IOException {
		Element_Displayed = webFindElementByXpath(xpath).isDisplayed();
		if (Element_Displayed.TRUE) {
			Element_Displayed = webFindElementByXpath(xpath).isEnabled();
		}

		return Element_Displayed;
	}

	public Boolean webElementEnabled(WebElement web_Enabled) {
		return (web_Enabled.isEnabled());
	}

	public void performScreenCapture(String fname) {
		try {
			Robot robot = new Robot();
			String format = "jpg";
			String fileName = fname + format;
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit()
					.getScreenSize());
			BufferedImage screenFullImage = robot
					.createScreenCapture(screenRect);
			ImageIO.write(screenFullImage, format, new File(fileName));

		} catch (AWTException ex) {
			System.err.println(ex);
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

}
