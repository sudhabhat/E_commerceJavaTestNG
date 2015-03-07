package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetPropertyValues {
	/**
	 * Reads the config.properties file which holds the key:value pair of the
	 * webelements of the ecommerce website
	 * 
	 * @throws IOException
	 */
	/**
	 * Returns xpath value
	 * <p>
	 * <i><b>element</b> type is string</i>
	 * 
	 * @author Sudha Rani
	 * @param name
	 *            of the xpath from config.properties file
	 * @return None
	 * @throws Throwable
	 */
	public String getPropValue(String prop_Xpath) throws IOException {
		Properties prop = new Properties();
		String dir;
		// Windows must be found based on the Operating system
		boolean windows = true;
		if (windows) {
			dir = "\\src\\configuration\\";
		} else {
			dir = "//src//configuration//";
		}
		File propFileName = new File(System.getProperty("user.dir") + dir
				+ "config.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(propFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop.getProperty(prop_Xpath);

	}

	/*
	 * String propFileName =
	 * "E:\\SudhaDev\\Java\\E_commerceJavaTestNG\\src\\configuration\\config.properties"
	 * ;
	 */
	/*
	 * FileInputStream inputStream = new FileInputStream(propFileName); if
	 * (inputStream != null) { prop.load(inputStream); } else { throw new
	 * FileNotFoundException("property file '" + propFileName +
	 * "' not found in the classpath"); }
	 */

}
